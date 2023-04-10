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
                <form action="/vulnmobile/incluir" method="post">
                    <h3>Cadastro de Vulnerabilidade Mobile</h3>

                    <div class="form-group">
                        <label>Nome:</label>
                        <input type="text" name="nome" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Descrição:</label>
                        <input type="text" name="descricao" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Recomendação:</label>
                        <input type="text" name="recomendacao" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Impacto:</label>
                        <input type="number" name="impacto" min="1" max="3" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Probabilidade:</label>
                        <input type="number" name="probabilidade" min="1" max="3" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Referência:</label>
                        <input type="text" name="referencia" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Classificação OWASP Mobile:</label>
                        <input type="text" name="classificacaoOWASPMobile" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Sistema Operacional:</label>
                        <input type="text" name="sistemaOperacionalMobile" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Pacotes Afetados:</label>
                        <input type="text" name="pacotesAfetados" class="form-control" required>
                    </div>

                    <button type="submit">Cadastrar</button>
                </form>
            </div>
        </body>

        </html>