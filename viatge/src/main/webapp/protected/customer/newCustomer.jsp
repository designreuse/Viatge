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
				<i class="icon-menu"></i> <span>Novo Cliente</span>
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
	<li><a href="#" title="Sample page 1">Novo Cliente</a></li>
</ul>
<!-- FIM BREADCRUMB -->

<div class="fluida">

	<div class="content-wrap margin-bottom">
		<div class="row-cols novo-atendimento">

			<div class="rows">

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
				<c:url var="saveCustomer" value="/auth/customer/add"></c:url>
				<f:form modelAttribute="customer" method="post"
					action="${saveCustomer}">
					<f:hidden id="id" path="idCustomer" />
					<!-- Anotações -->
					<div class="col-sm-4 pull-right">
						<div class="nest text margin-bottom">

							<div class="title-alt">
								<h6>
									<a href="#" rel="obs-note" class="toggle-box">Anotações</a>
								</h6>
								<a href="#" rel="obs-note" class="icon-chevron-down toggle-box"></a>
							</div>

							<div class="body-nest" id="obs-note" style="display: none;">
								<div class="aling-form">
									<div class="box03">
										<f:textarea rows="5" cols="5" path="observations"
											class="form-control" style="min-height:130px;"></f:textarea>
									</div>
								</div>
							</div>

						</div>
					</div>


					<div class="col-sm-8">

						<!-- Dados Básicos -->
						<div class="nest text margin-bottom">
							<div class="title-alt">
								<h6>Dados Básicos</h6>
							</div>

							<div class="body-nest">

								<div class="aling-form">

									<div class="box01">
										<div class="ui-widget">
											<f:input id="first-name" placeholder="Primeiro Nome"
												path="firstName" type="text" class="form-control" />
										</div>

									</div>

									<div class="box02">
										<f:input id="last-name" placeholder="Sobrenome"
											path="lastName" type="text" class="form-control" />
									</div>

									<div class="box01">
										<div class="input-group ">
											<span class="input-group-addon btn-success"><i
												class="fa fontawesome-envelope-alt"></i></span>
											<f:input id="email" placeholder="E-mail" path="email"
												type="text" class="form-control" />
										</div>
									</div>

									<div class="box02">
										<div class="input-group ">
											<span class="input-group-addon btn-success"><i
												class="fa fa-phone-square"></i></span>
											<f:input id="residential-phone"
												placeholder="Telefone Residencial"
												path="customerPhone.homePhone" type="text"
												class="form-control" />
										</div>
									</div>

									<div class="box01">
										<div class="input-group ">
											<span class="input-group-addon btn-success"><i
												class="fa entypo-mobile"></i></span>
											<f:input id="mobile-telefone" placeholder="Telefone Celular"
												path="customerPhone.celPhone" type="text"
												class="form-control" />
										</div>
									</div>

									<div class="box02">
										<div class="input-group ">
											<span class="input-group-addon btn-success"><i
												class="fa fa-phone-square"></i></span>
											<f:input id="work-telephone" placeholder="Telefone comercial"
												path="customerPhone.workPhone" type="text"
												class="form-control" />
										</div>
									</div>

									<div class="box01">
										<div class="input-group ">
											<span class="input-group-addon btn-success"><i
												class="fa fa-calendar"></i></span>
											<f:input id="birthday" placeholder="Data de Nascimento"
												path="birthDate" type="text" class="form-control" />
										</div>
									</div>

									<div class="box02 skin skin-flat">
										<div class="box-radio">
											<f:radiobutton id="gender-male" path="gender" value="M" />
											<label for="line-radio-1">Masculino</label>
										</div>

										<div class="box-radio">
											<f:radiobutton id="gender-female" path="gender" value="F" />
											<label for="line-radio-2">Feminino</label>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Dados Complementares -->
						<div class="nest text margin-bottom">

							<div class="title-alt">
								<h6>
									<a href="#" rel="dados-complementares" class="toggle-box">Dados
										Complementares</a>
								</h6>
								<a href="#" rel="dados-complementares"
									class="icon-chevron-down toggle-box"></a>
							</div>

							<div class="body-nest" id="dados-complementares"
								style="display: none;">

								<div class="aling-form">

									<div class="box01">
										<f:input id="cpf" placeholder="CPF ou CNPJ"
											path="document.cpf" type="text" class="form-control" />
									</div>

									<div class="box02">
										<f:input id="rg" placeholder="RG" path="document.rg"
											type="text" class="form-control" />
									</div>



									<div class="box01">
										<f:input id="cep" placeholder="CEP" path="customerAddress.cep"
											type="text" class="form-control" />
									</div>

									<div class="box02">
										<f:input id="estado" placeholder="UF"
											path="customerAddress.state" type="text" class="form-control" />
									</div>

									<div class="box01">
										<f:input id="cidade" placeholder="Cidade"
											path="customerAddress.city" type="text" class="form-control" />
									</div>

									<div class="box02">
										<f:input id="bairro" placeholder="Bairro"
											path="customerAddress.quarter" type="text"
											class="form-control" />
									</div>

									<div class="box01">
										<f:input id="endereco" placeholder="Rua"
											path="customerAddress.street" type="text"
											class="form-control" />
									</div>

									<div class="box02">
										<f:input id="numero" placeholder="Número"
											path="customerAddress.number" type="text"
											class="form-control" />
									</div>

									<div class="box01">
										<f:input id="complemento" placeholder="Complemento"
											path="customerAddress.complement" type="text"
											class="form-control" />
									</div>
								</div>

							</div>
						</div>
						<!-- List de Passageiros -->
						<div class="nest text margin-bottom">

							<div class="title-alt">
								<h6>
									<a href="#" rel="list-passageiros" class="toggle-box">Cadastro
										de Passageiros</a>
								</h6>
								<a href="#" rel="list-passageiros"
									class="icon-chevron-down toggle-box"></a>
							</div>

							<div class="body-nest" id="list-passageiros"
								style="display: none;">

								<div class="aling-form">

									<div class="box03">
										<a class="btn btn-primary btn-lg" data-toggle="modal"
											data-backdrop="static" data-target="#myModal"><span
											class="entypo-plus-squared"></span>&nbsp;&nbsp;Cadastrar Novo
											Passageiro</a>
									</div>

									<ul id="passenger-list" class="list-user">

									</ul>

								</div>

							</div>

						</div>

					</div>
					<button id="submit-all" type="submit"
						class="pull-right btn btn-info">Pronto!</button>
				</f:form>
			</div>
		</div>
	</div>


	<!-- Modal Passageiros-->
	<div class="modal fade" id="myModal" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">

			<div class="modal-content">
				<form id="modal-form" action="./addPassenger" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Cadastrar Novo
							Passageiro</h4>
					</div>
					<div class="modal-body">

						<div id="div-modal-input-body"
							class="aling-form col-sm-12 nest text" style="padding-top: 25px">

							<div class="box01">
								<select id="familyBond" class="form-control" name="familyBond">
									<c:forEach items="${listOfBondNames}" var="bond">
										<option value="${bond.key}">${bond.value}</option>
									</c:forEach>
								</select>
							</div>

							<div class="box02">

								<input id="passenger-name" placeholder="Nome do Passageiro"
									name="firstName" type="text" class="form-control" />
							</div>

							<div class="box01">

								<input id="passenger-lastName"
									placeholder="Sobrenome do Passageiro" type="text"
									name="lastName" class="form-control" />
							</div>

							<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa fontawesome-envelope-alt"></i></span> <input
										id="passenger-email" placeholder="E-mail" type="text"
										name="email" class="form-control" />
								</div>
							</div>

							<div class="box01">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa fa-phone-square"></i></span> <input id="passenger-phone"
										placeholder="Telefone Principal" type="text" name="mainTel"
										class="form-control" />
								</div>
							</div>

							<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa fa-calendar"></i></span> <input id="passenger-birth"
										placeholder="Data de Nascimento" type="text" name="birthDate"
										class="form-control" />
								</div>
							</div>

							<div class="box01">
								<input id="passenger-rg" placeholder="RG" type="text"
									name="documentPassenger.rg" class="form-control"
									style="margin: 0px;" />
							</div>

							<div class="box02">
								<input id="passenger-cpf" placeholder="CPF" type="text"
									name="documentPassenger.cpf" class="form-control" />
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

						</div>

					</div>
					<div class="modal-footer clear" style="margin: 0px;">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
						<button id="buttton-modal-register " type="submit"
							class="btn btn-primary">Cadastrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>