
<%@ page import="com.harris.domain.Book"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<div class="container">
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label" /></a></li>
				<li><g:link class="create" action="create">
						<g:message code="default.new.label" args="[entityName]" />
					</g:link></li>
				<li><g:form action="search">
						<div class="search">
							Search Books <input type="text" name="q" value="${params.q}" /> <input type="submit" value="Search" />
						</div>
					</g:form></li>
			</ul>
		</div>
		<div id="list-book" class="content scaffold-list" role="main">
			<h1>
				<g:message code="default.list.label" args="[entityName]" />
			</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">
					${flash.message}
				</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="title" title="${message(code: 'book.title.label', default: 'Title')}" />
						<g:sortableColumn property="isbnType" title="${message(code: 'book.isbnType.label', default: 'Isbn Type')}" />
						<g:sortableColumn property="isbn" title="${message(code: 'book.isbn.label', default: 'Isbn')}" />
						<g:sortableColumn property="rating" title="${message(code: 'book.rating.label', default: 'Rating')}" />
						<g:sortableColumn property="readDate" title="${message(code: 'book.readDate.label', default: 'Read Date')}" />
					</tr>
				</thead>
				<tbody>
					<g:each in="${bookInstanceList}" status="i" var="bookInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td><g:link action="show" id="${bookInstance.id}">
									${fieldValue(bean: bookInstance, field: "title")}
								</g:link></td>
							<td>
								${fieldValue(bean: bookInstance, field: "isbnType")}
							</td>
							<td><a href="http://www.amazon.com/gp/search/ref=sr_adv_b/?field-isbn=${fieldValue(bean: bookInstance, field: "isbn") }" target="_blank">
									amazon: ${fieldValue(bean: bookInstance, field: "isbn")}
							</a><br> <a href="http://www.isbnsearch.org/isbn/${fieldValue(bean: bookInstance, field: "isbn") }" target="_blank">isbnsearch: ${fieldValue(bean: bookInstance, field: "isbn")}</a>
							</td>
							<td>
								${fieldValue(bean: bookInstance, field: "rating")}
							</td>
							<td><g:formatDate date="${bookInstance.readDate}" /></td>
						</tr>
					</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bookInstanceTotal}" />
				(Total =
				${bookInstanceTotal })
			</div>
		</div>
	</div>
</body>
</html>
