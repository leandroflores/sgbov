package controlador.visao.modal.consulta.administrativo;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.administrativo.ControllerFuncionario;
import modelo.dao.administrativo.DaoFuncionario;
import modelo.entidade.administrativo.Funcionario;
import visao.modal.consulta.administrativo.ViewConsultaFuncionario;
import visao.modal.editar.administrativo.ViewEditarFuncionario;
import visao.modal.excluir.administrativo.ViewExcluirFuncionario;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.administrativo.ViewNovoFuncionario;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaFuncionario</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaFuncionario.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.dao.administrativo.DaoFuncionario
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.modal.consulta.administrativo.ViewConsultaFuncionario
 */
public class ControllerViewConsultaFuncionario extends ControllerViewConsulta {
    private final DaoFuncionario dao;
    private List<Funcionario> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Funcionario.
     */
    public ControllerViewConsultaFuncionario(ViewConsultaFuncionario view) {
        super(view);
        dao  = new DaoFuncionario();
        list = new ArrayList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getView().getPanelFiltro().getButtonAtualizar().equals(event.getSource()))
            update();
    }
    
    @Override
    public void update() {
        pesquisar();
        getView().addRows("consulta", getController().getMatriz(list));
        getView().setCount(list.size());
    }
    
    @Override
    public void pesquisar() {
        String cpf  = getStringSimples(getView().getPanelFiltro().getTextFieldCPF());
        String nome = getString(getView().getPanelFiltro().getTextFieldNome()).toUpperCase();
               list = dao.filter(cpf, nome);
    }
    
    @Override
    public void novo() {
        new ViewNovoFuncionario(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewEditarFuncionario(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Funcionário!").setVisible(true);
    }

    @Override
    public void excluir() {
        int indice  = getView().getTable().getSelectedRow();
        int tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewExcluirFuncionario(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Funcionário!").setVisible(true);
    }
    
    @Override
    public ControllerFuncionario getController() {
        return new ControllerFuncionario();
    }
    
    @Override
    public ViewConsultaFuncionario getView() {
        return (ViewConsultaFuncionario) view;
    }
}