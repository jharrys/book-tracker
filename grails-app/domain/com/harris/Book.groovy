package com.harris

class Book {

	static constraints = {
		title(blank:false)
		isbnType(inList:[13, 10])
		isbn(blank:false)
		readDate()
		rating(range:1..10)
	}

	static belongsTo = Author
	static hasMany = [authors:Author]

	String title
	Date readDate
	Integer isbnType
	String isbn
	// 1-low, 10-high
	Integer rating

	String toString() {
		"${title} - ${isbn}"
	}
}
