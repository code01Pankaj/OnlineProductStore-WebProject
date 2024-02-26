<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession hs=(HttpSession)request.getSession();

String ms = (String)request.getAttribute("msg");
out.println(ms);
hs.removeAttribute("abean");
hs.removeAttribute("al");
hs.invalidate();
%>
<jsp:include page="home.html"/>
</body>
</html>