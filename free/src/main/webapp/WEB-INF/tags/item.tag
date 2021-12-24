<%@ tag language="java" body-content="tagdependent" pageEncoding="UTF-8"%>
<%@ attribute name="bgcolor" %>
<%@ attribute name="border" %>
<jsp:useBean id="local" class="jungeun_free.controller.Local"/>
<H2><jsp:doBody/></H2>
<table border="${border}" bgcolor="${bgcolor}" width="150">
<%
for(String item : local.getLocalList()) {
out.println("<tr><td>"+item+"</td></tr>");
}
%>
</table>