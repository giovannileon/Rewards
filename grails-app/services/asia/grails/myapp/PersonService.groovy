package asia.grails.myapp

import grails.transaction.Transactional

@Transactional
class PersonService {

	Person createPerson(String lastName, String firstName,int age) {
		Person p = new Person()
		p.lastName = lastName
		p.firstName = firstName
		p.age = age
		p.save()
		return p
	}

	List<Person> listPerson(){
		def listOfAllPerson = Person.executeQuery("from asia.grails.myapp.Person where lastName like '%John%'")
		return  listOfAllPerson;
	}

	List<Person> personByAge(){
		def listOfAllPerson = Person.executeQuery(
				"select age, count(*) from Person group by age having count(*) > 1");
		return  listOfAllPerson;
	}
}
