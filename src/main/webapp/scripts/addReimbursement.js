
class reimbursement{
    
    constructor(employeeID, dateSubmitted, eventDate, approvalState, amount, gradingFormat, active, lastApprovalDate, eventType){
        
        this.employeeID = employeeID;
        this.dateSubmitted = dateSubmitted;
        this.eventDate = eventDate;
        this.approvalState = approvalState;
        this.amount = amount;
        this.gradingFormat = gradingFormat;
        this.active = active;
        this.lastApprovalDate = lastApprovalDate;
        this.eventType = eventType
      //  this.courseName = courseName;
    }
    
    
}

function createReimburesmentFromForm(e){
   
    
    
   let date = new Date();
    let managerSelect = document.getElementById("managerPosition");
    let gradingSelect = document.getElementById("gradingFormat");
    
    reim = new reimbursement(document.getElementById("employeeId").value, date.toDateString(), document.getElementById("startTrainingDate").value, managerSelect.options[managerSelect.selectedIndex].value, document.getElementById("courseCost").value, gradingSelect.options[gradingSelect.selectedIndex].value, true, date.toDateString(), document.getElementById("eventType").value);
    return reim;
    
    
      
    let xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("Reimbursement Sent to the Server");
            
        }
    }
    
    xhr.open("POST", "/BenCo/reimbursement",true);
    xhr.send(JSON.stringify(reim));
   event.preventDefault(e);      
}


window.onload = function() {
    
    this.document.getElementById("submitButton").addEventListener("click", createReimburesmentFromForm, false);
}
      
  
    
    
