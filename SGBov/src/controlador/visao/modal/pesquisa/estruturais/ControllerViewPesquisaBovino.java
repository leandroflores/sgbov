package controlador.visao.modal.pesquisa.estruturais;

import controlador.visao.modal.pesquisa.ControllerViewPesquisa;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.estruturais.ControllerBovino;
import modelo.dao.estruturais.DaoBovino;
import modelo.entidade.estruturais.Bovino;
import visao.modal.mensagem.ViewErro;
import visao.modal.pesquisa.estruturais.ViewPesquisaBovino;

/**
 * <p>Classe de Controle <b>ControllerViewPesquisaBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewPesquisaBovino.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.pesquisa.ControllerViewPesquisa
 * @see    modelo.controlador.estruturais.ControllerBovino
 * @see    modelo.dao.estruturais.DaoBovino
 * @see    modelo.entidades.estruturais.Bovino
 * @see    visao.modal.pesquisa.estruturais.ViewPesquisaBovino
 */
public class ControllerViewPesquisaBovino extends ControllerViewPesquisa {
    private final DaoBovino dao;
    private List<Bovino> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa Bovino.
     */
    public ControllerViewPesquisaBovino(ViewPesquisaBovino view) {
        super(view);
        dao  = new DaoBovino();
        list = new ArrayList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getView().getPanelPesquisa().getButtonAtualizar().equals(event.getSource()))
            update();
    }

    @Override
    public void update() {
        pesquisar();
        getView().addRows("pesquisa", getController().getDadosPesquisa(list));
    }
    
    @Override
    public void pesquisar() {
        String  tipo   = getString(getView().getPanelPesquisa().getComboBoxTipo());
        char    sexo   = getSexo();
        Integer numero = getInteger(getView().getPanelPesquisa().getSpinnerNumero());
        boolean ativo  = getView().getPanelPesquisa().getCheckBoxAtivo().isSelected();
                list   = numero.equals(0) ? 
                         dao.filter(tipo, sexo, ativo) : 
                         dao.filter(tipo, sexo, numero, ativo);
    }
    
    /**
     * Metodo responsavel por retornar o Char do Sexo do Bovino.
     * @return Char do Sexo do Bovino.
     */
    private char getSexo() {
        return getView().getPanelPesquisa().getComboBoxSexo().getSelectedIndex() == 0 ? 'M' : 'F';
    }
    
    @Override
    public void selecionar() {
        Integer indice  = getView().getTable().getSelectedRow();
        Integer tamanho = list.size();
        if (indice >= 0 && indice < tamanho) {
            getView().getView().setValue(list.get(indice));
            getView().dispose();
        }else {
            new ViewErro(getView(), "Selecione um Bovino!").setVisible(true);
        }
    }

    @Override
    public ControllerBovino getController() {
        return new ControllerBovino();
    }
    
    @Override
    public ViewPesquisaBovino getView() {
        return (ViewPesquisaBovino) view;
    }
}