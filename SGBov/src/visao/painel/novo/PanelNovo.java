package visao.painel.novo;

import visao.modal.novo.ViewNovo;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelNovo</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para o <b>Painel Novo</b> do SGBov.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    visao.modal.novo.ViewNovo
 * @see    visao.painel.Panel
 */
public abstract class PanelNovo extends Panel {
    protected ViewNovo view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovo(ViewNovo view) {
        this.view = view;
    }
    
    /**
     * Metodo abstrato responsavel por definir as Propriedades do Panel Novo.
     */
    protected abstract void setProperties();
    
    /**
     * Metodo abstrato responsavel por Limpar os Componentes do Panel Novo.
     */
    public abstract void clear();
    
    /**
     * Metodo responsavel por retornar a View Novo.
     * @return View Novo.
     */
    public ViewNovo getView() {
        return (ViewNovo) view;
    }
}