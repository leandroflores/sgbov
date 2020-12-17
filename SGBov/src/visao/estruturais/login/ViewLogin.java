package visao.estruturais.login;

import java.awt.Component;
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
public final class ViewLogin extends View {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public ViewLogin() {
        updateTitle("Login");
        setDefaultProperties();
        addPanels();
    }
    
    @Override
    protected void setDefaultProperties() {
        super.setDefaultProperties();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    protected void addPanels() {
        getContentPane().add(getVerticalSpace(100));
        getContentPane().add(new PanelLogo());
        getContentPane().add(getVerticalSpace(20));
        getContentPane().add(new PanelLogin());
    }
    /*
    public static void main(String[] args) {
        new ViewLogin().setVisible(true);
    }*/
}