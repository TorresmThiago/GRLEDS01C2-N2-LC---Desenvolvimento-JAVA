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

                <h3>Listagem de Aplicações</h3>

                <form action="/aplicacao/cadastro" method="get">
                    <button type="submit">Registrar nova Aplicação</button>
                </form>

                <c:if test="${empty aplicacoes}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> Não há aplicações cadastradas.
                    </div>
                </c:if>

                <c:if test="${not empty aplicacoes}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Demanda</th>
                                <th>Ambiente</th>
                                <th>Endereço</th>
                                <th>Criado por</th>
                                <th>Qnt. Vulnerabilidades</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${aplicacoes}" var="aplicacao">
                                <tr>
                                    <td>${aplicacao.id}</td>
                                    <td>${aplicacao.nome}</td>
                                    <td>${aplicacao.demanda}</td>
                                    <td>${aplicacao.ambiente}</td>
                                    <td>${aplicacao.endereco}</td>
                                    <td>${aplicacao.usuario.nome}</td>
                                    <td>${aplicacao.vulnerabilidades.size()}</td>
                                    <td><a href="/aplicacao/${aplicacao.id}/excluir">excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>

        </body>

        </html>