<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				src="https://s3-sa-east-1.amazonaws.com/joocebox-media/Poltrona+1/Lista+de+Clientes.mp4"
				type="video/mp4">
		</video>

</div>


<div class="content-wrap margin-bottom">
	<div class="row">


		<div class="nest text">
			<div class="title-alt">
				<h6>Clientes</h6>
			</div>

			<div class="col-sm-12">
				<p>
					Você possui
					<c:out value="${customerCount}"></c:out>
					clientes ativos
				</p>
			</div>

			<form action="#" method="post" class="form-filtro">
				<div class="col-sm-4">
					<input class="form-control" id="filter" placeholder="Procurar"
						type="text" />
				</div>
			</form>

			<div class="col-sm-12">
				<c:choose>
					<c:when test="${!empty customerList}">
						<table id="footable-res2" class="demo margin-bottom"
							data-filter="#filter" data-filter-text-only="true"
							data-page-size="15">
							<thead>
								<tr>
									<th class="vertical-align-center">Nome</th>
									<th class="vertical-align-center">E-mail</th>
									<th class="vertical-align-center">Telefone Celular</th>
									<th class="vertical-align-center">Telefone Fixo</th>
									<th class="vertical-align-center">Cliente Ativo</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${customerList}" var="c">
									<tr>
										<td><a
											href="<c:url value="customer/view/${c.idCustomer}"/>">${c.firstName}&nbsp;${c.lastName}</a></td>
										<td>${c.email}</td>
										<td>${c.customerPhone.celPhone}</td>
										<td>${c.customerPhone.homePhone}</td>
										<td><div class="make-switch" data-on="info"
												data-off="success">
												<input type="checkbox" checked>
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="5">
										<div class="pagination pagination-centered"></div>
									</td>
								</tr>
							</tfoot>
						</table>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info">
							<span class="entypo-info-circled"></span> <strong>Hummm!</strong>&nbsp;&nbsp;Parece
							que você ainda não possui nenhuma cliente cadastrado, adicione
							por meio do <b>"Novo Atendimento"</b>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

		</div>


	</div>
</div>
