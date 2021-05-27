<%@ page contentType="text/html; charset=UTF-8"%>
<%-- <%@ include file="common/header.jspf" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="home" value="/"/>
<html>

<body>
<div align="center">
<table width="100%">
<tr>
	<td><%@ include file="common/top.jsp" %></td>
</tr>
<tr>
 	<td  ><c:import url="${home}${formpath}"/> </td>
</tr>
<tr>
	<td><%@ include file="common/footer.jspf" %></td>
</tr>
</table>
</div>
</body>
</html>