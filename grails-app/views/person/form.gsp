<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Form</title>
	</head>
	<body>
        <g:form controller="person" action="save">
            <label>First Name: </label>
            <g:textField name="firstName"/><br/>
            <label>Last Name: </label>
            <g:textField name="lastName"/><br/>
            <label>Age: </label>
            <g:textField name="age"/><br/>
            <g:actionSubmit value="Save"/>
        </g:form>
	</body>
</html>