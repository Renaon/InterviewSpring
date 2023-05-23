<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adding student</title>
</head>
<body>
    <h1>Add a student </h1>
    <form action="create" method="post">
      <p>
        <label for="name">Введите имя:</label>
        <input type="text" name="name" id="name" required>
      </p>
      <p>
        <label for="text">Введите оценку:</label>
        <input type="text" name="mark" id="mark" required>
      </p>
      <button type="submit">Отправить</button>
    </form>

</body>