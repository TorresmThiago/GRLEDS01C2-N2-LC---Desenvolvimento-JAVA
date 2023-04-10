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

                <h3>Listagem de Análises</h3>

                <form action="/analise/cadastro" method="get">
                    <button type="submit">Registrar nova Análise</button>
                </form>

                <c:if test="${empty analises}">
                    <div class="alert alert-danger">
                        <strong>Atenção!</strong> Não há aplicações cadastradas.
                    </div>
                </c:if>

                <c:if test="${not empty analises}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Titulo</th>
                                <th>Descrição</th>
                                <th>Cliente</th>
                                <th>Atividade</th>
                                <th>Qtd. Horas</th>
                                <th>Data Início</th>
                                <th>Prazo</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${analises}" var="analise">
                                <tr>
                                    <td>${analise.titulo}</td>
                                    <td>${analise.descricao}</td>
                                    <td>${analise.cliente}</td>
                                    <td>${analise.atividade}</td>
                                    <td>${analise.qtdHoras}</td>
                                    <td>${analise.dataInicio}</td>
                                    <td>${analise.dataFim}</td>
                                    <td>${analise.status}</td>
                                    <td><a href="/analise/${analise.id}/excluir">excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </div>

        </body>

        </html>