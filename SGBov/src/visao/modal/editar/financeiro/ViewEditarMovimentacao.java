package visao.modal.editar.financeiro;

import controlador.visao.modal.editar.financeiro.ControllerViewEditarMovimentacao;
import java.awt.Dimension;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.consulta.financeiro.ViewConsultaMovimentacao;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.financeiro.PanelEditarMovimentacao;

/**
 * <p>Classe de Visao <b>ViewEditarMovimentacao</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao da Movimentacao</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.editar.financeiro.ControllerViewEditarMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.editar.ViewEditar
 */
public final class ViewEditarMovimentacao extends ViewEditar {
    private final Movimentacao movimentacao;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Movimentacao.
     * @param movimentacao_ Movimentacao.
     */
    public ViewEditarMovimentacao(ViewConsultaMovimentacao view, Movimentacao movimentacao_) {
        super(view);
        movimentacao = movimentacao_;
        title        = "Editar Movimentação Financeira";
        controller   = new ControllerViewEditarMovimentacao(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(500, 270));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void addBody() {
        addPanel("panel_editar", new PanelEditarMovimentacao(this, movimentacao));
        getContentPane().add(getPanelEditar());
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void setValues() {
        getPanelEditar().setValues();
    }
    
    /**
     * Metodo responsavel por retornar a Movimentacao.
     * @return Movimentacao.
     */
    public Movimentacao getMovimentacao() {
        return movimentacao;
    }
    
    @Override
    public PanelEditarMovimentacao getPanelEditar() {
        return (PanelEditarMovimentacao) super.getPanelEditar();
    }
}