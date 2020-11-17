/**
 * 
 */
function validatefunction(){
	console.log("----------------------------------------------------->");
    let name= document.querySelector("#username").value;
   
    let password= document.querySelector("#password").value;
    var pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; 
 
    if(name=="")
    {
     alert("User name cannot be Empty");
    }
    else if(password.length>=8){
    	alert("password should have more than 8 characters")
    }
}