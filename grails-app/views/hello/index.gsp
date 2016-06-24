<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Welcome to Grails</title>
</head>
<body>
	Hello World** 
	
	
	
	<g:each in="${(1..10)}" var="number">
        ${number}<br/>
    </g:each>
    
    
     <table>
        <tr>
            <td>Name</td>
            <td>Age</td>
        </tr>
        <g:each in="${list}" var="person">
        <tr>
            <td>${person.lastName}, ${person.firstName}</td>
            <td>${person.age}</td>
        </tr>
        </g:each>        
    </table>
    
</body>
</html>