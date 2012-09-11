package com.harris.domain

class Author
{
	
	String lastName
	String firstName
	String middleName
	
	static hasMany = [books:Book]
	
	static searchable = true
	
	static constraints =
	{
		firstName nullable:true
		middleName nullable:true
		lastName nullable:true
	}
}
