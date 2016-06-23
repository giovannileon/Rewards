package rewards

class OrderItem {
	Integer qty
	Float total
	
	static belongsTo = [orders:OnlineOrder, products:Product]
	
	static constraints = {
	}
}
