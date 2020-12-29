package controlador.visao.painel.base.rebanho;

import controlador.visao.painel.base.ControllerPanelBase;
import visao.painel.base.rebanho.PanelBaseInseminacao;

/**
 * <p>Classe de Controle <b>ControllerPanelBaseInseminacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelBaseInseminacao.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.base.ControllerPanelBase
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.painel.base.rebanho.PanelBaseInseminacao
 */
public final class ControllerPanelBaseInseminacao extends ControllerPanelBase {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Base Inseminacao.
     */
    public ControllerPanelBaseInseminacao(PanelBaseInseminacao panel) {
        super(panel);
    }
    
    @Override
    public PanelBaseInseminacao getPanel() {
        return (PanelBaseInseminacao) panel;
    }
}