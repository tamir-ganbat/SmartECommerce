$(document).ready(function() {
	var root = '/' + window.location.pathname.split("/")[1];
	
	seeOrders = function(userId){
		$.ajax({
			url:root + '/product/' + userId,
			type:'PUT',
			datatype:'json',
			success:function(response){
				
			},
			error : function(errorResponse){
				alert("Error while user getting orders...");
			}
		})
	}
})