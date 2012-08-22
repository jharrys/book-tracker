import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
    	switch(GrailsUtil.environment) {
    		case "development":
		    	def kassi = new com.harris.Author(firstName: "Kassi", middleName:"B", lastName: "Harris")
		    	def john = new com.harris.Author (firstName: "John", middleName:"C", lastName: "Ferrari")
		    	kassi.save(failOnError: true)
		    	john.save(failOnError: true)

		    	if(kassi.hasErrors()) {
		    		println kassi.errors
		    	}

		    	if(john.hasErrors()) {
		    		println john.errors
		    	}

		    	def book1 = new com.harris.Book(title: "Book One", isbnType: 13, isbn: "97833", readDate: new Date(), rating: 2)
				def book2 = new com.harris.Book(title: "Book Two", isbnType: 13, isbn: "97844", readDate: new Date(), rating: 2)

				book1.addToAuthors(kassi)
				book2.addToAuthors(john)

				book1.save(failOnError: true)
				book2.save(failOnError: true)

				if(book1.hasErrors()) {
					println book1.errors
				}

				if(book2.hasErrors()) {
					println book2.errors
				}

		    	break
		    case "production": break
    	}
    }
    def destroy = {
    }
}
