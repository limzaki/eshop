<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>E-Shop</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-5">

<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/> ">

</head>

<body>
	<div id="header">
		<a href="" class="float"><img src="<c:url value='/resources/images/logo.jpg'/>" alt="" width="171" height="73" /></a>																																								
	 
		
		
	</div>
	
	<div id="container">
	  <div id="center" class="column">
	  	<div id="content">
			<div id="about">
				
				<div class="photos">
					<img src="<c:url value='${product.imageURL}'/>" alt="" width="177" height="165" /><br />
					
				</div>
				<div class="description">
					<p><u>${product.description}</u> <span class="price">${product.price} Dhs</span></p>
					<p>${product.details}</p>
					<form method="post" action="<c:url value='/order/addItem'/>">
            			<input type="hidden" name="productCode" value="${product.code}">
						<button>Add to Cart</button><img src="<c:url value='/resources/images/carts.gif'/>" alt="" width="16" height="24" class="carts" />
					</form>
				</div>
			</div>
		</div>
	  </div>
	  <div id="left" class="column">
	  	<div class="block">
		<img src="<c:url value='/resources/images/title1.gif'/>" alt="" width="168" height="42" /><br />
			<ul id="navigation">
				<li class="color"><a href="#">Electronique</a></li>
				<li><br></li>
				<li class="color"><a href="#">Habillement</a></li>
				<li><br></li>
				<li class="color"><a href="#">Ameublement</a></li>
				<li><br></li>
				<li class="color"><a href="#">Electromenager</a></li>
				<li><br></li>
				<li class="color"><a href="#">Sport & Loisirs</a></li>
				<li><br></li>
				<li class="color"><a href="#">Autres Categories</a></li>
				
			</ul>
		</div>
	</div>
	</div>
	
	<div id="footer">
	
		<p>Copyright &copy;. All rights reserved.  </p>
	</div>
</body>
</html>
