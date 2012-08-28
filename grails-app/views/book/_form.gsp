<%@ page import="com.harris.domain.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="book.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${bookInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'isbnType', 'error')} required">
	<label for="isbnType">
		<g:message code="book.isbnType.label" default="Isbn Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="isbnType" from="${bookInstance.constraints.isbnType.inList}" required="" value="${fieldValue(bean: bookInstance, field: 'isbnType')}" valueMessagePrefix="book.isbnType"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'isbn', 'error')} required">
	<label for="isbn">
		<g:message code="book.isbn.label" default="Isbn" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="isbn" required="" value="${bookInstance?.isbn}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'readDate', 'error')} required">
	<label for="readDate">
		<g:message code="book.readDate.label" default="Read Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="readDate" precision="day"  value="${bookInstance?.readDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'rating', 'error')} required">
	<label for="rating">
		<g:message code="book.rating.label" default="Rating" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="rating" from="${1..10}" class="range" required="" value="${fieldValue(bean: bookInstance, field: 'rating')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'authors', 'error')} ">
	<label for="authors">
		<g:message code="book.authors.label" default="Authors" />
		
	</label>
	
</div>

