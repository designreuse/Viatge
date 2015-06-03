<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<script>

$(function (){
       
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
              email: "Seu email estÃ¡ incorreto"
            }
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
            
            $.blockUI({
                message: '<img src="https://s3-sa-east-1.amazonaws.com/joocebox-media/static-images/pre_loader_02.GIF" /> <h1>Estamos criando a sua agência! Aguarde alguns minutos....</h1>',

                css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#2692FE',
                        '-webkit-border-radius': '10px',
                        '-moz-border-radius': '10px',
                    opacity: .9,
                    color: '#fff'
                }
            });
            return form.valid();
        }, onFinished: function (event, currentIndex) {
            form.submit();
        },
        labels: {
            cancel: "Cancelar",
            current: "current step:",
            pagination: "Pagination",
            finish: "Criar Minha Agência!",
            next: "Próximo",
            previous: "Anterior",
            loading: "Loading ..."
        }
    });
    
});

$(function(){
	
    $('#agencyCNPJ').mask("99.999.999/9999-99");
    
    jQuery('#agencyPhone').mask("(99) 9999-9999?9").ready(function(event) {
        var target, element;
        element = $(target);
        element.mask("(99) 99999-999?9");
    });
});

$(function() {
    $("div#myDropZone").dropzone({
        url: "/viatge/register/upload?${_csrf.parameterName}=${_csrf.token}",
        autoProcessQueue: true,
        uploadMultiple: false,
        parallelUploads: 1,
        maxFilesize: 10,
        maxFiles: 1,
        acceptedFiles: "image/png",
        dictDefaultMessage: "Upload",
        dictRemoveFile: "Remover",
        dictInvalidFileType: "Tipo de Arquivo Invalido",
        dictFileTooBig: "Arquivo grande demais. Selecione outro atÃ© 5mb",
        dictResponseError: "Servidor fora do ar. Contacte o administrador de sistemas",
        dictMaxFilesExceeded: "O limite de imagens excedeu!",
        addRemoveLinks: true,
        
    });
    
    Dropzone.autoDiscover = false;
    Dropzone.options.myAwesomeDropzone = false;
});

</script>


