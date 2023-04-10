<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <meta charset="UTF-8">
            <title>App Segurança</title>
        </head>

        <body>

            <c:import url="/WEB-INF/jsp/menu.jsp" />

            <c:if test="${not empty usuario}">
                <div class="container">
                    <h3>Olá ${usuario.nome}!</h3>
                    <p>Seja bem-vindo ao App Segurança!</p>
                </div>
            </c:if>

            <c:if test="${empty usuario}">
                <div class="container">
                    <h3>Olá!</h3>
                    <p>Seja bem-vindo ao App Segurança!</p>
                </div>
            </c:if>

        </body>

        </html>