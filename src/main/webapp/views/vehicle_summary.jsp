<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
     <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
     <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"> </script>
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">





</head>
<body>

      <div  class ="container">
         <h2 class="text-center">Vehicle Summary</h2>
      
      </div>

   
                  <div class="container">
                           <table class= "table">
                 <thead class="thead-dark text-center";">
                  <tr>
                   <th>Vehicle Owner Details</th>
                  </tr>
                 </thead>
                 
                  
                     <tr>  
                       <td>First Name</td>
                     <td>${vehicleOwnerDetails.firstName}</td></tr>
                        
                     <tr>
                        <td>Last Name</td>
                     <td>${vehicleOwnerDetails.lastName}</td></tr>
                     
                     <tr>
                       <td>Gender</td>
                     <td>${vehicleOwnerDetails.gender}</td></tr>
                         
                     <tr>
                         <td>Email ID</td>
                     <td>${vehicleOwnerDetails.email}</td></tr>
                     
                     <tr>
                      <td>Date Of Birth</td>
                     <td>${vehicleOwnerDetails.dob}</td></tr>
                       
                     <tr>
                       <td>SSNo</td>
                     <td>${vehicleOwnerDetails.zzn}</td></tr>
                     
                  
                  <thead class="thead-dark text-center">
                  <tr>
                   <th>Vehicle Owner Address Details</th>
                  </tr>
                 </thead>
                  
                  
                  <tr>
                     <td>House No</td>
                  <td>${vehicleOwnerAddress.houseNo}</td></tr>
                  
                  <tr>
                     <td>Street Name</td>
                  <td>${vehicleOwnerAddress.streetName}</td></tr>
                  
                  <tr>
                      <td>City</td>
                  <td>${vehicleOwnerAddress.city}</td></tr>
                  
                  <tr>
                    <td>Zip Code</td>
                  <td>${vehicleOwnerAddress.zipCode}</td></tr>
                  
                  
                   <thead class="thead-dark text-center">
                  <tr>
                   <th>Vehicle  Details</th>
                  </tr>
                 </thead>
                  
                  
                   <tr>
                     <td>Vehicle Type</td>
                   <td>${vehicleDetails.vehicleType}</td></tr>
                   <tr>
                    <td>Vehicle Manufacturing Year</td>
                   <td>${vehicleDetails.mfgYear}</td></tr>
                   
                   <tr>
                     <td>Vehicle Brand</td>
                   <td>${vehicleDetails.vehicleBrand}</td></tr>
       
          <tr>
          <td>
          <a href="/summary/handlesummaryregbtn?vehicleOwnerId=${vehicleOwnerId}" class="btn btn-primary" style="width:100%">Register</a> 
          </td>
          
          
          <td>
          <a href="/summary/handlevehicledetails?vehicleId=${vehicleDetails.vehicleId}&vehicleOwnerId=${vehicleOwnerId}" class ="btn btn-danger" style="width:100%">Back To Form</a> 
          </td>
          </tr>
                 
                 </table>
                           
                  </div>          
                 
</body>
</html>