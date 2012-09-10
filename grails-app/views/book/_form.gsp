<%@ page import="com.harris.domain.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="book.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${bookInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'isbnType', 'error')} ">
	<label for="isbnType">
		<g:message code="book.isbnType.label" default="Isbn Type" />
		
	</label>
	<g:select name="isbnType" from="${bookInstance.constraints.isbnType.inList}" value="${fieldValue(bean: bookInstance, field: 'isbnType')}" valueMessagePrefix="book.isbnType" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'isbn', 'error')} ">
	<label for="isbn">
		<g:message code="book.isbn.label" default="Isbn" />
		
	</label>
	<g:textField name="isbn" value="${bookInstance?.isbn}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'rating', 'error')} ">
	<label for="rating">
		<g:message code="book.rating.label" default="Rating" />
		
	</label>
	<g:select name="rating" from="${0..10}" class="range" value="${fieldValue(bean: bookInstance, field: 'rating')}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'readDate', 'error')} ">
	<label for="readDate">
		<g:message code="book.readDate.label" default="Read Date" />
		
	</label>
	<g:datePicker name="readDate" precision="day"  value="${bookInstance?.readDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'authors', 'error')} ">
	<label for="authors">
		<g:message code="book.authors.label" default="Authors" />
		
	</label>
	
</div>

