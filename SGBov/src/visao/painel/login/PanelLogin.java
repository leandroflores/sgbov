package visao.painel.login;

import controlador.visao.painel.login.ControllerPanelLogin;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelLogin</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Login</b> do SGBov.</p>
 * @author Leandro
 * @since  16/12/2020
 * @see    controlador.visao.painel.login.ControllerPanelLogin
 * @see    visao.painel.Panel
 */
public final class PanelLogin extends Panel {

    /**
     * Metood construtor padrao da Classe.
     */
    public PanelLogin() {
        controller = new ControllerPanelLogin(this);
        setProperties();
        addComponents();
    }
    
    /**
     * Metodo responsavel por definir as Propriedades do Panel Login.
     */
    protected void setProperties() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 150));
    }
    
    @Override
    protected void addComponents() {
        add(createLabel("Login: "), createConstraints(2, 1, 0, 0));
        add(createTextField("login", "", 20), createConstraints(3, 1, 2, 0));
        
        add(createLabel("Senha: "), createConstraints(2, 1, 0, 1));
        add(createPasswordField("senha", "", 20), createConstraints(3, 1, 2, 1));
        
        addButtons();
    }
    
    /**
     * Metodo responsavel por adicionar o Painel de Botoes.
     */
    private void addButtons() {
        JPanel panel = new JPanel();
               panel.setLayout(new GridLayout(1, 2));
               panel.add(createButton("login", "Login ", "sim"));
               panel.add(createButton("sair",  " Sair ", "excluir"));
        add(panel, createConstraints(5, 1, 0, 2));
    }
    
    /**
     * Metodo responsavel por retornar o Text Field do Login.
     * @return Text Field do Login.
     */
    public JTextField getLoginField() {
        return getTextField("login");
    }
    
    /**
     * Metodo responsavel por retornar o Password Field da Senha.
     * @return Password Field da Senha.
     */
    public JPasswordField getSenhaField() {
        return getPasswordField("senha");
    }
    
    /**
     * Metodo responsavel por retornar o Button do Login.
     * @return Button do Login.
     */
    public JButton getLoginButton() {
        return getButton("login");
    }
    
    /**
     * Metodo responsavel por retornar o Button de Sair.
     * @return Button de Sair.
     */
    public JButton getSairButton() {
        return getButton("sair");
    }
}