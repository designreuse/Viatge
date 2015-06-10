<c:if test="${validator}">
	<div class="alert alert-danger">
		<button data-dismiss="alert" class="close" type="button">×</button>
		<span class="entypo-attention"></span> <strong>Opa!</strong>&nbsp;&nbsp;Você
		não pode deixar o campo abaixo em branco e ele tem que ter mais que
		três caracteres!.

	</div>
</c:if>

<div class="col-sm-12">
	<f:form method="post" commandName="articleBlogForm" action="${action}">
		<div class="form-group">
			<table width="100%">
				<tr>
					<td valign="top"
						style="width: 70%;">
						<input type="hidden" 
		         		 	name="id" 
		         		 	value="${articleBlogForm.idArticle}" />
		         		 <label for="category">Nome do Artigo:</label>	 
		         		 <f:input type="text"
							      placeholder="Ex. Dubai para crianças ou Melhores destinos Inverno/2015"
							      id="inputArticleBlog" 
							      class="form-control" 
							      path="atName" /> 
						 <f:errors path="atName" /> 
						 <br />

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
							<legend>Descreva o Destino</legend>
								
							<div style=" padding-top: 50px;">
								<f:textarea  id="descriptionId" path="atContent" cssClass="ckeditor"/>
							</div>
						</fieldset>
					</td>
					<td valign="top">
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

		<button type="submit" class="btn btn-primary">
			<span class="entypo-plus-squared"></span>&nbsp;&nbsp;Cadastrar
		</button>

		<a class="btn btn-danger" href="<c:url value="article-blog-list"/>">
			<span class="entypo-cancel-squared"></span>&nbsp;&nbsp;Cancelar
		</a>
	</f:form>
</div>

<script type="text/javascript">
$(function() {
    $("div#myDropZone").dropzone({
        url: "/viatge/file/upload?${_csrf.parameterName}=${_csrf.token}",
        autoProcessQueue: true,
        uploadMultiple: true,
        parallelUploads: 1,
        maxFilesize: 5,
        maxFiles: 8,
        acceptedFiles: "image/jpeg",
        dictDefaultMessage: "Upload",
        dictRemoveFile: "Remover",
        dictInvalidFileType: "Tipo de Arquivo Invalido! Selecione uma imagem do tipo JPG.",
        dictFileTooBig: "Arquivo grande demais. Selecione outro até 5mb",
        dictResponseError: "Servidor fora do ar. Contacte o administrador de sistemas",
        dictMaxFilesExceeded: "O limite de imagens excedeu!",
        addRemoveLinks: true,
        removedfile: function(file) {
            var imageName = file.name; 
            var url = location.href;
            var id = url.split("?id=");
            $.ajax({
                url: '/viatge/file/imageDelete/'+id[1]+'/'+imageName,
                type: 'GET', 
                success: function(result) {
                    alert('Imagem '+result+' deletada com sucesso!');
                }
            });


        var _ref;
        return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
                      },
        
        init: function() {          
            Dropzone.autoDiscover = false;
            
            thisDropzone = this;
            
            $.get('/viatge/file/imageList/'+$('#articleBlogID').val(), function(data) {
            	var existingFileCount = 0;
                $.each(data, function(key,value){
                    
                    var obj = JSON.parse(value);
                    var mockFile = { name: obj.fileName, size: obj.fileSize };
                     
                    thisDropzone.options.addedfile.call(thisDropzone, mockFile);    
                    thisDropzone.options.thumbnail.call(thisDropzone, mockFile, "/viatge/image/articleBlog/thubnail/"+obj.fileName+'/'+$('#articleBlogID').val());
                    
                    existingFileCount = existingFileCount + 1; // The number of files already uploaded
                    thisDropzone.options.maxFiles = thisDropzone.options.maxFiles - existingFileCount;
                     
                });
                 
            });
        }
    });
});


	$('#ckHighlightWebsite').click(function() {
		$(this).is(':checked') ? $('#ckHighlightWebsite').attr('checked', true) : void 0;
		
		$.get(action, function(data) {
			// faz alguma coisa com o retorno, manda msg de sucesso, algo assim
		}).fail(function(error) {
			// se der problema cai aqui. Você pode exibir o erro e desfazer a checagem do checkbox
		});
	});		


	$('#street_in').change(function () {
    var inputValue = $(this).val();

    if (inputValue !== null || inputValue !== "") {
        var heightFormated = alterHeight(inputValue);
        var widthFormated = alterWidth(heightFormated);

        if ($('#street-view-div > iframe').length) {
            $('#street-view-div').empty();

        }
        
        $('#street-view-div').append(widthFormated);
    }

    function alterHeight(input) {
        var heightVar = /.*height=\"(.+?)\".*/;
        var x = heightVar.exec(input);
        var foo = "height=\"" + x[1] + "\"";
        var replacedHeight = inputValue.replace(foo, "height=\"300px\"");
        return replacedHeight;
    }

    function alterWidth(input) {
        var widthVar = /.*width=\"(.+?)\".*/;
        var y = widthVar.exec(input);
        var xpto = "width=\"" + y[1] + "\"";
        var replacedWidth = input.replace(xpto, "Width=\"100%\"");
        return replacedWidth;
    }
});
	
</script>