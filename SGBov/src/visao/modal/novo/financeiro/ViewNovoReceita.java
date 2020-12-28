package visao.modal.novo.financeiro;

import controlador.visao.modal.novo.financeiro.ControllerViewNovoReceita;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.financeiro.PanelNovoReceita;

/**
 * <p>Classe de Visao <b>ViewNovoReceita</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Receita</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.novo.financeiro.ControllerViewNovoReceita
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoReceita extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoReceita(ViewModal view) {
        super(view);
        title      = "Cadastro de Receita";
        controller = new ControllerViewNovoReceita(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(500, 275));
    }
    
    @Override
    protected PanelNovoReceita createPanelNovo() {
        return new PanelNovoReceita(this);
    }
    
    @Override
    public PanelNovoReceita getPanelNovo() {
        return (PanelNovoReceita) super.getPanelNovo();
    }
}