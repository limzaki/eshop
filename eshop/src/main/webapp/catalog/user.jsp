<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/main.css'/> ">
</head>
<h1>Enter your name and contact information</h1>

<form action="<c:url value='/order/processUser' />" method="post">
    <p id="required">Required <span class="required">*</span></p>
    
    <label>First Name</label>
    <input type="text" name="firstName"  
               required>
    <p class="required">*</p><br>
    
    <label>Last Name</label>
    <input type="text" name="lastName"  required>
    <p class="required">*</p><br>
    
    <label>Email</label>
    <input type="text" name="email" required>
    <p class="required">*</p><br>
	
	<label>Phone Number</label>
    <input type="text" name="phone"  required>
    <p class="required">*</p><br>    
    
    <label>Address</label>
    <input type="text" name="address" required>
    <p class="required">*</p><br>
    
    <label>&nbsp;</label>
    <input type="submit" value="Continue">
</form>
