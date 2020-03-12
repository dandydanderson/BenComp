class reimbursement{

    constructor(reimbursementId, employeeId, dateSubmitted, StringeventDate, approvalState, amount, gradingFormat, active, lastApprovalDate, courseName){

        this.reimbursementId = reimbursementId;
        this.employeeId = employeeId;
        this.dateSubmitted = dateSubmitted;
        this.eventDate = StringeventDate;
        this.approvalState = approvalState;
        this.amount = amount;
        this.gradingFormat = gradingFormat;
        this.active = active;
        this.lastApprovalDate = lastApprovalDate;
        //   this.eventType = eventType
        this.courseName = courseName;
    }


}


class employee{

    constructor(employeeId, firstName, lastName, deptName, position, reimbursementTotal){

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptName = deptName;
        this.position = position;
        this.reimbursementTotal = reimbursementTotal;

    }


}




function createNewReim(){

    document.getElementById("newReim").addEventListener("click", navigateToForm);
    document.getElementById("navBarNewReim").addEventListener("click", navigateToForm);
}

function navigateToForm(){

    window.location.replace("/BenCo/pages/ReimbursementForm.html");

}

function logout(){
    document.getElementById("logout").addEventListener("click",navToLogout);
    
}

function navToLogout(){
    window.location.replace("/BenCo/pages/Login.html")
}




function getMyReimbursements() {

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {
            let reimList = JSON.parse(xhr.responseText);
            console.log(reimList);
            displayReimList(reimList);

        }
    }

    xhr.open("GET", "/BenCo/reimbursement", true);
    xhr.send();

}


function getEmployee() {

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

        if (xhr.readyState === 4 && xhr.status === 200) {
            let employee = JSON.parse(xhr.responseText);
            console.log(employee);
            console.log("Should print employee")
            displayEmployee(employee);

        }
    }

   
    xhr.open("GET", "/BenCo/login", true);
     xhr.send();

}

function displayEmployee(employee){

    document.getElementById("employeeId").textContent = employee.employeeId;
    document.getElementById("firstName").innerHTML = employee.firstName;
    document.getElementById("lastName").innerHTML = employee.lastName;
    document.getElementById("deptName").innerHTML = employee.deptName;
    document.getElementById("reimbursementTotal").innerHTML = employee.reimbursementTotal;
    document.getElementById("position").innerHTML = employee.position;




}

function clickReim(){
    console.log("clicked reimbursement " + this.childNodes[0].textContent);
    var reimNum = this.childNodes[0].textContent;
    
    
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

        if (xhr.readyState === 4 && xhr.status === 200) {

           //this just sends the reimbursement id

        }
    }

   
    
     xhr.open("POST", "/BenCo/manageReim", true);
     xhr.send(reimNum);
    
    window.location.replace("/BenCo/pages/ReimbursementManagement.html");
}





function displayReimList(reimList){

    var rowNum = 0;
    
    console.log('We are in!');
    console.log(reimList);
    console.log(reimList[0]);

    for (let reimbursement of reimList){



        let row = document.createElement("tr");
        row.className = "list-form";
        let reimbursement_id = document.createElement("td");
        let employee_id = document.createElement("td");
        let date_submitted = document.createElement("td");
        let event_date = document.createElement("td");
        let approval_stage = document.createElement("td");
        let amount = document.createElement("td");
        let grading_format = document.createElement("td");
        let active = document.createElement("td");
        let last_approval_date = document.createElement("td");
        let course_name = document.createElement("td");

        reimbursement_id.innerHTML = reimbursement.reimbursementId;
        employee_id.innerHTML = reimbursement.employeeId;
        date_submitted.innerHTML = reimbursement.dateSubmitted;
        event_date.innerHTML = reimbursement.eventDate;
        approval_stage.innerHTML = reimbursement.approvalState;
        amount.innerHTML = reimbursement.amount;
        grading_format.innerHTML = reimbursement.gradingFormat;
        active.innerHTML = reimbursement.active;
        last_approval_date.innerHTML = reimbursement.lastApprovalDate;
        course_name.innerHTML = reimbursement.courseName;


        row.append(reimbursement_id);
        row.append(employee_id);
        row.append(course_name);
        row.append(date_submitted);
        row.append(event_date);
        row.append(approval_stage);
        row.append(amount);
        row.append(grading_format);
        row.append(active);
        row.append(last_approval_date);
        row.append(course_name);

        let position = document.getElementById("position").innerHTML;

        console.log(reimbursement.approvalState + " /" + position);




        if(reimbursement.approvalState == position){
           
            row.id = rowNum;
          console.log(row);
            document.getElementById("myManagerReimTable").appendChild(row);
            
            document.getElementById(rowNum).addEventListener("click", clickReim);
            rowNum +=1;
        }
        else{
            document.getElementById("myReimTable").appendChild(row);
        }

        console.log(reimbursement);
        console.log(reimbursement.reimbursementId);



    }  

}








window.onload = function() {

    this.getEmployee();
    this.createNewReim();
    this.getMyReimbursements();
    this.logout();

}