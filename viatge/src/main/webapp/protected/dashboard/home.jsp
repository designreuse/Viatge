<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÃGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Dashboard</span>
			</h2>
		</div>
	</div>
</div>
<!--/ TITLE -->

<div class="content-wrap margin-bottom width-fixid">
Clientes
<hr>

	<table style="width: 950px;">
		<tr>
			<td align="left" width="600">
				<div class="title-alt">
					<h6>SATISFAÇÃO DOS CLIENTES</h6>
				</div> <script type="text/javascript">
					google.load('visualization', '1', {
						packages : [ 'corechart', 'bar' ]
					});
					google.setOnLoadCallback(drawMultSeries);

					function drawMultSeries() {
						var data = google.visualization.arrayToDataTable([
								[ 'Tipo', 'Geral', 'Site', 'Físico' ],
								[ 'Insatisfeito', 4, 5, 10 ],
								[ 'Razoavelmente Satisfeito', 6, 15, 20 ],
								[ 'Muito Satisfeito', 90, 80, 70 ],

						]);

						var options = {
							height : 250,
							hAxis : {
								title : 'Satisfação: Site / Físico',
								minValue : 0
							},
						};

						var chart = new google.visualization.BarChart(document
								.getElementById('chart_satisfacao'));
						chart.draw(data, options);
					}
				</script>

				<div id="chart_satisfacao" style="width: 450px; overflow: hidden"></div>
			</td>

			<td width="600">

				<div class="title-alt">
					<h6>ORIGEM DO CLIENTE</h6>
				</div> <script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {

						var data = google.visualization.arrayToDataTable([
								[ 'Origem', 'Quantidade' ], [ 'Site', 11 ],
								[ 'CRM', 2 ], ]);

						var options = {
							pieHole : 0.4,
							title : 'Origem Cliente',
							height : 250
						};

						var chart = new google.visualization.PieChart(document
								.getElementById('chart_origem'));

						chart.draw(data, options);
					}
				</script> <script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
				<div id="chart_origem" style="width: 450px;"></div>
			</td>
		</tr>
	</table>

	<br /> <br />

	<table>
		<tr>
			<td>
				<div class="title-alt">
					<h6>PERFIL DO CLIENTE: Econômico</h6>
				</div> <script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {

						var data = google.visualization.arrayToDataTable([
								[ 'Perfil', 'Quantidade' ],
								[ 'Econômico', 22 ], [ 'Intermediário', 38 ],
								[ 'Luxio', 40 ] ]);

						var options = {
							pieHole : 0.4,
							title : 'Econômico',
							height : 250,
						};

						var chart = new google.visualization.PieChart(document
								.getElementById('chart_economico'));

						chart.draw(data, options);
					}
				</script> <script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
				<div id="chart_economico" style="width: 330px;"></div>
			</td>

			<td>
				<div class="title-alt">
					<h6>Social</h6>
				</div> <script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {

						var data = google.visualization.arrayToDataTable([
								[ 'Perfil', 'Quantidade' ],
								[ 'Acompanhante', 22 ], [ 'Sozinho', 4 ],
								[ 'Crianças', 17 ], [ 'Amigos', 20 ],
								[ 'Terceira Idade', 11 ],
								[ 'Sem Crianças', 13 ], [ 'Jovem', 13 ], ]);

						var options = {
							pieHole : 0.4,
							title : 'Social',
							height : 250
						};

						var chart = new google.visualization.PieChart(document
								.getElementById('chart_social'));

						chart.draw(data, options);
					}
				</script> <script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
				<div id="chart_social" style="width: 400px;"></div>
			</td>

			<td>
				<div class="title-alt">
					<h6>Viagem</h6>
				</div> <script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {

						var data = google.visualization.arrayToDataTable([
								[ 'Viagem', 'Quantidade' ],
								[ 'Praia', 58 ], 
								[ 'Cidades e Grandes Centros Urbanos', 43 ],
								[ 'Campo', 28 ],
								[ 'Montanha', 13 ]]);

						var options = {
							pieHole : 0.4,
							title : 'Viagem',
							height : 250
						};

						var chart = new google.visualization.PieChart(document
								.getElementById('chart_viagem'));

						chart.draw(data, options);
					}
				</script> <script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
				<div id="chart_viagem" style="width: 300px;"></div>
			</td>
		</tr>
		
		<tr>

			<td>
				<div class="title-alt">
					<h6>Clima</h6>
				</div> <script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {

						var data = google.visualization.arrayToDataTable([
								[ 'Clima', 'Quantidade' ],
								[ 'Frio', 25 ], 
								[ 'Calor', 64 ],
								[ 'Frio e Neve', 50 ]]);

						var options = {
							pieHole : 0.4,
							title : 'Clima',
							height : 250
						};

						var chart = new google.visualization.PieChart(document
								.getElementById('chart_clima'));

						chart.draw(data, options);
					}
				</script> <script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
				<div id="chart_clima" style="width: 330px;"></div>
			</td>

			<td>
				<div class="title-alt">
					<h6>Experiências</h6>
				</div> <script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {

						var data = google.visualization.arrayToDataTable([
								[ 'Experiência', 'Quantidade' ],
								[ 'Descanso e Relaxar', 25 ], 
								[ 'Romance', 64 ],
								[ 'História, Arte e Cultura', 50 ],
								[ 'Festa e Vida Noturna', 50 ],
								[ 'Compras', 50 ],
								[ 'Ecoturismo e Esporte', 50 ],
								[ 'Gastronomia e Culinária', 50 ],
								[ 'Diversão e Aventura', 50 ],
								[ 'Parques Temáticos e Entretenimento', 50 ]
								]);

						var options = {
							pieHole : 0.4,
							title : 'Experiência',
							height : 250
						};

						var chart = new google.visualization.PieChart(document
								.getElementById('chart_experiencia'));

						chart.draw(data, options);
					}
				</script> <script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
				<div id="chart_experiencia" style="width: 400px;"></div>
			</td>
		
		</tr>
	</table>

	<br/><br/>
	
	<table>
		<tr>
			<td>
				<div class="title-alt">
					<h6>COMPRAS POR CATEGORIA</h6>
				</div> <script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {

						var data = google.visualization.arrayToDataTable([
								[ 'Categoria', 'Compra' ], [ 'Nacional', 11 ],
								[ 'Internacional', 20 ], [ 'Cruzeiro', 40 ] ]);

						var options = {
							title : 'Compras por Categoria',
							height : 250
						};

						var chart = new google.visualization.PieChart(document
								.getElementById('chart_compras'));

						chart.draw(data, options);
					}
				</script> <script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
				<div id="chart_compras" style="width: 450px;"></div>
			</td>
		</tr>
	</table>
	
	<br/>
	Vendas
	<hr>
	<table>
		<tr>
			<td>
			 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
  <div id="chart_div" style="width: 900px;"></div>
      
			<script> 
			google.load('visualization', '1', {packages: ['corechart', 'line']});
			google.setOnLoadCallback(drawCurveTypes);

			function drawCurveTypes() {
			      var data = google.visualization.arrayToDataTable([
			          ['Ano', 'Vendas Total', 'Site', 'Físico'],
			          ['03/2015',  30000, 21000, 9000],
			          ['04/2015',  27000, 15000, 12000],
			          ['05/2015',  40500, 10200, 30300],
			          ['06/2015',  60000, 35000, 25000],
			        ]);

			    var options = {
			    		width: 900,
			          title: 'Vendas por Período',
			          curveType: 'function',
			          legend: { position: 'bottom' },
		          vAxis: {
		            title: 'Valor'
		          },
			        };

			    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
			      chart.draw(data, options);
			    }
			</script>
			      			
			</td>
		</tr>
	</table>
	
</div>