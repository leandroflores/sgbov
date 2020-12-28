package controlador.visao.painel.novo.financeiro;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.financeiro.PanelNovoReceita;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoReceita</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoReceita.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.novo.financeiro.PanelNovoReceita
 */
public final class ControllerPanelNovoReceita extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Receita.
     */
    public ControllerPanelNovoReceita(PanelNovoReceita panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoReceita getPanel() {
        return (PanelNovoReceita) panel;
    }
}