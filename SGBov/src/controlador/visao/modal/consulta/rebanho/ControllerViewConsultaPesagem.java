package controlador.visao.modal.consulta.rebanho;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import modelo.controlador.rebanho.ControllerPesagem;
import modelo.dao.rebanho.DaoPesagem;
import modelo.entidade.rebanho.Pesagem;
import visao.modal.consulta.rebanho.ViewConsultaPesagem;
import visao.modal.editar.rebanho.ViewEditarPesagem;
import visao.modal.excluir.rebanho.ViewExcluirPesagem;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.rebanho.ViewNovoPesagem;
import visao.painel.consulta.filtro.rebanho.PanelFiltroPesagem;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaPesagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaPesagem.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.rebanho.DaoPesagem
 * @see    modelo.entidade.rebanho.Pesagem
 * @see    visao.modal.consulta.rebanho.ViewConsultaPesagem
 */
public class ControllerViewConsultaPesagem extends ControllerViewConsulta {
    private final DaoPesagem dao;
    private List<Pesagem> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Pesagem.
     */
    public ControllerViewConsultaPesagem(ViewConsultaPesagem view) {
        super(view);
        dao  = new DaoPesagem();
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
        Date    inicio = getData(getFiltro().getTextFieldInicio());
        Date    final_ = getData(getFiltro().getTextFieldFinal());
        boolean bovino = getFiltro().getCheckBoxBovino().isSelected();
        Integer numero = getInteger(getFiltro().getSpinnerNumero());
                list   = bovino ? 
                         dao.filter(numero, inicio, final_) : 
                         dao.filter(inicio, final_);
    }
    
    @Override
    protected Date getData(JTextField textField) {
        if (!checkData(textField, "Data Inválida!"))
            return new Date();
        return super.getData(textField);
    }
    
    @Override
    public void novo() {
        new ViewNovoPesagem(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewEditarPesagem(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione uma Pesagem!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewExcluirPesagem(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Bovino!").setVisible(true);
    }
    
    @Override
    public ControllerPesagem getController() {
        return new ControllerPesagem();
    }
    
    @Override
    public PanelFiltroPesagem getFiltro() {
        return (PanelFiltroPesagem) super.getFiltro();
    }
    
    @Override
    public ViewConsultaPesagem getView() {
        return (ViewConsultaPesagem) view;
    }
}