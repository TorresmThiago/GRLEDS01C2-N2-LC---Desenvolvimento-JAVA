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
                <form action="/vulnweb/incluir" method="post">
                    <h3>Cadastro de Vulnerabilidade Web</h3>

                    <div class="form-group">
                        <label>Nome:</label>
                        <input type="text" name="nome" class="form-control" required
                            value="Falha na validação dos campos dos formulários">
                    </div>

                    <div class="form-group">
                        <label>Descrição:</label>
                        <input type="text" name="descricao" class="form-control" required
                            value="Alguns campos dos formulários não são validados corretamente no servidor, permitindo um funcionamento diferente do previsto na aplicação.">
                    </div>

                    <div class="form-group">
                        <label>Recomendação:</label>
                        <input type="text" name="recomendacao" class="form-control" required
                            value="Implementar as devidas validações dos campos dos formulários no lado cliente e, principalmente, no lado servidor da aplicação">
                    </div>

                    <div class="form-group">
                        <label>Impacto:</label>
                        <input type="number" name="impacto" min="1" max="3" class="form-control" required value="2">
                    </div>

                    <div class="form-group">
                        <label>Probabilidade:</label>
                        <input type="number" name="probabilidade" min="1" max="3" class="form-control" required
                            value="2">
                    </div>

                    <div class="form-group">
                        <label>Referência:</label>
                        <input type="text" name="referencia" class="form-control" required
                            value="https://cwe.mitre.org/data/definitions/20.html">
                    </div>

                    <div class="form-group">
                        <label>Classificação OWASP:</label>
                        <input type="text" name="classificacaoOWASP" class="form-control" required value="A3 - Injeção">
                    </div>

                    <div class="form-group">
                        <label>Navegador:</label>
                        <input type="text" name="navegador" class="form-control" required value="Firefox">
                    </div>

                    <div class="form-group">
                        <label>Rede interna?</label><br>
                        <label for="sim">Sim</label>
                        <input type="radio" name="redeInterna" id="sim" value="1" required>

                        <label for="nao">Não</label>
                        <input type="radio" name="redeInterna" id="nao" value="0" required>
                    </div>

                    <div class="form-group">
                        <label>URL Afetados:</label>
                        <input type="text" name="urlAfetada" class="form-control" required
                            value="localhost:8080/appseguranca">
                    </div>

                    <button type="submit">Cadastrar</button>
                </form>
            </div>
        </body>

        </html>