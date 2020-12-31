package controlador.visao.painel.editar.rebanho.inseminacao;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.rebanho.inseminacao.PanelEditarMatriz;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarMatriz</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarMatriz.</p>
 * @author Leandro
 * @since  31/12/2020
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.editar.rebanho.inseminacao.PanelEditarMatriz
 */
public final class ControllerPanelEditarMatriz extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Matriz.
     */
    public ControllerPanelEditarMatriz(PanelEditarMatriz panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarMatriz getPanel() {
        return (PanelEditarMatriz) panel;
    }
}