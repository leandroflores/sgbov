package visao.estruturais.login;

import javax.swing.BoxLayout;
import visao.View;
import visao.painel.login.PanelLogin;
import visao.painel.logo.PanelLogo;

/**
 * <p>Classe de Visao <b>ViewLogin</b>.</p> 
 * <p>Classe responsavel por definir a <b>View de Login</b> do SGBov.</p>
 * @author Leandro
 * @since  16/12/2020
 * @see    controlador
 * @see    visao.View
 */
public class ViewLogin extends View {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public ViewLogin() {
        addComponents();
    }
    
    @Override
    protected void setDefaultProperties() {
        super.setDefaultProperties();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    protected void addComponents() {
        getContentPane().add(createLabel("A"));
        getContentPane().add(createLabel("B"));
        getContentPane().add(new PanelLogo());
        getContentPane().add(new PanelLogin());
        getContentPane().add(createLabel("C"));
    }
    
    public static void main(String[] args) {
        new ViewLogin().setVisible(true);
    }
}