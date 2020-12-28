package controlador.visao.painel.editar.financeiro;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.financeiro.PanelEditarReceita;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarReceita</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarReceita.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.editar.financeiro.PanelEditarReceita
 */
public final class ControllerPanelEditarReceita extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Receita.
     */
    public ControllerPanelEditarReceita(PanelEditarReceita panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarReceita getPanel() {
        return (PanelEditarReceita) panel;
    }
}