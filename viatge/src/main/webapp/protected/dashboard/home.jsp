<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÁGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>DashBoard</span>
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
	<li><a href="#" title="Sample page 1">Atendimentos em Aberto</a></li>
</ul>
<!-- FIM BREADCRUMB -->

<!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
 // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {

      // Create the data table.
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Topping');
      data.addColumn('number', 'Slices');
      data.addRows([
        ['Mushrooms', 3],
        ['Onions', 1],
        ['Olives', 1],
        ['Zucchini', 1],
        ['Pepperoni', 2]
      ]);

      // Set chart options
      var options = {'title':'How Much Pizza I Ate Last Night',
                     'width':400,
                     'height':300};

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
  </script>    
<div class="content-wrap margin-bottom">
	<div class="row-cols">

		<ul class="list-metricas list6">
			<li class="status01">
			<div id="chart_div"></div>
			
			
			
				<div>
					<p>PRÓXIMOS DE VIAJAR</p>
					<div class="var-metrica">
						<span class="entypo-clock"></span> 
					</div>
				</div>
			</li>

			<li class="status02">
				<div>
					<p>ENVIAR ORÇAMENTO</p>
					<div class="var-metrica">
						<span class="fontawesome-money"></span> 
					</div>
				</div>


			</li>

			<li class="status03">
				<div>
					<p>ORÇAMENTO ENVIADO</p>
					<div class="var-metrica">
						<span class="fontawesome-comments"></span> 
					</div>
				</div>
			</li>

			<li class="status04">
				<div>
					<p>PRÓXIMOS DE EMBARQUE</p>
					<div class="var-metrica">
						<span class="entypo-suitcase"></span> 0
					</div>
				</div>
			</li>

			<li class="status05">
				<div>
					<p>EM VIAGEM</p>
					<div class="var-metrica">
						<span class="fontawesome-plane"></span> 0
					</div>
				</div>
			</li>

			<li class="status06">
				<div>
					<p>RETORNO DE VIAGEM</p>
					<div class="var-metrica">
						<span class="entypo-home"></span> 0
					</div>										
				</div>
			</li>
		</ul>

	</div>
</div>
