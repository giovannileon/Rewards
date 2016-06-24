package rewards

class MaskTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	
	def phone334 = { attrs->
		String phone = attrs.phone
		def formatted =""
		if (phone != null){
			formatted = "("+phone.substring(0,3)+ ") " + phone.substring(3,6)+"-" +phone.substring(6)
		}
		
		out << formatted
	}
}
