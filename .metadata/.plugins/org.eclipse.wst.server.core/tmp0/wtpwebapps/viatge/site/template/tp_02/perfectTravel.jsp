<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="filtro">
	
    <div class="container">
        
        <h1>Viagem Perfeita</h1>
        
        <div class="passo-filtro txt-thema">
        
            <h2>Como utilizar o destino perfeito</h2>
            
            <ul>
                <li><span class="border-thema">1</span> <p>Selecione abaixo as opções que mais combinam com você!</p></li>
                <li><span class="border-thema">2</span> <p>Aperte o botão ok! Buscaremos os destinos perfeitos para sua férias!</p></li>
                <li><span class="border-thema">3</span> <p>Navegue pelos destinos sugeridos, escolha o que mais gostar e entre em contato conosco!</p></li>
            </ul>
        
        </div>
        
        <div class="filtro">
            <h2 class="bg-thema">ENCONTRAR DESTINO PERFEITO.</h2>
    		
            <!-- FILTRO DE DESTINO -->
            
            <form action="?alert=resposta" method="post" name="form-filtro" class="form-filtro">
                <div class="box-select">
                    <label>VIAJO COM (SOU)</label>
                    <select class="select01" name="viajo">
                        <option value="">Selecionar...</option>
                        <option value="Opção 01">Opção 01</option>
                        <option value="Opção 02">Opção 02</option>
                        <option value="Opção 03">Opção 03</option>
                        <option value="Opção 04">Opção 04</option>
                    </select> 
                </div>
                
                <div class="box-select">
                    <label>PROCURO POR</label>
                    <select class="select01" name="procuro">
                        <option value="">Selecionar...</option>
                        <option value="Opção 01">Opção 01</option>
                        <option value="Opção 02">Opção 02</option>
                        <option value="Opção 03">Opção 03</option>
                        <option value="Opção 04">Opção 04</option>
                    </select> 
                </div>
                
                <div class="box-select">
                    <label>QUERO</label>
                    <select class="select01" name="quero">
                        <option value="">Selecionar...</option>
                        <option value="Opção 01">Opção 01</option>
                        <option value="Opção 02">Opção 02</option>
                        <option value="Opção 03">Opção 03</option>
                        <option value="Opção 04">Opção 04</option>
                    </select> 
                </div>
                
                <div class="box-select">
                    <label>PREFIRO</label>
                    <select class="select01" name="prefiro">
                        <option value="">Selecionar...</option>
                        <option value="Opção 01">Opção 01</option>
                        <option value="Opção 02">Opção 02</option>
                        <option value="Opção 03">Opção 03</option>
                        <option value="Opção 04">Opção 04</option>
                    </select> 
                </div>
                
                <div class="box-select">
                    <label>ADORO</label>
                    <select class="select01" name="adoro">
                        <option value="">Selecionar...</option>
                        <option value="Opção 01">Opção 01</option>
                        <option value="Opção 02">Opção 02</option>
                        <option value="Opção 03">Opção 03</option>
                        <option value="Opção 04">Opção 04</option>
                    </select> 
                </div>
                
                <div class="box-botton">
                    <button type="submit" class="button01 bg-thema"><i></i> REALIZAR BUSCA</button>
                </div>
            </form>
            
            <!-- FIM FILTRO DE DESTINO -->
            
        </div>
        
        <div class="txt-destino-perfeito txt-thema">
            <p>A (Nome da Agência) é diferente porque é personalizada...</p>
            <p>Existe uma viagem PERFEITA para cada pessoa!</p>
            <p>Qual será a sua?</p>
        </div>
        
    </div>
    
</section>