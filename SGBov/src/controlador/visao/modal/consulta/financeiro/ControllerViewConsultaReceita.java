package controlador.visao.modal.consulta.financeiro;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.controlador.financeiro.ControllerMovimentacao;
import modelo.dao.financeiro.DaoMovimentacao;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.consulta.financeiro.ViewConsultaReceita;
import visao.modal.editar.financeiro.ViewEditarReceita;
import visao.modal.excluir.financeiro.ViewExcluirMovimentacao;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.financeiro.ViewNovoReceita;
import visao.painel.consulta.filtro.financeiro.PanelFiltroSimples;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaReceita</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaReceita.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.financeiro.DaoMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.consulta.financeiro.ViewConsultaReceita
 */
public class ControllerViewConsultaReceita extends ControllerViewConsulta {
    private final DaoMovimentacao dao;
    private List<Movimentacao> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Receita.
     */
    public ControllerViewConsultaReceita(ViewConsultaReceita view) {
        super(view);
        dao  = new DaoMovimentacao();
        list = new ArrayList<>();
    }
    
    @Override
    public void update() {
        pesquisar();
        getView().addRows("consulta", getController().getMatriz(list));
        getView().setCount(list.size());
        getView().setTotal(getController().getTotal(list));
    }
    
    @Override
    public void pesquisar() {
        String tipo      = "RECEITA";
        Date   inicio    = getData(getFiltro().getTextFieldInicio());
        Date   final_    = getData(getFiltro().getTextFieldFinal());
        String descricao = getString(getFiltro().getTextFieldDescricao()).toUpperCase();
               list      = dao.filter(tipo, descricao, inicio, final_);
    }
    
    @Override
    public void novo() {
        new ViewNovoReceita(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewEditarReceita(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione uma Receita!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewExcluirMovimentacao(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione uma Receita!").setVisible(true);
    }
    
    @Override
    public ControllerMovimentacao getController() {
        return new ControllerMovimentacao();
    }
    
    @Override
    public PanelFiltroSimples getFiltro() {
        return (PanelFiltroSimples) super.getFiltro();
    }
    
    @Override
    public ViewConsultaReceita getView() {
        return (ViewConsultaReceita) view;
    }
}