package com.harris.domain

class Book {
	
	String title
	Date readDate
	Integer isbnType
	String isbn
	Integer rating		// 1-low, 10-high

	static hasMany = [authors:Author]
	static belongsTo = Author
	
	static constraints = {
		title nullable:true
		isbnType (inList:[13, 10], nullable:true)
		isbn nullable:true
		rating (range:0..10, nullable:true)
		readDate nullable:true
	}
	
	String toString() {
		"${id}: ${title} - ${isbn}"
	}
}
