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
				<i class="icon-menu"></i> <span>Metas de Vendas</span>
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
	<li><a href="#" title="Sample page 1">Metas de Vendas</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
	<div class="row">


		<div class="nest text">
			<div class="title-alt">
				<h6>Vendas</h6>
			</div>


			<div class="col-sm-12 margin-bottom">

				<table class="table table-bordered table-striped cf">
					<thead>
						<tr>
							<th>JAN</th>
							<th>FEV</th>
							<th>MAR</th>
							<th>ABR</th>
							<th>MAI</th>
							<th>JUN</th>
							<th>JUL</th>
							<th>AGO</th>
							<th>SET</th>
							<th>OUT</th>
							<th>NOV</th>
							<th>DEZ</th>
						</tr>
					</thead>
					<tbody>
						<!-- CONTEUDO DE TABLE -->
						<tr>
							<td>R$ ${dataChart.january}</td>
							<td>R$ ${dataChart.february}</td>
							<td>R$ ${dataChart.march}</td>
							<td>R$ ${dataChart.april}</td>
							<td>R$ ${dataChart.may}</td>
							<td>R$ ${dataChart.june}</td>
							<td>R$ ${dataChart.july}</td>
							<td>R$ ${dataChart.august}</td>
							<td>R$ ${dataChart.september}</td>
							<td>R$ ${dataChart.october}</td>
							<td>R$ ${dataChart.november}</td>
							<td>R$ ${dataChart.december}</td>
						</tr>
						<tr>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
							<td>R$0.00</td>
						</tr>
						<tr>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
							<td>0%</td>
						</tr>
					</tbody>
				</table>

			</div>

			<div class="col-lg-6">
				<p>Meta Anual: R$ ${yearAmmount}</p>
				<p>Meta Atigindo: R$500.000,00</p>
				<p>Meta Restante: R$400.000,00</p>
			</div>

			<div class="col-lg-6">

				% Ideal
				<div class="progress">
					<div class="progress-bar progress-bar-danger" role="progressbar"
						aria-valuenow="48" aria-valuemin="0" aria-valuemax="100"
						style="width: 0%">
						<span class="sr-only">0%</span>
					</div>
				</div>

				% Atingida
				<div class="progress">
					<div class="progress-bar progress-bar-success" role="progressbar"
						aria-valuenow="52" aria-valuemin="0" aria-valuemax="100"
						style="width: 0%">
						<span class="sr-only">0%</span>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>