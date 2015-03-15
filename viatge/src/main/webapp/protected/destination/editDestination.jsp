<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!--TITLE -->
		<div class="row">
			<div id="paper-top">
				<div class="col-sm-3">
					<h2 class="tittle-content-header">
						<span class="entypo-menu"></span> <span>Destinos de Viagem</span>
					</h2>
				</div>
			</div>
		</div>
		<!-- BREADCRUMB -->
		<ul id="breadcrumb">
			<li><span class="entypo-home"></span></li>
			<li><i class="fa fa-lg fa-angle-right"></i></li>
			<li><a href="${pageContext.request.contextPath}/auth/home" title="Página Inicial">Página Inicial</a></li>
			<li><i class="fa fa-lg fa-angle-right"></i></li>
			<li><a href="${pageContext.request.contextPath}/auth/destination" title="Listagem de Destinos">Gestão de Destinos</a></li>
			<li><i class="fa fa-lg fa-angle-right"></i></li>
			<li><a href="#" title="Editar Destino">Editar Destino</a></li>
		</ul>
		<!-- FIM BREADCRUMB -->
		
		<div class="col-sm-12">
			<div class="nest" id="stepyClose">
			
				<div class="title-alt">
					<h6>Edição do Destino de Viagem</h6>
				</div>

				<div class="body-nest" id="stepy">
				
					<c:if test="${validator}">
						<div class="alert alert-danger">
							<span class="entypo-attention"></span> <strong>Opa!</strong>&nbsp;&nbsp;Houve
							algum erro na hora de salvar os seguintes dados:
							<ul>
								<c:forEach items="${errors}" var="e">
									<li><c:out value="${e}" /></li>
								</c:forEach>
							</ul>
						</div>
					</c:if>

					<div class="demo">
					
						<f:form id="transition-duration-demo" method="post" action="editDestination" modelAttribute="destinationModify" enctype="multipart/form-data">
						
						<input id="destinationID" type="hidden" name="id" value="${destinationModify.idDestination}"/>
						
							<fieldset title="Categoria">
								<legend>Associar Categoria</legend>

								<p>
									<label for="category">Categoria:</label>
		
									<f:select path="categories.idCategory" cssClass="form-control">
										<f:option value="-1" label="-- Selecione uma categoria para associação --" />
										<f:options items="${categoryDropDown}" itemValue="idCategory" itemLabel="ctName" />
									</f:select>
								</p>

								<p>
									<label>País do Destino:</label>

									<f:select path="country.idCountry" cssClass="form-control">
										<f:option value="-1" label="-- Selecione um país para associação --" />
										<f:options items="${countriesList}" itemValue="idCountry" itemLabel="countryName" />
									</f:select>
								</p>

                                <p>
                                    <label for="destination">Nome do Destino:</label>
                                    <f:input id="destination" type="text" placeholder="Ex... Roma" path="dtName" cssClass="form-control"/>
                                </p>
							</fieldset>
							
							        
                            <!-- Filtros -->
                            <fieldset title="Filtros">
                                <legend>Filtros do Destino</legend>
                                <ul class="list-checkbox skin skin-flat">
                                    <li>                                       
                                        <label for="socialProfiles.accompanying1">Viagem com Acompanhante</label>
                                        <f:checkbox id="socialProfiles.accompanying1" path="socialProfiles.accompanying"/>
                                    </li>

                                    <li>                                    
                                        <label for="socialProfiles.friends1">Viagem com Amigos</label>
                                        <f:checkbox id="socialProfiles.friends1" path="socialProfiles.friends"/>
                                    </li>

                                    <li>                                       
                                        <label for="socialProfiles.children1">Família sem Crianças</label>
                                        <f:checkbox id="socialProfiles.children1" path="socialProfiles.children"/>
                                    </li>

                                    <li>                                    
                                        <label for="socialProfiles.alone1">Viajantes Solitários</label>
                                        <f:checkbox id="socialProfiles.alone1" path="socialProfiles.alone"/>
                                    </li>

                                    <li>                                       
                                        <label for="socialProfiles.elderly1">Terceira Idade</label>
                                        <f:checkbox id="socialProfiles.elderly1" path="socialProfiles.elderly"/>
                                    </li>

                                    <li>                                    
                                        <label for="socialProfiles.teenager1">Jovens</label>
                                        <f:checkbox id="socialProfiles.teenager1" path="socialProfiles.teenager"/>
                                    </li>

                                    <li>                                        
                                        <label for="socialProfiles.familyChildren1">Familia com Crianças</label>
                                        <f:checkbox id="socialProfiles.familyChildren1" path="socialProfiles.familyChildren"/>
                                    </li>
                                </ul>
                                                                                          
                                <!-- Economic Profile -->                                
                                <h6>Perfil Económico</h6>

                                <ul class="list-checkbox skin skin-flat">
                                    <li>                                                                        
                                        <label for="economicProfiles.economic1">Viagem Económica</label>
                                        <f:checkbox id="economicProfiles.economic1" path="economicProfiles.economic"/>
                                    </li>

                                    <li>                                                                           
                                        <label for="economicProfiles.intermediate1">Viagem Intermediária</label>
                                        <f:checkbox id="economicProfiles.intermediate1"  path="economicProfiles.intermediate"/>
                                    </li>

                                    <li>                                        
                                        <label for="economicProfiles.luxury1">Viagem de Luxo</label>
                                        <f:checkbox id="economicProfiles.luxury1" path="economicProfiles.luxury"/>
                                    </li>
                                </ul>                          
        
                                <!-- Trip Profile -->
                                <h6>Perfil de Viagem</h6>

                                <ul class="list-checkbox skin skin-flat">
                                    <li>                                    
                                        
                                        <label for="tripProfiles.chill1">Descanso e Relax</label>
                                        <f:checkbox id="tripProfiles.chill1" path="tripProfiles.chill"/>
                                    </li>

                                    <li>
                                        
                                        <label for="tripProfiles.party1">Festas e Vida Noturna</label>
                                        <f:checkbox id="tripProfiles.chill1" path="tripProfiles.party"/>
                                    </li>

                                    <li>
                                        
                                        <label for="tripProfiles.gastronomy1">Gastronomia e Culinária</label>
                                        <f:checkbox id="tripProfiles.gastronomy1" path="tripProfiles.gastronomy"/>
                                    </li>

                                    <li>
                                        
                                        <label for="tripProfiles.romance1">Romance</label>
                                        <f:checkbox id="tripProfiles.romance1" path="tripProfiles.romance"/>
                                    </li>

                                    <li>
                                        
                                        <label for="tripProfiles.shopping1">Compras</label>
                                        <f:checkbox id="tripProfiles.shopping1" path="tripProfiles.shopping"/>
                                    </li>

                                    <li>
                                       
                                        <label for="tripProfiles.fun1">Diversão e Aventura</label>
                                        <f:checkbox id="tripProfiles.fun1" path="tripProfiles.fun"/>
                                    </li>

                                    <li>
                                        
                                        <label for="tripProfiles.history1">História, Arte e Cultura</label>
                                        <f:checkbox id="tripProfiles.history1" path="tripProfiles.history"/>
                                    </li>

                                    <li>
                                        
                                        <label for="tripProfiles.sports1">Ecoturismo e Esportes</label>
                                        <f:checkbox id="tripProfiles.sports1" path="tripProfiles.sports"/>
                                    </li>

                                    <li>
                                        
                                        <label for="tripProfiles.entertainment1">Parques Tematicos e Entretenimento</label>
                                        <f:checkbox id="tripProfiles.entertainment1" path="tripProfiles.entertainment"/>
                                    </li>
                                </ul>                                                                
        
                                <!-- Weather Profile -->
                                <h6>Climas</h6>

                                <ul class="list-checkbox skin skin-flat">
                                    <li>                                        
                                        <label for="weatherprofile.heat1">Calor</label>
                                        <f:checkbox id="weatherprofile.heat1" path="weatherprofile.heat"/>
                                    </li>

                                    <li>                                        
                                        <label for="weatherprofile.cold1">Frio</label>
                                        <f:checkbox id="weatherprofile.cold1" path="weatherprofile.cold" /> 
                                    </li>

                                    <li>                                       
                                        <label for="weatherprofile.winter1">Frio e Neve</label>
                                        <f:checkbox id="weatherprofile.winter1" path="weatherprofile.winter"/>  
                                    </li>
                                </ul>
                                                                   
                                <!-- Default Profile -->
                                <h6>Perfil Geral</h6>

                                <ul class="list-checkbox skin skin-flat">
                                    <li>
                                        <label for="generalProfiles.beach1">Praia</label>
                                        <f:checkbox id="generalProfiles.beach1" path="generalProfiles.beach"/>                                       
                                    </li>

                                    <li>                                       
                                        <label for="generalProfiles.Cottage1">Campo</label>
                                        <f:checkbox id="generalProfiles.Cottage1" path="generalProfiles.Cottage"/>
                                    </li>

                                    <li>                                       
                                        <label for="generalProfiles.mountain1">Montanha</label>
                                        <f:checkbox id="generalProfiles.mountain1" path="generalProfiles.mountain"/>
                                    </li>

                                    <li>                                    
                                        <label for="generalProfiles.city1">Cidades e Grandes Centros Urbanos</label>
                                        <f:checkbox id="generalProfiles.city1" path="generalProfiles.city"/>
                                    </li>
                                </ul>                                                           
                            </fieldset>
                            <!-- Fim dos Filtros -->
                            
                            <fieldset title="Vitrine Multimídia">
                                <legend>Tour Virtual, Fotos e Videos</legend>
                                <div class="box-midia">
                                
                                    <div class="col-sm-6">

                                        <script type="text/javascript">
                                        
                                            function changeiFrame() {                                           
                                                var input = document.getElementById("yt_input").value;
                                                var iframe = document.getElementById("yt_input");
                                                var result = input.split("=");
                                                
                                                
                                                if(result[0] == "https://www.youtube.com/watch?v" || result[0] == "www.youtube.com/watch?v"){
                                                    
                                                    iframe.setAttribute("src", "//www.youtube.com/embed/"+result[1]);
                                                    
                                                }else{
                                                    iframe.setAttribute("src", "https://www.youtube.com/watch?v=");
                                                    alert("Por Favor, selecione um link válido do Youtube");
                                                }   
                                            }
                                            
                                        </script>
    
                                        <div class="well-media">
                                            <div class="vendor">
                                            <iframe id="id-video" width="560" height="315" src="" frameborder="0" allowfullscreen></iframe>
                                            </div>
                                            <div class="video-text">
                                                <h2>Link do Youtube</h2>
                                                <div class="tag-nest">
                                                    <f:input type="text" path="video.code" id="yt_input" onchange="changeiFrame();" placeholder="Ex:. https://www.youtube.com/watch?v=QEfPzNS3Shg"  cssClass="form-control"/>
                                                </div>
                                            </div>
                                            <div class="video-category-bg">
                                                <h3>Video</h3>
                                                <a class="link-media pull-right" href="#"> <span
                                                    class="fontawesome-film"></span>
                                                </a>
                                                <div class="triangle-white"></div>
                                                <div class="triangle-video-right"></div>
                                            </div>
                                        </div>
    
                                    </div>
                                                                   
                                    <div class="col-sm-6">
                                        <div class="well-media">
                                            <div id="street-view-div" class="vendor">
                                              
                                            </div>
    
                                            <div class="video-text">
                                                <h2>Link do StreetView</h2>
                                                <div class="tag-nest">
                                                    <f:input type="text" path="streetView.embedCode" placeholder="" id="street_in"  cssClass="form-control"/>
                                                </div>
                                            </div>
                                            <div class="audio-category-bg">
                                                <h3>Tour Virtual</h3>
                                                <a class="link-media pull-right" href="#"> <span class="fontawesome-road"></span>
                                                </a>
                                                <div class="triangle-white"></div>
                                                <div class="triangle-audio-right"></div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="col-sm-12">
                                        <div class="nest" id="DropZoneClose">
                                            <div class="title-alt">
                                                <h6>Imagens do Destino</h6>
                                            </div>
    
                                            <div class="body-nest" id="DropZone">
                                                <div id="myDropZone" class="dropzone"></div>
    
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>                          

                            </fieldset>

                            <fieldset title="Descrição">
                                <legend>Descreva o Destino</legend>
                                
                                <div style=" padding-top: 50px;">
                                <f:textarea  id="descriptionId" path="dtDescription" cssClass="ckeditor"></f:textarea>
                                </div>
                                
                                <ul class="list-checkbox skin skin-flat">
                                    <li>
                                        <f:checkbox id="dtAppearWebsite2"  path="dtAppearWebsite"/>
                                        <label for="dtAppearWebsite2">Aparecer no Website</label>
                                    </li>
                                    
                                    <li>                                
                                        <f:checkbox id="dtHighlightWebsite1" path="dtHighlightWebsite"/>
                                        <label for="dtHighlightWebsite1">Destacar no Website</label>
                                    </li>
                                </ul>
 							</fieldset>
					

							<button id="submit-all" type="submit" class="stepy-finish pull-right btn btn-info">Pronto!</button>
							
						</f:form>
					</div>
				</div>
			</div>
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
            
            $.get('/viatge/file/imageList/'+$('#destinationID').val(), function(data) {
            	var existingFileCount = 0;
                $.each(data, function(key,value){
                    
                    var obj = JSON.parse(value);
                     
                    var mockFile = { name: obj.fileName, size: obj.fileSize };
                     
                    thisDropzone.options.addedfile.call(thisDropzone, mockFile);    
                    thisDropzone.options.thumbnail.call(thisDropzone, mockFile, "/viatge/image/destination/thubnail/"+obj.fileName+'/'+$('#destinationID').val());
                    
                    existingFileCount = existingFileCount + 1; // The number of files already uploaded
                    thisDropzone.options.maxFiles = thisDropzone.options.maxFiles - existingFileCount;
                     
                });
                 
            });
        }
    });
});

$(document).ready(function(){
    $.get('/viatge/auth/getStreetViewCode?${_csrf.parameterName}=${_csrf.token}',{destinationId: $('#destinationID').val()}, function(data){
        $('#street-view-div').append(data);
        $( '#street-view-div > iframe' ).attr( 'src', function ( i, val ) { return val; });
    });
});

$(document).ready(function(){
$.get('/viatge/auth/getVideoCode?${_csrf.parameterName}=${_csrf.token}',{destinationId: $('#destinationID').val()}, function(data){
    $('#id-video').attr("src", data);
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