<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<script>
    if(typeof (WebSocket) =="undefined") {
        console.log("您的浏览器不支持WebSocket");
    }else {
        console.log("您的浏览器支持WebSocket");
        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        socket = new WebSocket("ws://localhost:8083/websocket/20");
        socket.onopen = function() {
            console.log("Socket 已打开");
            socket.send("这是来自客户端的消息" + location.href + new Date());

        };
        //获得消息事件
        socket.onmessage = function(msg) {
            console.log(msg.data);

            var data=msg.data;
            var abc=document.getElementById('abc');
             abc.innerHTML=abc.innerHTML+'<br>'+data
        };
        //关闭事件
        socket.onclose = function() {
            console.log("Socket已关闭");
        };
        //发生了错误事件
        socket.onerror = function() {
            alert("Socket发生了错误");
            //此时可以尝试刷新页面
        }


    }
    var socket;


</script>





<title></title>
<body>

11111


<div align="center" id="abc">


</div>

</body>
</html>