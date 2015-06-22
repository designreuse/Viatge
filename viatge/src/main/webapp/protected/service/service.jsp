<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÁGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Novo Atendimento</span>
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
	<li><a href="#" title="Sample page 1">Novo Atendimento</a></li>
</ul>
<!-- FIM BREADCRUMB -->

<div class="fluida">

	<div class="content-wrap margin-bottom">
		<div class="row-cols novo-atendimento">

			<div class="rows">

				<form id="transition-duration-demo" class="transition-form" method="post">
				
					<fieldset class="row-cols margin-bottom fluida" title="Dados do Cliente" ng-controller="CustomerController">
						<legend>&nbsp;&nbsp;</legend>
						
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
											<textarea rows="5" cols="5" ng-model="observations" class="form-control" style="min-height:130px;"></textarea>
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
												<input id="first-name" placeholder="Primeiro Nome" ng-model="firstName" type="text" class="form-control"/>
											</div>

										</div>

										<div class="box02">
											<input id="last-name" placeholder="Sobrenome" ng-model="lastName" type="text" class="form-control" />
										</div>

										<div class="box01">
											<div class="input-group ">
												<span class="input-group-addon btn-success"><i
													class="fa fontawesome-envelope-alt"></i></span>
												<input id="email" placeholder="E-mail" ng-model="email" type="email" class="form-control" />
											</div>
										</div>

										<div class="box02">
											<div class="input-group ">
												<span class="input-group-addon btn-success"><i
													class="fa fa-phone-square"></i></span>
												<input id="residential-phone" placeholder="Telefone Residencial" ng-model="customerHomePhone" type="text" class="form-control" />
											</div>
										</div>

										<div class="box01">
											<div class="input-group ">
												<span class="input-group-addon btn-success"><i
													class="fa entypo-mobile"></i></span>
												<input id="mobile-telefone" placeholder="Telefone Celular" ng-model="customerCelPhone" type="text" class="form-control" />
											</div>
										</div>

										<div class="box02">
											<div class="input-group ">
												<span class="input-group-addon btn-success"><i
													class="fa fa-phone-square"></i></span>
												<input id="work-telephone" placeholder="Telefone comercial" ng-model="customerWorkPhone" type="text" class="form-control" />
											</div>
										</div>

										<div class="box01">
											<div class="input-group ">
												<span class="input-group-addon btn-success"><i
													class="fa fa-calendar"></i></span>
												<input id="birthday" placeholder="Data de Nascimento" ng-model="birthDate" type="date" class="form-control" />
											</div>
										</div>

										<div class="box02 skin skin-flat">
											<div class="box-radio">
												<label>
													<input type="radio" name="gender" ng-model="gender" value="M"/>
													Masculino
												</label>
											</div>

											<div class="box-radio">
												<label for="gender-female">
													<input type="radio" id="gender-female" name="gender" ng-model="gender" value="F"/>
													Feminino
												</label>
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
											<input id="cpf" placeholder="CPF ou CNPJ" ng-model="customerCpf" type="text" class="form-control" />
										</div>

										<div class="box02">
											<input id="rg" placeholder="RG" ng-model="customerRg" type="text" class="form-control" />
										</div>

										<div class="box01">
											<input id="cep" placeholder="CEP" ng-model="customerAddressCep" type="text" class="form-control" />
										</div>

										<div class="box02">
											<input id="estado" placeholder="UF" ng-model="customerAddressState" type="text" class="form-control" />
										</div>

										<div class="box01">
											<input id="cidade" placeholder="Cidade" ng-model="customerAddressCity" type="text" class="form-control" />
										</div>

										<div class="box02">
											<input id="bairro" placeholder="Bairro" ng-model="customerAddressQuarter" type="text" class="form-control" />
										</div>

										<div class="box01">
											<input id="endereco" placeholder="Rua" ng-model="customerAddressStreet" type="text" class="form-control" />
										</div>

										<div class="box02">
											<input id="numero" placeholder="Número" ng-model="customerAddressNumber" type="text" class="form-control" />
										</div>

										<div class="box01">
											<input id="complemento" placeholder="Complemento" ng-model="customerAddressComplement" type="text" class="form-control" />
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
												class="entypo-plus-squared"></span>&nbsp;&nbsp;Cadastrar
												Novo Passageiro</a>
										</div>
									    <ul>
									      <li></li>
									    </ul>
									</div>
								</div>
							</div>
						</div>
					</fieldset>

					<fieldset class="row-cols margin-bottom"
						title="Detalhes do Atendimento">
						<legend>&nbsp;&nbsp;</legend>

						<!-- Quem vai nesta viagem -->
						<div class="col-sm-4 pull-right">
							<div class="nest text margin-bottom">

								<div class="title-alt">
									<h6>
										<a href="#" rel="quem-vai" class="toggle-box">Quem vai
											nesta viagem?</a>
									</h6>
									<a href="#" rel="quem-vai" class="icon-chevron-down toggle-box"></a>
								</div>

								<div class="body-nest" id="quem-vai">

									<div id="passenger-list-confirmation"
										class="aling-form skin skin-flat">

										<div id="passenger-alone" class="alert alert-info box03">
											<span class="entypo-info-circled"></span> <b>Parece que o
												cliente irá viajar sozinho</b>.
										</div>

									</div>
								</div>

							</div>
						</div>

						<!-- Destinos Oferecidos -->
						<div class="col-sm-8">
							<div class="nest text margin-bottom">
								<div class="title-alt">
									<h6>
										<a href="#" rel="destino-solicitado" class="toggle-box">Negociar Destinos</a>
									</h6>
									<a href="#" rel="destino-solicitado" class="icon-chevron-down toggle-box"></a>
								</div>
								<div class="body-nest" id="destino-solicitado">
									<div class="aling-form">								
										<div class="box03">									
												<a class="btn btn-primary btn-lg" data-toggle="modal"
												data-backdrop="static" data-target="#destinationModal"><span
												class="entypo-plus-squared"></span>&nbsp;&nbsp;Adicionar um
												Destino</a>								
										</div>		
																		
										<ul id="destination-list" class="list-user" ng-controller="RequestedDestinationListController">
										<!-- Linha de cada destino -->
											<li id="item{{customerObjectTree.id}}" ng-repeat="item in customerObjectTree.data">
												<label><b>{{item.title}}</b>
												<button ng-click="deleteItem($index)" id="" type="button" class="btn btn-danger pull-right" style="position: relative;"><span class="entypo-cancel-squared"></span>&nbsp;&nbsp;Remover</button>
												<button ng-click="editItem($index)" id="" type="button" data-toggle="modal" data-backdrop="static" data-target="#EditDestinationModal" class="btn btn-info pull-right" style="position: relative;">
												<span class="entypo-pencil"></span>&nbsp;&nbsp;Editar</button>			
												</label>											
											</li>															 
										</ul>
									</div>
								</div>
							</div>
						</div>

						<!-- Hístórico de Destino deste passageiro -->
						<div class="col-sm-8">
							<div class="nest text margin-bottom">

								<div class="title-alt">
									<h6>
										<a href="#" rel="destino-historico" class="toggle-box">Hístórico
											de Destino deste passageiro</a>
									</h6>
									<a href="#" rel="destino-historico"
										class="icon-chevron-down toggle-box"></a>
								</div>

								<div class="body-nest" id="destino-historico"
									style="display: none">

									<div class="aling-form">

										<ul class="list-user">
											<li><label>Registro</label></li>

										</ul>

										<div class="alert alert-info">
											<span class="entypo-info-circled"></span> <strong>Não
												há registro historico deste atendimento!!</strong>
										</div>
									</div>
								</div>
							</div>
						</div>
					</fieldset>
					<button id="submit-all" type="submit" class="stepy-finish pull-right btn btn-info">Pronto!</button>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- Modal Novo Destino Requisitado-->
