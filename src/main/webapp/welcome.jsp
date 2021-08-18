<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome <s:property value = "firstName" />
	
	
</body>
</html>

<!--

	<s:append var="appendIterator">
     	<s:param value="%{myList1}" />       
	</s:append>
	<s:iterator value="%{#appendIterator}">  
	    <s:property />    
	</s:iterator>
-->