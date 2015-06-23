<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
	<li><a href="#" title="Sample page 1">Cadastro do Novo Colaborador</a></li>
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="javascript:void(null);" onclick="showDialog();"><img src="../resources/img/help.png" height="18"/></a></li>

</ul>
<!-- FIM BREADCRUMB -->
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
function showDialog()
{
    $("#dialog-modal").dialog(
    {
        width: 600,
        height: 400,
        open: function(event, ui)
        {
            var textarea = $('<textarea style="height: 276px;">');
            $(textarea).redactor({
                focus: true,
                maxHeight: 300,
                initCallback: function()
                {
                    //this.code.set('<p>Lorem...</p>');
                }
            });
        }
     });
}
</script>
<div id="dialog-modal" style="display: none;">
		<video width="100%" controls>
			<source
				src="https://s3-sa-east-1.amazonaws.com/joocebox-media/Poltrona+1/Cadastrar+Usu%C3%A1rio.mp4"
				type="video/mp4">
		</video>

</div>


<div class="content-wrap margin-bottom width-fixid-fluida">
	<div class="row-cols novo-atendimento">

		<c:url var="saveEmployee" value="/auth/employee/add"></c:url>

		<f:form id="employeeForm" action="${saveEmployee}" method="post"
			modelAttribute="staff">

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
										class="fa fa-calendar"></i></span>
									<f:input id="employee-birthDate" type="text"
										cssClass="form-control" placeholder="Data de Nascimento"
										path="birthDate" />
								</div>
							</div>

							<div class="box02">					
								<f:radiobutton id="radio-m" path="gender" value="M"/>
								<label for="radio-m">Masculino</label>&nbsp;&nbsp;
								<f:radiobutton id="radio-f" path="gender" value="F"/>
								<label for="radio-f">Feminino</label>
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

							<security:authorize ifAllGranted="ROLE_MASTER,ROLE_ADMIN" access="${showRole}">
								<div class="aling-form">

									<div class="box01">
										<div class="input-group ">
											<span class="input-group-addon btn-success"> <i
												class="fa fa-cogs"></i>
											</span>
											<f:input id="employee-jobTitle" placeholder="Cargo"
												type="text" cssClass="form-control" path="jobTitle"/>
										</div>
									</div>

									<div class="box02">
										<f:select id="employee-role" cssClass="form-control"
											path="login.role">
											<f:option value="" label="Permissão de Acesso ao Sistema"></f:option>
											<f:options items="${systemRoles}" />
										</f:select>
									</div>

								</div>
							</security:authorize>
							
							<security:authorize ifAllGranted="ROLE_USER,ROLE_MASTER,ROLE_ADMIN" access="${!showRole}">
								<div class="aling-form">

									<div class="box01">
										<div class="input-group ">
											<span class="input-group-addon btn-success"> <i
												class="fa fa-cogs"></i>
											</span>
											<f:input id="employee-jobTitle" placeholder="Cargo"
												type="text" cssClass="form-control" path="jobTitle"
												readonly="true" />
										</div>
									</div>

									<div class="box02">
										<f:select id="employee-role" cssClass="form-control"
											path="login.role" disabled="true">
											<f:option value="" label="Permissão de Acesso ao Sistema"></f:option>
											<f:options items="${systemRoles}" />
										</f:select>
									</div>

								</div>
							</security:authorize>
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
										path="login.email" />
								</div>
							</div>
							<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
                                        class="fa fa-key"></i>
                                    </span>
                                    <f:password id="password" path="login.password" placeholder="Senha" cssClass="required form-control"/>
								</div>
							</div>
							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"> <i
                                        class="fa fa-key"></i>
                                    </span>
									<input id="confirm" name="confirm" type="password" placeholder="Confirme a Senha" class="required form-control"/>
								</div>
							</div>

						</div>

					</div>

				</div>

				<div class="txt-right">
					<button type="submit" style="margin-left: 15px;"
						class="btn btn-info pull-right">Concluir</button>

					<a href="<c:url value="/auth/staff"/>" class="btn btn-danger pull-right">
						<span class="entypo-cancel-squared"></span>&nbsp;&nbsp;Cancelar
					</a>

				</div>
			</div>

		</f:form>

	</div>
</div>