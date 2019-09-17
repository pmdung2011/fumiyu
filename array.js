// function capitalize(str){
// 	return str.charAt(0).toUpperCase() + str.slice(1);
// }

// function isEven (num){
// 	return num % 2 === 0;
// }

// function factorial(num){
// 	var result = 1; 
// 	for (var i = 1; i <= num; i++){
// 	 	result *= i;
// 	 }
// 	return result;
// }

let toDoList = ["nothing"];

function getIndex (index){
	var i = toDoList.indexOf(index);
	return i;
}
var input = prompt("What would you like to do ?");

function listItem (){
	toDoList.forEach(function(list, i){
		alert(toDoList.toString());
	});
}

function deleteFunction (index){
	toDoList.splice(index, 1);
}



function addItem(item){
	toDoList.push(item);
}


while (input !== "quit"){
	
	//List array
	if (input === "list"){
		listItem();
	}

	// push new element
	else if (input === "new"){
		let task = prompt("What would you like to add to the LIST ?");
		addItem(task);
		alert(task + " is added.");
		
	}

	// delete elements
	else if (input === "delete"){
		
		var deleteItem = prompt("What would you like to delete ?" );
		deleteFunction(getIndex(deleteItem));	
		alert(deleteItem + " is deleted.");

	}

	else if (input === "quit"){
		alert("Bye !");
	}


	input = prompt("What would you like to do ?");
}