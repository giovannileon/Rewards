package asia.grails.tutorial

import asia.grails.myapp.Person

class HelloController {
	def personService

   def index() { 
	   
	   def list = []
	   list << personService.createPerson('John', 'Doe',20)
	   list << personService.createPerson('Jane', 'Smith',45)
	   list << personService.createPerson('Sam', 'Robinson',47)
	   list << personService.createPerson('Leon', 'Giovanni Ernesto',40)
	 
	   [ list:list ]
	
	}
	def hi() { 
		//render (view:'index.gsp')
		Person person = personService.createPerson('John', 'Doe',55)
		[ person:person ]
	}
	
	def displayForm() {
		// just provide value for age. First Name and Last name are blanks.
		Person person = personService.createPerson('', 'Doe',15)
		[ person:person ]
	}
	
	def testPage() {
		
	}
}
