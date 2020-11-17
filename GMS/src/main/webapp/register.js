/**
 * 
 */
function validatefunction(){
	console.log("----------------------------------------------------->");
    let name= document.querySelector("#username").value;
     let password= document.querySelector("#password").value;
    let email= document.querySelector("#email").value;
    let phoneno= document.querySelector("#phoneno").value;
	let address=document.querySelector("#address").value;
   
    var pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; 
 
    if(name=="")
    {
     alert("User name cannot be Empty");
    }else if(password.length>=8){
    	alert("password should have more than 8 characters")
    }else if (email==""){
     alert("email Id cannot be Empty");
    }
    else if(pattern.test(email)){
     alert("email is invalid");
    }else if (phoneno=="" ){
        alert("phone number cannot be Empty");
    }
    else if (phoneno.length!=10 ){
        alert("Invalid phone number");
    }
    else if(address==""){
	alert("address cannot empty");
     }
    
}