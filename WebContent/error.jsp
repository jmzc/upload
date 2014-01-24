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

 
<c:forEach items="${actionErrors}" var="item" varStatus="status">
  <c:set var="actionerror" value="${status.first ? '' : actionerror} ${item}" />
</c:forEach>

<c:forEach items="${fieldErrors}" var="item" varStatus="status">
  <c:set var="fielderror" value="${status.first ? '' : fielderror} ${item}" />
</c:forEach>
 

 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8"/>
<script type="text/javascript">

var actionerror = '<c:out value="${actionerror}"/>';
var fielderror = '<c:out value="${fielderror}"/>';

var message = actionerror + ' ' + fielderror;

parent.result(1, message);

</script>
</head>
<body>
<s:actionerror/>
<s:fielderror/>
</body>
</html>