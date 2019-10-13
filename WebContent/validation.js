/**
 * Form validation functions
 */

function validateForm(){
	var name = document.getElementById("name").value;
	if (name == ""){
		document.getElementById("nameError").innerHTML = "Name must be filled out.";
		return false;
	}
	else {
		document.getElementById("nameError").innerHTML = "";
	}
	
	var d = new Date();
	var n = d.getFullYear();
	var year = document.getElementById("year").value;
	if (year == ""){
		document.getElementById("yearError").innerHTML = "Year must be filled out.";
		return false;
	}
	else if (isNaN(year) || year < 1000){
		document.getElementById("yearError").innerHTML = "Must be a four-digit year.";
		return false;
	}
	else if (year > n){
		document.getElementById("yearError").innerHTML = "Must be the current year or earlier.";
		return false;
	}
	else {
		document.getElementById("yearError").innerHTML = "";
	}
	
	var cat = document.getElementById("cat").value;
	if (cat == ""){
		document.getElementById("catError").innerHTML = "Category must be filled out.";
		return false;
	}
	else if (isNaN(cat) || cat < 1 || cat > 5){
		document.getElementById("catError").innerHTML = "Must be a valid hurricane category (1-5).";
		return false;
	}
	else {
		document.getElementById("catError").innerHTML = "";
	}
}

function validateNav(){
	var id = document.getElementById("selectedId").value;
	if (id == ""){
		document.getElementById("formError").innerHTML = "No hurricane selected. Please select a hurricane.";
		return false;
	}
	else {
		document.getElementById("formError").innerHTML = "";
	}

}