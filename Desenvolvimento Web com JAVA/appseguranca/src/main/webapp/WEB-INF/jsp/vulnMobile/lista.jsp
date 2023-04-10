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

                <h3>Listagem de Vulnerabilidades Mobile</h3>

                <form action="/vulnmobile/cadastro" method="get">
                    <button type="submit">Registrar nova Vulnerabilidade</button>
                </form>

                <c:if test="${not empty msg}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> ${msg}.
                    </div>
                </c:if>

                <c:if test="${empty vulnmobiles}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> Não há vulnerabilidade cadastradas.
                    </div>
                </c:if>

                <c:if test="${not empty vulnmobiles}">
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
                                <th>Sistema Operacional</th>
                                <th>Pacotes Afetados</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${vulnmobiles}" var="vuln">
                                <tr>
                                    <td>${vuln.getId()}</td>
                                    <td>${vuln.getNome()}</td>
                                    <td>${vuln.getDescricao()}</td>
                                    <td>${vuln.getRecomendacao()}</td>
                                    <td>${vuln.calcularSeveridade()}</td>
                                    <td>${vuln.getReferencia()}</td>
                                    <td>${vuln.getClassificacaoOWASPMobile()}</td>
                                    <td>${vuln.getSistemaOperacionalMobile()}</td>
                                    <td>${vuln.getPacotesAfetados()}</td>
                                    <td><a href="/vulnmobile/${vuln.id}/excluir">excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>

        </body>

        </html>