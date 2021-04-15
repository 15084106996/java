package org.neuedu.java20vblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.neuedu.java20vblog.model.RespBean;
import org.neuedu.java20vblog.model.User;
import org.neuedu.java20vblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;
    @Autowired
    MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        o.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setCharacterEncoding("utf-8");
                        resp.setContentType("application/json;charset=utf8");
                        User user = (User) authentication.getPrincipal();
                        user.setPassword(null);
                        RespBean respBean = RespBean.success(200, "登录成功", user);
                        resp.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setCharacterEncoding("utf-8");
                        resp.setContentType("application/json;charset=utf8");
                        RespBean respBean = null;
                        if (e instanceof BadCredentialsException) {
                            respBean = RespBean.error(500, "用户名或密码错误，请重新确认");
                        } else if (e instanceof AccountExpiredException) {
                            respBean = RespBean.error(500, "账户已过期，请联系管理员");
                        } else if (e instanceof CredentialsExpiredException) {
                            respBean = RespBean.error(500, "账户密码已过期，请联系管理员");
                        } else if (e instanceof LockedException) {
                            respBean = RespBean.error(500, "账户被锁定，请联系管理员");
                        } else if (e instanceof DisabledException) {
                            respBean = RespBean.error(500, "账户被禁用，请联系管理员");
                        } else {
                            respBean = RespBean.error(500, "未知错误，请联系管理员");
                        }
                        resp.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setCharacterEncoding("utf-8");
                        resp.setContentType("application/json;charset=utf8");
                        RespBean respBean = RespBean.success(200, "注销成功");
                        resp.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();
    }
}
