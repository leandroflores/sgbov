package visao.modal.editar.financeiro;

import controlador.visao.modal.editar.financeiro.ControllerViewEditarDespesa;
import java.awt.Dimension;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.consulta.financeiro.ViewConsultaDespesa;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.financeiro.PanelEditarDespesa;

/**
 * <p>Classe de Visao <b>ViewEditarDespesa</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao da Despesa</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.editar.financeiro.ControllerViewEditarDespesa
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.editar.ViewEditar
 */
public final class ViewEditarDespesa extends ViewEditar {
    private final Movimentacao movimentacao;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Despesa.
     * @param movimentacao_ Movimentacao.
     */
    public ViewEditarDespesa(ViewConsultaDespesa view, Movimentacao movimentacao_) {
        super(view);
        movimentacao = movimentacao_;
        title        = "Editar Despesa";
        controller   = new ControllerViewEditarDespesa(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(500, 270));
    }
    
    @Override
    protected PanelEditarDespesa createPanel() {
        return new PanelEditarDespesa(this, movimentacao);
    }
    
    /**
     * Metodo responsavel por retornar a Movimentacao.
     * @return Movimentacao.
     */
    public Movimentacao getMovimentacao() {
        return movimentacao;
    }
    
    @Override
    public PanelEditarDespesa getPanelEditar() {
        return (PanelEditarDespesa) super.getPanelEditar();
    }
}