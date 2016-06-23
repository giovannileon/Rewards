package rewards

class Paciente {
  
	String nombre
	Date edad
    static constraints = {
		nombre (nullable:false)
		edad ( nullable:true)
    }
}
