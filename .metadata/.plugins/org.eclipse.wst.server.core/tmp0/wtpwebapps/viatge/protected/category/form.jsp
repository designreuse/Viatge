<c:if test="${validator}">
	<div class="alert alert-danger">
		<button data-dismiss="alert" class="close" type="button">×</button>
		<span class="entypo-attention"></span> <strong>Opa!</strong>&nbsp;&nbsp;Você
		não pode deixar o campo abaixo em branco e ele tem que ter mais que
		três caracters!.

	</div>
</c:if>

<div class="col-sm-12">
	<f:form method="post" commandName="categoryForm" action="${action}">
		<div class="form-group">
			<input type="hidden" name="id" value="${categoryForm.idCategory}" />
			<f:input type="text" placeholder="Ex. Nacional ou Internacional"
				id="inputCategory" class="form-control" path="ctName" />
			<f:errors path="ctName" />
		</div>

		<button type="submit" class="btn btn-primary">
			<span class="entypo-plus-squared"></span>&nbsp;&nbsp;Cadastrar
		</button>


		<a class="btn btn-danger" href="<c:url value="category"/>"> <span
			class="entypo-cancel-squared"></span>&nbsp;&nbsp;Cancelar
		</a>
	</f:form>
</div>