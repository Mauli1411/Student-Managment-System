document.getElementById('form').addEventListener('submit',function(event){
	const firstName=document.getElementById('firstName').value;
	const lastName=document.getElementById('lastName').value;
	const email=document.getElementById('email').value;
	if(!firstName){
	document.getElementById('firstName_error').innerHTML="*First Name is required.*";
	event.preventDefault();
	return;	
	}
	if(!/^[a-zA-Z]+$/.test(firstName)){
				document.getElementById('firstName_error').innerHTML="*First name should not contain numbers.*"
				event.preventDefault();
				return;	
				}
	if(!/^[a-zA-Z]*$/.test(lastName)){
			document.getElementById('lastName_error').innerHTML="*Last name should not contain numbers.*"
			event.preventDefault();
			return;	
			}
	if(!email){
				document.getElementById('emailName_error').innerHTML="*Please add you email.*";
				event.preventDefault();
				return;	
				}
	if(!/^[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\.[a-zA-Z]+$/.test(email)){
							document.getElementById('emailName_error').innerHTML="*Enter email in correct format.*"
							event.preventDefault();
							return;	
							}	
			
})