<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<tiles:insertTemplate template="tiles/layout.jsp">
	<tiles:putAttribute name="title" value="Template" cascade="true" />
	<tiles:putAttribute name="header" value="tiles/header.jsp" />
	<tiles:putAttribute name="menu" value="tiles/menu.jsp" />
	<tiles:putAttribute name="body" value="tiles/helloWorld.jsp" />
	<tiles:putAttribute name="footer" value="tiles/footer.jsp" />
</tiles:insertTemplate>