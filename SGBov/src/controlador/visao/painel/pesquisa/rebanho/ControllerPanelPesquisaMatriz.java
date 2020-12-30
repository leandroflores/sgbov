package controlador.visao.painel.pesquisa.rebanho;

import controlador.visao.painel.pesquisa.*;
import java.awt.event.ActionEvent;
import visao.painel.pesquisa.rebanho.PanelPesquisaMatriz;

/**
 * <p>Classe de Controle <b>ControllerPanelPesquisaMatriz</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>PanelPesquisaMatriz</b> do SGBov.</p>
 * @author Leandro
 * @since  30/12/2020
 * @see    controlador.visao.painel.pesquisa.ControllerPanelPesquisa
 * @see    modelo.entidade.rebanho.Bovino
 * @see    visao.painel.pesquisa.rebanho.PanelPesquisaMatriz
 */
public class ControllerPanelPesquisaMatriz extends ControllerPanelPesquisa {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Pesquisa Matriz.
     */
    public ControllerPanelPesquisaMatriz(PanelPesquisaMatriz panel) {
        super(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanel().getButtonAtualizar().equals(event.getSource()))
            getPanel().getOwner().update();
    }
    
    @Override
    public PanelPesquisaMatriz getPanel() {
        return (PanelPesquisaMatriz) panel;
    }
}