<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Policy List</title>
</head>
<body bgcolor="cyan">
<center>
    <c:choose>
        <c:when test="${policyList ne null || !empty policyList }">
            <table border='1'>
                <tr>
                    <th>PolicyId</th>
                    <th>PolicyName</th>
                    <th>PolicyType</th>
                    <th>Tenure</th>
                </tr>
                <c:forEach var="policyListDto" items="${policyList }">
                    <tr>
                        <td>${policyListDto.policyId}</td>
                        <td>${policyListDto.policyName}</td>
                        <td>${policyListDto.policyType}</td>
                        <td>${policyListDto.tenure}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
    </c:choose>
    <c:if test="${pageNo>1}">
        <b>
            <a href='./controller?pageNo=${pageNo-1}&s1=link'>Previous</a> &nbsp;&nbsp;
        </b>
    </c:if>
    <c:forEach var='i' begin='1' end='${pageCount}' step='1'>
        <b>
            <a href='./controller?pageNo=${i}&s1=link'>[${i}]</a> &nbsp;&nbsp;
        </b>
    </c:forEach>
    <c:if test="${pageNo<pageCount}">
        <b>
            <a href='./controller?pageNo=${pageNo+1}&s1=link'>Next</a> &nbsp;&nbsp;
        </b>
    </c:if>
</center>
<h1 style='color:red;text-align: center;'>
    <a href='./index.jsp'>HOME</a>
</h1>
</body>
</html>
