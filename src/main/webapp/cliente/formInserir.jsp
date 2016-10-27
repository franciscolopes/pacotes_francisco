<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Pacotes Turísticos</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Inserir novo Cliente</h1>
		</div>

		<form method="post" name="myform" class="form-horizontal"
			action="<%=request.getContextPath()%>/cliente/inserir">

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<ul>
						<c:forEach items="${erros}" var="msg">
							<li class="erro">${msg}</li>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome:</label>
				<div class="col-sm-5">
					<input type="text" name="nome" id="nome" value="${item.nome}"
						required="required" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="email">E-mail:</label>
				<div class="col-sm-5">
					<input type="text" name="email" id="email"
						value="${item.email}" required="required"
						class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="telefone">Telefone:</label>
				<div class="col-sm-5">
					<input type="text" name="telefone" id="telefone"
						value="${item.telefone}" required="required"
						class="form-control" />
				</div>
			</div>
			
				<div class="form-group">
				<label class="col-sm-2 control-label" for="cpf">CPF:</label>
				<div class="col-sm-5">
					<input type="text" name="cpf" id="cpf"
						value="${item.cpf}" required="required"
						class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nascimento">Nascimento:</label>
				<div class="col-sm-5">
					<input type="text" name="nascimento" id="nascimento"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${item.nascimento}"/>"
						required="required" class="form-control" />
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="rendaMensal">Renda mensal:</label>
				<div class="col-sm-5">
					<input type="text" name="rendaMensal" id="rendaMensal" value="${item.rendaMensal}"
						required="required" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/cliente/listar"
						class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
