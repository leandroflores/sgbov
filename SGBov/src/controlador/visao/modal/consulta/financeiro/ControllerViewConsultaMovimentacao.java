package controlador.visao.modal.consulta.financeiro;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.controlador.financeiro.ControllerMovimentacao;
import modelo.dao.financeiro.DaoMovimentacao;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.consulta.financeiro.ViewConsultaMovimentacao;
import visao.modal.mensagem.ViewErro;
import visao.painel.consulta.filtro.financeiro.PanelFiltroMovimentacao;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaMovimentacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaMovimentacao.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.financeiro.DaoMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.consulta.financeiro.ViewConsultaMovimentacao
 */
public class ControllerViewConsultaMovimentacao extends ControllerViewConsulta {
    private final DaoMovimentacao dao;
    private List<Movimentacao> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Movimentacao.
     */
    public ControllerViewConsultaMovimentacao(ViewConsultaMovimentacao view) {
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
        String tipo      = getValor(getFiltro().getComboBoxTipo());
        Date   inicio    = getData(getFiltro().getTextFieldInicio());
        Date   final_    = getData(getFiltro().getTextFieldFinal());
        String descricao = getString(getFiltro().getTextFieldDescricao()).toUpperCase();
               list      = dao.filter(tipo, descricao, inicio, final_);
    }
    
    @Override
    public void novo() {
        System.out.println("New");
        //new ViewNovoFuncionario(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            System.out.println("Edit");
        else
            new ViewErro(getView(), "Selecione uma Movimentação!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            System.out.println("Delete");
            //new ViewExcluirFuncionario(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione uma Movimentação!").setVisible(true);
    }
    
    @Override
    public ControllerMovimentacao getController() {
        return new ControllerMovimentacao();
    }
    
    @Override
    public PanelFiltroMovimentacao getFiltro() {
        return (PanelFiltroMovimentacao) super.getFiltro();
    }
    
    @Override
    public ViewConsultaMovimentacao getView() {
        return (ViewConsultaMovimentacao) view;
    }
}