<div class="modal fade" id="destinationModal" role="dialog" aria-labelledby="myModalLabelDestination" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Negociar Novo Destino</h4>
				</div>
				<div class="modal-body">
					<div class="aling-form col-sm-12 nest text"
						style="padding-top: 25px">
						<form ng-controller="RequestedDestinationModalController as destinationModalCtrl">
							<div class="box01">
                            	<select id="destination-passenger-list" class="form-control" ng-model="destinationModalCtrl.destination">
                                	 <c:forEach items="${destinationList}" var="destination">
                                     	<option value="${destination.idDestination}">${destination.dtName}</option>
                                     </c:forEach>
								</select>
							</div>

							<div class="box02">
								<div class="input-group ">
									<span id="span-arrive" class="input-group-addon btn-success"><i
										class="fa fa-calendar"></i></span>
										<input id="see-in" type="text" class="form-control" placeholder="Ver em..." ng-model="destinationModalCtrl.seeIn"/>
								</div>
							</div>

							<div class="box01">
								<div class="input-group ">
									<span id="span-departure" class="input-group-addon btn-success"><i
										class="fa fa-calendar"></i></span> <input id="input-departure" type="text" class="form-control" placeholder="Data de Ida" ng-model="destinationModalCtrl.arrivalDate"/>
								</div>
							</div>

							<div class="box02">
								<div class="input-group ">
									<span id="span-arrive" class="input-group-addon btn-success"><i
										class="fa fa-calendar"></i></span> <input id="input-arrive" type="text" class="form-control" placeholder="Data de Volta" ng-model="destinationModalCtrl.departureDate"/>
								</div>
							</div>

						<div class="box01">
							<select id="combo-saleType" class="form-control" ng-model="destinationModalCtrl.saleType">
								<c:forEach items="${listOfSaleTypes}" var="saleType">
									<option value="${saleType.key}">${saleType.value}</option>
								</c:forEach>
							</select>
						</div>

						<div class="box02">
								<div class="input-group ">
									<span class="input-group-addon btn-success"><i
										class="fa fa-money"></i></span> <input id="input-price" type="text" class="form-control" ng-model="destinationModalCtrl.valueNegotiated"/>
								</div>
							</div>
							<div class="box03">
								<textarea id="destination-observations" rows="3" placeholder="Observações..." class="form-control" style="min-height: 130px;" ng-model="destinationModalCtrl.negociationObservations"></textarea>
							</div>

							<div class="box02">
								<div class="input-group skin skin-flat">
									<input id="ckb-requested" type="checkbox" ng-model="destinationModalCtrl.requestedDestination" /> <label
										id="ckb-label" for="ckb-requested">Destino Solicitado
										pelo Passageiro?</label>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer clear" style="margin: 0px;">
					<button class="btn btn-primary" data-dismiss="modal" ng-click="addReqDestiantion()">Cadastrar</button>
					<button class="btn btn-danger" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>