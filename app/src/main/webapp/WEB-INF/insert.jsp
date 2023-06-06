<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Novo Jogo</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Novo Jogo </h1>
            <a href="/jogo" class="btn btn-primary">voltar</a>
            <form action="/insert" method="post">
                <div class="form-group">
                    <label for="titulo">Titulo</label>
                    <input type="text" name="titulo" class="form-control">
                </div>
                <div class="form-group">
                    <label for="anoDeLancamento">Ano de Lancamento</label>
                    <input type="text" name="anoDeLancamento" class="form-control">
                </div>
                <br/>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>
