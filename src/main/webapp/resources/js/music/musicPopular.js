$(document).ready(function () {

  $('#musicTable').dataTable({
    language: {
      "sProcessing": "处理中...",
      "sLengthMenu": "显示 _MENU_ 项结果",
      "sZeroRecords": "没有匹配结果",
      "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
      "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
      "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
      "sInfoPostFix": "",
      "sSearch": "搜索:",
      "sUrl": "",
      "sEmptyTable": "表中数据为空",
      "sLoadingRecords": "载入中...",
      "sInfoThousands": ",",
      "oPaginate": {
        "sFirst": "首页",
        "sPrevious": "上页",
        "sNext": "下页",
        "sLast": "末页"
      },
      "oAria": {
        "sSortAscending": ": 以升序排列此列",
        "sSortDescending": ": 以降序排列此列"
      }
    },
    autoWidth: true,
    stripeClasses: ["odd", "even"],
   ordering:  true,

    processing: true, //开启加载提示,自行处理
    serverSide: true, //启用服务器端分页
    searching: false, //禁用原生搜索
    ajax: function (data, callback, settings) {
      //封装请求参数
      var param = {};
      param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
      param.start = data.start;//开始的记录序号
      param.page = (data.start / data.length) + 1;//当前页码
      //console.log(param);
      //ajax请求数据
      $.ajax({
        type: "POST",
        url: "music_getMusic.html",
        cache: false,  //禁用缓存
        data: param,  //传入组装的参数
        dataType: "json",
        success: function (result) {
          //console.log(result);
          //setTimeout仅为测试延迟效果
          setTimeout(function () {
            //封装返回数据
            var returnData = {};
            returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
            returnData.recordsTotal = result.total;//返回数据全部记录
            returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
            returnData.data = result.data;//返回的数据列表
            //console.log(returnData);
            //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
            callback(returnData);
          }, 200);
        }
      });
    },
    //列表表头字段
    columns: [
      {"data": "musicName"},
      {"data": "musicStar"},
      {"data": "fileName"},
      {"data": "createTime",
        render:  function (data, type, row, meta) {
          return moment(data).format("YYYY-MM-DD");
        },//会显示省略号的列，需要用title属性实现划过时显示全部文本的效果
       }
    ],
    "order": [[ 1, "desc" ]]
  }).api();
  //此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
});