<c:if test="${validator}">
	<div class="alert alert-danger">
		<button data-dismiss="alert" class="close" type="button">×</button>
		<span class="entypo-attention"></span> <strong>Opa!</strong>&nbsp;&nbsp;Você
		não pode deixar o campo abaixo em branco e ele tem que ter mais que
		três caracteres!.

	</div>
</c:if>

<div class="col-sm-12">
	<f:form method="post" commandName="categoryBlogForm" action="${action}">
		<div class="form-group">
			<input type="hidden" name="id" value="${categoryBlogForm.idCategoryBlog}" />
			<f:input type="text" placeholder="Ex. Cruzeiros ou Parques Temáticos"
				id="inputCategoryBlog" class="form-control" path="ctBgName" />
			<f:errors path="ctBgName" />
		</div>

		<button type="submit" class="btn btn-primary">
			<span class="entypo-plus-squared"></span>&nbsp;&nbsp;Cadastrar
		</button>


		<a class="btn btn-danger" href="<c:url value="category-blog-list"/>"> <span
			class="entypo-cancel-squared"></span>&nbsp;&nbsp;Cancelar
		</a>
	</f:form>
</div>