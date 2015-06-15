<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div id="paper-top">
        <div class="col-sm-12">
            <h2 class="tittle-content-header">
                <i class="icon-menu"></i> <span>Novo Artigo (Blog)</span>
            </h2>
        </div>
    </div>
</div>

<ul id="breadcrumb">
    <li><span class="entypo-home"></span></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="${pageContext.request.contextPath}/auth/home" title="Página Inicial">Página Inicial</a></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="${pageContext.request.contextPath}/auth/article-blog-list" title="Listagem de Artigos">Artigos</a></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="#" title="Nova Categoria">Novo Artigo</a></li>
</ul>
    
<div class="content-wrap margin-bottom">
    <div class="row">
        <div class="nest text">
            <div class="title-alt">
                <h6>Criar Novo Artigo</h6>
            </div>
            
           <%@ include file="formArticleBlog.jsp" %>
        
        </div>
    </div>
</div>

<script type="text/javascript">
$(function() {
    $("div#myDropZone").dropzone({
        url: "/viatge/fileArticleBlog/upload?${_csrf.parameterName}=${_csrf.token}",
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
        removedfile: function(fileArticleBlog) {
            var imageName = fileArticleBlog.name; 
            var url = location.href;
            var id = url.split("?id=");
            $.ajax({
                url: '/viatge/fileArticleBlog/imageDelete/'+id[1]+'/'+imageName,
                type: 'GET', 
                success: function(result) {
                    alert('Imagem '+result+' deletada com sucesso!');
                }
            });


        var _ref;
        return (_ref = fileArticleBlog.previewElement) != null ? _ref.parentNode.removeChild(fileArticleBlog.previewElement) : void 0;        
                      },

    });
});
</script>