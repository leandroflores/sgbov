package visao.modal.novo.financeiro;

import controlador.visao.modal.novo.financeiro.ControllerViewNovoDespesa;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.financeiro.PanelNovoDespesa;

/**
 * <p>Classe de Visao <b>ViewNovoDespesa</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Nova Despesa</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.novo.financeiro.
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoDespesa extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoDespesa(ViewModal view) {
        super(view);
        title      = "Cadastro de Despesa";
        controller = new ControllerViewNovoDespesa(this);
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
    protected PanelNovoDespesa createPanelNovo() {
        return new PanelNovoDespesa(this);
    }
    
    @Override
    public PanelNovoDespesa getPanelNovo() {
        return (PanelNovoDespesa) super.getPanelNovo();
    }
}