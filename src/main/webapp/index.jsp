<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pagination</title>
</head>
<body>
<h1 style="color: red; text-align: center">Welcome to LIC</h1>
<form method="post" action="./controller">
    <table align="center" bgcolor="cyan">
        <tr>
            <td>Enter input page</td>
            <td>
                <input type='text' name='pageSize'/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type='submit' value='generateReport' name='s1'/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>