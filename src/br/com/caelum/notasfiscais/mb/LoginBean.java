package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDao dao;
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;

	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		if(dao.existe(this.usuario)) {
			usuarioLogado.logar(this.usuario);
			return "produto?faces-redirect=true";
		}
		usuarioLogado.deslogar();
		this.usuario = new Usuario();
		return "login";
	}
	
	public String efetuaLogoff() {
		this.usuarioLogado.deslogar();
		return "login?faces-redirect=true";
	}
}