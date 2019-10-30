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
  
     <h1 style= "align-content: center;"> Vehicle Owner Address Details </h1>
   
    <hr/>
    
    
    <form:form action ="" method="post" modelAttribute="">
     
       <table align="center">
       <tr>
       <td>House No</td>
       <td>
         <form:input path="houseNo"/>
       </td>
       </tr>
       
       <tr>
       <td>Street Name</td>
       <td>
         <form:input path="streetName"/>
       </td>
       </tr>
       
        <tr>
       <td>City</td>
       <td>
         <form:select path="city">
           <form:option value ="Los Angeles"/>Los Angeles
           <form:option value ="San Diego"/>San Diego
           <form:option value ="Los Altos"/>Los Altos
           <form:option value ="Malibu"/>Malibu
           <form:option value ="Rio Dell"/>Rio Dell
           <form:option value ="Yuba CityCounty"/>Yuba CityCounty
         </form:select>
       </td>
       </tr>
       
       <tr>
       <td>Zip Code</td>
       <td>
         <form:input path="zipCode"/>
       </td>
       </tr>
       
       
       </table>
    
         <input type="submit" value ="Next"/>
    
    </form:form>



</body>
</html>