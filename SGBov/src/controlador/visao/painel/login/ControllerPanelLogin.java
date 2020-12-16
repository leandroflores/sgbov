package controlador.visao.painel.login;

import controlador.visao.painel.ControllerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.painel.login.PanelLogin;

/**
 * <p>Classe de Controle <b>ControllerPanelLogin</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>PanelLogin</b> do SGBov.</p>
 * @author Leandro
 * @since  16/12/2020
 * @see    controlador.visao.painel.ControllerPanel
 * @see    visao.painel.login.PanelLogin
 */
public class ControllerPanelLogin extends ControllerPanel {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Painel de Login.
     */
    public ControllerPanelLogin(PanelLogin panel) {
        super(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (getPanel().getLoginButton().equals(event.getSource()))
            login();
        else if (getPanel().getSairButton().equals(event.getSource()))
            System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case ENTER:
            case F1:
                login();
                break;
            case ESC:
            case F2:
                System.exit(0);
                break;
            default:
                break;
        }
    }
    
    private void login() {
        String login = getPanel().getLoginField().getText().trim();
        String senha = getPanel().getSenhaField().getText();
        System.out.println(login);
        System.out.println(senha);
        System.out.println("");
    }
    
    @Override
    public PanelLogin getPanel() {
        return (PanelLogin) panel;
    }
}