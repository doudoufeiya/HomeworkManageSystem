$(function () {

    $('#page1').bPage({
        url: "findLesson.action",
        totalPage: $('#totalPage').val(),
        totalRow: $('#totalRow').val(),
        pageSize: $('#pageSize').val(),
        pageNumber: $('#pageNumber').val(),
        params: function () {
            return {
                userName: 'zhangsan',
                age: 42
            };
        }
    });

    //javascript初始化
    // $('#page1').bPage({
    //     //页面跳转的目标位置
    //     url: $webroot + 'demo/manage/page',
    //     //分页数据设置
    //     totalPage: $('#totalPage').val(),
    //     totalRow: $('#totalRow').val(),
    //     pageSize: $('#pageSize').val(),
    //     pageNumber: $('#pageNumber').val(),
    //     //页面跳转时需要同时传递给服务端的自定义参数设置
    //     params: function () {
    //         alert(totalPage)
    //         return {
    //             userName: 'zhangsan',
    //             age: 42
    //         };
    //     }
    // });
});