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

                <h3>Listagem de Usuários</h3>

                <c:if test="${empty usuarios}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> Não há usuários cadastrados.
                    </div>
                </c:if>

                <c:if test="${not empty usuarios}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Senha</th>
                                <th>E-mail</th>
                                <th>Qntd. de Aplicações</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${usuarios}" var="u">
                                <tr>
                                    <td>${u.nome}</td>
                                    <td>${u.senha}</td>
                                    <td>${u.email}</td>
                                    <td>${u.aplicacoes.size()}</td>
                                    <c:if test="${usuario.admin}">
                                        <td><a href="/usuario/${u.id}/excluir">excluir</a></td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>

        </body>

        </html>