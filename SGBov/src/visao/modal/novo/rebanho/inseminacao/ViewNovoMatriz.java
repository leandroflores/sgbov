package visao.modal.novo.rebanho.inseminacao;

import controlador.visao.modal.novo.rebanho.inseminacao.ControllerViewNovoMatriz;
import java.awt.Dimension;
import modelo.entidade.rebanho.Bovino;
import visao.interfaces.Searchable;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.modal.novo.rebanho.ViewNovoInseminacao;
import visao.painel.novo.rebanho.inseminacao.PanelNovoMatriz;

/**
 * <p>Classe de Visao <b>ViewNovoMatriz</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Matriz</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.modal.novo.rebanho.inseminacao.ControllerViewNovoMatriz
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.interfaces.Searchable
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoMatriz extends ViewNovo implements Searchable {
    private Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoMatriz(ViewModal view) {
        super(view);
        bovino     = null;
        title      = "Cadastro de Matriz";
        controller = new ControllerViewNovoMatriz(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(550, 400));
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
    
    @Override
    public void setValue(Object value) {
        if (value instanceof Bovino) {
            bovino = (Bovino) value;
            getPanelNovo().getPanelBaseMatriz().getTextFieldBovino().setText(bovino.toString());
        }
    }
    
    @Override
    protected PanelNovoMatriz createPanelNovo() {
        return new PanelNovoMatriz(this);
    }
    
    @Override
    public PanelNovoMatriz getPanelNovo() {
        return (PanelNovoMatriz) super.getPanelNovo();
    }
    
    @Override
    public ViewNovoInseminacao getView() {
        return (ViewNovoInseminacao) view;
    }
}