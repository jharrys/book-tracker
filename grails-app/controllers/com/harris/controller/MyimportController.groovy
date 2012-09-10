package com.harris.controller

import grails.converters.*
import groovy.json.*

import java.text.*

import com.harris.domain.*

class MyimportController
{
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index()
	{
		[books: Book.list()]
	}
	
	def myimport()
	{
		[msg : "Import"]
	}
	
	def doimport()
	{
		File file = grailsAttributes.getApplicationContext().getResource("/import/books.json").getFile()
		FileReader fr = null
		def result = ""
		
		try
		{
			fr = new FileReader(file)
			BufferedReader br = new BufferedReader(new FileReader(file))
			String line = ""
			def dateParser = new SimpleDateFormat("MM/dd/yyyy")
			int x = 0
			while((line = br.readLine()) != null)
			{
				System.out.println("JJJJ: " + line)
				def json = JSON.parse(line)
				//json.id = ++x
				json.readDate = dateParser.parse(json.readDate)
				
				// first take care of authors; JSON doesn't deal with JSONArrays very well (it's documented)
				List authorList = new ArrayList()
				json.authors.each { a ->
					String[] names = a.split()
					def temp = ""
					if(names.length > 2) {
						temp = Author.findByFirstNameAndMiddleNameAndLastName(names[0], names[1], names[2])
					} else {
						temp = Author.findByFirstNameAndLastName(names[0], names[1])
					}
					if(temp == null) {
						if(names.length > 2) {
							temp = new Author(firstName: names[0], middleName: names[1], lastName: names[2])
						} else {
							temp = new Author(firstName: names[0], lastName: names[1])
						}
					}
					authorList.add(temp)
				}
				json.remove("authors")
				
				System.out.println("JJJJ: " + json)
				
				Book b = new Book(json)
				b.save(flush:true, failOnError:true)
				
				authorList.each { author ->
					author.addToBooks(b)
					author.save(failOnError:true)
				}
			}
		} catch (Exception e)
		{
			System.err.println("blahn " + e)
			result = e
		}
		[result : result ? result:"Done"]
	}
	
	def doexport()
	{
		Book a = new Book(title: "A", rating: 2, readDate: new Date(), isbnType: 13, isbn: 1234)
		Book b = new Book(title: "B", rating: 1, readDate: new Date(), isbnType: 13, isbn: 1234)
		Book c = new Book(title: "C", rating: 4, readDate: new Date(), isbnType: 13, isbn: 1234)
		Book d = new Book(title: "D", rating: 6, readDate: new Date(), isbnType: 13, isbn: 1234)
		a.save(true)
		b.save(true)
		c.save(true)
		d.save(true)
		
		//		System.out.println(a.toString())
		
		//		render(contentType: "text/json")
		//		{ a }
		
		render Book.list() as JSON
	}
}
