<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value='/resources/css/main.css'/> ">
<h1>Your invoice</h1>

<table>
  <tr>
      <th class="top">Ship To</th>
    <td>${user.address}</td>
    <td></td>
  </tr>
  <tr>
      <td colspan="3"><hr></td>
  </tr>
  <tr>
      <th>Qty</th>
      <th>Description</th>
      <th>Price</th>
  </tr>

  <c:forEach var="item" items="${invoice.lineItems}">
  <tr>
    <td>${item.quantity}</td>
    <td>${item.product.description}</td>
    <td>${item.total}</td>
  </tr>
  </c:forEach>

  <tr>
    <th>Total:</th>
    <td></td>
    <td>${invoice.invoiceTotal}</td>
  </tr>
</table>
