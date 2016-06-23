<%@ page import="rewards.Paciente" %>



<div class="fieldcontain ${hasErrors(bean: pacienteInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="paciente.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${pacienteInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pacienteInstance, field: 'edad', 'error')} ">
	<label for="edad">
		<g:message code="paciente.edad.label" default="Edad" />
		
	</label>
	<g:datePicker name="edad" precision="day"  value="${pacienteInstance?.edad}" default="none" noSelection="['': '']" />

</div>

