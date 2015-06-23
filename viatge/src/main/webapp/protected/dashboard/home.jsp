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


	<table>
		<tr>
			<td>
				<div class="title-alt">
					<h6>SATISFAÇÃO DOS CLIENTES</h6>
				</div> <script type="text/javascript">
					$(window).resize(function() {
						drawChart1();
					});
					google.load("visualization", "1", {
						packages : [ "corechart", "bar" ]
					});
					google.setOnLoadCallback(drawChart1);
					function drawChart1() {

						var data = google.visualization
								.arrayToDataTable([
										[ 'Físico', 'Site', '2000 Population' ],
										[ 'New York City, NY', 8175000, 8008000 ]
												  ]);

						var options = {
// 							title : 'SITE',
							chartArea : {
								width : '100%'
							},
							width : 300,
							hAxis : {
								title : 'Site e Físico',
								minValue : 0
							},
							vAxis : {
								title : 'City'
							}
						};

						var chart = new google.visualization.BarChart(document
								.getElementById('chartDiv'));

						chart.draw(data, options);
					}
				</script>

				<div id="chartDiv" style="width: 100%; overflow: hidden"></div>
			</td>

		</tr>
	</table>

</div>
</div>
