<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="lib/jQuery3.7.0/jquery-3.7.0.min.js"></script>
    <script src="js/md5.js"></script>
    <link rel="stylesheet" href="lib/bootstrap-3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/index.js"></script>
    <title>本地密码管理</title>
</head>
<body>
<div id="err">
    <div class="alert alert-danger" role="alert">
        <%
            String errMsg = "";
            Object errMessage = request.getSession().getAttribute("errMessage");
            if (errMessage != null) {
                errMsg = (String) errMessage;
                request.getSession().removeAttribute("errMessage");
            }
        %>
        <%=errMsg%>
    </div>
</div>
<form action="${pageContext.request.contextPath}/entry" method="post" onsubmit="return checkForm()">
    <div class="row-no-gutters">
        <div id="img" class="col-lg-6"><img src="images/entry.jpg" alt="管理员入口"></div>
        <div class="col-lg-6" id="right">
            <label for="password">请输入管理员密码：</label><br>
            <div>
                <input type="password" id="password" value="" autofocus>
                <input type="hidden" name="password" id="md5-password">
                <span id="eye-open">
                            <svg t="1687099488039" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="28543" width="25" height="25"><path
                                    d="M512 298.666667c-162.133333 0-285.866667 68.266667-375.466667 213.333333 89.6 145.066667 213.333333 213.333333 375.466667 213.333333s285.866667-68.266667 375.466667-213.333333c-89.6-145.066667-213.333333-213.333333-375.466667-213.333333z m0 469.333333c-183.466667 0-328.533333-85.333333-426.666667-256 98.133333-170.666667 243.2-256 426.666667-256s328.533333 85.333333 426.666667 256c-98.133333 170.666667-243.2 256-426.666667 256z m0-170.666667c46.933333 0 85.333333-38.4 85.333333-85.333333s-38.4-85.333333-85.333333-85.333333-85.333333 38.4-85.333333 85.333333 38.4 85.333333 85.333333 85.333333z m0 42.666667c-72.533333 0-128-55.466667-128-128s55.466667-128 128-128 128 55.466667 128 128-55.466667 128-128 128z"
                                    fill="#444444" p-id="28544"></path></svg>
                        </span>
                <span id="eye-close">
                            <svg t="1687102886875" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                 xmlns="http://www.w3.org/2000/svg" p-id="28949" width="25" height="25"><path
                                    d="M332.8 729.6l34.133333-34.133333c42.666667 12.8 93.866667 21.333333 145.066667 21.333333 162.133333 0 285.866667-68.266667 375.466667-213.333333-46.933333-72.533333-102.4-128-166.4-162.133334l29.866666-29.866666c72.533333 42.666667 132.266667 106.666667 183.466667 192-98.133333 170.666667-243.2 256-426.666667 256-59.733333 4.266667-119.466667-8.533333-174.933333-29.866667z m-115.2-64c-51.2-38.4-93.866667-93.866667-132.266667-157.866667 98.133333-170.666667 243.2-256 426.666667-256 38.4 0 76.8 4.266667 110.933333 12.8l-34.133333 34.133334c-25.6-4.266667-46.933333-4.266667-76.8-4.266667-162.133333 0-285.866667 68.266667-375.466667 213.333333 34.133333 51.2 72.533333 93.866667 115.2 128l-34.133333 29.866667z m230.4-46.933333l29.866667-29.866667c8.533333 4.266667 21.333333 4.266667 29.866666 4.266667 46.933333 0 85.333333-38.4 85.333334-85.333334 0-12.8 0-21.333333-4.266667-29.866666l29.866667-29.866667c12.8 17.066667 17.066667 38.4 17.066666 64 0 72.533333-55.466667 128-128 128-17.066667-4.266667-38.4-12.8-59.733333-21.333333zM384 499.2c4.266667-68.266667 55.466667-119.466667 123.733333-123.733333 0 4.266667-123.733333 123.733333-123.733333 123.733333zM733.866667 213.333333l29.866666 29.866667-512 512-34.133333-29.866667L733.866667 213.333333z"
                                    fill="#444444" p-id="28950"></path></svg>
                        </span>
                <hr>
            </div>
            <input id="submit" class="btn btn-primary" type="submit" value="登录">
        </div>
    </div>
</form>
</body>
</html>