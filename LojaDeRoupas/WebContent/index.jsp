<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Brazucas Technology</title>	
	
  <link rel="shortcut icon" href="<c:url value="/Imagens/bandeiraBrasil.png"/>"/>	
  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/jquery/jquery.min.js"></script>
  <script lang="text/javascript">
  $(document).ready( function () {
	  var data = new Date();

		
		
		var hora    = data.getHours();          // 0-23
		var min     = data.getMinutes();        // 0-59
		var seg     = data.getSeconds();        // 0-59
		var mseg    = data.getMilliseconds();   // 0-999
		var tz      = data.getTimezoneOffset(); // em minutos

		var str_hora = hora + ':' + min + ':' + seg;
		console.log('teste');
		console.log(str_hora)
		document.getElementById('horaAtual').innerHTML = str_hora; 
	           
  });        

	
  </script>

</head>

<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index">Brazucas Technology</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>
	<a class="navbar-brand mr-1" href="#" style="margin-left: 30%;">Bem vindo ${sessionScope.usuario.nome}</a>
	 
	   
    <ul class="navbar-nav ml-auto ml-md-0" style="float: rigth">
      <li class="nav-item dropdown no-arrow" >
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-fw"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Configura��es</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
        </div>
      </li>
    </ul>

  </nav>

  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
    <!-- NAO APAGARRRR  <li class="nav-item active">
        <a class="nav-link" href="graficos.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Gr�ficos</span>
        </a>
      </li>-->
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Cadastros</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Cadastros:</h6>
          <a class="dropdown-item" href="ListarClientes">Listar Clientes</a>
          <a class="dropdown-item" href="/LojaDeRoupas/Admin/cadastrarCliente.jsp">Cadastrar Clientes</a>
          <a class="dropdown-item" href="Admin/cadastrarFuncionario.jsp">Cadastrar Funcionario</a>
          <a class="dropdown-item" href="/LojaDeRoupas/listaProdutos">Produtos</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Venda:</h6>
          <a class="dropdown-item" href="RealizarVenda.jsp">Realizar Venda</a>
        </div>
      </li>
      <li class="nav-item">
         <a class="nav-link" href="/LojaDeRoupas/listaVendas">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Relat�rios</span></a>
      </li>
   
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
       <!--  <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Gr�ficos</a>
          </li>
    
        </ol>
 -->
        <!-- Icon Cards-->
        <div class="row">
          <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-primary o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-users"></i>
                </div>
                <div class="mr-5">${totalCliente} Cliente(s) cadastrado(s)</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="ListarClientes">
                <span class="float-left">  Ver mais
                </span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
          <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-warning o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-archive"></i>
                </div>
                <div class="mr-5">${totalProduto } Produto(s) cadastrado(s)</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="/LojaDeRoupas/entrada?acao=ProdutoConsultar">
                <span class="float-left">Ver mais</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
          <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-success o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-shopping-cart"></i>
                </div>
                <div class="mr-5">${totalVenda } Venda(s)</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="/LojaDeRoupas/entrada?acao=VendaConsultar">
                <span class="float-left">Ver mais</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
          <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-danger o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-comments-dollar"></i>
                </div>
                <div class="mr-5">Produtos a venda</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="ProdutosVenda.jsp">
                <span class="float-left">Ver mais</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div> 
        </div>

        <!-- Area Chart Example-->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-chart-area"></i>
            Total de Vendas</div> 
            <!-- <button class="btn btn-primary">visualizar em tabela</button> -->
          <div class="card-body">
            <canvas id="myAreaChart" width="100%" height="30"></canvas>
          </div>
          <div class="card-footer small text-muted">Atualizado hoje �s <strong><label id="horaAtual"></label></strong></div>
        </div>
        
        <input id="listaData" type="hidden" value="${data}">
        <input id="listaQtd" type="hidden" value="${qtd}">
     <!--    <a href="/LojaDeRoupas/Index">Clique aqui</a> -->
      <!-- Sticky Footer -->
      <footer class="sticky-footer">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright � Brazucas Technology 2020</span>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Pronto para partir?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">�</span>
          </button>
        </div>
        <div class="modal-body">${sessionScope.usuario.nome}, selecione "Logout" abaixo se voc� estiver pronto para encerrar sua sess�o atual.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="/LojaDeRoupas/Logout">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="vendor/chart.js/Chart.min.js"></script>
  
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="js/demo/datatables-demo.js"></script>
  <script src="js/demo/chart-area-demo.js"></script>

</body>

</html>
