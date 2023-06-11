function myFunction(event){
event.preventDefault();
fetch('/save/hello/world',{method: 'GET'})
.then(
  response => response.json()
).then(jsonResponse => {
  console.log(jsonResponse);
});
}

function saveMessage(event){
event.preventDefault();
var email = document.getElementById("email");
var message = document.getElementById("message");
fetch('/data/' +email.value + '/' + message.value ,{method: 'GET'})
.then(
  response => modalDisplay('Message Sent', 'Please Wait while this message is evaluated.', 'details', 'aviralaman25@gmail.com')
).then(jsonResponse => {
  console.log(jsonResponse);
});
}