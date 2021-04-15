import axios from 'axios';
import {Message} from "element-ui";

axios.interceptors.response.use(resp => {
    if (resp.status == 200 && resp.data.code == 500) {
        if (resp.data.msg) {
            Message.error({message: resp.data.msg});
            return;
        }
    }
    if (resp.data.msg) {
        Message.success({message: resp.data.msg});
    }
    return resp.data;
}, error => {
    if (error.response) {
        if (error.response.status == 404) {
            Message.error({message: '访问资源不存在'});
        } else if (error.response.status == 405) {
            Message.error({message: '请求方式错误'});
        } else if (error.response.status == 400) {
            Message.error({message: '请求参数格式错误'});
        } else if (error.response.status == 403) {
            Message.error({message: '权限不足'});
        } else if (error.response.status == 504) {
            Message.error({message: '网关超时'});
        } else if (error.response.status == 401) {
            Message.error({message: '用户未认证'});
        } else {
            Message.error({message: '未知错误'});
        }
    }
})

export const getRequest = (url, data) => {
    return axios({
        method: 'get',
        url: url,
        data: data
    })
}

export const postRequest = (url, data) => {
    return axios({
        method: 'post',
        url: url,
        data: data
    })
}

export const putRequest = (url, data) => {
    return axios({
        method: 'put',
        url: url,
        data: data
    })
}

export const delRequest = (url, data) => {
    return axios({
        method: 'delete',
        url: url,
        data: data
    })
}