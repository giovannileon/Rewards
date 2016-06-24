package asia.grails.myapp

class Person {
	String firstName
	String lastName
	int age
	
	static constraints = {
		firstName (blank: false)
		lastName (blank: false)
		age (blank: false)
	}
}
