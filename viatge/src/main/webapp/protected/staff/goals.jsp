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
				<i class="icon-menu"></i> <span>Metas de venda</span>
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
	<li><a href="#" title="Sample page 1">Equipe</a></li>
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="#" title="Sample page 1">Gerenciar Metas</a></li>

</ul>
<!-- FIM BREADCRUMB -->

<div class="content-wrap margin-bottom width-fixid-fluida">
	<div class="row-cols novo-atendimento">
	
		<c:url var="saveGoal" value="/auth/goal/add"></c:url>

		<f:form id="goalsForm" method="post" action="${saveGoal}" modelAttribute="goals">
		
		<input id="ajax-goal-url" type="hidden" value="${pageContext.request.contextPath}/auth/goal/getGoal"/>
		
			<div class="col-sm-12">

				<div class="nest text margin-bottom">
					<div class="title-alt">
						<h6>Cadastro de Metas de Vendas</h6>
					</div>

					<div class="body-nest">
						<div class="nest text margin-bottom">

							<div class="row-cols">
								<div class="col-sm-12 txt-right margin-bottom">
									<select id="employee-goal" class="form-control"
										style="width: 200px" name="employeeID">
										<option value="">Funcionario</option>
										<c:forEach items="${staff}" var="s">
											<option value="${s.id}">${s.firstName}</option>
										</c:forEach>
									</select>
								</div>
<!--  
								<div class="col-sm-4 txt-right margin-bottom">
									<f:select id="employee-goal-year" cssClass="form-control"
										style="width: 200px" path="year">
										<option value="">Ano</option>
										<option value="2015">2015</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
									</f:select>
								</div>
							</div>
-->
							<div class="row-cols meses-meta">
								<div class="col-sm-3">
									<f:input id="employee-goal-jan" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Janeiro" path="january" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-feb" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Fevereiro" path="february" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-mar" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Março" path="march" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-abr" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Abril" path="april" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-maio" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Maio" path="may" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-jun" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Junho" path="june" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-jul" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Julho" path="july" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-ago" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Agosto" path="august" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-set" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Setembro" path="september" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-out" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Outubro" path="october" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-nov" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Novembro" path="november" />
									<br />
								</div>

								<div class="col-sm-3">
									<f:input id="employee-goal-dec" data-thousands="."
										data-decimal="," type="text" cssClass="form-control"
										placeholder="Dezembro" path="december" />
									<br />
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
</div>
		</f:form>

	</div>
</div>
