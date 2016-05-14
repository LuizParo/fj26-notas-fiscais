package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean(name = "produtoBean")
public class ProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void grava() {
		System.out.println("Será que vai passar por aqui?");
		
		ProdutoDao dao = new ProdutoDao();
		
		if(produto.getId() == null) {
			dao.adiciona(produto);
		} else {
			dao.atualiza(produto);
		}
		this.produtos = null;
		this.produto = new Produto();
	}
	
	public void remove(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		this.produtos = new ProdutoDao().listaTodos();
	}
	
	public void reset(){
		produto = new Produto();
	}
	
	public List<Produto> getProdutos() {
		if(this.produtos == null) {
			System.out.println("Carregando produtos...");
			this.produtos = new ProdutoDao().listaTodos();
		}
		return produtos;
	}
}