/**
 * 
 */
function validate(){
	console.log("----------------------------------------------------->");
    let description= document.querySelector("#description").value;
    
	let remark=document.querySelector("#remark").value;
   

 
    if(description=="")
    {
     alert("User name cannot be Empty");
    
	}
    else if(remark==""){
	alert("address cannot empty");
     }
    
}