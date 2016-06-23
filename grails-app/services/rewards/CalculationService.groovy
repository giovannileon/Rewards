package rewards

import grails.transaction.Transactional

@Transactional
class CalculationService {

	def welcome(params) {
		def firstName = params.first
		def totalPoints = params.points.toInteger();
		def welcomeMessage ="Welcome back ${firstName}, "

		switch (totalPoints){
			case 5:
				welcomeMessage += "this drink is on us."
				break;
			case 4:
				welcomeMessage +="your next drink is free."
				break;
			case 2..3:
				welcomeMessage +="you now have $totalPoints points."
				break;
			default:
				welcomeMessage +="Thanks for registering."
				break;
		}
	}
	def getTotalPoints(customerInstance){
		
		//recorrer los awards loop por los awards get point 
		def totalAwards = 0
		
		customerInstance.awards.each {
			totalAwards = totalAwards + it.points
		}
		customerInstance.totalPoints = totalAwards
		return customerInstance
		
		
	}
	
	def processCheckin(lookupInstance){
		//Query customer by phonenumber
		def customerInstance = Customer.findByPhone(lookupInstance.phone)
		//if no result
		if (!customerInstance){
			// create a new customer
			customerInstance = lookupInstance
			customerInstance.firstName = "customer"
		}
		//customerInstance = getTotalPoints(customerInstance)
		//Calculate current awards points
		def totalAwards = 0
		def welcomeMessage ="Welcome back ${customerInstance.firstName}, "
		customerInstance.awards.each {
			totalAwards = totalAwards + it.points
		}
		customerInstance.totalPoints = totalAwards
		
		// Create a welcome message
		switch (totalAwards){
			case 5:
				welcomeMessage += "this drink is on us."
				break;
			case 4:
				welcomeMessage +="your next drink is free."
				break;
			case 1..3:
				welcomeMessage +="you now have ${totalAwards + 1} points."
				break;
			default:
				welcomeMessage +="Thanks for registering."
				break;
		}
		
		//add a new award
		if ( totalAwards < 5){
			//usar el alias de la relacion en este caso awards
			customerInstance.addToAwards(new Award(awardDate: new Date(), type:"Purchase", points:1))
		}else{
		    customerInstance.addToAwards(new Award(awardDate: new Date(), type:"Reward", points:-5))
		}
		customerInstance.save()
		return [customerInstance,welcomeMessage]
	}
}
