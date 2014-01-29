<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- 
<c:set var="abc"><c:out value="${xyz}" /></c:set>
 -->
 
 <!--
<c:set var="err" scope="request" value="${requestScope['org.apache.struts.action.ERROR']}"/>
<c:set var="exp" scope="request" value="${requestScope['org.apache.struts.action.EXCEPTION']}"/>
-->
<!-- 
 FreemarkerTemplateEngine:126 - Could not load template /template/plain/actionerror
 -->
 

<!-- 
<s:iterator value="actionErrors">
  	<c:set var="actionerror"><s:property escape="false" /></c:set>
</s:iterator>
 -->
 
  <!-- 
<c:set var="actionerror" scope="request"><s:actionerror/></c:set>
<c:set var="fielderror" scope="request"><s:fielderror/></c:set>
 -->

<c:choose>
      <c:when test="${!empty fieldErrors}">
      <c:forEach items="${fieldErrors}" var="item" varStatus="status">
  			<c:set var="message" value="${status.first ? '' : message} ${item}" />
	</c:forEach>
	 </c:when>
      <c:otherwise>
		<c:forEach items="${actionErrors}" var="item" varStatus="status">
  			<c:set var="message" value="${status.first ? '' : message} ${item}" />
		</c:forEach>
      </c:otherwise>
</c:choose>
      
<c:choose>
      <c:when test="${empty reports}">
  		<c:set var="mode" value="1" />
	 </c:when>
      <c:otherwise>
		 <c:set var="mode" value="2" />
      </c:otherwise>
</c:choose>
      
 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8"/>
<link href="css/style2.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">


var message = '<c:out value="${message}"/>';

if (message.indexOf("=") >= 0)
{
	message = message.split("=")[1];	
}	

var mode = '<c:out value="${mode}"/>';

parent.result(mode, message);

</script>
</head>
<c:if test="${not empty reports}"> 
<div id="report" class="report">
<table border="0" width="100%" >
  <thead>
    <tr>
      <th width="100%" height="5px" colspan="2"></th>
     
    </tr>
  </thead>
  <tbody>
  	<s:iterator value="reports">
  		<tr>
      		<td width="20%">Fila <s:property value="row"/></td>
      		<td><s:property value="message"/></td>
    	</tr>
	</s:iterator>
  </tbody>
</table>
</div>

</body>
</c:if>

</html>