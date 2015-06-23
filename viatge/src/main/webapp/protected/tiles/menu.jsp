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
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/service" title="Novo Atendimento"><i class="entypo-doc-text"></i><span>Novo Atendimento</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/serviceList" title="Atendimentos em Aberto"><i class="entypo-doc-text"></i><span>Atendimentos em Aberto</span></a></li>                              
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Clientes"><i class="entypo-user"></i><span>Clientes</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/customer-list" title="Submenu 01"><i class="entypo-doc-text"></i><span>Lista de Clientes</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/customer" title="Submenu 02"><i class="entypo-newspaper"></i><span>Novo Cliente</span></a></li>
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Equipe"><i class="entypo-users"></i><span>Equipe</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/staff" title="Gerenciar Equipe"><i class="entypo-doc-text"></i><span>Gerenciar Equipe</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/goals" title="Gerenciar Metas"><i class="entypo-doc-text"></i><span>Gerenciar Metas</span></a></li>
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Destinos"><i class="entypo-globe"></i><span>Destinos</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/destination" title="Gerenciamento de Destinos"><i class="entypo-doc-text"></i><span>Gerenciar Destinos</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/category" title="Gerenciamento de Categorias"><i class="entypo-doc-text"></i><span>Gerenciar Categorias</span> </a></li>
                            </ul>
                        </li>
                        
                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="WebSite"><i class="entypo-monitor"></i><span>WebSite</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/template-list" title="Layout"><i class="entypo-doc-text"></i><span>Layout</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Cores"><i class="entypo-newspaper"></i><span>Cores</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="LogoMarca"><i class="entypo-newspaper"></i><span>LogoMarca</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Endereço e Contato"><i class="entypo-newspaper"></i><span>Endereço e Contato</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Página Quem Somos"><i class="entypo-newspaper"></i><span>Página Quem Somos</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/social-network" title="Redes Sociais"><i class="entypo-newspaper"></i><span>Redes Sociais</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Motores de Busca"><i class="entypo-newspaper"></i><span>Motores de Busca</span></a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="#" title="Dominios"><i class="entypo-newspaper"></i><span>Dominios</span></a></li>
                            </ul>
                        </li>

                        <li>
                            <a class="tooltip-tip ajax-load" href="#" title="Blog"><i class="entypo-globe"></i><span>Blog</span></a>
                            <ul>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/category-blog-list" title="Categorias"><i class="entypo-doc-text"></i><span>Categorias</span> </a></li>
                                <li><a class="tooltip-tip2 ajax-load" href="${pageContext.request.contextPath}/auth/article-blog-list" title="Artigos"><i class="entypo-doc-text"></i><span>Artigos</span> </a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    </div>
<!-- END OF SIDE MENU -->
