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
  
  
  
    <script>
  $(function() {
	
	    $('form[id="vehicleDetails"]').validate({
			rules : {
			
				vehicleType : 'required',
				mfgYear : 'required',
				vehicleBrand  : 'required'
				
			},
			messages : {
			
				vehicleType : 'please choose your vehicle type',
				mfgYear: 'select vehicle manufacturing year',
				vehicleBrand : 'enter your  vehicle brand'
				
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
  
  </script>

 
  <style>
       .error {
	color: #FF0000
      }
      
      </style>
      

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  .ui-autocomplete-category {
    font-weight: bold;
    padding: .2em .4em;
    margin: .8em 0 .2em;
    line-height: 1.5;
  }
  </style>
  
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $.widget( "custom.catcomplete", $.ui.autocomplete, {
      _create: function() {
        this._super();
        this.widget().menu( "option", "items", "> :not(.ui-autocomplete-category)" );
      },
      _renderMenu: function( ul, items ) {
        var that = this,
          currentCategory = "";
        $.each( items, function( index, item ) {
          var li;
          if ( item.category != currentCategory ) {
            ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
            currentCategory = item.category;
          }
          li = that._renderItemData( ul, item );
          if ( item.category ) {
            li.attr( "aria-label", item.category + " : " + item.label );
          }
        });
      }
    });
    var data = [
      { label: "Honda", category: "" },
      { label: "Hero", category: "" },
      { label: "Royal Enfield", category: "" },
      { label: "Maruti", category: "" },
      { label: "TATA", category: "" },
      { label: "ETOS", category: "" },
      { label: "Ford", category: "" },
      { label: "Audi", category: "" },
      { label: "BMW", category: "" },
      { label: "Mercedes", category: "" },
      { label: "Apache", category: "" },
      { label: "TVS", category: "" },
      { label: "Ashok Lyland", category: "" },
      { label: "Bajaj", category: "" },
      { label: "Mahindra", category: "" }
      
    ];
 
    $( "#search" ).catcomplete({
      delay: 0,
      source: data
    });
  } );
  </script>
  


  
  

</head>
<body>

   
 <h2 style="color: green;" class="text-center">Vehicle Details</h2>
         <hr/>
    <form:form action ="/vehicledetails/handlevehicledetails" method="post"  modelAttribute="vehicleDetails" id="vehicleDetails">
    <table align="center">
      
      <tr>
      <td>
      <input type="hidden" name="vehicleOwnerId" value="${vehicleOwnerId}" />
       </td>      
      </tr>
      
      <tr>
      <td>
      <input type="hidden" name="addressId" value="${vehicleOwnerAddress.addressId}" />
       </td>      
      </tr>
      
      <tr>
      <td>
      <input type="hidden" name="vehicleId" value="${vehicleDetails.vehicleId}" />
       </td>      
      </tr>
      
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
       <form:select  path="mfgYear">
        <form:option value="2010"/>2006
        <form:option value="2010"/>2007
        <form:option value="2010"/>2008
        <form:option value="2010"/>2009
        <form:option value="2010"/>2010
        <form:option value="2011"/>2011
        <form:option value="2012"/>2012
        <form:option value="2013"/>2013
        <form:option value="2014"/>2014
        <form:option value="2015"/>2015
        <form:option value="2016"/>2016
        <form:option value="2017"/>2017
        <form:option value="2018"/>2018
        <form:option value="2019"/>2019
        <form:option value="2020"/>2020
       
       </form:select>
      </td>
      </tr>
      
      <tr>
      <td>Brand</td>
      <td>
       <form:input path="vehicleBrand" id="search"/>
      </td>
      </tr>
                         
    </table>
    <br/>
    <div style="text-align:center;">
<input type="submit" value ="Next" class="btn btn-primary" style="width: 300px;"/>
              </div>
    
    </form:form>


<br/>
 <div style="text-align:center;">
 <a href="/vehicledetails/handlepreviousaddress?vehicleOwnerId=${vehicleOwnerId}&vehicleAddrId=${vehicleOwnerAddress.addressId}" class="btn btn-primary" style="width: 300px;">Previous</a>
              </div>


</body>
</html>