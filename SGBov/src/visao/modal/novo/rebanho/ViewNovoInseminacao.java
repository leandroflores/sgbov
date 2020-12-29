package visao.modal.novo.rebanho;

import controlador.visao.modal.novo.rebanho.ControllerViewNovoInseminacao;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.rebanho.PanelNovoInseminacao;

/**
 * <p>Classe de Visao <b>ViewNovoInseminacao</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Inseminacao</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.modal.novo.rebanho.ControllerViewNovoInseminacao
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoInseminacao extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoInseminacao(ViewModal view) {
        super(view);
        title      = "Cadastro de Inseminação";
        controller = new ControllerViewNovoInseminacao(this);
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