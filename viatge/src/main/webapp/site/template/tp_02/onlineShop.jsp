<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section id="compra">
	
    <div class="container">
    	
        <h1>Compra On-line</h1>    
		
        <div class="coluna-1">
        
            <ul class="categoria-compra">
                <li class="hoteis bg-thema"><a href="#"><i></i><span>Hoteis</span></a></li>
                <li class="passagens bg-thema"><a href="#"><i></i><span>Passagens</span></a></li>
            </ul>
            
            <div class="forms-compra">
                
                <!-- FORM HOTEIS --> 
                <form action="#" method="post" name="form-compra" class="form-compra border-thema">
                    <p>Preencha os campos abaixo, nós lhe mostraremos os melhores preços e os horários de vôos das melhores companhias aéreas, depois é só escolher o melhor para você.</p>
                    
                    <div class="box-1">
                      <label for="destino">Destino</label>
                      <input type="text" class="input01" name="destino" id="destino">
                    </div>
                    
                    <div class="box-2 data">
                      <label for="entrada">Entrada</label>
                      <input type="text" class="input01" name="entrada data" id="entrada" placeholder="99/99/9999">
                    </div>
                    
                    <div class="box-3 data">
                      <label for="saida">Saída</label>
                      <input type="text" class="input01" name="saida data" id="saida" placeholder="99/99/9999">
                    </div>
                    
                    <h2>Quantidade de passageiros:</h2>
                    
                    <div class="qrt-hoteis">
                    	<div class="select-quartos">
                        	<label for="quartos">Quantidade<br> de quartos:</label>
                            <select class="select01" name="quartos" id="quartos">
                            	<option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                            </select>
                        </div>
                        
                        <div class="select-adultos">
                        	<label for="adultos">Adultos: <small>(+12 anos)</small></label>
                            <select class="select01" name="adultos" id="adultos">
                            	<option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                            </select>
                        </div>
                        
                        <div class="select-criancas">
                        	<label for="criancas">Crianças: <small>(2 a 11 anos)</small></label>
                            <select class="select01" name="criancas" id="criancas">
                            	<option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </div>
                        
                    </div>
                    
                    <div class="box-1">
                    	<button type="submit" name="enviar" class="submit01 bg-thema"><i></i> Buscar</button>
                    </div>
                    
                </form>
                
                <!-- FORM PASSAGENS --> 
                <form action="#" method="post" name="form-compra" class="form-compra border-thema">
                    <p>Preencha os campos abaixo, nós lhe mostraremos os melhores preços e os horários de vôos das melhores companhias aéreas, depois é só escolher o melhor para você.</p>
                    <div>
                        <label class="label-radio"><input name="n-passagem" type="radio" value="2" checked> <span>Ida e Volta</span></label>
                        <label class="label-radio"><input name="n-passagem" type="radio" value="1" checked> <span>Ida</span></label>
                    </div>
                    
                    <div class="box-2">
                      <label for="origem">Origem</label>
                      <input type="text" class="input01" name="origem" id="origem">
                    </div>
                    
                    <div class="box-3 data">
                      <label for="ida">Ida</label>
                      <input type="text" class="input01 data" name="ida" id="ida">
                    </div>
                    
                    <div class="box-2">
                      <label for="destino">Destino</label>
                      <input type="text" class="input01" name="destino" id="destino">
                    </div>
                    
                    <div class="box-3 data">
                      <label for="volta">volta</label>
                      <input type="text" class="input01" name="volta" id="volta">
                    </div>
                    
                    <h2>Quantidade de passageiros:</h2>
                    
                    <div class="qrt-passagens">
                    	<div class="select-adultos">
                        	<label for="adultos">Adultos: <small>(+12 anos)</small></label>
                            <select class="select01" name="adultos" id="adultos">
                            	<option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                            </select>
                        </div>
                        
                        <div class="select-criancas">
                        	<label for="criancas">Crianças: <small>(2 a 11 anos)</small></label>
                            <select class="select01" name="criancas" id="criancas">
                            	<option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </div>
                        
                        <div class="select-bebes">
                        	<label for="bebes">Bebês: <small>(0 a 23 meses)</small></label>
                            <select class="select01" name="bebes" id="bebes">
                            	<option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="box-1">
                    	<button type="submit" name="enviar" class="submit01 bg-thema"><i></i> Buscar</button>
                    </div>
                </form>
                
            </div>
		
        </div>
        
        <div class="coluna-2">
        	<h2>Entre em contato</h2>
            <p>E vivencie as melhores experiências de viagem da sua vida.</p>
            <p class="telefone txt-thema"><small>(43)</small> 6598-8458</p>
            <p class="email"><a href="mailto:contato@seusiteaqui.com.br">contato@seusiteaqui.com.br</a></p>
        </div>
        
    </div>    

	<!-- AUTO COMPLETAR DE DESTINO -->
	<script>
	  $(function() {
		var availableTags = [
		  "Acre (AC)",
		  "Alagoas (AL)",
		  "Amapá (AP)",
		  "Amazonas (AM)",
		  "Bahia (BA)",
		  "Ceará (CE)",
		  "Distrito Federal (DF)",
		  "Espírito Santo (ES)",
		  "Goiás (GO)",
		  "Maranhão (MA)",
		  "Mato Grosso (MT)",
		  "Mato Grosso do Sul (MS)",
		  "Minas Gerais (MG)",
		  "Pará (PA)",
		  "Paraíba (PB)",
		  "Paraná (PR)",
		  "Pernambuco (PE)",
		  "Piauí (PI)",
		  "Rio de Janeiro (RJ)",
		  "Rio Grande do Norte (RN)",
		  "Rio Grande do Sul (RS)",
		  "Rondônia (RO)",
		  "Roraima (RR)",
		  "Santa Catarina (SC)",
		  "São Paulo (SP)",
		  "Sergipe (SE)",
		  "Tocantins (TO)"
		];
		$( "#destino, #origem" ).autocomplete({
		  source: availableTags
		});
	  });
	</script>    
</section>