<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>Register User</h1>
<form:form commandName="user" cssClass="form-horizontal">
	<div class="row">
		<div class="col-sm-12">
			<label>Name: </label>
			<form:input path="name" cssClass="form-control"  />
			<form:errors path="name"/>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<label>Address: </label>
			<form:input path="address" cssClass="form-control" />
			<form:errors path="address"/>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<input type="submit" class="btn btn-primary" value="Save">
		</div>
	</div>
</form:form>