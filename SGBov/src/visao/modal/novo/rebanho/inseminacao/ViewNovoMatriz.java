package visao.modal.novo.rebanho.inseminacao;

import controlador.visao.modal.novo.rebanho.ControllerViewNovoInseminacao;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.rebanho.PanelNovoInseminacao;

/**
 * <p>Classe de Visao <b>ViewNovoMatriz</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Matriz</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.modal.novo.rebanho.
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoMatriz extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoMatriz(ViewModal view) {
        super(view);
        title      = "Cadastro de Matriz";
        //controller = new ControllerViewNovoMatriz(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(650, 500));
    }
    
    @Override
    protected PanelNovoInseminacao createPanelNovo() {
        return new PanelNovoInseminacao(this);
    }
    
    @Override
    public PanelNovoInseminacao getPanelNovo() {
        return (PanelNovoInseminacao) super.getPanelNovo();
    }
}