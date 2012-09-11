package com.harris.controller

import org.springframework.dao.DataIntegrityViolationException

import com.harris.domain.Book

class BookController
{
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index()
	{
		redirect(action: "list", params: params)
	}
	
	def list(Integer max)
	{
		System.out.println("RUUUUUUUNING");
		params.max = Math.min(max ?: 10, 100)
		[bookInstanceList: Book.list(params), bookInstanceTotal: Book.count()]
	}
	
	def create()
	{
		[bookInstance: new Book(params)]
	}
	
	def save()
	{
		def bookInstance = new Book(params)
		if (!bookInstance.save(flush: true))
		{
			render(view: "create", model: [bookInstance: bookInstance])
			return
		}
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'book.label', default: 'Book'), bookInstance.id])
		redirect(action: "show", id: bookInstance.id)
	}
	
	def show(Long id)
	{
		def bookInstance = Book.get(id)
		if (!bookInstance)
		{
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), id])
			redirect(action: "list")
			return
		}
		
		[bookInstance: bookInstance]
	}
	
	def edit(Long id)
	{
		def bookInstance = Book.get(id)
		if (!bookInstance)
		{
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), id])
			redirect(action: "list")
			return
		}
		
		[bookInstance: bookInstance]
	}
	
	def update(Long id, Long version)
	{
		def bookInstance = Book.get(id)
		if (!bookInstance)
		{
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), id])
			redirect(action: "list")
			return
		}
		
		if (version != null)
		{
			if (bookInstance.version > version)
			{
				bookInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
								[message(code: 'book.label', default: 'Book')] as Object[],
								"Another user has updated this Book while you were editing")
				render(view: "edit", model: [bookInstance: bookInstance])
				return
			}
		}
		
		bookInstance.properties = params
		
		if (!bookInstance.save(flush: true))
		{
			render(view: "edit", model: [bookInstance: bookInstance])
			return
		}
		
		flash.message = message(code: 'default.updated.message', args: [message(code: 'book.label', default: 'Book'), bookInstance.id])
		redirect(action: "show", id: bookInstance.id)
	}
	
	def delete(Long id)
	{
		def bookInstance = Book.get(id)
		if (!bookInstance)
		{
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), id])
			redirect(action: "list")
			return
		}
		
		try
		{
			bookInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'book.label', default: 'Book'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e)
		{
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'book.label', default: 'Book'), id])
			redirect(action: "show", id: id)
		}
	}
	
	def searchableService
	def search()
	{
		def query = params.q
		if(query)
		{
			def srchResults = searchableService.search(query)
			def result = srchResults.results[0]
			
			if (srchResults.results.isEmpty()) {
				render ("nothing found")	
			} else if (srchResults.results instanceof Collection && srchResults.results.size() > 1) {
				render(view: "list", model: [bookInstanceList: srchResults.results, bookInstanceTotal: srchResults.results.size()])
			} else {
				render(view: "show", model: [bookInstance:result])
			}
		}else
		{
			redirect(action: "list")
		}
	}
}
