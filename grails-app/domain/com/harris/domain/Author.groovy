package com.harris.domain

class Author
{
	
	String lastName
	String firstName
	String middleName
	
	static hasMany = [books:Book]
	
	static constraints =
	{
		firstName nullable:true
		middleName nullable:true
		lastName nullable:true
	}
	
	String toString()
	{
		"${lastName}, ${firstName}"
	}
}
