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
		def customerInstance = lookupInstance
		def welcomeMessage = "Welcome back."
		return [customerInstance,welcomeMessage]
	}
}
