$(document).ready(function() {
	var winH = $(window).height();
	var winW = $(window).width();
	
	$('.gatilho-menu').click( function(event){
		event.preventDefault();
		$('menu').slideToggle(1000);
	});
	
	//TOOLTIP DE ICONES
	$('.item ul li a').tooltipster({
	   animation: 'fade',
	   delay: 200,
	   theme: 'tooltipster-default',
	   touchDevices: false,
	   trigger: 'hover',
	   position: 'bottom'
	});
	
	//CAROUSEL DESTAQUES
	$('.list-destaques').owlCarousel({
		loop:true,
		margin:50,
		responsiveClass:true,
		responsive:{
			0:{
				items:1,
				nav:true
			},
			960:{
				items:2,
				nav:true,
			}
		}
	});
	
	//NAV MIDIA DESTINO
	 $('.midia-destino').cycle({
        fx:     'fade',
        speed:  'fast',
        timeout: 0,
        pager:  '.nav-midia',
        pagerAnchorBuilder: function(idx, slide) {
            return '.nav-midia li:eq(' + (idx) + ') a';
        },
    });
	
	//CAROUSEL FOTOS DESTINOS
	$('.midia-destino .fotos').owlCarousel({
		loop:true,
		margin:0,
		responsiveClass:true,
		responsive:{
			0:{
				items:1,
				nav:true
			}
		}
	});
	
	// SELECIONAR DATA DE VIAGEM
	$("#ida, #entrada").datepicker({
		minDate: 0,
		maxDate:365,
		numberOfMonths: 2,
		
		onSelect: function(selected) {
			var d1 = $(this).datepicker("getDate");
			d1.setDate(d1.getDate() + 0);
			var d2 = $(this).datepicker("getDate");
			d2.setDate(d2.getDate() + 30); 
			$("#volta, #saida").datepicker("setDate", null);
			$("#volta, #saida").datepicker("option", "minDate", d1);
			$("#volta, #saida").datepicker("option", "maxDate", d2);
		},
		
		dateFormat: 'dd/mm/yy',
		dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		nextText: 'Próximo',
		prevText: 'Anterior'
	});
	
	$("#volta, #saida").datepicker({ 
		minDate: 0,
		maxDate:365,
		numberOfMonths: 2,
		onSelect: function(selected) {
		  $("#volta, #saida").datepicker("option","minDate", selected)
		},
		dateFormat: 'dd/mm/yy',
		dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		nextText: 'Próximo',
		prevText: 'Anterior'
	}); 
	
	//NAV MIDIA DESTINO
	 $('.forms-compra').cycle({
        fx:     'none',
        speed:  'fast',
        timeout: 0,
        pager:  '.categoria-compra',
        pagerAnchorBuilder: function(idx, slide) {
            return '.categoria-compra li:eq(' + (idx) + ') a';
        },
    });
	
	//ADD ACOMPANHANTE VIAGEM
	var max_fields      = 10;
	var wrapper         = $(".gerarAcompanhante");
	var add_button      = $(".addPessoa");
	
	var x = 1;
	$(add_button).click(function(e){
		e.preventDefault();
		if(x < max_fields){
			x++;
			$(wrapper).append('<div class="dadosPessoa"><div class="box-03"><label for="vinculo">*Vínculo</label><select name="vinculo" id="vinculo" class="select01"><option value="PARTNER">Cônjuge</option><option value="CHILDREN">Filho(a)</option><option value="DATE">Namorado(a)</option><option value="FRIEND">Amigo(a)</option><option value="PARENTS">Pai e/ou Mãe</option><option value="SIBLINGS">Irmão e/ou Irmã</option><option value="OTHER_PARENTS">Outros (Parentes)</option><option value="OTHER">Outros</option></select></div><div class="box-03"><label for="acompanhante">*Nome</label><input type="text" name="acompanhante[]" id="acompanhante" class="input01"></div><div class="box-04"><label for="idade">Idade</label><input type="text" name="idade[]" id="idade" class="input01" onkeypress="return SomenteNumero(event)"></div><a href="#" class="removarPessoa">Remover</a></div>');
		}
	});
	
	$(wrapper).on("click",".removarPessoa", function(e){
		e.preventDefault(); $(this).parent('div').remove(); x--;
	})
		
	//SELECT STYLE
	$('.select01').customSelect();
	
	//MASCARAS
	$("#telefone").mask("(99) 9999-9999?9");
	$("#celular").mask("(99) 9999-9999?9");
	
	// INPUT FILE
	$(".file").change(function() {
		$(this).prev().html($(this).val());
	});
	
	// VALIDAÇÃO DE CONTATO
	$('.form-contato').validate({
		rules:{
			nome:{
				required: true,
				minlength: 3
			},
			email:{
				required: true,
      			email: true
			},
			telefone:{
				required: true
			},
			estado:{
				required: true
			},
			cidade:{
				required: true
			},
			endereco:{
				required: true
			},
			mensagem:{
				required: true,
				minlength: 10
			}
		},
		messages:{
			nome:{
				required: "O campo nome é obrigatorio.",
				minlength: "O campo nome deve conter no mínimo 3 caracteres."
			},
			email:{
				required: "O campo e-mail é obrigatorio.",
				email: "E-mail inválido."
			},
			telefone:{
				required: "O campo de telefone é obrigatorio."
			},
			estado:{
				required: "O campo de estado é obrigatorio."
			},
			cidade:{
				required: "O campo de cidade é obrigatorio."
			},
			endereco:{
				required: "O campo de cidade é obrigatorio."
			},
			mensagem:{
				required: "O campo de mensagem é obrigatorio.",
				minlength: "O campo de mensagem deve conter no mínimo 10 caracteres."
			}
		}
 
	});
	
	// VALIDAÇÃO DE ORÇAMENTO
	$('.form-orcamento').validate({
		rules:{
			nome:{
				required: true
			},
			sobrenome:{
				required: true
			},
			email:{
				required: true,
      			email: true,
			},
			conf_email:{
				required: true,
      			email: true,
				equalTo: "#email"
			},
			telefone:{
				required: true
			},
			destino:{
				required: true
			}
		},
		messages:{
			nome:{
				required: "O campo nome é obrigatorio.",
			},
			sobrenome:{
				required: "O campo sobrenome é obrigatorio.",
			},
			email:{
				required: "O campo e-mail é obrigatorio.",
				email: "E-mail inválido."
			},
			conf_email:{
				required: "O campo e-mail é obrigatorio.",
				email: "E-mail inválido.",
				equalTo: "O campo confirmação de e-mail deve ser identico ao campo e-mail."
			},
			telefone:{
				required: "O campo de telefone é obrigatorio."
			},
			destino:{
				required: "O campo de destino é obrigatorio."
			}
		}
 
	});
	
	// VALIDAÇÃO DE ORÇAMENTO
	$('.newsletter').validate({
		rules:{
			email:{
				required: true,
      			email: true,
			}
		},
		messages:{
			email:{
				required: "O campo e-mail é obrigatorio.",
				email: "E-mail inválido."
			}
		}
	});
	
	$('footer .form-newsletter').validate({
		rules:{
			email:{
				required: true,
      			email: true,
			}
		},
		messages:{
			email:{
				required: "O campo e-mail é obrigatorio.",
				email: "E-mail inválido."
			}
		}
	});
	
});
