package controlador.visao.painel.novo.rebanho;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.rebanho.PanelNovoInseminacao;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoInseminacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoInseminacao.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.painel.novo.rebanho.PanelNovoInseminacao
 */
public final class ControllerPanelNovoInseminacao extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Inseminacao.
     */
    public ControllerPanelNovoInseminacao(PanelNovoInseminacao panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoInseminacao getPanel() {
        return (PanelNovoInseminacao) panel;
    }
}