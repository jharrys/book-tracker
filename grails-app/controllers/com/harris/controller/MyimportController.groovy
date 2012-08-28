package com.harris.controller

import groovy.json.*

import com.harris.domain.*

class MyimportController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index() {
		[msg : "Hello World"]
	}
	
	def myimport() {
		[msg : "Import"]
	}
	
	def doimport() {
		BufferedReader br = new BufferedReader(new FileReader("/tmp/books.json"))
		def slurper = new JsonSlurper()
		String line = ""
		ArrayList result = new ArrayList()
		int x = 1
		while((line=br.readLine()) != null) {
			def jsonObject = slurper.parseText(line)
			//			result.add(jsonObject)
			Book b = new Book(jsonObject)
			b.save()
			result.add(b)
		}
		[result : result]
	}
}
