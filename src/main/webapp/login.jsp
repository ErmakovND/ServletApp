<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>
    ${loginMessage}
</h3>
<form action="login" method="post">
    <label>
        Name <br/>
        <input type="text" name="name" autofocus/>
    </label>
    <br/>
    <label>
        Password <br/>
        <input type="password" name="password"/>
    </label>
    <br/>
    <input type="submit" value="Log In"/>
    <a href="signup">
        Sign Up
    </a>
</form>
</body>
</html>
