<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/resources/dist/css/bootstrap.css" rel="stylesheet">
<title>Update Task</title>
</head>
<body>
<div class="container">
<!--This is button that goes to create task screen -->
		<div class="row col-lg-6 col-md-offset-2 custyle">
			<table class="table table-striped custab">		
				<thead>
					<tr>
						<th>Task ID</th>
						<th>Task Description</th>
						<th>Status</th>
						<th>Assigned To</th>
					</tr>
				</thead>
				<tr>
				<td>${task.taskID}</td>
				<td>${task.description}</td>
				<td>${task.status}</td>
				<td>${task.assignedTo}</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="container">
		<div class="row col-lg-6 col-md-offset-2">
		
<!-- here is my guess as to what the buttons might look like once they are functional - JUST A START -->
		<form:form action="updateTask" modelAttribute="task" method="post">
		<a href="${contextPath}/updateTask/ASSIGN/${task.taskID}/${username}" class="btn btn-primary btn-block"><i class="glyphicon glyphicon-user"></i> <strong>Assign To Me</strong></a>
		<a href="${contextPath}/updateTask/IN-PROGRESS/${task.taskID}/${username}" class="btn btn-warning btn-block"><i class="glyphicon glyphicon-edit"></i> <strong>IN PROGRESS</strong></a>
		<a href="${contextPath}/updateTask/COMPLETED/${task.taskID}/${username}" class="btn btn-success btn-block"><i class="glyphicon glyphicon-ok"></i> <strong>COMPLETED</strong></a>
		</form:form>
		
<!-- Here is the code for buttons THAT WORKED before I tampered with it :) -->
<!-- this code wouldn't require the updateTask method that I began writing in the TaskController -->
<!-- needless to say, it wouldn't update the tasks, either -->
	<!-- <a href="/empTasks" class="btn btn-primary btn-block"><i class="glyphicon glyphicon-user"></i> <strong>Assign To Me</strong></a> -->
	<!-- <a href="/empTasks" class="btn btn-warning btn-block"><i class="glyphicon glyphicon-edit"></i> <strong>IN PROGRESS</strong></a> -->
	<!-- <a href="/empTasks" class="btn btn-success btn-block"><i class="glyphicon glyphicon-ok"></i> <strong>COMPLETE</strong></a> -->
<!-- The buttons are clickable, but will not update task; they will just reroute you to the emp tasks page -->
		
		</div>
	</div>
</body>
</html>