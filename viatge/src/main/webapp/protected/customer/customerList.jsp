<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÁGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Lista de Clientes</span>
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
	<li><a href="#" title="Sample page 1">Lista de Clientes</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
	<div class="row">


		<div class="nest text">
			<div class="title-alt">
				<h6>Clientes</h6>
			</div>

			<div class="col-sm-12">
				<p>Você possui 380 clientes ativos</p>
			</div>

			<form action="#" method="post" class="form-filtro">
				<div class="col-sm-4">
					<input class="form-control" id="filter" placeholder="Procurar"
						type="text" />
				</div>
				<div class="col-sm-6 pull-right">
					<a href="#" class="pull-right btn btn-info filter-api"
						title="Editar">Enviar E-mail</a>
				</div>
			</form>

			<div class="col-sm-12">
				<table class="table table-border-clientes table-striped cf">
					<thead>
						<tr>
							<th class="border0"></th>
							<th class="border0"></th>
							<th class="t-filtro" colspan="6">Filtros de Perfil</th>
							<th class="border0"></th>
						</tr>
						<tr>
							<th class="vertical-align-center">Nome</th>
							<th class="vertical-align-center">Sobrenome</th>
							<th><select class="filter-status form-control">
									<option value="">Social</option>
							</select></th>
							<th><select class="filter-status form-control">
									<option value="">De Viagem</option>
							</select></th>
							<th><select class="filter-status form-control">
									<option value="">Clima</option>
							</select></th>
							<th><select class="filter-status form-control">
									<option value="">Categoria</option>
							</select></th>
							<th><select class="filter-status form-control">
									<option value="">Econômico</option>
							</select></th>
							<th><select class="filter-status form-control">
									<option value="">Geral</option>
							</select></th>
							<th><select class="filter-status form-control">
									<option value="">Ativo</option>
							</select></th>
						</tr>
					</thead>
					<tbody>
						<!-- CONTEUDO DE TABLE -->
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>José</td>
							<td>Silveira</td>
							<td>Cônjuge</td>
							<td>Descanso</td>
							<td>Calor</td>
							<td>Nacional</td>
							<td>Intermediário</td>
							<td>Praia</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>


	</div>
</div>