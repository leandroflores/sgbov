package controlador.visao.painel.novo.rebanho.inseminacao;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.rebanho.inseminacao.PanelNovoMatriz;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoMatriz</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoMatriz.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.novo.rebanho.inseminacao.PanelNovoMatriz
 */
public final class ControllerPanelNovoMatriz extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Matriz.
     */
    public ControllerPanelNovoMatriz(PanelNovoMatriz panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoMatriz getPanel() {
        return (PanelNovoMatriz) panel;
    }
}