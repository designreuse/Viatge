/**
 * Comportamento JS da pagina da funcionalidade de Staff
 */
(function($) {
	$(function() {

		$("#employee-goal-jan").maskMoney();
		$('#employee-goal-feb').maskMoney();
		$('#employee-goal-mar').maskMoney();
		$('#employee-goal-abr').maskMoney();
		$('#employee-goal-maio').maskMoney();
		$('#employee-goal-jun').maskMoney();
		$('#employee-goal-jul').maskMoney();
		$('#employee-goal-ago').maskMoney();
		$('#employee-goal-set').maskMoney();
		$('#employee-goal-out').maskMoney();
		$('#employee-goal-nov').maskMoney();
		$('#employee-goal-dec').maskMoney();
		
		$("#employee-workPhone").mask("(99) 9999-9999");
		$("#employee-celPhone").mask("(99) 9999-9999");
		$("#employee-homePhone").mask("(99) 9999-9999");
		
		$("#employee-birthDate").mask("99/99/9999");
		
		
		$('#fileupload').fileupload({
			url: $('#ajax-url').val(),
			add: function(e, data) {
		        var uploadErrors = [];
		        var acceptFileTypes = /^image\/(jpe?g)$/i;
		        if(data.originalFiles[0]['type'].length && !acceptFileTypes.test(data.originalFiles[0]['type'])) {
		            uploadErrors.push('Arquivo não suportado! Selecione uma imagem do tipo *.jpg');
		        }
		        if(data.originalFiles[0]['size'].length && data.originalFiles[0]['size'] > 5000000) {
		            uploadErrors.push('Arquivo muito grande!');
		        }
		        if(uploadErrors.length > 0) {
		            alert(uploadErrors.join("\n"));
		        } else {
		            data.submit();
		        }
			},
			done: function (e, data){			
				$('#avatar-img').attr('src', data._response.result);
			}
		});

		var form = $("#employeeForm");
	    form.validate({
	        errorPlacement: function errorPlacement(error, element) { element.before(error); },
	        rules: {
	        	confirm: {
	                equalTo: "#password"
	            }
	        },
	        messages: {
	        	confirm :"Entre com a mesma Senha!"
	          }
	    });
	    
	    $('#employee-goal').change(function() {
	        $.get($('#ajax-goal-url').val(), {empID: $(this).val()}, function(data) {
	    		$("#employee-goal-jan").val(data.january);
	    		$('#employee-goal-feb').val(data.february);
	    		$('#employee-goal-mar').val(data.march);
	    		$('#employee-goal-abr').val(data.april);
	    		$('#employee-goal-maio').val(data.may);
	    		$('#employee-goal-jun').val(data.june);
	    		$('#employee-goal-jul').val(data.july);
	    		$('#employee-goal-ago').val(data.august);
	    		$('#employee-goal-set').val(data.september);
	    		$('#employee-goal-out').val(data.october);
	    		$('#employee-goal-nov').val(data.november);
	    		$('#employee-goal-dec').val(data.december);
	        }).fail(function() {
	            alert("Ocorreu um erro, tente novamente mais tarde.");
	        });
	    });

	   
	});
})(jQuery);