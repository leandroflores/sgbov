package controlador.visao.modal.consulta.rebanho;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import modelo.controlador.rebanho.ControllerInseminacao;
import modelo.dao.rebanho.DaoInseminacao;
import modelo.entidade.rebanho.Inseminacao;
import visao.modal.consulta.rebanho.ViewConsultaInseminacao;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.rebanho.ViewNovoInseminacao;
import visao.painel.consulta.filtro.rebanho.PanelFiltroInseminacao;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaInseminacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaInseminacao.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.rebanho.DaoInseminacao
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.modal.consulta.rebanho.ViewConsultaInseminacao
 */
public class ControllerViewConsultaInseminacao extends ControllerViewConsulta {
    private final DaoInseminacao dao;
    private List<Inseminacao> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Inseminacao.
     */
    public ControllerViewConsultaInseminacao(ViewConsultaInseminacao view) {
        super(view);
        dao  = new DaoInseminacao();
        list = new ArrayList<>();
    }
    
    @Override
    public void update() {
        pesquisar();
        getView().addRows("consulta", getController().getMatriz(list));
        getView().setCount(this.list.size());
    }
    
    @Override
    public void pesquisar() {
        Integer ano    = getInteger(getFiltro().getTextFieldAno());
        Date    inicio = getData(getFiltro().getTextFieldInicio());
        Date    final_ = getData(getFiltro().getTextFieldFinal());
                list   = dao.filter(ano, inicio, final_);
    }
    
    @Override
    protected Date getData(JTextField textField) {
        if (!checkData(textField, "Data Inválida!"))
            return new Date();
        return super.getData(textField);
    }
    
    @Override
    public void novo() {
        new ViewNovoInseminacao(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            System.out.println("Editar Inseminacao");
            //new ViewEditarInseminacao(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione uma Inseminação!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            System.out.println("Exluir Inseminacao");
            //new ViewExcluirInseminacao(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione uma Inseminação!").setVisible(true);
    }
    
    @Override
    public ControllerInseminacao getController() {
        return new ControllerInseminacao();
    }
    
    @Override
    public PanelFiltroInseminacao getFiltro() {
        return (PanelFiltroInseminacao) super.getFiltro();
    }
    
    @Override
    public ViewConsultaInseminacao getView() {
        return (ViewConsultaInseminacao) view;
    }
}