<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <meta charset="ISO-8859-1">
        <title>AppLanche</title>
    </head>

    <body>



        <div class="container">

            <form action="/usuario/cadastro" method="get">
                <h3>Listagem de Usuários</h3>

                <button type="submit">Novo</button>
            </form>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Senha</th>
                        <th>E-mail</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- <% List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
                            for (Usuario usuario : lista) {
                            %>
                            <tr>
                                <td>
                                    <%= usuario.getNome() %>
                                </td>
                                <td>
                                    <%= usuario.getSenha() %>
                                </td>
                                <td>
                                    <%= usuario.getEmail() %>
                                </td>
                            </tr>
                            <% } %> -->

                    <tr>
                        <td>
                            Fulano Sicrano
                        </td>
                        <td>
                            !S3NH4
                        </td>
                        <td>
                            fulano@sicrano.com
                </tbody>
            </table>
        </div>

    </body>

    </html>