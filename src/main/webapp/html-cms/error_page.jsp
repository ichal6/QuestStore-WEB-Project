<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<p style="font-size:30px">Uppsss.... Something went wrong, Click back to return to dashboard</p>
<br>${error_message}

<form action="/cms-user/my-account" method="get"></form>
<input type="submit" value="Back"/>
</body>
</html>