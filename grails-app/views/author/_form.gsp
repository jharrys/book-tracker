<%@ page import="com.harris.domain.Author" %>



<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="author.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${authorInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="author.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" value="${authorInstance?.middleName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="author.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${authorInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'books', 'error')} ">
	<label for="books">
		<g:message code="author.books.label" default="Books" />
		
	</label>
	<g:select name="books" from="${com.harris.Book.list()}" multiple="multiple" optionKey="id" size="5" value="${authorInstance?.books*.id}" class="many-to-many"/>
</div>

