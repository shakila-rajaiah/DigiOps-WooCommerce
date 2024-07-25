

//function  setUpEvents() {
	var content = document.getElementById("content");
	var button = document.getElementById("show-more");



alert(button);


	button.onclick = function(){
		if(content.classname==open){
			//shrink the box
			content.classname="content";
			button.innerHTML="show More";
		}
		else{
			//expand the box
			content.classname="open";
			button.innerHTML= "Show Less"	
		}
	};
	
//};
	
	
	
/*	windows.onload = function () {
		setUpEvents();
	
};*/
