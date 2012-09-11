<%@ page import="com.harris.domain.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>Do Import</title>
    <blueprint:resources/>
    <link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="container">
            message: ${result }<br>
    </div>
    blah
    <hr>
    <%= Book.list() %>
</body>
</html>
