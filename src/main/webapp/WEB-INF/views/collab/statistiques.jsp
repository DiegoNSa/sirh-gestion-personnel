<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
	/sgp/collaborateurs/nouveau <c:out value="${nombreVisiteNouveau}" />
	</p>
	
	<p>
	/sgp/collaborateurs/lister  <c:out value="${nombreVisiteLister}" />
	</p>
	
	<p>
	/sgp/collaborateurs/editer  <c:out value="${nombreVisiteEditer}" />
	</p>
	
		
	
</body>
</html>