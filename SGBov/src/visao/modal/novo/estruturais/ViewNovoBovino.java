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
        setSize(new Dimension(550, 350));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
        super.addHeader();
    }

    @Override
    public void addBody() {
        getContentPane().add(getVerticalSpace(20));
        addPanel("panel_bovino", new PanelNovoBovino(this));
        getContentPane().add(getPanelNovo());
        getContentPane().add(getVerticalSpace(20));
    }

    @Override
    public void clear() {
        getPanelNovo().clear();
    }
    
    /**
     * Metodo responsavel por retornar o Panel Novo Bovino.
     * @return Panel Novo Bovino.
     */
    public PanelNovoBovino getPanelNovo() {
        return (PanelNovoBovino) getPanel("panel_bovino");
    }
}