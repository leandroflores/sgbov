package visao.modal.novo.financeiro;

import controlador.visao.modal.novo.financeiro.ControllerViewNovoMovimentacao;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.financeiro.PanelNovoMovimentacao;

/**
 * <p>Classe de Visao <b>ViewNovoMovimentacao</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Movimentacao Financeira</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.modal.novo.financeiro.ControllerViewNovoMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoMovimentacao extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoMovimentacao(ViewModal view) {
        super(view);
        title      = "Cadastro de Movimentação Financeira";
        controller = new ControllerViewNovoMovimentacao(this);
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
    protected PanelNovoMovimentacao createPanelNovo() {
        return new PanelNovoMovimentacao(this);
    }
    
    @Override
    public PanelNovoMovimentacao getPanelNovo() {
        return (PanelNovoMovimentacao) super.getPanelNovo();
    }
}