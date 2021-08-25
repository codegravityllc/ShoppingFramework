<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome <s:property value = "firstName" /> &nbsp; <s:property value = "lastName" /> 
	
	<s:textfield name="struttextbox" label="Strut text box" />
	<input type="text" name="html text box"/>
	
</body>
</html>

 <ul>

	<s:append var="appendIterator">
     	<s:param value="%{myList1}" /> <s:param value="%{myList2}" />       
	</s:append>
	<s:iterator value="%{#appendIterator}">  
	  <li>
		  <s:property />    
	  </li>
	</s:iterator>
 </ul>
 <img src="1.png"/>