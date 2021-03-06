/**
 * Script jQuery para mudança do tema com base em parametro em BD
 */
( function($) {
	$(function() {
		$.get( "/viatge/templateColorCodHex", function( data ) {
			$('.bg-thema').css('background-color', data);
			$('.txt-thema').css('color', data);
			$('.border-thema').css('border-color', data);
			$('.hover-txt-thema').hover(function(){
				var $this = $(this);
				$this.data('color', $this.css('color')).css('color', data);
				
			},
			function(){
				var $this = $(this);
			    $this.css('color', $this.css('color')).css('color', '#969696');
			});
		});
		
	});
})(jQuery);