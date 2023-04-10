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
                <form action="/aplicacao/incluir" method="post">
                    <h3>Cadastro de Aplicação</h3>

                    <div class="form-group">
                        <label>Nome da Aplicação:</label>
                        <input type="text" name="nome" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Demanda:</label>
                        <input type="text" name="demanda" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Ambiente:</label>
                        <input type="text" name="ambiente" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Endereço:</label>
                        <input type="text" name="endereco" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <c:if test="${not empty analises}">
                            <label>Análise:</label>
                            <select name="solicitante" class="form-control">
                                <c:forEach var="a" items="${analises}">
                                    <option value="${a.id}">${a.titulo}</option>
                                </c:forEach>
                            </select>
                        </c:if>
                        <c:if test="${empty analises}">
                            <c:set var="botao" value="disabled" />
                            <label>Não existem análises cadastradas!</label>
                        </c:if>
                    </div>

                    <div class="form-group">
                        <c:if test="${not empty vulnerabilidades}">
                            <label>Vulnerabilidades:</label>
                            <c:forEach var="v" items="${vulnerabilidades}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="checkbox" name="vulnerabilidades" value="${v.id}"
                                            class="form-check-input">
                                        ${v.nome}
                                    </label>
                                </div>
                            </c:forEach>
                        </c:if>

                        <c:if test="${empty vulnerabilidades}">
                            <c:set var="botao" value="disabled" />
                            <label>Não existem vulnerabilidades cadastradas!</label>
                        </c:if>
                    </div>

                    <button ${botao} type="submit">Cadastrar</button>
                </form>
            </div>
        </body>

        </html>