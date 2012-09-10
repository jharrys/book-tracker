import grails.converters.*
import groovy.json.*
import com.harris.domain.*

def json = JSON.parse('{"title":"D","authors":["a one","b two"],"readDate":"01/29/2012","isbnType":13,"isbn":"1233334","rating":9}')
json.remove("authors")
json
//List authorList = new ArrayList()
//json.authors.each { a -> def names = a.split(); def temp = new Author(firstName: names[0], lastName: names[1]); authorList.add(temp) }
//json.authors = null
//Book b = new Book(json)
//authorList.each { it.addToBooks(b); it.save(flush:true,failOnError:true) }
//Book.list()
//Author.list()
//def book = new Book(json)
//def author = new Author(lastName:"harris", firstName:"john")
//book.addToAuthors(author)
//author.save(flush:true,failOnError:true)
//book.save(flush:true,failOnError:true)
//JSON j = new JSON(target: book)
//JSON a = new JSON(target: author)
//j.toString(false)
//a.toString(false)
//Book.list()
//Author.list().each { it.delete(flush:true) }
//Book.list().each { it.delete(flush:true) }