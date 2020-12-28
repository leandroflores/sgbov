package controlador.visao.modal.editar.financeiro;

import controlador.visao.modal.editar.ControllerViewEditar;
import modelo.dao.financeiro.DaoMovimentacao;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.editar.financeiro.ViewEditarDespesa;
import visao.modal.mensagem.ViewMensagem;
import visao.painel.editar.financeiro.PanelEditarDespesa;

/**
 * <p>Classe de Controle <b>ControllerViewEditarDespesa</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewEditarDespesa.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.editar.ControllerViewEditar
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.editar.financeiro.ViewEditarDespesa
 */
public class ControllerViewEditarDespesa extends ControllerViewEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Despesa.
     */
    public ControllerViewEditarDespesa(ViewEditarDespesa view) {
        super(view);
    }
    
    /**
     * Metodo responsavel por validar a Descricao da Movimentacao.
     * @return Descricao da Movimentacao e valida.
     */
    public boolean checkDescricao() {
        return check(getPanel().getTextFieldDescricao(), "Descrição Inválida!");
    }
    
    /**
     * Metodo responsavel por validar o Valor da Movimentacao.
     * @return Valor da Movimentacao e valido.
     */
    public boolean checkValor() {
        return checkValor(getPanel().getTextFieldValor(), "Valor Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Pagamento da Movimentacao.
     * @return Data de Pagamento da Movimentacao e valida.
     */
    public boolean checkDataPagamento() {
        return checkData(getPanel().getTextFieldDataPagamento(), "Data Inválida!");
    }
    
    @Override
    public boolean check() {
        return checkDescricao()
            && checkValor()
            && checkDataPagamento();
    }
    
    @Override
    public void salvar() {
        Movimentacao movimentacao = getView().getMovimentacao();
                     movimentacao.setDescricao(getString(getPanel().getTextFieldDescricao()));
                     movimentacao.setValor(getFloat(getPanel().getTextFieldValor()));
                     movimentacao.setPagamento(getData(getPanel().getTextFieldDataPagamento()));
        new DaoMovimentacao().update(movimentacao);
        new ViewMensagem(getView(), "Despesa atualizada com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelEditarDespesa getPanel() {
        return getView().getPanelEditar();
    }
    
    @Override
    public ViewEditarDespesa getView() {
        return (ViewEditarDespesa) view;
    }
}