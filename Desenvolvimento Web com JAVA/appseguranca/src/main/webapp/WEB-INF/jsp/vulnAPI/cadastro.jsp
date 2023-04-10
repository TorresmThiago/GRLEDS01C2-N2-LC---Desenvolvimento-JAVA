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
                <form action="/vulnapi/incluir" method="post">
                    <h3>Cadastro de Vulnerabilidade de API</h3>

                    <div class="form-group">
                        <label>Nome:</label>
                        <input type="text" name="nome" class="form-control" required value="Uso de autenticação básica">
                    </div>

                    <div class="form-group">
                        <label>Descrição:</label>
                        <input type="text" name="descricao" class="form-control" required
                            value="A autenticação de acesso básica é um método de passar o login e senha do usuário para a aplicação via cabeçalho HTTP. Dessa forma, as credenciais do usuário são enviadas em claro">
                    </div>

                    <div class="form-group">
                        <label>Recomendação:</label>
                        <input type="text" name="recomendacao" class="form-control" required
                            value="Interromper a utilização da autenticação básica na aplicação e seus componentes. Em seu lugar, utilizar métodos seguros como OAuth ou JSON Web Tokens (JWT).">
                    </div>

                    <div class="form-group">
                        <label>Impacto:</label>
                        <input type="number" name="impacto" min="1" max="3" class="form-control" required value="2">
                    </div>

                    <div class="form-group">
                        <label>Probabilidade:</label>
                        <input type="number" name="probabilidade" min="1" max="3" class="form-control" required
                            value="1">
                    </div>

                    <div class="form-group">
                        <label>Referência:</label>
                        <input type="text" name="referencia" class="form-control" required
                            value="https://cwe.mitre.org/data/definitions/311.html">
                    </div>

                    <div class="form-group">
                        <label>Classificação OWASP API:</label>
                        <input type="text" name="classificacaoOWASPAPI" class="form-control" required
                            value="A5 - Configuração incorreta de segurança">
                    </div>

                    <div class="form-group">
                        <label>Host:</label>
                        <input type="text" name="host" class="form-control" required value="http://localhost:8080">
                    </div>

                    <div class="form-group">
                        <label>Requisição:</label>
                        <input type="text" name="requisicao" class="form-control" required value="/api/v1/usuarios">
                    </div>

                    <div class="form-group">
                        <label>Método HTTP:</label>
                        <input type="text" name="metodo" class="form-control" required value="POST">
                    </div>


                    <button type="submit">Cadastrar</button>
                </form>
            </div>
        </body>

        </html>