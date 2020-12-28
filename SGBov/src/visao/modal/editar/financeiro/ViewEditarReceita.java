package visao.modal.editar.financeiro;

import controlador.visao.modal.editar.financeiro.ControllerViewEditarReceita;
import java.awt.Dimension;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.consulta.financeiro.ViewConsultaReceita;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.financeiro.PanelEditarReceita;

/**
 * <p>Classe de Visao <b>ViewEditarReceita</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao da Receita</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.editar.financeiro.ControllerViewEditarReceita
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.editar.ViewEditar
 */
public final class ViewEditarReceita extends ViewEditar {
    private final Movimentacao movimentacao;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Receita.
     * @param movimentacao_ Movimentacao.
     */
    public ViewEditarReceita(ViewConsultaReceita view, Movimentacao movimentacao_) {
        super(view);
        movimentacao = movimentacao_;
        title        = "Editar Despesa";
        controller   = new ControllerViewEditarReceita(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(500, 270));
    }
    
    @Override
    protected PanelEditarReceita createPanel() {
        return new PanelEditarReceita(this, movimentacao);
    }
    
    /**
     * Metodo responsavel por retornar a Movimentacao.
     * @return Movimentacao.
     */
    public Movimentacao getMovimentacao() {
        return movimentacao;
    }
    
    @Override
    public PanelEditarReceita getPanelEditar() {
        return (PanelEditarReceita) super.getPanelEditar();
    }
}