package controlador.visao.painel.editar.estruturais;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.estruturais.PanelEditarPesagem;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarPesagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarPesagem.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.painel.editar.estruturais.PanelEditarPesagem
 */
public final class ControllerPanelEditarPesagem extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Pesagem.
     */
    public ControllerPanelEditarPesagem(PanelEditarPesagem panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarPesagem getPanel() {
        return (PanelEditarPesagem) panel;
    }
}