<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Insert title here</title>
</head>
<body>
	<div class="body">


		<table>
			<tr>
				<td>Name</td>
				<td>Edad</td>
			</tr>
			<g:each in="${list}" var="person">
				<tr>
					<td>
						${person.lastName}, ${person.firstName}
					</td>
					<td>
						${person.age}
					</td>
				</tr>
			</g:each>
		</table>



	</div>
</body>
</html>