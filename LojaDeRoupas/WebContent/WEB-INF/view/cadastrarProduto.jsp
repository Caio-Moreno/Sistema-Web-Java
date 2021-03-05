<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp" %>
<head>

<script lang="text/javascript">
            
$(document).ready( function () {
	$('#valorCompra').mask("#.##0.00", {reverse: true});
	$('#valorVenda').mask("#.##0.00", {reverse: true});
});
</script>

<script lang="text/javascript">
window.onload = function () {
	  crear_select();
	};

	function isMobileDevice() {
	  return (
	    typeof window.orientation !== "undefined" ||
	    navigator.userAgent.indexOf("IEMobile") !== -1
	  );
	}

	var li = new Array();
	function crear_select() {
	  var div_cont_select = document.querySelectorAll(
	    "[data-mate-select='active']"
	  );
	  var select_ = "";
	  for (var e = 0; e < div_cont_select.length; e++) {
	    div_cont_select[e].setAttribute("data-indx-select", e);
	    div_cont_select[e].setAttribute("data-selec-open", "false");
	    var ul_cont = document.querySelectorAll(
	      "[data-indx-select='" + e + "'] > .cont_list_select_mate > ul"
	    );
	    select_ = document.querySelectorAll(
	      "[data-indx-select='" + e + "'] >select"
	    )[0];
	    if (isMobileDevice()) {
	      select_.addEventListener("change", function () {
	        _select_option(select_.selectedIndex, e);
	      });
	    }
	    var select_optiones = select_.options;
	    document
	      .querySelectorAll(
	        "[data-indx-select='" + e + "']  > .selecionado_opcion "
	      )[0]
	      .setAttribute("data-n-select", e);
	    document
	      .querySelectorAll(
	        "[data-indx-select='" + e + "']  > .icon_select_mate "
	      )[0]
	      .setAttribute("data-n-select", e);
	    for (var i = 0; i < select_optiones.length; i++) {
	      li[i] = document.createElement("li");
	      if (
	        select_optiones[i].selected == true ||
	        select_.value == select_optiones[i].innerHTML
	      ) {
	        li[i].className = "active";
	        document.querySelector(
	          "[data-indx-select='" + e + "']  > .selecionado_opcion "
	        ).innerHTML = select_optiones[i].innerHTML;
	      }
	      li[i].setAttribute("data-index", i);
	      li[i].setAttribute("data-selec-index", e);
	      // funcion click al selecionar
	      li[i].addEventListener("click", function () {
	        _select_option(
	          this.getAttribute("data-index"),
	          this.getAttribute("data-selec-index")
	        );
	      });

	      li[i].innerHTML = select_optiones[i].innerHTML;
	      ul_cont[0].appendChild(li[i]);
	    } // Fin For select_optiones
	  } // fin for divs_cont_select
	} // Fin Function

	var cont_slc = 0;
	function open_select(idx) {
	  var idx1 = idx.getAttribute("data-n-select");
	  var ul_cont_li = document.querySelectorAll(
	    "[data-indx-select='" + idx1 + "'] .cont_select_int > li"
	  );
	  var hg = 0;
	  var slect_open = document
	    .querySelectorAll("[data-indx-select='" + idx1 + "']")[0]
	    .getAttribute("data-selec-open");
	  var slect_element_open = document.querySelectorAll(
	    "[data-indx-select='" + idx1 + "'] select"
	  )[0];
	  if (isMobileDevice()) {
	    if (window.document.createEvent) {
	      // All
	      var evt = window.document.createEvent("MouseEvents");
	      evt.initMouseEvent(
	        "mousedown",
	        false,
	        true,
	        window,
	        0,
	        0,
	        0,
	        0,
	        0,
	        false,
	        false,
	        false,
	        false,
	        0,
	        null
	      );
	      slect_element_open.dispatchEvent(evt);
	    } else if (slect_element_open.fireEvent) {
	      // IE
	      slect_element_open.fireEvent("onmousedown");
	    } else {
	      slect_element_open.click();
	    }
	  } else {
	    for (var i = 0; i < ul_cont_li.length; i++) {
	      hg += ul_cont_li[i].offsetHeight;
	    }
	    if (slect_open == "false") {
	      document
	        .querySelectorAll("[data-indx-select='" + idx1 + "']")[0]
	        .setAttribute("data-selec-open", "true");
	      document.querySelectorAll(
	        "[data-indx-select='" + idx1 + "'] > .cont_list_select_mate > ul"
	      )[0].style.height = hg + "px";
	      document.querySelectorAll(
	        "[data-indx-select='" + idx1 + "'] > .icon_select_mate"
	      )[0].style.transform = "rotate(360deg)";
	    } else {
	      document
	        .querySelectorAll("[data-indx-select='" + idx1 + "']")[0]
	        .setAttribute("data-selec-open", "false");
	      document.querySelectorAll(
	        "[data-indx-select='" + idx1 + "'] > .icon_select_mate"
	      )[0].style.transform = "rotate(0deg)";
	      document.querySelectorAll(
	        "[data-indx-select='" + idx1 + "'] > .cont_list_select_mate > ul"
	      )[0].style.height = "0px";
	    }
	  }
	} // fin function open_select

	function salir_select(indx) {
	  var select_ = document.querySelectorAll(
	    "[data-indx-select='" + indx + "'] > select"
	  )[0];
	  document.querySelectorAll(
	    "[data-indx-select='" + indx + "'] > .cont_list_select_mate > ul"
	  )[0].style.height = "0px";
	  document.querySelector(
	    "[data-indx-select='" + indx + "'] > .icon_select_mate"
	  ).style.transform = "rotate(0deg)";
	  document
	    .querySelectorAll("[data-indx-select='" + indx + "']")[0]
	    .setAttribute("data-selec-open", "false");
	}

	function _select_option(indx, selc) {
	  if (isMobileDevice()) {
	    selc = selc - 1;
	  }
	  var select_ = document.querySelectorAll(
	    "[data-indx-select='" + selc + "'] > select"
	  )[0];

	  var li_s = document.querySelectorAll(
	    "[data-indx-select='" + selc + "'] .cont_select_int > li"
	  );
	  var p_act = (document.querySelectorAll(
	    "[data-indx-select='" + selc + "'] > .selecionado_opcion"
	  )[0].innerHTML = li_s[indx].innerHTML);
	  var select_optiones = document.querySelectorAll(
	    "[data-indx-select='" + selc + "'] > select > option"
	  );
	  for (var i = 0; i < li_s.length; i++) {
	    if (li_s[i].className == "active") {
	      li_s[i].className = "";
	    }
	    li_s[indx].className = "active";
	  }
	  select_optiones[indx].selected = true;
	  select_.selectedIndex = indx;
	  select_.onchange();
	  salir_select(selc);
	}


