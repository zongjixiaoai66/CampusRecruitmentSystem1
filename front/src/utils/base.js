const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyuanzhaopin/",
            name: "xiaoyuanzhaopin",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyuanzhaopin/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园招聘系统"
        } 
    }
}
export default base
