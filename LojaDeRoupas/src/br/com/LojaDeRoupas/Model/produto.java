package br.com.LojaDeRoupas.Model;




import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class produto {
    
    private int _codFilial;
    private int _codProduto;
    private String _nome;
    private String _tipo;
    private int _quantidade;
    private double _valorCompra;
    private double _valorVenda;
    private String _filial;
    
    public produto() {	
	}
    
    public produto(int codProduto, String nome, String tipo, int quantidade, double valorCompra, double valorVenda,String filial) {
    	//this._codFilial = codFilial;
    	this._codProduto = codProduto;
    	this._nome = nome;
    	this._tipo = tipo;
    	this._quantidade = quantidade;
    	this._valorCompra = valorCompra;
    	this._valorVenda = valorVenda;
    	this._filial = filial;
    }
    
    public produto(int codFilial, String nome, String tipo, int quantidade, double valorCompra, double valorVenda) {
    	this._codFilial = codFilial;
    	this._nome = nome;
    	this._tipo = tipo;
    	this._quantidade = quantidade;
    	this._valorCompra = valorCompra;
    	this._valorVenda = valorVenda;
    }
    
    

    @Override
    public String toString() {
        return "produto{" + "_codFilial=" + _codFilial + ", _codProduto=" + _codProduto + ", _nome=" + _nome + ", _tipo=" + _tipo + ", _quantidade=" + _quantidade + ", _valorCompra=" + _valorCompra + ", _valorVenda=" + _valorVenda + '}';
    }

	public int get_codFilial() {
		return _codFilial;
	}

	public void set_codFilial(int _codFilial) {
		this._codFilial = _codFilial;
	}

	public int get_codProduto() {
		return _codProduto;
	}

	public void set_codProduto(int _codProduto) {
		this._codProduto = _codProduto;
	}

	public String get_nome() {
		return _nome;
	}

	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public String get_tipo() {
		return _tipo;
	}

	public void set_tipo(String _tipo) {
		this._tipo = _tipo;
	}

	public int get_quantidade() {
		return _quantidade;
	}

	public void set_quantidade(int _quantidade) {
		this._quantidade = _quantidade;
	}

	public double get_valorCompra() {
		return _valorCompra;
	}

	public void set_valorCompra(double _valorCompra) {
		this._valorCompra = _valorCompra;
	}

	public double get_valorVenda() {
		return _valorVenda;
	}

	public void set_valorVenda(double _valorVenda) {
		this._valorVenda = _valorVenda;
	}

	public String get_filial() {
		return _filial;
	}

	public void set_filial(String _filial) {
		this._filial = _filial;
	}

  
    
  
    
    
    
}
