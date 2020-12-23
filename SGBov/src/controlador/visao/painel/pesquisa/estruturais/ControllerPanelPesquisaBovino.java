package controlador.visao.painel.pesquisa.estruturais;

import controlador.visao.painel.pesquisa.*;
import java.awt.event.ActionEvent;
import visao.painel.pesquisa.estruturais.PanelPesquisaBovino;

/**
 * <p>Classe de Controle <b>ControllerPanelPesquisaBovino</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> do <b>PanelPesquisaBovino</b> do SGBov.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.painel.pesquisa.ControllerPanelPesquisa
 * @see    visao.painel.pesquisa.estruturais.PanelPesquisaBovino
 */
public class ControllerPanelPesquisaBovino extends ControllerPanelPesquisa {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Pesquisa Bovino.
     */
    public ControllerPanelPesquisaBovino(PanelPesquisaBovino panel) {
        super(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanel().getButtonAtualizar().equals(event.getSource()))
            System.out.println("Atualizar");
    }
    
    @Override
    public PanelPesquisaBovino getPanel() {
        return (PanelPesquisaBovino) panel;
    }
}