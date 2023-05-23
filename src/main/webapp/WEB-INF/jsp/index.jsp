<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<body modelAttribute="students">
<h1>Студенты</h1>
<a href="http://localhost:8189/add" class="button">Создать нового</a>
	<ul>
	    <table>
	        <tr>
	            <th>Имя</th>
	            <th>Оценка</th>
	            <th></th>
	            <th>Сменить оценку</th>
	        </tr>

            <c:forEach var="item" items="${students}">
                <tr>
                    <th>${item.name}</th>
                    <th>${item.mark}</th>
                    <th><a href="http://localhost:8189/delete?name=${item.name}" class="button">Удалить</a></th>
                    <th>
                        <form method="post" action="change_mark?name=${item.name}">
                            <p>
                                <input type="text" name="mark" id="mark" required>
                            </p>
                            <button type="submit">Отправить</button>
                        </form>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </ul>

</body>

<style>
    a.button {
        -webkit-appearance: button;
        -moz-appearance: button;
        appearance: button;

        text-decoration: none;
        color: initial;
    }

</style>