<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<script>
$(function (){
	jQuery(function($){
		   $("#agencyCNPJ").mask("99.999.999/9999-99");
		   
		   jQuery('#agencyPhone').mask("(99) 9999-9999?9").ready(function(event) {
		        var target, element;
		        element = $(target);
		      	element.mask("(99) 99999-999?9");
		    });
		});
	
	var form = $("#example-form");
	form.validate({
	    errorPlacement: function errorPlacement(error, element) { element.before(error); },
	    rules: {
	        confirm: {
	            equalTo: "#password"
	        }
	    },
	    messages: {
	    	agencyName: "Digite o Nome Fantasia",
	    	agencyCNPJ: "Digite o CNPJ",
	    	agencyPhone: "Digite o Telefone",
	    	firstName: "Digite seu Nome",
            lastName: "Digite seu Sobrenome",
            password: "Digite sua Senha de acesso!",
            email: {
	          required: "Digite o seu Email",
	          email: "Seu email está incorreto"
	        },
	        acceptTerms: "Para continuar é necessário você aceitar os termo",
	      }
	});
	
	form.children("div").steps({
	    headerTag: "h3",
	    bodyTag: "section",
	    transitionEffect: "slideLeft",
	    onStepChanging: function (event, currentIndex, newIndex) {
	        //form.validate().settings.ignore = ":disabled,:hidden";
	        //return form.valid();
	        return true;
	    }, onFinishing: function (event, currentIndex) {
	        form.validate().settings.ignore = ":disabled";
	        return form.valid();
	    }, onFinished: function (event, currentIndex) {
	    	form.submit();
	    }
	});
});
 </script>

<style>
#wrapper {
	width: 600px;
	margin: 0 auto;
	background: #fff url(../images/shade.jpg) repeat-x center bottom;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	border-top: 1px solid #fff;
	padding-bottom: 76px;
}

h1 {
	padding-top: 10px;
}

h2 {
	font-size: 100%;
	font-style: italic;
}

header, article>*, footer>* {
	margin: 20px;
}

footer>* {
	margin: 20px;
	color: #999;
}

#status {
	padding: 5px;
	color: #fff;
	background: #ccc;
}

#status.fail {
	background: #c00;
}

#status.success {
	background: #0c0;
}

#status.offline {
	background: #c00;
}

#status.online {
	background: #0c0;
}

/*footer #built:hover:after {
  content: '...quickly';
}
*/
[
contenteditable
]
:hover
:not
 
(
:focus
 
)
{
outline
:
 
1
px
 
dotted
 
#ccc
;


}
abbr {
	border-bottom: 0;
}

abbr[title] {
	border-bottom: 1px dotted #ccc;
}

li {
	margin-bottom: 10px;
}

#promo {
	font-size: 90%;
	background: #333 url(../images/learn-js.jpg) no-repeat left center;
	display: block;
	color: #efefef;
	text-decoration: none;
	cursor: pointer;
	padding: 0px 20px 0px 260px;
	border: 5px solid #006;
	height: 160px;
}

#promo:hover {
	border-color: #00f;
}

#ih5 {
	font-size: 90%;
	background: #442C0D url(../images/ih5.jpg) no-repeat left center;
	display: block;
	color: #F7FCE4;
	text-decoration: none;
	cursor: pointer;
	padding: 1px 20px 1px 260px;
	border: 5px solid #904200;
}

#ih5:hover {
	border-color: #CF6D3B;
}

#ffad section {
	padding: 20px;
}

#ffad p {
	margin: 10px 10px 10px 100px;
}

#ffad img {
	border: 0;
	float: left;
	display: block;
	margin: 14px 14px 0;
}

#ffad .definition {
	font-style: italic;
	font-family: Georgia, Palatino, Palatino Linotype, Times,
		Times New Roman, serif;
}

#ffad .url {
	text-decoration: underline;
}

button, input {
	font-size: 16px;
	padding: 3px;
	margin-left: 5px;
}

#view-source {
	display: none;
}

body.view-source {
	margin: 0;
	background: #fff;
	padding: 20px;
}

body.view-source>* {
	display: none;
}

body.view-source #view-source {
	display: block !important;
	margin: 0;
}

#demos {
	width: 560px;
	border-collapse: collapse;
}

#demos .demo {
	padding: 5px;
}

#demos a {
	color: #00b;
	text-decoration: none;
	font-size: 14px;
}

#demos a:hover {
	text-decoration: underline;
}

#demos tbody tr {
	border-top: 1px solid #DCDCDC;
}

#demos .demo p {
	margin-top: 0;
	margin-bottom: 5px;
}

#demos .support {
	width: 126px;
}

.support span {
	cursor: pointer;
	overflow: hidden;
	float: left;
	display: block;
	height: 16px;
	width: 16px;
	text-indent: -9999px;
	background-image: url(../images/browsers.gif);
	background-repeat: none;
	margin-right: 5px;
}

.support span.selected {
	outline: 1px dashed #75784C;
}

