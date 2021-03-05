<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="Jquery/jquery-3.5.1.min.js" ></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<link href="css/cartao.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/imask/3.4.0/imask.min.js"></script>
<script src="js/cartao.js"></script>
<title>Brazucas Technology</title>


</head>

<script>
var verifica = false;

var verificaMoney = false;

$(document).ready(function() {
	
   $("#creditCard").hide();
   $("#adicionarMoney").hide();
   
   
  
});


function adicionarCreditCard(){
	
	   if(verifica){
     		$("#creditCard").hide(500);
     verifica = false;
	   }else {
		   $("#adicionarMoney").hide();
       		$("#creditCard").show(500);
       		verifica = true;
	   }
   }
   
function adicionarMoney(){
	  if(verificaMoney){
		     $("#adicionarMoney").hide(500);
		     verificaMoney = false;
			   }else {
				   $("#creditCard").hide();
		       $("#adicionarMoney").show(500);
		       verificaMoney = true;
			   }
}

function buscaCliente(){
	var cpf = document.getElementById('cpf').value;
	$.get("/LojaDeRoupas/ClienteBusca?cpf="+cpf, function resposta( resposta ){
		
		var split = resposta.split(';');
		document.getElementById('nome').innerHTML = split[0];
		document.getElementById('id').value = split[1];
		
		
	});
	
}

function calculaDesconto(){
	var valorDesconto = document.getElementById('percentDesconto').value;
	var total =  document.getElementById('valor_Total').value;
	
	
	
	if(valorDesconto == 3){
		descontar = total * 0.03; 
		total = total - descontar;
		total = parseFloat(total.toFixed(2));
		document.getElementById('desconto').value = descontar;
		document.getElementById('valor_Total').value = total;
		return;
	}
	if(valorDesconto == 5){
		descontar = total * 0.05; 
		total = total - descontar;
		total = parseFloat(total.toFixed(2));
		document.getElementById('desconto').value = descontar;
		document.getElementById('valor_Total').value = total;
		return;
	}
	if(valorDesconto == 10){
		descontar = total * 0.10; 
		total = total - descontar;
		total = parseFloat(total.toFixed(2));
		document.getElementById('desconto').value = descontar;
		document.getElementById('valor_Total').value = total;
		return;
	}
	if(valorDesconto == 15){
		descontar = total * 0.15; 
		total = total - descontar;
		total = parseFloat(total.toFixed(2));
		document.getElementById('desconto').value = descontar;
		document.getElementById('valor_Total').value = total;
		return;
	}
	
}

function calcularTroco(){
	console.log('entrei')
	var total =  document.getElementById('valor_Total').value;
	var recebido =document.getElementById('totalRecebido').value;
	var troco = recebido - total;
	troco = parseFloat(troco.toFixed(2));
	document.getElementById('troco').value = troco;
}

   
   
</script>
<body>

 <nav class="navbar navbar-expand-lg navbar-light bg-light">
   <c:if test = "${sessionScope.usuario.tipo == 'G'}">     
  <a class="navbar-brand" href="entrada?acao=Index"> <i class="fa fa-home" aria-hidden="true"></i> </a>
  </c:if>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Cadastros
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="/LojaDeRoupas/entrada?acao=ClienteConsultar">Listar Clientes</a><br/>
          <a class="dropdown-item" href="/LojaDeRoupas/entrada?acao=NovoClienteForm">Cadastrar Clientes</a><br/>
          <c:if test = "${sessionScope.usuario.tipo == 'G'}">
          <a class="dropdown-item" href="entrada?Acao=NovoFuncionarioForm"> Consulta de Vendas</a><br/>
      	  </c:if>
      	  <c:if test = "${sessionScope.usuario.tipo == 'G'}">
		  <a class="dropdown-item" href="entrada?acao=NovaVendaForm">Realizar Venda</a></br>
		  </c:if>
		  <c:if test = "${sessionScope.usuario.tipo == 'G'}">
		  <a class="dropdown-item" href="/LojaDeRoupas/entrada?acao=ProdutoConsultar">Produtos</a>
		  </c:if>
		  
        </div>
      </li>
      
      
     
    </ul>
    
  </div>
</nav>
<br>
<br>
        <nav></nav>

<div class="container">

<h1>FINALIZAR VENDA CLIENTE</h1>
<h2>Nome:</h2><h2 id="nome"></h2>



