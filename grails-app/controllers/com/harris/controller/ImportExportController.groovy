package com.harris.controller

import grails.converters.*
import groovy.json.*

import java.text.*

import com.harris.domain.*

class ImportExportController
{
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index()
	{
		render("Implement me ....")
	}
	
	/*
	 * TODO create a progress bar
	 * TODO add button and explain that it's being loaded from /import/books.json
	 * TODO create a new page to upload content from local file
	 */
	def doimport()
	{
		File file = grailsAttributes.getApplicationContext().getResource("/import/books.json").getFile()
		FileReader fr = null
		
		try
		{
			fr = new FileReader(file)
			BufferedReader br = new BufferedReader(new FileReader(file))
			String line = ""
			def dateParser = new SimpleDateFormat("MM/dd/yyyy")
			while((line = br.readLine()) != null)
			{
				def json = JSON.parse(line)
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
				
				Book b = Book.findByIsbn(json.isbn)
				
				if(b == null) {
					b = new Book(json)
					b.save()
					authorList.each { author ->
						author.addToBooks(b)
						author.save(failOnError:true)
					}
				} else {
					if (!(b.authors.containsAll(authorList))) {
						b.authors.each { author ->
							if(!authorList.contains(author)) {
								author.addToBooks(b)
							}
						}
					}
				}
			}
		} catch (Exception e)
		{
			System.err.println(e)
			flash.message = e
		}
		
		forward action: "list", controller: "book"
	}
	
	/*
	 * TODO create a page to save JSON to local file (see http://blogs.bytecode.com.au/glen/2006/09/12/grails-sending-a-file-to-the-browser.html)
	 * response.setHeader("Content-disposition", "attachment; filename=" +
	 session.userid + ".csv");
	 render(contentType: "text/csv", text: sw.toString());
	 */
	def doexport()
	{
		// TODO this does not render nested authors correctly: see http://javasplitter.blogspot.com/2009/07/json-in-grails-with-nested-collections.html
		response.setHeader("Content-disposition", "attachment; filename=test.json")
		render (contentType: "application/json", text: Book.list() as JSON)
	}
}
