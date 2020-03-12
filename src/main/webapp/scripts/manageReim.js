class FullReimbursement{ 
    constructor(employeeId, firstName, lastName, deptName, reimbursementTotal, position, reimbursementId, courseName, dateSubmitted, eventDate, amount, lastApprovalDate){

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptName = deptName;
        this.reimbursementTotal = reimbursementTotal;
        this.position = position;
        this.reimbursementId = reimbursementId;
        this.courseName = courseName;
        this.dateSubmitted = dateSubmitted;
        this.eventDate = eventDate;
        this.amount = amount;
        this.lastApprovalDate = lastApprovalDate;

    }
}





function logout(){
    document.getElementById("logout").addEventListener("click",navToLogout);
    
}

function navToLogout(){
    window.location.replace("/BenCo/pages/Login.html")
}



function displayFullReim(full){

    document.getElementById("employeeId").textContent = full.employeeId;
    document.getElementById("firstName").innerHTML = full.firstName;
    document.getElementById("lastName").innerHTML = full.lastName;
    document.getElementById("deptName").innerHTML = full.deptName;
    document.getElementById("reimbursementTotal").innerHTML = full.reimbursementTotal;


    document.getElementById("reimId").innerHTML = full.reimbursementId;
    document.getElementById("courseName").innerHTML = full.courseName;
    document.getElementById("dateSubmitted").innerHTML = full.dateSubmitted;
    document.getElementById("eventDate").innerHTML = full.eventDate;
    document.getElementById("amount").innerHTML = full.amount;
    document.getElementById("lastApprovalDate").innerHTML = full.lastApprovalDate;


}

function getFullReimbursement(){


    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

        if (xhr.readyState === 4 && xhr.status === 200) {
            let full = JSON.parse(xhr.responseText);
            console.log(full);
            console.log("Should print the fullreim object")
            displayFullReim(full);

        }
    }

    xhr.open("GET", "/BenCo/manageReim", true);
    xhr.send();




}

function denyReim(){
    
     console.log("denyReim() being called");

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);

        }
    }

    xhr.open("POST", "/BenCo/reimbAction", true);
    xhr.send('deny');
window.location.replace("/BenCo/pages/Dashboard.html");

}

function approveReim(){

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);

        }
    }

    xhr.open("POST", "/BenCo/reimbAction", true);
    xhr.send('approve');
 window.location.replace("/BenCo/pages/Dashboard.html");

}

function buttonSet(){

    console.log("buttonSet() being called");
    document.getElementById("denyReim").addEventListener("click", denyReim);
    document.getElementById("approveReim").addEventListener("click", approveReim);




}

function navBar() {
    console.log("Getting into navBar Function");
    
    document.getElementById("navDash").addEventListener("click", navigateToDashboard);
}

function navigateToDashboard(){
    
    
     console.log("Getting into navigateToDashboard Function");
    window.location.replace("/BenCo/pages/Dashboard.html");
    
}






window.onload = function() {

    this.getFullReimbursement();
    this.buttonSet();
    this.navBar();
    this.logout();
}

