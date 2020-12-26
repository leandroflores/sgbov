package visao.modal.novo.estruturais;

import controlador.visao.modal.novo.estruturais.ControllerViewNovoPesagem;
import java.awt.Dimension;
import modelo.entidade.estruturais.Bovino;
import visao.interfaces.Searchable;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.estruturais.PanelNovoPesagem;

/**
 * <p>Classe de Visao <b>ViewNovoPesagem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Pesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.modal.novo.estruturais.ControllerViewNovoPesagem
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.interfaces.Searchable
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoPesagem extends ViewNovo implements Searchable {
    private Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoPesagem(ViewModal view) {
        super(view);
        title      = "Cadastro de Pesagem";
        controller = new ControllerViewNovoPesagem(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(550, 280));
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
        bovino = null;
        getPanelNovo().clear();
    }
    
    @Override
    public void setValue(Object value) {
        bovino = (Bovino) value;
        getPanelNovo().setValue(value);
    }
    
    /**
     * Metodo responsavel por retornar o Panel Novo Pesagem.
     * @return Panel Novo Pesagem.
     */
    public PanelNovoPesagem getPanelNovo() {
        return (PanelNovoPesagem) getPanel("panel_pesagem");
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
}