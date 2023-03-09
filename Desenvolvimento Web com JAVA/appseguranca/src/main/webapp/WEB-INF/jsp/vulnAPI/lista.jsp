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

                <h3>Listagem de Vulnerabilidades de API</h3>

                <form action="/vulnapi/cadastro" method="get">
                    <button type="submit">Registrar nova Vulnerabilidade</button>
                </form>

                <c:if test="${empty vulnapis}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> Não há vulnerabilidade cadastradas.
                    </div>
                </c:if>

                <c:if test="${not empty vulnapis}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Descrição</th>
                                <th>Recomendação</th>
                                <th>Severidade</th>
                                <th>Referência</th>
                                <th>Classificação OWASP</th>
                                <th>Host</th>
                                <th>Requisição</th>
                                <th>Método</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${vulnapis}" var="vuln">
                                <tr>
                                    <td>${vuln.getId()}</td>
                                    <td>${vuln.getNome()}</td>
                                    <td>${vuln.getDescricao()}</td>
                                    <td>${vuln.getRecomendacao()}</td>
                                    <td>${vuln.calcularSeveridade()}</td>
                                    <td>${vuln.getReferencia()}</td>
                                    <td>${vuln.getClassificacaoOWASPAPI()}</td>
                                    <td>${vuln.getHost()}</td>
                                    <td>${vuln.getRequisicao()}</td>
                                    <td>${vuln.getMetodo()}</td>
                                    <td><a href="/vulnapi/${vuln.id}/excluir">excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>

        </body>

        </html>