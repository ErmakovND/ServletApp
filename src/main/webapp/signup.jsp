<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>
    ${signupMessage}
</h3>
<form action="sign" method="post">
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
    <input type="submit" value="Sign Up"/>
</form>
</body>
</html>
