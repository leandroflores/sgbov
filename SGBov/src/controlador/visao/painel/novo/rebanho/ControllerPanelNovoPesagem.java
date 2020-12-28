package controlador.visao.painel.novo.rebanho;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.rebanho.PanelNovoPesagem;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoPesagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoPesagem.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.painel.novo.rebanho.PanelNovoPesagem
 */
public final class ControllerPanelNovoPesagem extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Pesagem.
     */
    public ControllerPanelNovoPesagem(PanelNovoPesagem panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoPesagem getPanel() {
        return (PanelNovoPesagem) panel;
    }
}