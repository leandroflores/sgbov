package controlador.visao.modal.consulta.estruturais;

import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import modelo.controlador.estruturais.ControllerBovino;
import modelo.dao.estruturais.DaoBovino;
import modelo.entidade.estruturais.Bovino;
import visao.modal.consulta.estruturais.ViewConsultaBovino;
import visao.modal.editar.estruturais.ViewEditarBovino;
import visao.modal.excluir.estruturais.ViewExcluirBovino;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.estruturais.ViewNovoBovino;

/**
 * <p>Classe de Controle <b>ControllerViewConsultaBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsultaBovino.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    modelo.controlador.estruturais.ControllerBovino
 * @see    modelo.dao.estruturais.DaoBovino
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
    public void pesquisar() {
        atualizarLista();
        getView().addRows("consulta", getController().getMatriz(list));
        getView().setTotal(this.list.size());
    }
    
    /**
     * Metodo responsavel por atualizar a Lista de Bovinos.
     */
    private void atualizarLista() {
        String  tipo   = getString(getView().getComboBoxTipo()).replaceAll("Selecione", "");
        Date    inicio = getData(getView().getTextFieldDataInicio());
        Date    fim    = getData(getView().getTextFieldDataFinal());
        char    sexo   = getSexo();
        Integer numero = getInteger(getView().getSpinnerNumero());
        boolean ativo  = getView().getCheckBoxAtivo().isSelected();
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
        return getView().getComboBoxSexo().getSelectedIndex() == 0 ? 'M' : 'F';
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
    public ViewConsultaBovino getView() {
        return (ViewConsultaBovino) view;
    }
}