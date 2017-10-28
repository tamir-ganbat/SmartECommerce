	var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function cartClick(total,username,productId){
	
   	 $.ajax({
		type: 'POST',
		url: contextRoot + '/cart',
 		data:{"total":total,"userName":username,"productId":productId},
 		dataType:'application/json',// Sends - Content-type
		success: function(){
			window.alert("Item added into your cart");
		},
 
		error: function(errorObject ){	

//			alert(errorObject);   // "non" Validation Error
			
 		}
	});
}

decrement=function(quantity){
	quatity=quantity -1;
	return quantity;
}

increment=function(quantity){
	quatity=quantity + 1;
	return quantity;
}
 
resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  
	


make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }	   

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};


 