
class reimbursement{
    
    constructor(employeeId, StringeventDate, approvalState, amount, gradingFormat, active, eventType, courseName){
        
        this.employeeId = employeeId;
        this.eventDate = StringeventDate;
        this.approvalState = approvalState;
        this.amount = amount;
        this.gradingFormat = gradingFormat;
        this.active = active;
        this.eventType = eventType
        this.courseName = courseName;
    }
    
    
}

function createReimburesmentFromForm(event){
   
       event.preventDefault(); 
    
   //let date = new Date();
    let managerSelect = document.getElementById("managerPosition");
    let gradingSelect = document.getElementById("gradingFormat");
    
    reim = new reimbursement(document.getElementById("employeeId").value, document.getElementById("startTrainingDate").value, managerSelect.options[managerSelect.selectedIndex].value, document.getElementById("courseCost").value, gradingSelect.options[gradingSelect.selectedIndex].value, true, document.getElementById("eventType").value, document.getElementById("courseName").value);
    console.log(reim);
    
    
      
    let xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("Reimbursement Sent to the Server");
            
        }
    }
    
    xhr.open("POST", "/BenCo/reimbursement", true);
    xhr.send(JSON.stringify(reim));
     
}

function navBar() {
    console.log("Getting into navBar Function");
    
    document.getElementById("navDash").addEventListener("click", navigateToDashboard);
}


function navigateToDashboard(){
    
    
     console.log("Getting into navigateToDashboard Function");
    window.location.replace("/BenCo/pages/Dashboard.html");
    
}

function logout(){
    document.getElementById("logout").addEventListener("click",navToLogout);
    
}

function navToLogout(){
    window.location.replace("/BenCo/pages/Login.html")
}

function dashboardAfterSubmit(){
    
document.getElementById("submitButton").addEventListener("click", navigateToDashboard);
}





window.onload = function() {
    
    this.document.getElementById("submitButton").addEventListener("click", createReimburesmentFromForm, false);
    console.log("onload funciton being reached");
    this.navBar();
    this.logout();
    this.dashboardAfterSubmit();
}
      
  
    
    
