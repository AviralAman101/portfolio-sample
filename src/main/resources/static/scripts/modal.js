

function searchModals(event){
    event.preventDefault();
    var x = document.getElementById("searchBar");
    tags = x.value;
    tags = tags.toUpperCase().replaceAll(","," ").trim();
    var checkboxes = document.querySelectorAll('.card-container');
    const checkTagsArray = tags.split(" ");
    let checkTags;
    if(checkTagsArray.length==1){
        checkTags = new RegExp(checkTagsArray[0]);
    } else {
    checkTags="(";
    for(let k=0; k < checkTagsArray.length; k++){
        if(checkTagsArray[k].trim()=="")
            continue;
        checkTags =checkTags+ checkTagsArray[k]+"|";
    }
    checkTags = new RegExp(checkTags.slice(0,-1) + ")");
    }
    for (let i = 0; i < checkboxes.length; i++) {
      var tags = checkboxes[i].getAttribute("tags").toUpperCase();
          if(!checkTags.test(tags)){
              checkboxes[i].style.display = "none";
          }else{
              checkboxes[i].style.display = "block";
          }
    }
}

function modalDisplay(name, heading, details, link){
    document.getElementById("modal-heading").innerHTML = name;
    document.getElementById("modal-description").innerHTML = details;
    document.getElementById("modal-link").innerHTML = link;
    document.getElementById("myModal").style.display = "block";
    console.log(document.getElementById("modal-heading"));s
}

function closeModal(){
    document.getElementById("myModal").style.display="none";
}

document.addEventListener("DOMContentLoaded", () => {
  console.log("Hello World!");
  cards = document.querySelectorAll(".card-container");
  for (let i = 0; i < cards.length; i++) {
        cards[i].style.height = "700px";
        cards[i].style.width = "auto";
        cards[i].style.float = "left";
      }
});