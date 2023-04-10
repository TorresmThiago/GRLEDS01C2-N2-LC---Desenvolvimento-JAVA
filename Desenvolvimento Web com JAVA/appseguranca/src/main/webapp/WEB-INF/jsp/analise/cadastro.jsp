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
                <form action="/analise/incluir" method="post">
                    <h3>Cadastro de Análise</h3>

                    <div class="form-group">
                        <label>Titulo:</label>
                        <input type="text" name="titulo" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Descrição:</label>
                        <input type="text" name="descricao" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Cliente:</label>
                        <input type="text" name="cliente" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Atividade:</label>
                        <input type="text" name="atividade" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Quantidade de horas:</label>
                        <input type="number" name="qtdHoras" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Data Inicial:</label>
                        <input type="date" name="dataInicio" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Prazo:</label>
                        <input type="date" name="dataFim" value="" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Status:</label>
                        <input type="text" name="status" value="" class="form-control" required>
                    </div>

                    <button type="submit">Cadastrar</button>
                </form>
            </div>
        </body>

        </html>