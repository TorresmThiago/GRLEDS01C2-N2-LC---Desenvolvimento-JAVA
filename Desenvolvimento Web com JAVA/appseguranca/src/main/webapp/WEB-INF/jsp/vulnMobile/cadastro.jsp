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
                        <input type="text" name="nome" class="form-control" value="Falha no saneamento de dados"
                            required>
                    </div>

                    <div class="form-group">
                        <label>Descrição:</label>
                        <input type="text" name="descricao" class="form-control"
                            value="A aplicação não realiza corretamente o saneamento dos dados de entrada do usuário"
                            required>
                    </div>

                    <div class="form-group">
                        <label>Recomendação:</label>
                        <input type="text" name="recomendacao" class="form-control"
                            value=" todas as entradas e saídas de dados sejam sanitizadas, ou seja, deixando passar apenas os caracteres válidos de acordo com os campos em questão"
                            required>
                    </div>

                    <div class="form-group">
                        <label>Impacto:</label>
                        <input type="number" name="impacto" min="1" max="3" class="form-control" value="2" required>
                    </div>

                    <div class="form-group">
                        <label>Probabilidade:</label>
                        <input type="number" name="probabilidade" min="1" max="3" class="form-control" value="2"
                            required>
                    </div>

                    <div class="form-group">
                        <label>Referência:</label>
                        <input type="text" name="referencia" class="form-control"
                            value="https://cheatsheetseries.owasp.org/cheatsheets/Input_Validation_Cheat_Sheet.html"
                            required>
                    </div>

                    <div class="form-group">
                        <label>Classificação OWASP Mobile:</label>
                        <input type="text" name="classificacaoOWASPMobile" class="form-control" value="A3 - Injeção"
                            required>
                    </div>

                    <div class="form-group">
                        <label>Sistema Operacional:</label>
                        <input type="text" name="sistemaOperacionalMobile" class="form-control" value="iOS" required>
                    </div>

                    <div class="form-group">
                        <label>Pacotes Afetados:</label>
                        <input type="number" name="pacotesAfetados" class="form-control" value="2" required>
                    </div>

                    <button type="submit">Cadastrar</button>
                </form>
            </div>
        </body>

        </html>