package visao.modal.excluir.financeiro;

import controlador.visao.modal.excluir.financeiro.ControllerViewExcluirMovimentacao;
import java.awt.Dimension;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.consulta.financeiro.ViewConsultaMovimentacao;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Visao <b>ViewExluirMovimentacao</b>.</p>
 * <p>Classe responsavel por definir uma <b>Interface de Exclusao de Movimentacao</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.modal.excluir.financeiro.ControllerViewExcluirMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.excluir.ViewExcluir
 */
public final class ViewExcluirMovimentacao extends ViewExcluir {
    private final Movimentacao movimentacao;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Movimentacao.
     * @param movimentacao_ Movimentacao.
     */
    public ViewExcluirMovimentacao(ViewConsultaMovimentacao view, Movimentacao movimentacao_) {
        super(view);
        movimentacao = movimentacao_;
        title       = "Excluir Movimentação Financeira";
        controller  = new ControllerViewExcluirMovimentacao(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(650, 165));
    }
    
    @Override
    public void addBody() {
        super.addMessage(movimentacao.toString());
    }
    
    /**
     * Metodo responsavel por retornar a Movimentacao.
     * @return Movimentacao.
     */
    public Movimentacao getMovimentacao() {
        return movimentacao;
    }
}