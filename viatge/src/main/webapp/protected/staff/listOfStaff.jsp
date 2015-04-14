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
				<i class="icon-menu"></i> <span>Gerenciar Equipe</span>
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
	<li><a href="#" title="Sample page 1">Gerenciar Equipe</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
	<div class="row">


		<div class="nest text">
			<div class="title-alt">
				<h6>Equipe</h6>
			</div>

			<form action="#" method="post" class="form-filtro">

				<div class="col-sm-4">
					<input class="form-control" id="filter" placeholder="Procurar"
						type="text" />
				</div>
				<div class="col-sm-2">
					<select class="filter-status form-control">
						<option value="active">Active</option>
						<option value="disabled">Disabled</option>
						<option value="suspended">Suspended</option>
					</select>
				</div>
				<div class="col-sm-6">
					<a href="#clear" style="margin-left: 10px;"
						class="pull-right btn btn-info clear-filter" title="clear filter">Limpar</a>
					<a href="#api" class="pull-right btn btn-info filter-api"
						title="Filter using the Filter API">Cadastro Novo</a>
				</div>

			</form>

			<div class="col-sm-12">

				<table id="footable-res2" class="demo margin-bottom"
					data-filter="#filter" data-filter-text-only="true">
					<thead>
						<tr>
							<th>Funcionário</th>
							<th>Departamento</th>
							<th>Ativo</th>
						</tr>
					</thead>
					<tbody>
						<!-- CONTEUDO DE TABLE -->
						<tr>
							<td>Carlos Afonso</td>
							<td>Venda</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>Rosane Braga</td>
							<td>Venda</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox" checked>
								</div></td>
						</tr>
						<tr>
							<td>Carla Ishimura</td>
							<td>Venda</td>
							<td><div class="make-switch" data-on="info"
									data-off="success">
									<input type="checkbox">
								</div></td>
						</tr>
					</tbody>
				</table>

			</div>

		</div>


	</div>
</div>