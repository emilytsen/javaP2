<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Atualizar Jogos</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Atualizar Jogo</h1>
            <a href="/jogo" class="btn btn-primary">Voltar</a>
            <form action="/update" method="post">
                <input type="hidden" name="id" value="${jogo.id}"/> <!--campo que o usuário não vai ver-->
                <div class="form-group">
                    <label for="titulo">Titulo</label>
                    <input type="text" name="titulo" class="form-control" value="${jogo.titulo}"/>
                    <br>
                    <label for="titulo">Ano de Lancamento</label>
                    <input type="text" name="anoDeLancamento" class="form-control" value="${jogo.anoDeLancamento}"/>
                </div>
                <br/>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>