package visao.modal.novo.rebanho;

import controlador.visao.modal.novo.rebanho.ControllerViewNovoPesagem;
import java.awt.Dimension;
import modelo.entidade.rebanho.Bovino;
import visao.interfaces.Searchable;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.rebanho.PanelNovoPesagem;

/**
 * <p>Classe de Visao <b>ViewNovoPesagem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Pesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.modal.novo.rebanho.ControllerViewNovoPesagem
 * @see    modelo.entidade.rebanho.Pesagem
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
    protected PanelNovoPesagem createPanelNovo() {
        return new PanelNovoPesagem(this);
    }

    @Override
    public void clear() {
        bovino = null;
        super.clear();
    }
    
    @Override
    public void setValue(Object value) {
        bovino = (Bovino) value;
        getPanelNovo().setValue(value);
    }
    
    @Override
    public PanelNovoPesagem getPanelNovo() {
        return (PanelNovoPesagem) super.getPanelNovo();
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
}