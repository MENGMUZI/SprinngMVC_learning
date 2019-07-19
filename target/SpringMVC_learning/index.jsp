<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="book" method="post">
    bookName:<input type="text" name="bookName"/><br/>
    author:<input type="text" name="author"/><br/>
    price:<input type="text" name="price"/><br/>
    stock:<input type="text" name="stock"/><br/>
    sales:<input type="text" name="sales"/><br/>
    <hr/>
    province:<input type="text" name="address.province"/>
    city:<input type="text" name="address.city"/>
    street:<input type="text" name="address.street"/><br/>
    <input type="submit">

</form>
<a href="hellotest02">hellotest02-欢迎！</a><br/>
<a href="hellotest04">hellotest04-欢迎！</a><br/>
</body>
</html>