.support span.safari {
	background-position: 0 0;
}

.support span.chrome {
	background-position: 16px 0;
}

.support span.firefox {
	background-position: 32px 0;
}

.support span.ie {
	background-position: 48px 0;
}

.support span.opera {
	background-position: 64px 0;
}

.support span.nightly {
	opacity: 0.5;
	filter: alpha(opacity = 50);
}

.support span.none {
	opacity: 0.1;
	filter: alpha(opacity = 10);
}

#demos .tags {
	width: 140px;
}

.tags span {
	font-size: 11px;
	color: #6E724E;
	padding: 2px 5px;
	border: 1px solid #D7D999;
	background: #FFFFC6;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	cursor: pointer;
}

.tags span:hover, .tags span.selected {
	border: 1px solid #75784C;
	background: #FF7;
	color: #333521;
}

#tags span {
	margin-right: 2px;
}

#tags {
	font-size: 14px;
}

#html5badge {
	/*  display: none;*/
	margin-left: -30px;
	border: 0;
}

#html5badge img {
	border: 0;
}

.support span.yourbrowser {
	width: 16px;
	height: 16px;
	background: none;
}

.support span.yourbrowser.supported {
	background: url(../images/yourbrowser.gif) no-repeat top left;
}

.support span.yourbrowser.not-supported {
	background: url(../images/yourbrowser.gif) no-repeat top right;
}

#carbonads-container {
	position: fixed;
	margin-left: 620px;
	margin-top: -2px;
}

/** Pretty printing styles. Used with prettify.js. */
pre {
	font-size: 14px;
}

.str {
	color: #080;
}

.kwd {
	color: #008;
}

.com {
	color: #800;
}

.typ {
	color: #606;
}

.lit {
	color: #066;
}

.pun {
	color: #660;
}

.pln {
	color: #000;
}

.tag {
	color: #008;
}

.atn {
	color: #606;
}

.atv {
	color: #080;
}

.dec {
	color: #606;
}

#holder {
	border: 10px dashed #ccc;
	width: 300px;
	min-height: 300px;
	margin: 20px auto;
}

#holder.hover {
	border: 10px dashed #0c0;
}

#holder img {
	display: block;
	margin: 10px auto;
}

#holder p {
	margin: 10px;
	font-size: 14px;
}

progress {
	width: 100%;
}

progress:after {
	content: '%';
}

.fail {
	background: #c00;
	padding: 2px;
	color: #fff;
}

.hidden {
	display: none !important;
}
</style>

<f:form id="example-form" commandName="agencyForm" method="post"
	action="${pageContext.request.contextPath}/register/populateAgency">

	<div>
		<h3>DADOS</h3>

		<section>
			<div style="float: left;">

				<H2>Dados da Agência</H2>
				<label for="agencyName">Nome Fantasia *</label> <input
					id="agencyName" name="agencyName" type="text" class="required">

				<label for="agencyCNPJ">CNPJ *</label> <input id="agencyCNPJ"
					name="agencyCNPJ" type="text" class="required"
					data-mask="99.999.999/9999-99"> <label for="agencyPhone">Telefone
					*</label> <input id="agencyPhone" name="agencyPhone" type="text"
					class="required" data-mask="(99) 9999-99999">
			</div>


			<div style="float: right;">
				<H2>Dados Pessoais</H2>
				<label for="firstName">Nome *</label> <input id="firstName"
					name="firstName" type="text" class="required"> <label
					for="lastName">Sobrenome *</label> <input id="lastName"
					name="lastName" type="text" class="required"> <label
					for="email">Email *</label> <input id="email" name="email"
					type="text" class="required"> <label for="password">Senha
					*</label> <input id="password" name="password" type="text" class="required">

				<label for="confirm">Confirme a senha *</label> <input id="confirm"
					name="confirm" type="text" class="required">
			</div>

			<br clear="all" />

			<p>(*) Obrigatórios</p>
		</section>

		<h3>LOGOMARCA</h3>
		
		<section id="wrapper">
			<header>
				<h1>Arraste para o quadrado a logo de sua agência</h1>
			</header>

			<article>
				<div id="holder"></div>

				<p id="upload" class="hidden">
					<label>Drag & drop not supported, but you can still upload via this input field:<br>
						<input type="file">
					</label>
				</p>
				<p id="filereader">File API & FileReader API not supported</p>
				<p id="formdata">XHR2's FormData is not supported</p>
				<p id="progress">XHR2's upload progress isn't supported</p>
				<p> 
					Upload progress: <progress id="uploadprogress" min="0" max="100" value="0">0</progress>
				</p>
				<p>Drag an image from your desktop on to the drop zone above to see the browser both render the preview, but also upload automatically to this server.</p>
			</article>

			<br /> 
			<br /> 
			
			<input id="acceptTerms" name="acceptTerms" type="checkbox" class="required">
			<label for="acceptTerms">Estou de acordo com o termo e as condições.</label>
		</section>
	</div>
</f:form>