<form action="/LojaDeRoupas/entrada?acao=VendaCadastrar" method="post">
    <div class="form-group">
      <label for="cpf">CPF Cliente</label>
      <input type="text" class="form-control" id="cpf" placeholder="CPF" required="required">
      <a onclick="buscaCliente()"><i class="fa fa-search" aria-hidden="true"></i></a>
    </div>
    <div class="form-group">
      <label for="data_venda">Data</label>
      <input type="date" class="form-control" id="data_venda" name="data_venda" placeholder="Email">
    </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="codFilial">Filial</label>
      <select class="form-control" name="codFilial" style="margin-top: 4px;">
	<c:forEach items="${filial}" var="filial">
          <option value="${filial.codfilial}">${filial.estado}</option>
    </c:forEach>
  	</select>
    </div>
    <div class="form-group col-md-6">
      <label for="percentDesconto">Desconto</label>
      <select class="form-control" name="percentDesconto" id="percentDesconto" name="percentDesconto" style="margin-top: 4px;" onchange="calculaDesconto()">
          <option value="0">0%</option>
          <option value="3">3%</option>
          <option value="5">5%</option>
          <option value="10">10%</option>
          <option value="15">15%</option>
       </select>
    </div>
  </div>

  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="valor_Total">Total</label>
    <input type="text" class="form-control" id="valor_Total" name="valor_Total" placeholder="Total" value="${total}">
    </div>
    <div class="form-group col-md-6">
      <label for="desconto">Desconto</label>
      <input type="text"  class="form-control" name="desconto" id="desconto" placeholder="desconto" value="0">
    </div>
  </div>
  
  <label for="forma">Forma de pagamento</label>
  <div class="form-group">
   <a onclick="adicionarMoney()"> <i class="fa fa-money fa-6" aria-hidden="true"></i></a>
   <a onclick="adicionarCreditCard()"> <i class="fa fa-credit-card-alt" aria-hidden="true"></i></a>
  </div>
  
  
  
  <div class="form-group">
  <section id="creditCard">
	 
    <div class="container preload">
        <div class="creditcard">
            <div class="front">
                <div id="ccsingle"></div>
                <svg version="1.1" id="cardfront" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                    x="0px" y="0px" viewBox="0 0 750 471" style="enable-background:new 0 0 750 471;" xml:space="preserve">
                    <g id="Front">
                        <g id="CardBackground">
                            <g id="Page-1_1_">
                                <g id="amex_1_">
                                    <path id="Rectangle-1_1_" class="lightcolor grey" d="M40,0h670c22.1,0,40,17.9,40,40v391c0,22.1-17.9,40-40,40H40c-22.1,0-40-17.9-40-40V40
                            C0,17.9,17.9,0,40,0z" />
                                </g>
                            </g>
                            <path class="darkcolor greydark" d="M750,431V193.2c-217.6-57.5-556.4-13.5-750,24.9V431c0,22.1,17.9,40,40,40h670C732.1,471,750,453.1,750,431z" />
                        </g>
                        <text transform="matrix(1 0 0 1 60.106 295.0121)" id="svgnumber" class="st2 st3 st4">0123 4567 8910 1112</text>
                        <text transform="matrix(1 0 0 1 54.1064 428.1723)" id="svgname" class="st2 st5 st6">JOAO DA SILVA</text>
                        <text transform="matrix(1 0 0 1 54.1074 389.8793)" class="st7 st5 st8">Nome impresso no cartão</text>
                        <text transform="matrix(1 0 0 1 479.7754 388.8793)" class="st7 st5 st8">Data de expiração</text>
                        <text transform="matrix(1 0 0 1 65.1054 241.5)" class="st7 st5 st8">Número do cartão</text>
                        <g>
                            <text transform="matrix(1 0 0 1 574.4219 433.8095)" id="svgexpire" class="st2 st5 st9">01/23</text>
                            <text transform="matrix(1 0 0 1 479.3848 417.0097)" class="st2 st10 st11">VALID</text>
                            <text transform="matrix(1 0 0 1 479.3848 435.6762)" class="st2 st10 st11">THRU</text>
                            <polygon class="st2" points="554.5,421 540.4,414.2 540.4,427.9 		" />
                        </g>
                        <g id="cchip">
                            <g>
                                <path class="st2" d="M168.1,143.6H82.9c-10.2,0-18.5-8.3-18.5-18.5V74.9c0-10.2,8.3-18.5,18.5-18.5h85.3
                        c10.2,0,18.5,8.3,18.5,18.5v50.2C186.6,135.3,178.3,143.6,168.1,143.6z" />
                            </g>
                            <g>
                                <g>
                                    <rect x="82" y="70" class="st12" width="1.5" height="60" />
                                </g>
                                <g>
                                    <rect x="167.4" y="70" class="st12" width="1.5" height="60" />
                                </g>
                                <g>
                                    <path class="st12" d="M125.5,130.8c-10.2,0-18.5-8.3-18.5-18.5c0-4.6,1.7-8.9,4.7-12.3c-3-3.4-4.7-7.7-4.7-12.3
                            c0-10.2,8.3-18.5,18.5-18.5s18.5,8.3,18.5,18.5c0,4.6-1.7,8.9-4.7,12.3c3,3.4,4.7,7.7,4.7,12.3
                            C143.9,122.5,135.7,130.8,125.5,130.8z M125.5,70.8c-9.3,0-16.9,7.6-16.9,16.9c0,4.4,1.7,8.6,4.8,11.8l0.5,0.5l-0.5,0.5
                            c-3.1,3.2-4.8,7.4-4.8,11.8c0,9.3,7.6,16.9,16.9,16.9s16.9-7.6,16.9-16.9c0-4.4-1.7-8.6-4.8-11.8l-0.5-0.5l0.5-0.5
                            c3.1-3.2,4.8-7.4,4.8-11.8C142.4,78.4,134.8,70.8,125.5,70.8z" />
                                </g>
                                <g>
                                    <rect x="82.8" y="82.1" class="st12" width="25.8" height="1.5" />
                                </g>
                                <g>
                                    <rect x="82.8" y="117.9" class="st12" width="26.1" height="1.5" />
                                </g>
                                <g>
                                    <rect x="142.4" y="82.1" class="st12" width="25.8" height="1.5" />
                                </g>
                                <g>
                                    <rect x="142" y="117.9" class="st12" width="26.2" height="1.5" />
                                </g>
                            </g>
                        </g>
                    </g>
                    <g id="Back">
                    </g>
                </svg>
            </div>
            <div class="back">
                <svg version="1.1" id="cardback" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                    x="0px" y="0px" viewBox="0 0 750 471" style="enable-background:new 0 0 750 471;" xml:space="preserve">
                    <g id="Front">
                        <line class="st0" x1="35.3" y1="10.4" x2="36.7" y2="11" />
                    </g>
                    <g id="Back">
                        <g id="Page-1_2_">
                            <g id="amex_2_">
                                <path id="Rectangle-1_2_" class="darkcolor greydark" d="M40,0h670c22.1,0,40,17.9,40,40v391c0,22.1-17.9,40-40,40H40c-22.1,0-40-17.9-40-40V40
                        C0,17.9,17.9,0,40,0z" />
                            </g>
                        </g>
                        <rect y="61.6" class="st2" width="750" height="78" />
                        <g>
                            <path class="st3" d="M701.1,249.1H48.9c-3.3,0-6-2.7-6-6v-52.5c0-3.3,2.7-6,6-6h652.1c3.3,0,6,2.7,6,6v52.5
                    C707.1,246.4,704.4,249.1,701.1,249.1z" />
                            <rect x="42.9" y="198.6" class="st4" width="664.1" height="10.5" />
                            <rect x="42.9" y="224.5" class="st4" width="664.1" height="10.5" />
                            <path class="st5" d="M701.1,184.6H618h-8h-10v64.5h10h8h83.1c3.3,0,6-2.7,6-6v-52.5C707.1,187.3,704.4,184.6,701.1,184.6z" />
                        </g>
                        <text transform="matrix(1 0 0 1 621.999 227.2734)" id="svgsecurity" class="st6 st7">000</text>
                        <g class="st8">
                            <text transform="matrix(1 0 0 1 518.083 280.0879)" class="st9 st6 st10">CÓDIGO DE SEGURANÇA</text>
                        </g>
                        <rect x="58.1" y="378.6" class="st11" width="375.5" height="13.5" />
                        <rect x="58.1" y="405.6" class="st11" width="421.7" height="13.5" />
                        <text transform="matrix(1 0 0 1 59.5073 228.6099)" id="svgnameback" class="st12 st13">NOME IMPRESSO</text>
                    </g>
                </svg>
            </div>
        </div>
    </div>
    <div class="form-container">
        <div class="field-container">
            <label for="name">Name</label>
            <input id="name" maxlength="20" type="text">
        </div>
        <div class="field-container">
            <label for="cardnumber">Card Number</label> <span id="generatecard">Gerar automático</span>
            <input id="cardnumber" type="text" >
            <svg id="ccicon" class="ccicon" width="750" height="471" viewBox="0 0 750 471" version="1.1" xmlns="http://www.w3.org/2000/svg"
                xmlns:xlink="http://www.w3.org/1999/xlink">

            </svg>
        </div>
        <div class="field-container">
            <label for="expirationdate">Expiration (mm/yy)</label>
            <input id="expirationdate" type="text" >
        </div>
        <div class="field-container">
            <label for="securitycode">Security Code</label>
            <input id="securitycode" type="text"  maxlength="3">
        </div>
    </div>
    </section>
  </div>
  
  
  
  
  <div class="form-row" id="adicionarMoney">
    <div class="form-group col-md-6">
      <label for="totalRecebido">Total recebido</label>
      <input type="text" onchange="calcularTroco()" class="form-control" name="totalRecebido" id="totalRecebido" placeholder="Total recebido">
    </div>
    <div class="form-group col-md-6">
      <label for="troco">Troco</label>
      <input type="text"  class="form-control" name="troco" id="troco" placeholder="troco">
    </div>
  </div>
  
  <input type="text" id="id" name="cod_cliente">
  
  
  
  <button type="submit" class="btn btn-primary">Finalizar venda</button>
</form>




 
    
    </div>
</body>
</html>