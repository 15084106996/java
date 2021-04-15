import axios from "axios";
import { Message } from 'element-ui';

// 添加响应的拦截器，对响应统一处理
axios.interceptors.response.use(resp => {
    if (resp && resp.status == 200 && resp.data) {
        if (resp.data.code == 200) {
            Message.success({message : resp.data.msg});
        }
        if (resp.data.code == 500) {
            Message.error({message : resp.data.msg});
            return;
        }
        return resp.data;
    }
},error => {
    if (error.response) {
        if (error.response.status == 404) {
            Message.error({message : '访问资源不存在'});
        }else if (error.response.status == 403) {
            Message.error({message : '权限不足'});
        }else if (error.response.status == 401) {
            Message.error({message : '用户未登录'});
        }else if (error.response.status == 504) {
            Message.error({message : '网关超时'});
        }else{
            Message.error({message : '未知错误'});
        }
    }
    return;
})

// 封装请求api
export const getRequest = (url,data) => {
    return axios({
        method : 'get',
        url : url,
        data : data
    })
}

export const postRequest = (url,data) => {
    return axios({
        method : 'post',
        url : url,
        data : data
    })
}

export const postKeyValueRequest = (url,data) => {
    return axios({
        method : 'post',
        url : url,
        data : data,
        transformRequest : [function (data) {
            let str = '';
            for (let i in data) {
                str += encodeURIComponent(i)+'='+encodeURIComponent(data[i])+'&'
            }
            return str;
        }],
        header : {
            'Content-Type' : 'application/x-www-form-urlencoded'
        }
    })
}

export const putRequest = (url,data) => {
    return axios({
        method : 'put',
        url : url,
        data : data
    })
}

export const delRequest = (url,data) => {
    return axios({
        method : 'delete',
        url : url,
        data : data
    })
}
