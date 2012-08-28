package com.harris.domain

class Author {

    static constraints = {
    	firstName(blank:false)
    	middleName()
    	lastName(blank:false)
    }

    static hasMany = [books:Book]

    String lastName
    String firstName
    String middleName

    String toString() {
    	"${lastName}, ${firstName}"
    }
}
