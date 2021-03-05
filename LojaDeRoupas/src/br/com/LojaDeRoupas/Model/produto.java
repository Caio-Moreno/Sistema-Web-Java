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
    private String _status;
    private String _path;
    
    public produto() {	
	}
    
    public produto(int codProduto, String status) {
    	_codProduto = codProduto;
    	_status = status;
    }
    
    public produto(int codFilial, String nome, String tipo, int quantidade, double valorCompra, double valorVenda,String path) {
    	this._codFilial = codFilial;
    	this._nome = nome;
    	this._tipo = tipo;
    	this._quantidade = quantidade;
    	this._valorCompra = valorCompra;
    	this._valorVenda = valorVenda;
    	this._path = path; 
    }
    
    public produto(int codFilial,int codProduto, String nome, String tipo, int quantidade, double valorCompra, double valorVenda,String path) {
    	this._codFilial = codFilial;
    	this._codProduto = codProduto;
    	this._nome = nome;
    	this._tipo = tipo;
    	this._quantidade = quantidade;
    	this._valorCompra = valorCompra;
    	this._valorVenda = valorVenda;
    	this._path = path;
    }
    
    public produto(int codProduto, String nome, String tipo, int quantidade, double valorCompra, double valorVenda,String filial,String path) {
    	//this._codFilial = codFilial;
    	this._codProduto = codProduto;
    	this._nome = nome;
    	this._tipo = tipo;
    	this._quantidade = quantidade;
    	this._valorCompra = valorCompra;
    	this._valorVenda = valorVenda;
    	this._filial = filial;
    	this._path = path;
    }
    
    
    public produto(String nome,int codProduto, String tipo, int quantidade, double valorCompra, double valorVenda,String filial) {
    	//this._codFilial = codFilial;
    	this._nome = nome;
    	this._codProduto = codProduto;
    	this._tipo = tipo;
    	this._quantidade = quantidade;
    	this._valorCompra = valorCompra;
    	this._valorVenda = valorVenda;
    	this._filial = filial;
    }
    

    
    
    
    
    

    @Override
    public String toString() {
        return "produto{" + "_codFilial=" + _codFilial + ", _codProduto=" + _codProduto + ", _nome=" + _nome + ", _tipo=" + _tipo + ", _quantidade=" + _quantidade + ", _valorCompra=" + _valorCompra + ", _valorVenda=" + _valorVenda + ", _filial"+ _filial + ", _status"+ _status + ", _path " +_path+ '}';
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

  
    public String get_status() {
    	return _status;
    }
    
    public void set_status(String _status) {
    	this._status = _status;
    }

	public String get_path() {
		return _path;
	}

	public void set_path(String _path) {
		this._path = _path;
	}


    
    
}
