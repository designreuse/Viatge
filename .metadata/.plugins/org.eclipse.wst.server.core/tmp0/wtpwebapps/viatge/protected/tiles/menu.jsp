<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- SIDE MENU -->
    <div id="skin-select">
        <div id="logo">
            <h1>JooceBox <span>v1.0</span></h1>
        </div>

        <a id="toggle"><span class="entypo-menu"></span></a>
        <div class="dark">
            <form action="#">
                <span>
                    <input type="text" name="search" value="" id="id_search" class="search rounded" placeholder="Buscar no Menu..." autofocus />
                </span>
            </form>
        </div>
        <div class="skin-part">
            <div id="tree-wrap">
                <div class="side-bar">
                
                    <ul class="topnav menu-left-nest">
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Atendimentos"><i class="entypo-vcard"></i><span>Atendimentos</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="<c:url value="service"/>" title="Novo Atendimento"><i class="entypo-doc-text"></i><span>Novo Atendimento</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="<c:url value="serviceList"/>" title="Atendimentos em Aberto"><i class="entypo-doc-text"></i><span>Atendimentos em Aberto</span></a></li>                              
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Clientes"><i class="entypo-user"></i><span>Clientes</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Submenu 01"><i class="entypo-doc-text"></i><span>Submenu 01</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Submenu 02"><i class="entypo-newspaper"></i><span>Submenu 02</span></a></li>
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Equipe"><i class="entypo-users"></i><span>Equipe</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="<c:url value="/staff"/>" title="Gerenciar Equipe"><i class="entypo-doc-text"></i><span>Gerenciar Equipe</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Vendas Realizadas"><i class="entypo-newspaper"></i><span>Vendas Realizadas</span></a></li>
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Destinos"><i class="entypo-globe"></i><span>Destinos</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="<c:url value="destination"/>" title="Gerenciamento de Destinos"><i class="entypo-doc-text"></i><span>Gerenciar Destinos</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="<c:url value="category"/>" title="Gerenciamento de Categorias"><i class="entypo-doc-text"></i><span>Gerenciar Categorias</span> </a></li>
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="WebSite"><i class="entypo-monitor"></i><span>WebSite</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Submenu 01"><i class="entypo-doc-text"></i><span>Submenu 01</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Submenu 02"><i class="entypo-newspaper"></i><span>Submenu 02</span></a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    </div>
<!-- END OF SIDE MENU -->