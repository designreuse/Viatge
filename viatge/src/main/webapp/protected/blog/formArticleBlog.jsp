<c:if test="${validator}">
	<div class="alert alert-danger">
		<button data-dismiss="alert" class="close" type="button">×</button>
		<span class="entypo-attention"></span> <strong>Opa!</strong>&nbsp;&nbsp;Você
		não pode deixar o campo abaixo em branco e ele tem que ter mais que
		três caracteres!.

	</div>
</c:if>

<div class="col-sm-12">
	<f:form  method="post" commandName="articleBlogForm" action="${action}" enctype="multipart/form-data">
		<input id="articleBlogID" type="hidden" name="id" value="${articleBlogForm.idArticle}"/>
		<div class="form-group">
			<table width="100%">
				<tr>
					<td valign="top" style="width: 70%;"><input type="hidden"
						name="id" value="${articleBlogForm.idArticle}" /> <label
						for="category">Nome do Artigo:</label> <f:input type="text"
							placeholder="Ex. Dubai para crianças ou Melhores destinos Inverno/2015"
							id="inputArticleBlog" class="form-control" path="atName" /> <f:errors
							path="atName" /> <br />

						<p>
							<label>Categoria:</label>
							<f:select path="categoryBlog.idCategoryBlog"
								cssClass="form-control" cssStyle="width: 500px;">
								<f:option value="-1"
									label="-- Selecione uma categoria para associação --" />
								<f:options items="${categoryBlogList}"
									itemValue="idCategoryBlog" itemLabel="ctBgName" />
							</f:select>
						</p>

						<fieldset title="Descrição">
							<legend>Insira o Artigo</legend>

							<div style="padding-top: 50px;">
								<f:textarea id="descriptionId" path="atContent"
									cssClass="ckeditor" />
							</div>
						</fieldset></td>
				</tr>
				<tr>
					<td>
						<div class="col-sm-12">
							<div class="nest" id="DropZoneClose">
								<div class="title-alt">
									<h6>Capa do Artigo</h6>
								</div>

								<div class="body-nest" id="DropZone">
									<div id="myDropZone" class="dropzone"></div>

								</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>

		<button type="submit" class="pull-right btn btn-primary">
			<span class="entypo-plus-squared"></span>&nbsp;&nbsp;Cadastrar
		</button>

		<a class="pull-right btn btn-danger" href="<c:url value="article-blog-list"/>">
			<span class="entypo-cancel-squared"></span>&nbsp;&nbsp;Cancelar
		</a>
	</f:form>
</div>

<script type="text/javascript">

	$('#ckHighlightWebsite').click(
			function() {
				$(this).is(':checked') ? $('#ckHighlightWebsite').attr(
						'checked', true) : void 0;

				$.get(action, function(data) {
					// faz alguma coisa com o retorno, manda msg de sucesso, algo assim
				}).fail(function(error) {
					// se der problema cai aqui. Você pode exibir o erro e desfazer a checagem do checkbox
				});
			});
</script>