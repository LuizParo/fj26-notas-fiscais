package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.util.EmailComercial;

public class LoginListener {

    @Inject @EmailComercial
    private String emailComercial;
    
    public void onLogin(@Observes Usuario usuario) {
        System.out.printf("Usuário %s se logou no sistema. ", usuario.getLogin());
        System.out.println("Disparando email para: " + this.emailComercial);
    }
}