</script>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/select.css">

<title>Cadastrar produto</title>
</head>
<body>
<div class="container">
	<c:if test="${empty action}">
  <form action= "/LojaDeRoupas/entrada?acao=ProdutoCadastrar" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="nome">Nome</label>
      <input type="text" class="form-control" id="nome" name="nome" required="required" placeholder="Ex: Boné Brasil, Camiseta New Era">
    </div>
   <div class="form-group col-md-6">
    <label for="tipoProduto">Tipo</label>
    <div class="select_mate" data-mate-select="active">
	<select onchange="" onclick="return false;" name="tipoProduto">
  	<option value="Calca">Calça</option>
  	<option value="Camiseta">Camiseta</option>
  	<option value="Bone">Boné</option>
  	<option value="Shorts">Shorts</option>
	</select>
	<p class="selecionado_opcion"  onclick="open_select(this)" ></p><span onclick="open_select(this)" class="icon_select_mate" style="margin-top: -18px; transform: rotate(360deg);">
	<svg fill="#000000" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg" style="margin-top:7px; ">
    <path d="M7.41 7.84L12 12.42l4.59-4.58L18 9.25l-6 6-6-6z"/>
    <path d="M0-.75h24v24H0z" fill="none"/>
	</svg>
	</span>
	<div class="cont_list_select_mate">
  	<ul class="cont_select_int">  </ul> 
	</div>
  	</div>
    </div>
  </div>
  <div class="form-row">
  	<div class="form-group col-md-6">
    <label for="quantidade">Quantidade</label>
    <input type="number" class="form-control" id="quantidade" name="quantidade" value="${produto._quantidade}" required="required">
    </div>
    <div class="form-group col-md-6">
    <label for="codFilial">Filial</label>
    <div class="select_mate" data-mate-select="active">
	<select onchange="" onclick="return false;" name="codFilial">
	<c:forEach items="${filial}" var="filial">
          <option value="${filial.codfilial}">${filial.estado}</option>
    </c:forEach>
  	</select>
	<p class="selecionado_opcion"  onclick="open_select(this)" ></p><span onclick="open_select(this)" class="icon_select_mate" style="margin-top: -18px; transform: rotate(360deg);">
	<svg fill="#000000" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg" style="margin-top:7px; ">
    <path d="M7.41 7.84L12 12.42l4.59-4.58L18 9.25l-6 6-6-6z"/>
    <path d="M0-.75h24v24H0z" fill="none"/>
	</svg>
	
	</span>
	<div class="cont_list_select_mate">
  	<ul class="cont_select_int">  </ul> 
	</div>
  	</div>
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="valorCompra">Valor compra</label>
      <input type="text" class="form-control" id="valorCompra" name="valorCompra">
    </div>
    <div class="form-group col-md-6">
      <label for="valorVenda">Valor venda</label>
      <input type="text" class="form-control" id="valorVenda" name="valorVenda">
    </div>
  </div>

   <button type="submit" class="btn btn-primary">OK</button>
