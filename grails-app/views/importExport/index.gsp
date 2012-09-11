<%@ page import="com.harris.domain.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Import</title>
<blueprint:resources />
<link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>Books</h2>
	</div>
	Start List
	<hr>
	<g:each in="${Book.list() }" var="book">
            listing: ${book }<br>
	</g:each>
	<hr>
	End List
	<div class="container">
        <h2>Authors</h2>
    </div>
    Start List
    <hr>
    <g:each in="${Author.list() }" var="author">
            listing: ${author}<br>
    </g:each>
    <hr>
    End List
</body>
</html>
