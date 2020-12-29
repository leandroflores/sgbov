package controlador.visao.painel.base.rebanho.inseminacao;

import controlador.visao.painel.base.ControllerPanelBase;
import visao.painel.base.rebanho.inseminacao.PanelBaseMatrizes;

/**
 * <p>Classe de Controle <b>ControllerPanelBaseMatrizes</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelBaseMatrizes.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.base.ControllerPanelBase
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.base.rebanho.inseminacao.PanelBaseMatrizes
 */
public final class ControllerPanelBaseMatrizes extends ControllerPanelBase {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Base Matrizes.
     */
    public ControllerPanelBaseMatrizes(PanelBaseMatrizes panel) {
        super(panel);
    }
    
    @Override
    public PanelBaseMatrizes getPanel() {
        return (PanelBaseMatrizes) panel;
    }
}