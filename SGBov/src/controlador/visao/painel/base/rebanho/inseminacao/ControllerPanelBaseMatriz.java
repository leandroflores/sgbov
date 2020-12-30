package controlador.visao.painel.base.rebanho.inseminacao;

import controlador.visao.painel.base.ControllerPanelBase;
import visao.painel.base.rebanho.inseminacao.PanelBaseMatriz;

/**
 * <p>Classe de Controle <b>ControllerPanelBaseMatriz</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelBaseMatriz.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.base.ControllerPanelBase
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.base.rebanho.inseminacao.PanelBaseMatriz
 */
public final class ControllerPanelBaseMatriz extends ControllerPanelBase {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Base Matriz.
     */
    public ControllerPanelBaseMatriz(PanelBaseMatriz panel) {
        super(panel);
    }
    
    @Override
    public PanelBaseMatriz getPanel() {
        return (PanelBaseMatriz) panel;
    }
}