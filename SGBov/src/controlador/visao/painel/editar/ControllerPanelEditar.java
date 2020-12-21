package controlador.visao.painel.editar;

import controlador.visao.painel.ControllerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Controle <b>ControllerPanelEditar</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>Painel Editar</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.painel.ControllerPanel
 * @see    visao.painel.editar.PanelEditar
 */
public abstract class ControllerPanelEditar extends ControllerPanel {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar.
     */
    public ControllerPanelEditar(PanelEditar panel) {
        super(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        getPanel().getView().getController().actionPerformed(event);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        getPanel().getView().getController().keyPressed(event);
    }
    
    @Override
    public PanelEditar getPanel() {
        return (PanelEditar) panel;
    }
}