<form id="example-form" method="post"
	action="./populateAgency?${_csrf.parameterName}=${_csrf.token}"
	enctype="multipart/form-data">

	<div>
		<h3>DADOS</h3>

		<section>
			<header>
				<h1>Preencha os campos abaixo:</h1>
			</header>

			<div style="float: left;">

				<H2>Dados da Agência</H2>

				<label for="agencyName">Nome Fantasia *</label> <input
					id="agencyName" name="agencyName" type="text"
					class="required form-control"> <label for="agencyCNPJ">CNPJ
					*</label> <input id="agencyCNPJ" name="agencyCNPJ" type="text"
					class="required form-control"> <label for="agencyPhone">Telefone*</label>
				<input id="agencyPhone" name="agencyPhone" type="text"
					class="required form-control" data-mask="(99) 9999-99999">
			</div>


			<div style="float: right;">
				<H2>Dados Pessoais</H2>

				<label for="firstName">Nome *</label> <input id="firstName"
					name="firstName" type="text" class="required form-control">

				<label for="lastName">Sobrenome *</label> <input id="lastName"
					name="lastName" type="text" class="required form-control">

				<label for="email">Email *</label> <input id="email"
					name="login.email" type="text" class="required form-control">

				<label for="password">Senha*</label> <input id="password"
					name="login.password" type="password" class="required form-control">

				<label for="confirm">Confirme a senha *</label> <input id="confirm"
					name="confirm" type="password" class="required form-control">
			</div>

			<br clear="all" />

			<p>
				<b>(*) Obrigatórios</b>
			</p>
		</section>

		<h3>LOGOMARCA</h3>

		<section id="wrapper">
			<header>
				<h1>Arraste dentro do quadrado abaixo sua logo:</h1>
			</header>
			<div class="col-sm-12">
				<div class="nest" id="DropZoneClose">
					<div class="body-nest" id="DropZone">
						<div id="myDropZone" class="dropzone"></div>

					</div>
				</div>
			</div>
		</section>

		<h3>COR</h3>

		<section id="section-color">
			<header>
				<h1>Selecione uma cor a partir da sua logo para defini-la como
					a cor de seu website:</h1>
			</header>

			<div id="insertcolor">
				<input style="float: left;" id="uploadImage" type="file"
					name="myPhoto" onchange="loadImageFile();" />
				<button type="button" id="showImage" onclick="myFunction()"
					class="btn btn-primary" style="margin-left: 144px;">Mostrar
					Imagem</button>
			</div>

			<div
				style="width: 622px; height: 302px; position: relative; background-color: #EEE;">
				<canvas id="myCanvas" width="470" height="300"
					style="border: 1px solid #d3d3d3; position: absolute; left: 0; top: 0; z-index: 0;">Your browser does not support the HTML5 canvas tag.</canvas>
				<canvas id="pixCanvas" width="150" height="150"
					style="border: 1px solid #d3d3d3; position: absolute; left: 470px; top: 0; z-index: 0;">Your browser does not support the HTML5 canvas tag.</canvas>

				<div id="barvadiv"
					style="border: 25px solid #d3d3d3; height: 100px; width: 102px; background-color: #d3d3d3; position: absolute; left: 470px; top: 152px; z-index: 0;"></div>
			</div>

			<div id="insertcolor" style="width: 612px; font-size: 14px;">
				<b>O Código da cor selecionada é: </b><input type="text"
					maxlength="7" id="templateColor" name="updateAgency.templateColor"
					style="font-size: 20px; width: 100px;" readonly
					class="form-control" />
			</div>

			<img id="slika"
				src="data:image/svg+xml,%3C%3Fxml%20version%3D%221.0%22%3F%3E%0A%3Csvg%20width%3D%22153%22%20height%3D%22153%22%20xmlns%3D%22http%3A//www.w3.org/2000/svg%22%3E%0A%20%3Cg%3E%0A%20%20%3Ctitle%3ENo%20image%3C/title%3E%0A%20%20%3Crect%20id%3D%22externRect%22%20height%3D%22150%22%20width%3D%22150%22%20y%3D%221.5%22%20x%3D%221.500024%22%20stroke-width%3D%223%22%20stroke%3D%22%23666666%22%20fill%3D%22%23e1e1e1%22/%3E%0A%20%20%3Ctext%20transform%3D%22matrix%286.66667%2C%200%2C%200%2C%206.66667%2C%20-960.5%2C%20-1099.33%29%22%20xml%3Aspace%3D%22preserve%22%20text-anchor%3D%22middle%22%20font-family%3D%22Fantasy%22%20font-size%3D%2214%22%20id%3D%22questionMark%22%20y%3D%22181.249569%22%20x%3D%22155.549819%22%20stroke-width%3D%220%22%20stroke%3D%22%23666666%22%20fill%3D%22%23000000%22%3E%3F%3C/text%3E%0A%20%3C/g%3E%0A%3C/svg%3E"
				alt="Image preview" style="display: none" />

		</section>

		<h3>MODELO</h3>

		<section>
			<header>
				<h1>Selecione o modelo de seu website a partir das imagens
					abaixo:</h1>
			</header>

			<div class="container">
				<div style="float: left; width: 120px;">
					<label for="template1"> <a
						href="javascript:window.open('http://www.freewebsitetemplates.com/preview/tourismsurfing/index.html','_blank');"
						target="_blank"><img
							src="${pageContext.request.contextPath}/resources/templates/thumbs/thumb2.png"
							width="80" height="80" style="margin-right: 25px;" /></a> <br />
						Tema Padrão Joocebox 1
					</label> <input id="template1" name="siteTemplate" value="1" type="radio"
						checked>

					<div style="float: left; width: 120px;">
						<label for="template2"> <a
							href="javascript:window.open('http://www.freewebsitetemplates.com/preview/tourismsurfing/index.html','_blank');"
							target="_blank"><img
								src="${pageContext.request.contextPath}/resources/templates/thumbs/thumb1.png"
								width="80" height="80" style="margin-right: 25px;" /></a> <br />
							Tema Padrão Joocebox 2
						</label> <input id="template2" name="siteTemplate" value="2" type="radio">
					</div>
				</div>

			</div>

			<p>Você poderá alterar o modelo escolhido depois, assim como ter
				acesso a mais opções.
		</section>
	</div>
</form>

