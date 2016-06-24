<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
    <table>
			<tr>
				<td>Age</td>
				<td>Total</td>
			</tr>
			<g:each in="${list}" var="item">
				<tr>
					<td>
						${item[0]}
					</td>
					<td>
						${item[1]}
					</td>
				</tr>
			</g:each>
		</table>
  </div>
</body>
</html>