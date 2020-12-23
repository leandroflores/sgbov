package visao.modal.novo.estruturais;

import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.estruturais.PanelNovoPesagem;

/**
 * <p>Classe de Visao <b>ViewNovoPesagem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Pesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.modal.novo.estruturais.
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoPesagem extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoPesagem(ViewModal view) {
        super(view);
        title      = "Cadastro de Pesagem";
        //controller = new ControllerViewNovoBovino(this);
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
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
        super.addHeader();
    }

    @Override
    public void addBody() {
        getContentPane().add(getVerticalSpace(20));
        addPanel("panel_pesagem", new PanelNovoPesagem(this));
        getContentPane().add(getPanelNovo());
        getContentPane().add(getVerticalSpace(20));
    }

    @Override
    public void clear() {
        getPanelNovo().clear();
    }
    
    /**
     * Metodo responsavel por retornar o Panel Novo Pesagem.
     * @return Panel Novo Pesagem.
     */
    public PanelNovoPesagem getPanelNovo() {
        return (PanelNovoPesagem) getPanel("panel_pesagem");
    }
}