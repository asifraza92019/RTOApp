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

    <style>
    .details
        {
            margin-top: 100px;
            margin-left: 400px;
        }
    
    
    </style>

</head>
<body>
           
            
            <div class="container" >
              <div class="details" style="border: 2px solid green;width:250px;background-color: cornflowerblue;">
               <p class="text-center">your registration Number is :</p> 
                 <p  class="text-center" style="color: red">${vehicleRegNumber}</p>
                  <table>
                      <tr>
                          <td><a href="/vehicleReg/index" class="btn btn-primary" style="width: 120px;">Back </a></td>
                           <td><a href="/vehicleReg/download?regNumber=${vehicleRegNumber}" class="btn btn-danger" style="width: 120px;">Download </a></td>
                      </tr>
                  </table>
              </div>
            
            </div>
            
           
                
</body>
</html>