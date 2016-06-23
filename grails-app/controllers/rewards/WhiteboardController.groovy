package rewards

class WhiteboardController {
	def calculationService;

	def index() { }

	def variables(){
		def myTotal = 1
		render ("Total "+myTotal)
		render ("</BR> "+myTotal.class)

		myTotal = myTotal+ 1
		render ("</BR> New Total"+myTotal)

		def firstName = "Mike"
		render ("</BR> Name: "+firstName)
		render ("</BR> "+firstName.class)
		firstName = firstName+ 1
		render ("</BR> New firstName: "+firstName)

		def today = new Date ("2/1/2014")
		render ("</BR> Today is: "+today)
		render ("</BR> "+today.class)
		today = today+ 1
		render ("</BR> New Date: "+today)
	}
	def strings(){
		def firstName = "Mike"
		def lastName = "Kelly"
		def fullName ="Mike Kelly"
		def input = "SHOUTING"
		def state = "ut"
		def points = 4

		render "</BR>Hey there $firstName.</BR> You already have $points points!"

		render "</BR>You live in ${state.toUpperCase()}."
	}

	def conditions(){

		def welcomeMessage = calculationService.welcome(params)

		render welcomeMessage
	}
}
