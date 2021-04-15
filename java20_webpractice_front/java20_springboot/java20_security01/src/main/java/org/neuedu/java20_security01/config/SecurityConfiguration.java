package org.neuedu.java20_security01.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.neuedu.java20_security01.model.RespBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("$2a$10$veZni1A3hgc4YXs5hwdZZ.P2S43DICXC97.EKxDNtfUa8SSXO5ZqS").roles("admin")
                .and()
                .withUser("tom").password("$2a$10$I.jrqaRfK7EUId2s.2wSRO5OrC7H2CBLEkqQpkyH/EzU09wqt5v12").roles("user")
                .and()
                .withUser("lucy").password("$2a$10$I.jrqaRfK7EUId2s.2wSRO5OrC7H2CBLEkqQpkyH/EzU09wqt5v12").roles("dba");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception { // 忽略哪些接口
        web.ignoring().antMatchers("/hello");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // 请求权限
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin") // admin角色有权限访问/admin/**形式的接口
                .antMatchers("/user/**").hasAnyRole("admin,user")// admin，user角色都有权限访问/user/**形式的接口
                .anyRequest().authenticated() // 其他接口登录就有权限访问
                .and()
                .formLogin() // 配置登录有关的内容
                .loginPage("/login") // 未登录的响应接口
                .loginProcessingUrl("/doLogin") // 登录接口
                .usernameParameter("username") // 用户名参数
                .passwordParameter("password")// 用户密码参数
                .successHandler(new AuthenticationSuccessHandler() {// 登录成功的处理器
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setCharacterEncoding("utf-8");
                        resp.setContentType("application/json;charset=utf-8");
                        // 获取登录者信息
                        Object user = authentication.getPrincipal();
                        RespBean respBean = RespBean.success(200, "登录成功",user);
                        resp.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {// 登录失败的处理器
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setCharacterEncoding("utf-8");
                        resp.setContentType("application/json;charset=utf-8");
                        RespBean respBean = null;
                        if (e instanceof BadCredentialsException) {
                            respBean = RespBean.error(500, "用户名或密码错误，请重新确认");
                        } else if (e instanceof LockedException) {
                            respBean = RespBean.error(500, "账户被锁定，请联系管理员");
                        } else if (e instanceof DisabledException) {
                            respBean = RespBean.error(500, "账户被禁用，请联系管理员");
                        } else if (e instanceof CredentialsExpiredException) {
                            respBean = RespBean.error(500, "账户密码过期，请联系管理员");
                        } else if (e instanceof AccountExpiredException) {
                            respBean = RespBean.error(500, "账户过期，请联系管理员");
                        }else {
                            respBean = RespBean.error(500, "未知错误，请联系管理员");
                        }
                        resp.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
                    }
                })
                .permitAll() // 接口放行
                .and()
                .logout() // 注销接口配置
                .logoutUrl("/logout")// 注销接口
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setCharacterEncoding("utf-8");
                        resp.setContentType("application/json;charset=utf-8");
                        RespBean respBean = RespBean.success(200, "注销成功");
                        resp.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();// 防止csrf攻击
    }
}