<!DOCTYPE html>
<html>
<head>
    <title>Do Import</title>
    <blueprint:resources/>
    <link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <g:each in="${result }" var="r">
            listing: ${r }<br>
        </g:each>
    </div>
</body>
</html>
