package visao.painel.login;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelLogin</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Login</b> do SGBov.</p>
 * @author Leandro
 * @since  16/12/2020
 * @see    controlador
 * @see    visao.painel.Panel
 */
public final class PanelLogin extends Panel {

    /**
     * Metood construtor padrao da Classe.
     */
    public PanelLogin() {
        addComponents();
    }
    
    @Override
    protected void setDefaultSettings() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 150));
        
    }
    
    @Override
    protected void addComponents() {
        add(createLabel("Login*: "), createConstraints(3, 1, 0, 0));
        add(createTextField("login", "", 10), createConstraints(3, 1, 3, 0));
        
        add(createLabel("Senha: "), createConstraints(3, 1, 0, 1));
        add(createPasswordField("senha", "", 10), createConstraints(3, 1, 3, 1));
        
        add(createButton("login", "Login ", "sim"), createConstraints(3, 1, 0, 2));
        add(createButton("sair",  " Sair ", "excluir"), createConstraints(3, 1, 3, 2));
        getLoginButton().setMinimumSize(new Dimension(75, 30));
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