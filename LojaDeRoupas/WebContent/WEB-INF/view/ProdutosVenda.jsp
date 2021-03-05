<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="js/jQuery.min.js"></script>
    <script src="js/jqueryui.min.js"></script>
    <script src="css/bootstrap_4_3/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <title>Produtos</title>
    
    <script>
		function adicionar(id){
			$.get("/LojaDeRoupas/Carrinho?id="+id+"&action=adicionar", function resposta( resposta ){
				alert('Produto adicionado com sucesso!');
				
			});
		}
		
		function remover(id){
			$.get("/LojaDeRoupas/Carrinho?id="+id+"&action=remover", function resposta( resposta ){
				alert('Produto deletado com sucesso!');
				
			});
		}
		
		

	</script>
    
    
</head>



<body>
    <header id="header" class="d-flex align-items-center scroll-Active">
        <nav class="navbar-expand-lg navbar-dark fixed-top floatRight" style="background-color:#f8f9fa!important" id="nav-bar">
          <div class="container-fluid">
            
            
            <div class="" id="navbarResponsive">
              <ul class="navbar-expand navbar-nav ml-auto floatRight">
              <c:if test = "${sessionScope.usuario.tipo == 'G'}">     
              <li style="margin-right: 900px">
              <a class="navbar-brand" href="entrada?acao=Index"> <i class="fa fa-home" aria-hidden="true"></i> </a>
              </li>
              </c:if>
     		 <li style="margin-right: 50px; margin-top: 10px">        
     		  <div class="dropdown">
  				<a class="dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size:1.5em">
    			Cadastros
  				</a>
  				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    			<a class="dropdown-item"  href="/LojaDeRoupas/entrada?acao=NovoClienteForm">Cadastrar cliente</a>
    			<a class="dropdown-item" href="/LojaDeRoupas/entrada?acao=ClienteConsultar">Consultar Clientes</a>
    			<!--  <a class="dropdown-item" href="#">Something else here</a>-->
  				</div>
				</div>
				</li>
               <li style="margin-top: 10px"> 
               <button type="button" class="btn btn-success"><a href="/LojaDeRoupas/entrada?acao=Finalizacao" style="color: white;  margin-top: 10px">Finalizar venda</a></button>
                </li>
                <li class="nav-item pl-2 pr-2">
                  <a class="nav-link js-scroll-trigger" href="#Tutorial">
                    <i class="fas fa-video hidden-md-up" style="font-size:1.5em"></i> 
                      <span class="hidden-sm-down"></span>
                  </a>
                </li>
            <!-- 
                
                <li class="nav-item pl-2 pr-2" style="border-bottom:1px solid #622569;">
                  <div class="cart text-center">
                    <i class="fa fa-shopping-basket fa-2x shopping-cart"></i>
                    <i class="fa fa-caret-down"></i>

                    <span id="items-basket">0</span>
                  </div>
                  <div id="cart-items" class="card text-center col-lg-3 col-md-3 col-sm-6 col-xs-6 offset-sm-1" style="background-color:#f8f9fa!important">
                    <div class="card-body">
                      <span id="emptyCart">Produtos no carrinho</span>
                      <ol class="list-group list-group-flush" id="list-item"></ol>
                    </div>
                    
                    <div class="card-title">Total : <span id="total-price">$0</span></div>
                    <div class="card-body d-flex">
                      <span id="email-me">Email me the list</span>
                      <form class="form-inline justify-content-center" id="form">
                        <div class="form-group row">
                          <input type="email" id="inputemail" class="form-control" placeholder="name@example.com"> <i class="fas fa-paper-plane m-2"></i>
                        </div>
                      </form>
                    </div>
                  </div>
                </li>
                 -->
                <li class="nav-item dropdown no-arrow" >
        <a class="nav-link" href="#" id="userDropdown" role="button">
          <i class="fa fa-sign-out" data-toggle="modal" data-target="#logoutModal" aria-hidden="true"></i>
        </a>
       <!--  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Configurações</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
        </div>
         -->
      </li>
                
              </ul>
            </div>
          </div>
        </nav>
        
       
        
      </header>
      <div class="container">
      <section id="Product">
              <div class="container-fluid">
                              <div class="row mt-6 mb-3">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                          <h2 class="align-left">
                             Lista de produtos
                          </h2>
                      </div>
                         
                    
                  <div class="row justify-content-center align-items-start">
					<c:forEach items="${produtos}" var="produto">
                      <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mb-3 mt-3">
                          <div class="item">
                              <img class="img-thumbnail" src="${produto._path}" alt="" />
      
                              
                                  <div class="text-center">
                                      <h4 class="product-name marginTop ">${produto._nome}</h4>
                                  </div>
                                   <div class="row">
    								<div class="col-sm">
      								R$
    								</div>
    								<div class="col-sm product-price">
      								${produto._valorVenda}
    								</div>
                                   </div>
                              <div class="text-center marginTop">
                                      <button class="btn" type="button" onclick="adicionar(${produto._codProduto})">Adicionar ao carrinho</button>
                                      <button class="btn btn-danger" type="button" style="margin-top: 10px" onclick="remover(${produto._codProduto})">Remover do carrinho</button>
                                      <!-- <input type="hidden" id="idProduto" value="${produto._codProduto}"> -->
                                </div>
                          </div>
                      </div>
                      </c:forEach>
                  </div>
                  
                  
                  
              </div>
          </section>
          </div>
      <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Pronto para partir?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">${sessionScope.usuario.nome}, selecione "Logout" abaixo se você estiver pronto para encerrar sua sessão atual.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="/LojaDeRoupas/entrada?acao=Logout">Logout</a>
        </div>
      </div>
    </div>
  </div>
          
          <footer>
              <div class="container">
                  <div class="row mt-3">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 d-flex justify-content-center align-items-center my-auto footer">
      
                          <ul class="navbar-expand navbar-nav">
                              
      
                              <li class="nav-item pl-2 pr-2" style="border-bottom:1px solid gray;">
                                  Feito por Brazucas Technology
                                  
                              </li>
                          </ul>
                      </div>
                  </div>
              </div>
          </footer>
      <script src="js/main.js"></script>
</body>
</html>