<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
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

   <h2 style="align-content: center">Vehicle Details </h2>
 
    <form:form action ="" method=""  modelAttribute="">
    <table align="center">
      
      <tr>
      <td>Vehicle Type</td>
      <td>
      <form:select path="vehicleType">
       <form:option value="2-wheeler"/>2-wheeler
       <form:option value="3-wheeler"/>3-wheeler
       <form:option value="4-wheeler"/>4-wheeler
       <form:option value="8-wheeler"/>8-wheeler
       <form:option value="10-wheeler"/>10-wheeler
       <form:option value="14-wheeler"/>14-wheeler    
       <form:option value="16-wheeler"/>16-wheeler
      </form:select>
      </td>
      </tr>
      
      <tr>
      <td>Manufacturing Year</td>
      <td>
       <form:input path="mfgYear"/>
      </td>
      </tr>
      
      <tr>
      <td>Brand</td>
      <td>
       <form:input path="vehicleBrand"/>
      </td>
      </tr>
                         
    </table>
    
    <input type="submit" value= "Next">
    
    </form:form>

</body>
</html>