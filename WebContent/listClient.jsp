<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "heb" dir = "rtl">
<head>
<link rel="stylesheet" type="text/css" href="izuv.css">
<script src="jscommends.js"></script>
<title>list client</title>
</head>
<body>
 
<h1>דו"ח לקוחות</h1>
<section>
  <table id="clienttable" cellspacing="0" cellpadding="0" style="text-align:center;">
  
    <thead>
      <tr>
        <th>שם לקוח</th>
        <th>שם משפחה</th>
        <th>תעודת זהות</th>
        <th>כתובת מייל</th>
        <th>טלפון</th>
      </tr>
    </thead>
    
    <tbody>
    
   <c:forEach items="${clients}" var="cli" >
      <tr>
        <td class="lalign"><c:out value = "${ cli.f_name}"/></td>
        <td class="lalign"><c:out value = "${ cli.l_name}"/></td>
        <td class="lalign"><c:out value = "${ cli.client_id}"/></td>
        <td class="lalign"><c:out value = "${ cli.mail_client}"/></td>
        <td class="lalign"><c:out value = "${ cli.phone_client}"/></td>
      </tr>
      <tr>   
   </c:forEach>	
   
    </tbody>
  </table>
  </section>
  <a href = "clientController?action=clientlist">ddd</a>

</body>

</html>