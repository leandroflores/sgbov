package controlador.visao.modal.excluir.financeiro;

import controlador.visao.modal.excluir.ControllerViewExcluir;
import modelo.dao.financeiro.DaoMovimentacao;
import visao.modal.excluir.financeiro.ViewExcluirMovimentacao;
import visao.modal.mensagem.ViewMensagem;

/**
 * <p>Classe de Controle <b>ControllerViewExcluirMovimentacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluirMovimentacao.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    modelo.dao.financeiro.DaoMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.excluir.financeiro.ViewExcluirMovimentacao
 */
public class ControllerViewExcluirMovimentacao extends ControllerViewExcluir {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Excluir Movimentacao.
     */
    public ControllerViewExcluirMovimentacao(ViewExcluirMovimentacao view) {
        super(view);
    }
    
    @Override
    public void excluir() {
        new DaoMovimentacao().delete(getView().getMovimentacao().getId());
        new ViewMensagem(getView(), "Movimentação removida com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public ViewExcluirMovimentacao getView() {
        return (ViewExcluirMovimentacao) view;
    }
}