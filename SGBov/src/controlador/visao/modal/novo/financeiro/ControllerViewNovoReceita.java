package controlador.visao.modal.novo.financeiro;

import controlador.visao.modal.novo.ControllerViewNovo;
import modelo.dao.financeiro.DaoMovimentacao;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.mensagem.ViewMensagem;
import visao.modal.novo.financeiro.ViewNovoReceita;
import visao.painel.novo.financeiro.PanelNovoReceita;

/**
 * <p>Classe de Controle <b>ControllerViewNovoReceita</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoReceita.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.dao.financeiro.DaoMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.novo.financeiro.ViewNovoReceita
 */
public class ControllerViewNovoReceita extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Receita.
     */
    public ControllerViewNovoReceita(ViewNovoReceita view) {
        super(view);
    }
    
    /**
     * Metodo responsavel por validar a Descricao da Movimentacao.
     * @return Descricao da Movimentacao e valida.
     */
    public boolean checkDescricao() {
        return check(getPanelNovo().getTextFieldDescricao(), "Descrição Inválida!");
    }
    
    /**
     * Metodo responsavel por validar o Valor da Movimentacao.
     * @return Valor da Movimentacao e valido.
     */
    public boolean checkValor() {
        return checkValor(getPanelNovo().getTextFieldValor(), "Valor Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Pagamento da Movimentacao.
     * @return Data de Pagamento da Movimentacao e valida.
     */
    public boolean checkDataPagamento() {
        return checkData(getPanelNovo().getTextFieldDataPagamento(), "Data Inválida!");
    }
    
    @Override
    public boolean check() {
        return checkDescricao()
            && checkValor()
            && checkDataPagamento();
    }
    
    @Override
    public void inserir() {
        Movimentacao movimentacao = new Movimentacao();
                     movimentacao.setTipo("RECEITA");
                     movimentacao.setDescricao(getString(getPanelNovo().getTextFieldDescricao()));
                     movimentacao.setValor(getFloat(getPanelNovo().getTextFieldValor()));
                     movimentacao.setPagamento(getData(getPanelNovo().getTextFieldDataPagamento()));
        new DaoMovimentacao().insert(movimentacao);
        new ViewMensagem(getView(), "Receita cadastrada com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelNovoReceita getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoReceita getView() {
        return (ViewNovoReceita) view;
    }
}