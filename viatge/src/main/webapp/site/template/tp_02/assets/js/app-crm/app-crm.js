/**
 * Comportamento JS do Site de Cliente
 */
(function($) {
	$(function() {

	    var dialog, form,
	    
	      // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
	      emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
	      name = $( "#name" ),
	      email = $( "#email" ),
	      allFields = $( [] ).add( name ).add( email ),
	      tips = $( ".validateTips" );
	 
	    function updateTips( t ) {
	      tips
	        .text( t )
	        .addClass( "ui-state-highlight" );
	      setTimeout(function() {
	        tips.removeClass( "ui-state-highlight", 1500 );
	      }, 500 );
	    }
	 
	    function checkLength( o, n, min, max ) {
	      if ( o.val().length > max || o.val().length < min ) {
	        o.addClass( "ui-state-error" );
	        updateTips( "O Comprimento do campo " + n + " precisar ser maior " +
	          min + " e menor que  " + max + "." );
	        return false;
	      } else {
	        return true;
	      }
	    }
	 
	    function checkRegexp( o, regexp, n ) {
	      if ( !( regexp.test( o.val() ) ) ) {
	        o.addClass( "ui-state-error" );
	        updateTips( n );
	        return false;
	      } else {
	        return true;
	      }
	    }
	    
	    function callAJAX(name, email){
            $.ajax({
                type: "GET",
                url: "/viatge/add-new-customer",
                data:{ name: $(name).val(), email: $(email).val()},
                success: function (response) {
                	perfectDestinationFilter();
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert(thrownError);
                }
            });
	    }
	    
	    function perfectDestinationFilter(){
	    	$("#form-filter-perfect-travel").submit();
	    }
	    
	    function getCookie(c_name) {
	        if (document.cookie.length > 0) {
	            c_start = document.cookie.indexOf(c_name + "=");
	            if (c_start != -1) {
	                c_start = c_start + c_name.length + 1;
	                c_end = document.cookie.indexOf(";", c_start);
	                if (c_end == -1) {
	                    c_end = document.cookie.length;
	                }
	                return unescape(document.cookie.substring(c_start, c_end));
	            }
	        }
	        return "";
	    }
	    
	    var createCookie = function(name, value, days) {
	        var expires;
	        if (days) {
	            var date = new Date();
	            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	            expires = "; expires=" + date.toGMTString();
	        }
	        else {
	            expires = "";
	        }
	        document.cookie = name + "=" + value + expires + "; path=/";
	    }
	    
	    function verifyCookie(){
		      if (getCookie("jb_client_name") && getCookie("jb_client_email")) {	          
		    	  perfectDestinationFilter();
		      }else{
		    	  dialog.dialog( "open" );	    	  
		      }
	    }
	 
	    function addUser() {
	      var valid = true;
	      allFields.removeClass( "ui-state-error" );
	 
	      valid = valid && checkLength( name, "Nome", 3, 16 );
	      valid = valid && checkLength( email, "email", 6, 80 );
	 
	      valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "O nome deve conter apenas caracteres alfanumericos" );
	      valid = valid && checkRegexp( email, emailRegex, "Insira um e-mail valido Ex. fulano@joocebox.com" );
	      
	      if(valid && (!getCookie("jb_client_name") && !getCookie("jb_client_email"))){
	          callAJAX(name, email);
	          dialog.dialog( "close" );
	      }else{	    		 
		      return valid;
	      }

	    }
	 
	    dialog = $( "#dialog-form" ).dialog({
	      autoOpen: false,
	      height: 300,
	      width: 300,
	      modal: true,
	      resizable: false,
	      buttons: {
	        "Ver Destinos": addUser,
	        "Cancelar": function() {
	          dialog.dialog( "close" );
	        }
	      },
	      close: function() {
	        form[ 0 ].reset();
	        allFields.removeClass( "ui-state-error" );
	      }
	    });
	 
	    form = dialog.find( "form" ).on( "submit", function( event ) {
	      event.preventDefault();
	      addUser();
	    });

	    $( "#show-modal" ).click(function() {
	    	verifyCookie();
	    });
	    
	    $('#show-modal-perfect').click(function() {
	    	verifyCookie();
	    });
	  });

})(jQuery);