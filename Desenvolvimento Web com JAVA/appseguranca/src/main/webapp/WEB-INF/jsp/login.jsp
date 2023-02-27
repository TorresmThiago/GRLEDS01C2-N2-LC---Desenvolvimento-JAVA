<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <meta charset="UTF-8">
            <title>AppSegurança</title>
        </head>

        <body>

            <c:import url="/WEB-INF/jsp/menu.jsp" />

            <div class="container">
                <h2>Autenticação</h2>

                <c:if test="${not empty mensagem}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> ${mensagem}
                    </div>
                </c:if>

                <form action="/login" method="post">

                    <div class="form-group">
                        <label>E-mail:</label>
                        <input type="text" class="form-control" placeholder="Login" name="login">
                    </div>

                    <div class="form-group">
                        <label>Senha:</label>
                        <input type="password" class="form-control" placeholder="Senha" name="senha">
                    </div>

                    <button type="submit" class="btn btn-default">Acessar</button>
                </form>
            </div>

        </body>

        </html>