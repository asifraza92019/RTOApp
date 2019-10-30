<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
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
    
         <h1 style="color: green; align-content: center">Vehicle Owner Registration </h1>
         <hr/>
         
         <form:form action ="vehicle/savevehicleowner" method="post" modelAttribute="">
          
           <table align= "center">
               <tr>
                  <td>First Name</td>
                  <td><form:input path="firstName"/></td>
               </tr>
               <tr>
                  <td>Last Name</td>
                  <td><form:input path="lastName"/></td>
               </tr>
               
               <tr>
                  <td>Gender</td>
                  <td>
                   <form:radiobutton path="gender" value="male"/>Male
                  <form:radiobutton path="gender" value="female"/>Female
                  </td>
               </tr>
               
               <tr>
                  <td>Email ID</td>
                  <td><form:input path="email"/></td>
               </tr>
               
               <tr>
                  <td>D.O.B</td>
                  <td><form:input path="dob"/></td>
               </tr>
               
               <tr>
                  <td>Phone Number</td>
                  <td><form:input path="phoneNumber"/></td>
               </tr>
               
               <tr>
                  <td>SSNo</td>
                  <td><form:input path="zzn"/></td>
               </tr>
               
               
           </table>
         <input type="submit" value ="Next"/>
         
         </form:form>
         
     
</body>
</html>