package br.com.LojaDeRoupas.Model;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.LojaDeRoupas.Model.funcionario;

public class Usuario {
		
	private String _usuario;
	private String _senha;
	
	public String get_usuario() {
		return _usuario;
	}
	
	
	public void set_usuario(String _usuario) {
		this._usuario = _usuario;
	}
	
	public String get_senha() {
		return _senha;
	}
	
	public void set_senha(String _senha) {
		this._senha = _senha;
	}
	
	public static boolean estaLogado(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sessao = request.getSession();
		
//		funcionario funcionario = (funcionario) sessao.getAttribute("usuario");
		
		
		
		if(sessao.getAttribute("usuario") == null) {
			return false;
		}
		
		//caso esteja autenticado
		return true;
		
	}
	
	public static boolean podeAcessar(HttpServletRequest request, HttpServletResponse response, funcionario funcionario,String tipo) {
		//HttpSession sessao = request.getSession();
		
		//funcionario funcionario = (funcionario) sessao.getAttribute("usuario");
		//String paramAcao = request.getParameter("acao");
		
		System.out.println("AQUI"+funcionario.getTipo());
		System.out.println("AQUI"+tipo);
		System.out.println(!tipo.equals("Login"));
		System.out.println(!tipo.equals("LoginForm"));
		System.out.println(!tipo.equals("ProdutosVenda"));
		
		
		if(funcionario.getTipo().equals("V")) {
			
			if(tipo.equals("Login") || tipo.equals("LoginForm") || tipo.equals("ProdutosVenda.jsp") || tipo.equals("cadastrarCliente.jsp") || tipo.equals("listaClientes.jsp") || tipo.equals("FinalizacaoVenda.jsp") || tipo.equals("ConsultarVenda.jsp")){
				return true;
			}
			
			System.out.println("false");
			return false;
		}
		System.out.println("Passei");
		//neste caso o vendedor tá acessando ou o login ou os produtos a venda
		return true;
	}
	
	
	
	
}
