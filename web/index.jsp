<%-- 
    Document   : index
    Created on : Jun 17, 2021, 4:59:15 PM
    Author     : macarena
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Using GET Method to Read Form Data</title>
    </head>

    <body>

        <%

            String nombre = request.getParameter("nombre");
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            String descripcion = request.getParameter("descripcion");
            String domicilio = request.getParameter("domicilio");
            String destacada = request.getParameter("destacada");
            boolean isDestacada = true;

            if (destacada == null) {
                isDestacada = false;
            }

            String query = "INSERT INTO estancia(nombre, categoria, descripcion, domicilio, destacada) VALUES (?, ?, ?, ?, ?)";

            String url = "jdbc:mysql://localhost:3306/jsp";
            Connection con = null;
            PreparedStatement pstatement = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, "root", "");
                pstatement = con.prepareStatement(query);
                
                pstatement.setString(1, nombre);
                pstatement.setInt(2, categoria);
                pstatement.setString(3, descripcion);
                pstatement.setString(4, domicilio);
                pstatement.setBoolean(5, isDestacada);
                pstatement.executeUpdate();

                out.println("Registro insertado en la base de datos!");
            } catch (Exception e) {
                System.err.println(e);
            }
        %>
    </body>
</html>