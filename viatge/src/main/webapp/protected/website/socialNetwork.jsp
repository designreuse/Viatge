<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!-- CONTENT -->
        <!--TITLE -->
        <div class="row">
            <div id="paper-top">
                <div class="col-sm-12">
                    <!-- TITULO DA PÃGINA -->
                    <h2 class="tittle-content-header"><i class="icon-menu"></i> <span>Edição de Site</span></h2>
                </div>
            </div>
        </div>
        <!--/ TITLE -->
        
        <!-- BREADCRUMB -->
        <ul id="breadcrumb">
            <li><span class="entypo-home"></span></li>
            <li><i class="fa fa-lg fa-angle-right"></i></li>
            <li><a href="${pageContext.request.contextPath}/auth/home" title="Sample page 1">Página Inicial</a></li>
            <li><i class="fa fa-lg fa-angle-right"></i></li>
            <li><a href="#" title="Sample page 1">WebSite</a></li>
            <li><i class="fa fa-lg fa-angle-right"></i></li>
            <li><a href="#" title="Sample page 1">Redes Sociais</a></li>
        </ul>
        <!-- FIM BREADCRUMB -->
		
        <div class="content-wrap margin-bottom">
            <div class="row">
            	
                <div class="nest text">
                    <div class="title-alt">
                        <h6>Redes Sociais</h6>
                    </div>
                    <f:form action="saveSocialNetwork"
                    		method="POST"
                    		modelAttribute="agConfig">
	                    <div class="col-sm-12 margin-bottom">
	                        <p>Seus passageiros estão nas Redes Sociais. Permita-os socializar através de seu website também, conecte-o as páginas de sua Agência nas Redes Sociais e alcance mais clientes.</p>
	                    </div>
	                
	                    <div class="col-sm-3">
	                        <div class="panel panel-default">
	                            <div class="panel-facebook">
	                                <span class="entypo-facebook-circled middle-social"></span>
	                            </div>
	                            <div class="panel-body">
	                                <p class="lead">Facebook</p>
	                                <p class="social-follower"><f:input type="text" placeholder="Cole aqui o link do Facebook" cssClass="form-control" path="facebookLink"/></p>
	                            </div>
	                        </div>
	                    </div>
	                    <!--/col-->
	        
	                    <div class="col-sm-3">
	                        <div class="panel panel-default">
	                            <div class="panel-twitter">
	                                <span class="entypo-twitter-circled middle-social"></span>
	                            </div>
	                            <div class="panel-body">
	                                <p class="lead">Twitter</p>
	                                <p><f:input type="text" placeholder="Cole aqui o link do Twitter" cssClass="form-control" path="twitterLink"/></p>
	                            </div>
	                        </div>
	                    </div>
	                    <!--/col-->
	        
	                    <div class="col-sm-3">
	                        <div class="panel panel-default">
	                            <div class="panel-instagram">
	                                <span class="entypo-instagrem middle-social"></span>
	                            </div>
	                            <div class="panel-body">
	                                <p class="lead">Instagram</p>
	                                <p><f:input type="text" placeholder="Cole aqui o link do Instagram" cssClass="form-control" path="instagramLink"/></p>
	                            </div>
	                        </div>
	                    </div>
	                    <!--/col-->
	        
	                    <div class="col-sm-3">
	                        <div class="panel panel-default">
	                            <div class="panel-google">
	                                <span class="entypo-gplus-circled middle-social"></span>
	                            </div>
	                            <div class="panel-body">
	                                <p class="lead">Google +</p>
	                                <p><f:input type="text" placeholder="Cole aqui o link do Google +" cssClass="form-control" path="googlePlusLink"/></p>
	                            </div>
	                        </div>
	                    </div>
	                    <!--/col-->
	             
	                    <div class="col-sm-12 button-social">
	                        <button type="submit" class="btn btn-info pull-right"><span class="entypo-link"></span>&nbsp;&nbsp; Salvar Link</button>
	                    </div>
                    </f:form>
     
     
     	    	</div>            
			</div>
		</div>
                
		<div class="content-wrap">
        	<p class="size14">Ainda não tem página nas Redes Sociais? Que tal começar pela mais popular delas, o Facebook? <a href="#">Clique aqui</a>, temos algumas dicas para você.</p>
        </div>