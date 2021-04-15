let proxyObj = {};

proxyObj['/'] = {
    target: 'http://localhost:8084',
    changeOrigin: true
}
module.exports = {
    devServer: {
        host: 'localhost',
        port: 8083,
        proxy : proxyObj
    }
}