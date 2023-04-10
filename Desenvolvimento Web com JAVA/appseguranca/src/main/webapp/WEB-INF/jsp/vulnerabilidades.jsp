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

                <h3>Listagem de Vulnerabilidades</h3>

                <c:if test="${not empty msg}">
                    <div class="alert alert-success">
                        <strong>Atenção!</strong> ${msg}.
                    </div>
                </c:if>

                <c:if test="${empty vulnerabilidades}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> Não há vulnerabilidades cadastradas.
                    </div>
                </c:if>

                <c:if test="${not empty vulnerabilidades}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Descrição</th>
                                <th>Recomendação</th>
                                <th>Severidade</th>
                                <th>Referência</th>
                                <th>Criado Por:</th>
                                <th>Relacionado a:</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${vulnerabilidades}" var="vuln">
                                <tr>
                                    <td>${vuln.getId()}</td>
                                    <td>${vuln.getNome()}</td>
                                    <td>${vuln.getDescricao()}</td>
                                    <td>${vuln.getRecomendacao()}</td>
                                    <td>${vuln.calcularSeveridade()}</td>
                                    <td>${vuln.getReferencia()}</td>
                                    <td>${vuln.getUsuario().getNome()}</td>
                                    <td>${vuln.getAplicacao().getNome()}</td>
                                    <td><a href="/vulnerabilidade/${vuln.id}/excluir">excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>

        </body>

        </html>