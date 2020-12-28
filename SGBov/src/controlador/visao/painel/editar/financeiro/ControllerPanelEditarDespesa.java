package controlador.visao.painel.editar.financeiro;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.financeiro.PanelEditarDespesa;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarDespesa</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarDespesa.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.editar.financeiro.PanelEditarDespesa
 */
public final class ControllerPanelEditarDespesa extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Despesa.
     */
    public ControllerPanelEditarDespesa(PanelEditarDespesa panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarDespesa getPanel() {
        return (PanelEditarDespesa) panel;
    }
}