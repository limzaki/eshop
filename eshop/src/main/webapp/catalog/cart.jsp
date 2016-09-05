<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/main.css'/> ">
</head>
<h1>Your cart</h1>
  <c:choose>
      <c:when test="${emptyCart != null}">
          <p>Your cart is empty.</p>
      </c:when>
      <c:otherwise>
        <table>
           <tr>
            <th>Qty</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            
         </tr>
         
          <c:forEach var="item" items="${cart.items}">
            <tr class="cart_row">
              <td>
                <form action="<c:url value='/order/updateItem'/>" method="post">
                  <input type="hidden" name="productCode" 
                         value="<c:out value='${item.product.code}'/>">
                         
                  <input type=text name="quantity" 
                         value="<c:out value='${item.quantity}'/>" id="quantity">
                  <input type="submit" value="Update">
                  
                </form>                  
              </td>
              <td>${item.product.description}</td>
              <td>${item.product.price} Dhs</td>
              <td>${item.total} Dhs</td>
              <td>
                <form action="<c:url value='/order/removeItem'/>" method="post">
                  <input type="hidden" name="productCode" 
                         value="<c:out value='${item.product.code}'/>">
                         
                  <input type="submit" value="Remove">
                </form>                  
              </td>
              
            </tr>
          </c:forEach>
            <tr>
              <td colspan="2">
                <p><b>To change the quantity for an item</b>, enter the new quantity 
                      and click on the Update button.</p>
                <p><b>To remove an item</b>, click on the Remove button.</p>
              </td>
              
            </tr>
          </table>
      </c:otherwise>
  </c:choose>

<a href=""><button>continue shopping</button></a>
  
<c:if test="${emptyCart == null}">
   
    <form action="<c:url value='/order/checkUser'/>" method="post">
      <input type="submit" value="Checkout">
    </form>
</c:if>
