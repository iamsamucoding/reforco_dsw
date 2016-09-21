
<%@page import="br.edu.ifsp.regescweb.models.Student"%>
<jsp:include page="_header.jsp" />

<h1>Cadastrado com Sucesso!</h1>

<%
    Student student = (Student) request.getAttribute("student");
%>

Nome: <%= student.getName() %> <br/>
Idade: <%= student.getAge() %>

<jsp:include page="_footer.jsp" />