<script>
	var ev = 0;
	var cnvHeight;
	var cnvWidth;
	var mousePos;
	var c;
	var ctx;
	var cPix;
	var ctxPix;
	var img;
	var imgHeight;
	var imgWidth;

			oFReader = new FileReader(),
			rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;

	oFReader.onload = function(oFREvent) {
		document.getElementById("slika").src = oFREvent.target.result;
	};

	function loadImageFile() {
		if (document.getElementById("uploadImage").files.length === 0) {
			return;
		}
		var oFile = document.getElementById("uploadImage").files[0];
		if (!rFilter.test(oFile.type)) {
			alert("Você Precisa selecionar um imagem!");
			return;
		}
		oFReader.readAsDataURL(oFile);

	}

	var onclickListener = function(evt) {
		imageData = ctxPix.getImageData(0, 0, 150, 150);
		var barva = '#' + d2h(imageData.data[45300 + 0])
				+ d2h(imageData.data[45300 + 1])
				+ d2h(imageData.data[45300 + 2]);
		document.getElementById("templateColor").value = barva;
		document.getElementById("templateColor").select();
		document.getElementById("barvadiv").style.backgroundColor = barva;
		istat = !istat;
	};

	function myFunction() {
		istat = true;
		cnvWidth = 470;
		cnvHeight = 300;

		c = document.getElementById("myCanvas");
		ctx = c.getContext("2d");

		cPix = document.getElementById("pixCanvas");
		ctxPix = cPix.getContext("2d");

		ctxPix.mozImageSmoothingEnabled = false;
		ctxPix.webkitImageSmoothingEnabled = false;

		img = document.getElementById("slika");
		imgHeight = img.height;
		imgWidth = img.width;

		if (imgHeight < cnvHeight && imgWidth < cnvWidth) {
			ctx.mozImageSmoothingEnabled = false;
			ctx.webkitImageSmoothingEnabled = false;
		}

		if ((imgWidth / imgHeight) < 1.56667) {
			cnvWidth = imgWidth / imgHeight * cnvHeight;
		} else {
			cnvHeight = cnvWidth / (imgWidth / imgHeight);
		}
		ctx.clearRect(0, 0, c.width, c.height);
		ctx.drawImage(img, 0, 0, cnvWidth, cnvHeight);

		var onmoveListener = function(evt) {
			ev = 1;
			if (istat) {
				mousePos = getMousePos(c, evt);
				drawPix(cPix, ctxPix, img, Math.round(mousePos.x
						* (imgWidth / cnvWidth)), Math.round(mousePos.y
						* (imgHeight / cnvHeight)));
			}
		};
		c.addEventListener('mousemove', onmoveListener, false);
		c.addEventListener('mousedown', onclickListener, false);

		var onMiniclickListener = function(evt) {
			mousePos = getMousePos(cPix, evt);
			imageData = ctxPix.getImageData(0, 0, 150, 150);
			var loc = Math.round(mousePos.y) * 600 + Math.round(mousePos.x) * 4;
			var barva = '#' + d2h(imageData.data[loc + 0])
					+ d2h(imageData.data[loc + 1])
					+ d2h(imageData.data[loc + 2]);
			document.getElementById("templateColor").value = barva;
			document.getElementById("templateColor").select();
			document.getElementById("barvadiv").style.backgroundColor = barva;
		};
		cPix.addEventListener('mousedown', onMiniclickListener, false);

	}

	function drawPix(cPix, ctxPix, img, x, y) {
		ctxPix.clearRect(0, 0, cPix.width, cPix.height);
		if (x < 5)
			x = 5;
		if (y < 5)
			y = 5;
		if (x > imgWidth - 4)
			x = imgWidth - 4;
		if (y > imgHeight - 4)
			y = imgHeight - 4;
		ctxPix
				.drawImage(img, x - 5, y - 5, 9, 9, 0, 0, cPix.width,
						cPix.height);
	}

	function getMousePos(canvas, evt) {
		var rect = canvas.getBoundingClientRect();
		return {
			x : evt.clientX - rect.left,
			y : evt.clientY - rect.top
		};
	}

	function d2h(d) {
		return ("0" + d.toString(16)).slice(-2).toUpperCase();
	}

	function greenbox(c, x, y) {
		c.beginPath();
		c.rect(x - 5, y - 5, 9, 9);
		c.lineWidth = 1;
		c.strokeStyle = '#00FF00';
		c.stroke();
	}
</script>

<style>
.form-control {
	background-color: #FFFFFF;
	background-image: none;
	border: 1px solid !important;
	border-radius: 4px;
	box-shadow: none !important;
	color: #9EA7B3 !important;
	font-size: 13px !important;
	height: 37px !important;
	padding: 0px 10px;
}

.form-control:focus {
	border-color: #45B6B0 !important;
	outline: 0;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
}
</style>