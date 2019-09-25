

<%@page import="com.revista.Revista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.revista.ListaRevistaEditor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
    </head>
    <body>
            <%@include file="NavegarcionEditor.html" %>
            <%System.out.println("HOla: "+session.getAttribute("Usuario").toString());
                    
            %>
            <div> 
            </div>
            <div>
                <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Titulo</th>
                        <th>Informacion</th>
                    </tr>
                    </thead>
                    <tbody>
                                <%
                                    ListaRevistaEditor listaRevistas;
                                    listaRevistas = new ListaRevistaEditor(session.getAttribute("Usuario").toString());
                                    
                                    ArrayList<Revista> dato = (ArrayList<Revista>) listaRevistas.listarRevistas();
                                    System.out.print(dato.isEmpty());
                                for (int i = 0; i < dato.size(); i++) {
                                        out.println("<tr>");
                                        out.println("<td>"+(i+1)+"</td>");
                                        out.println("<td><a href=\"VerRevista?id="+dato.get(i).getID()+"\" target=\"_blank\">"+dato.get(i).getTitulo()+"</a></td>");
                                        out.println("<td>"+dato.get(i).getDescripcion()+"</td>");
                                    }
                                %>
                                
                            
                            
                        
                    </tbody>
                    
                </table>
                
                
            </div>
    </body>
</html>