</form>
</c:if>
	
<c:if test="${not empty action}">
	<form action= "/LojaDeRoupas/entrada?acao=ProdutoAlterar&metodo=post" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="nome">Nome</label>
      <input type="text" class="form-control" id="nome" name="nome" required="required" value="${produto._nome}" placeholder="Ex: Boné Brasil, Camiseta New Era">
    </div>
    <div class="form-group col-md-6">
    <label for="tipoProduto">Tipo</label>
    <div class="select_mate" data-mate-select="active">
	<select onchange="" onclick="return false;" name="tipoProduto">
  	<option value="Calca">Calça</option>
  	<option value="Camiseta">Camiseta</option>
  	<option value="Bone">Boné</option>
  	<option value="Shorts">Shorts</option>
	</select>
	<p class="selecionado_opcion"  onclick="open_select(this)" ></p><span onclick="open_select(this)" class="icon_select_mate" style="margin-top: -18px; transform: rotate(360deg);">
	<svg fill="#000000" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg" style="margin-top:7px; ">
    <path d="M7.41 7.84L12 12.42l4.59-4.58L18 9.25l-6 6-6-6z"/>
    <path d="M0-.75h24v24H0z" fill="none"/>
	</svg>
	</span>
	<div class="cont_list_select_mate">
  	<ul class="cont_select_int">  </ul> 
	</div>
  	</div>
    </div>
  </div>
  <div class="form-row">
  	<div class="form-group col-md-6">
    <label for="quantidade">Quantidade</label>
    <input type="number" class="form-control" id="quantidade" name="quantidade" value="${produto._quantidade}" required="required">
    </div>
    <div class="form-group col-md-6">
    <label for="codFilial">Filial</label>
    <div class="select_mate" data-mate-select="active">
	<select onchange="" onclick="return false;" name="codFilial">
	<c:forEach items="${filial}" var="filial">
          <option value="${filial.codfilial}">${filial.estado}</option>
    </c:forEach>
  	</select>
	<p class="selecionado_opcion"  onclick="open_select(this)" ></p><span onclick="open_select(this)" class="icon_select_mate" style="margin-top: -18px; transform: rotate(360deg);">
	
	<svg fill="#000000" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg" style="margin-top:7px; ">
    <path d="M7.41 7.84L12 12.42l4.59-4.58L18 9.25l-6 6-6-6z"/>
    <path d="M0-.75h24v24H0z" fill="none"/>
	</svg>
	
	</span>
	<div class="cont_list_select_mate">
  	<ul class="cont_select_int">  </ul> 
	</div>
  	</div>
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="valorCompra">Valor compra</label>
      <input type="text" class="form-control" id="valorCompra" name="valorCompra" required="required" value="${produto._valorCompra}">
    </div>
    <div class="form-group col-md-6">
      <label for="valorVenda">Valor venda</label>
      <input type="text" class="form-control" id="valorVenda" name="valorVenda" required="required" value="${produto._valorVenda}">
    </div>
  </div>
	<input type="hidden" id="codProduto" name="codProduto" value="${produto._codProduto}">
   <button type="submit" class="btn btn-primary">OK</button>
</form>
</c:if>

</div>
	
</body>
</html>