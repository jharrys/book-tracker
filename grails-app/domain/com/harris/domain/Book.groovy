package com.harris.domain

class Book {

	static constraints = {
		title(blank:false)
		isbnType(inList:[13, 10])
		isbn(blank:false)
		readDate()
		rating(range:1..10)
	}

	static hasMany = [authors:Author]
	static belongsTo = Author

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
