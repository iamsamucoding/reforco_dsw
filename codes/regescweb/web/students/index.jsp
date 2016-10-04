<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifsp.regescweb.models.Student"%>
<jsp:include page="_header.jsp" />

<h1>Gerenciamento de Estudantes</h1>

<%
    ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("list");
%>

<table>
    <thead>
        <th>ID</th>
        <th>Nome</th>
        <th>Idade</th>
    </thead>
    <tbody>
        <%
            for (Student student : list) {
        %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getAge() %></td>
            </tr>
        <%
            }
        %>
    </tbody>
</table>

<br/><br/>
<a href="new.jsp">Cadastrar</a>
        
<jsp:include page="_footer.jsp" />
