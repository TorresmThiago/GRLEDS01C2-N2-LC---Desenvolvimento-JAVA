<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">AppSegurança</a>
                </div>

                <ul class="nav navbar-nav">
                    <li><a href="/">Home</a></li>
                    <c:if test="${not empty usuario}">
                        <li><a href="/usuario/lista">Usuário</a></li>
                        <li><a href="/analise/lista">Análise</a></li>
                        <li><a href="/aplicacao/lista">Aplicação</a></li>
                        <li><a href="/vulnerabilidade/lista">Vulnerabilidades</a></li>
                        <li><a href="/vulnweb/lista">Web</a></li>
                        <li><a href="/vulnapi/lista">API</a></li>
                        <li><a href="/vulnmobile/lista">Mobile</a></li>
                    </c:if>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${not empty usuario}">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Olá ${usuario.nome}!</a></li>
                        <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                    </c:if>

                    <c:if test="${empty usuario}">
                        <li><a href="/usuario/cadastro"><span class="glyphicon glyphicon-user"></span>Registrar</a>
                        </li>
                        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </c:if>
                </ul>
            </div>
        </nav>