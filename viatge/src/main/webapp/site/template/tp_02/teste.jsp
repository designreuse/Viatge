<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		 Procura rola malafaia
		 <br/>

<div class="container"
		 ng-controller="BudgetController">
	<table>
      <thead>
        <tr>
          <th>Produto</th>
        </tr>
      </thead>
      <tbody>
<!--         <tr ng-repeat="x in itens"> -->
		<tr>
          <td>{{ store }}</td>
        </tr>
      </tbody>
    </table>
    </div>

</body>
</html>