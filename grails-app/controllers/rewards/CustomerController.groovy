package rewards

import grails.transaction.Transactional;

class CustomerController {
	static scaffold = true
	
	def calculationService

	def lookup(){
		//def customerInstance = Customer.list(sort:"lastName", order:"desc", max: 10, offset:10)
		//def customerInstance = Customer.findAllByLastName("Foster")
		
		//def customerInstance = Customer.findAllByTotalPoints(5,[sort:"lastName",order:"desc" ])
		
		//def customerInstance = Customer.findAllByLastNameLike("B%")
		//def customerInstance = Customer.findAllByTotalPointsGreaterThan(3)
		//def customerInstance = Customer.findAllByTotalPointsGreaterThanEquals(3,[sort:"totalPoints",order:"desc"])
		
		
		//def customerInstance = Customer.findAllByTotalPointsBetween(2,4,[sort:"totalPoints",order:"desc"])
		
		//def customerInstance = Customer.findAllByFirstNameAndTotalPoints("Bo", 3)
		
		//def customerInstance = Customer.findAllByFirstNameAndTotalPoints("Bo", 3)
		
		def customerInstance = Customer.findAllByFirstNameLikeAndTotalPoints("B%", 3)
		
		//def customerInstance = Customer.findByPhone(params.id)
		[customerInstanceList:customerInstance]
	}

	def checkin(){

	}
	def index(){
		//use default view
		params.max = 10;
		[customerInstanceList: Customer.list(params), customerInstanceCount: Customer.count()]
	}
	
	def create(){
		[customerInstance: new Customer()]
	}
	
	@Transactional
	def save(Customer customerInstance){
		customerInstance.save()
		// show necesita el id
		//y necesito definir show
		redirect (action:"show", id:customerInstance.id)
	}
	
	def show(Long id){
		def customerInstance = Customer.get(id)
		//manipular datos
		customerInstance = calculationService.getTotalPoints(customerInstance)
		//muestra el cliente con el id correspondiente
		[customerInstance: customerInstance]
		
	}
	@Transactional
	def edit(Long id){
		def customerInstance = Customer.get(id)
		//muestra el cliente con el id correspondiente
		[customerInstance: customerInstance]
	}
	@Transactional
	def update(Long id){
		//aqui tiene dos versiones de customer que se deben mezclar 
		// una para el cliente de la bd y el otro que viene por la view
		def customerInstance = Customer.get(id)
		
		//sobreescribo los datos de la bd con los que llegan de la forma
		customerInstance.properties = params
		customerInstance.save()
		//redirecciono a la pagina que necesito en este caso show
		redirect (action:"show", id:customerInstance.id)
	}
	@Transactional
	def delete (Long id){
		def customerInstance = Customer.get(id)
		customerInstance.delete()
		redirect (action:"index")
	}
	
	def customerLookup(Customer lookupInstance){
		def (customerInstance,welcomeMessage)= calculationService.processCheckin(lookupInstance)
		render (view:"checkin", model:[customerInstance: customerInstance, welcomeMessage:welcomeMessage])
	}
	def profile(){
		def customerInstance = Customer.findByPhone(params.id)
		[customerInstance:customerInstance]
	}
	def updateProfile(){
	
	}
		
}
