package visao.modal.novo.estruturais;

import controlador.visao.modal.novo.estruturais.ControllerViewNovoBovino;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.estruturais.PanelNovoBovino;

/**
 * <p>Classe de Visao <b>ViewNovoBovino</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Novo Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.modal.novo.estruturais.ControllerViewNovoBovino
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoBovino extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoBovino(ViewModal view) {
        super(view);
        title      = "Cadastro de Bovino";
        controller = new ControllerViewNovoBovino(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(550, 340));
    }
    
    @Override
    protected PanelNovoBovino createPanelNovo() {
        return new PanelNovoBovino(this);
    }
    
    @Override
    public PanelNovoBovino getPanelNovo() {
        return (PanelNovoBovino) super.getPanelNovo();
    }
}