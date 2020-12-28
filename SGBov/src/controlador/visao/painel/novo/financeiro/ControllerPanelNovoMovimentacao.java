package controlador.visao.painel.novo.financeiro;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.financeiro.PanelNovoMovimentacao;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoFuncionario</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoFuncionario.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.novo.financeiro.PanelNovoMovimentacao
 */
public final class ControllerPanelNovoMovimentacao extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Movimentacao.
     */
    public ControllerPanelNovoMovimentacao(PanelNovoMovimentacao panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoMovimentacao getPanel() {
        return (PanelNovoMovimentacao) panel;
    }
}