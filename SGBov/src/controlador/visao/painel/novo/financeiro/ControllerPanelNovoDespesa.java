package controlador.visao.painel.novo.financeiro;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.financeiro.PanelNovoDespesa;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoDespesa</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoDespesa.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.novo.financeiro.PanelNovoDespesa
 */
public final class ControllerPanelNovoDespesa extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Despesa.
     */
    public ControllerPanelNovoDespesa(PanelNovoDespesa panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoDespesa getPanel() {
        return (PanelNovoDespesa) panel;
    }
}