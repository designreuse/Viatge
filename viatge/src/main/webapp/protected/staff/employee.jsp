<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÁGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Editar Dados do Colaborador</span>
			</h2>
		</div>
	</div>
</div>
<!--/ TITLE -->

<!-- BREADCRUMB -->
<ul id="breadcrumb">
	<li><span class="entypo-home"></span></li>
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="#" title="Sample page 1">Página Inicial</a></li>
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="#" title="Sample page 1">Editar Dados do Vendedor</a></li>
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="#" title="Sample page 1">Cadastro do Novo Cliente</a></li>

</ul>
<!-- FIM BREADCRUMB -->

<div class="content-wrap margin-bottom width-fixid-fluida">
	<div class="row-cols novo-atendimento">

		<div class="col-sm-12 margin-bottom ">
			<a href="#" class="btn btn-primary">Dados</a>&nbsp; &nbsp; <a
				href="#" class="btn btn-primary">Metas de Vendas</a>
		</div>
		<c:url var="saveEmployee" value="/auth/employee/add"></c:url>

		<f:form action="${saveEmployee}" method="post" modelAttribute="staff">

			<f:hidden id="id" path="id" />

			<div class="col-sm-12">

				<div class="nest text margin-bottom">
					<div class="title-alt">
						<h6>Dados Básicos</h6>
					</div>

					<div class="body-nest">

						<c:if test="${validator}">
							<div class="alert alert-danger">
								<span class="entypo-attention"></span> <strong>Opa!</strong>&nbsp;&nbsp;Houve
								algum erro na hora de salvar os seguintes dados:
								<ul>
									<c:forEach items="${errors}" var="e">
										<li><c:out value="${e}" /></li>
									</c:forEach>
								</ul>
							</div>
						</c:if>

						<div class="aling-form">

							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
										class="fa fa-user"></i>
									</span>
									<f:input id="employee-firstName" placeholder="Primeiro Nome"
										type="text" cssClass="form-control" path="firstName" />
								</div>
							</div>

							<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
										class="fa fa-user"></i>
									</span>
									<f:input id="employee-lastName" placeholder="Sobrenome"
										type="text" cssClass="form-control" path="lastName" />
								</div>
							</div>

							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa fa-phone-square"></i></span>
									<f:input id="employee-homePhone" type="text"
										class="form-control" placeholder="Telefone Residencial"
										path="contact.homePhone" />
								</div>
							</div>

							<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa entypo-mobile"></i></span>
									<f:input id="employee-celPhone" type="text"
										cssClass="form-control" placeholder="Telefone Celular"
										path="contact.celPhone" />
								</div>
							</div>

							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa fa-phone-square"></i></span>
									<f:input id="employee-workPhone" type="text"
										cssClass="form-control" placeholder="Telefone comercial"
										path="contact.workPhone" />
								</div>
							</div>

							<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa fa-calendar"></i></span>
									<f:input id="employee-birthDate" type="text"
										cssClass="form-control" placeholder="Data de Nascimento"
										path="birthDate" />
								</div>
							</div>

							<div class="box01">
								<f:select id="employee-gender" cssClass="form-control"
									path="gender">
									<option value=''>Sexo</option>
									<option value='M'>Masculino</option>
									<option value='F'>Feminino</option>
								</f:select>
							</div>

						</div>

					</div>
				</div>

				<div class="nest text margin-bottom">

					<div class="title-alt">
						<h6>
							<a href="#" rel="dados-profissionais" class="toggle-box">Dados
								Profissionais</a>
						</h6>
						<a href="#" rel="dados-profissionais"
							class="icon-chevron-down toggle-box"></a>
					</div>

					<div class="body-nest" id="dados-profissionais"
						style="display: none;">


						<div class="aling-form">

							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
										class="fa fa-cogs"></i>
									</span>
									<f:input id="employee-jobTitle" placeholder="Cargo" type="text"
										cssClass="form-control" path="professionalData.jobTitle" />
								</div>
							</div>

							<div class="box02">
								<f:select id="employee-role" cssClass="form-control"
									path="professionalData.role">
									<option value="">Permissão de Acesso ao Sistema</option>
									<c:forEach items="${systemRoles}" var="role">
										<option value="${role.key}">${role.value}</option>
									</c:forEach>
								</f:select>
							</div>

						</div>

					</div>

				</div>

				<div class="nest text margin-bottom">

					<div class="title-alt">
						<h6>
							<a href="#" rel="dados-acesso" class="toggle-box">Acesso ao
								sistema</a>
						</h6>
						<a href="#" rel="dados-acesso"
							class="icon-chevron-down toggle-box"></a>
					</div>

					<div class="body-nest" id="dados-acesso" style="display: none;">


						<div class="aling-form">

							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
										class="fa fa-envelope"></i>
									</span>
									<f:input id="employee-email" type="email"
										cssClass="form-control" placeholder="E-mail"
										path="contact.email" />
								</div>
							</div>

							<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
										class="fa fa-key"></i>
									</span>
									<f:input id="employee-password" type="password"
										cssClass="form-control" placeholder="Senha" path="" />
								</div>
							</div>

							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
										class="fa fa-key"></i>
									</span>
									<f:input id="employee-password-confirm" type="password"
										cssClass="form-control" placeholder="Confirmar a senha"
										path="" />
								</div>
							</div>

						</div>

					</div>

				</div>

				<div class="txt-right">
					<button type="submit" style="margin-left: 15px;"
						class="btn btn-info pull-right">Concluir</button>

					<a href="<c:url value="staff"/>" class="btn btn-danger pull-right">
						<span class="entypo-cancel-squared"></span>&nbsp;&nbsp;Cancelar
					</a>


				</div>
			</div>

		</f:form>

	</div>
</div>
