<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<article>
		Failed URL: ${url} <br/>
		Exception: ${exception.message} <br/>
		<c:forEach items="${exception.stackTrace}" var="ste">    ${ste}  <br/>
    </c:forEach>
	</article>
	 <br/>
	<article>
		<c:if test="${errors != null}">
			<c:forEach items="${errors}" var="entry" varStatus="count">
			  Key: <c:out value="${entry.key}" />
			  Value: <c:out value="${entry.value}" />
			</c:forEach>
		</c:if>
	</article>
</body>
</html>
