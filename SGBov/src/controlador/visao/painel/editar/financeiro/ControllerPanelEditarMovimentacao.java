package controlador.visao.painel.editar.financeiro;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.financeiro.PanelEditarMovimentacao;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarMovimentacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarMovimentacao.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.editar.financeiro.PanelEditarMovimentacao
 */
public final class ControllerPanelEditarMovimentacao extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Movimentacao.
     */
    public ControllerPanelEditarMovimentacao(PanelEditarMovimentacao panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarMovimentacao getPanel() {
        return (PanelEditarMovimentacao) panel;
    }
}