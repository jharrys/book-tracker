<%@ page import="com.harris.domain.*" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Import</title>
	</head>
	<body>
		<div class="nav" role="navigation">
		  <h2>${msg }</h2>
		</div>
		<div id="import" class="content scaffold-create" role="main">
			<g:form action="doimport" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="doimport" class="doimport" value="Do Import" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
