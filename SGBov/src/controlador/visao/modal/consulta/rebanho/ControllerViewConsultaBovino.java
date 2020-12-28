package controlador.visao.modal.consulta.rebanho;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import modelo.controlador.rebanho.ControllerBovino;
import modelo.dao.rebanho.DaoBovino;
import modelo.entidade.rebanho.Bovino;
import visao.modal.consulta.rebanho.ViewConsultaBovino;
import visao.modal.editar.rebanho.ViewEditarBovino;
import visao.modal.excluir.rebanho.ViewExcluirBovino;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.rebanho.ViewNovoBovino;
import visao.painel.consulta.filtro.rebanho.PanelFiltroBovino;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaBovino.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.controlador.rebanho.ControllerBovino
 * @see    modelo.dao.rebanho.DaoBovino
 * @see    modelo.entidades.estruturais.Bovino
 * @see    visao.consulta.ViewConsultaBovino
 */
public class ControllerViewConsultaBovino extends ControllerViewConsulta {
    private final DaoBovino dao;
    private List<Bovino> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Bovino.
     */
    public ControllerViewConsultaBovino(ViewConsultaBovino view) {
        super(view);
        dao  = new DaoBovino();
        list = new ArrayList<>();
    }

    @Override
    public void update() {
        pesquisar();
        getView().addRows("consulta", getController().getMatriz(list));
        getView().setCount(list.size());
    }
    
    @Override
    public void pesquisar() {
        String  tipo   = getString(getFiltro().getComboBoxTipo()).replaceAll("Selecione", "");
        Date    inicio = getData(getFiltro().getTextFieldInicio());
        Date    fim    = getData(getFiltro().getTextFieldFinal());
        char    sexo   = getSexo();
        Integer numero = getInteger(getFiltro().getSpinnerNumero());
        boolean ativo  = getFiltro().getCheckBoxAtivo().isSelected();
                list   = dao.filter(tipo, sexo, ativo);
    }
    
    @Override
    protected Date getData(JTextField textField) {
        if (!checkData(textField, "Data Inválida!"))
            return new Date();
        return super.getData(textField);
    }
    
    /**
     * Metodo responsavel por retornar o Char do Sexo do Bovino.
     * @return Char do Sexo do Bovino.
     */
    private char getSexo() {
        return getFiltro().getComboBoxSexo().getSelectedIndex() == 0 ? 'M' : 'F';
    }
    
    @Override
    public void novo() {
        new ViewNovoBovino(getView()).setVisible(true);
    }

    @Override
    public void editar() {
        Integer indice  = getView().getTable().getSelectedRow();
        Integer tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewEditarBovino(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Bovino!").setVisible(true);
    }

    @Override
    public void excluir() {
        Integer indice  = getView().getTable().getSelectedRow();
        Integer tamanho = list.size();
        if (indice >= 0 && indice < tamanho)
            new ViewExcluirBovino(getView(), list.get(indice)).setVisible(true);
        else
            new ViewErro(getView(), "Selecione um Bovino!").setVisible(true);
    }
    
    @Override
    public ControllerBovino getController() {
        return new ControllerBovino();
    }
    
    @Override
    public PanelFiltroBovino getFiltro() {
        return (PanelFiltroBovino) super.getFiltro();
    }
    
    @Override
    public ViewConsultaBovino getView() {
        return (ViewConsultaBovino) view;
    }
}