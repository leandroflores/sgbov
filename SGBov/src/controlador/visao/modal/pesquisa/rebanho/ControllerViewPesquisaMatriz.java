package controlador.visao.modal.pesquisa.rebanho;

import controlador.visao.modal.pesquisa.ControllerViewPesquisa;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.controlador.rebanho.ControllerBovino;
import modelo.dao.rebanho.DaoBovino;
import modelo.entidade.rebanho.Bovino;
import visao.modal.mensagem.ViewErro;
import visao.modal.pesquisa.rebanho.ViewPesquisaMatriz;

/**
 * <p>Classe de Controle <b>ControllerViewPesquisaMatriz</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewPesquisaMatriz.</p>
 * @author Leandro
 * @since  30/12/2020
 * @see    controlador.visao.modal.pesquisa.ControllerViewPesquisa
 * @see    modelo.controlador.rebanho.ControllerBovino
 * @see    modelo.dao.rebanho.DaoBovino
 * @see    modelo.entidades.estruturais.Bovino
 * @see    visao.modal.pesquisa.rebanho.ViewPesquisaMatriz
 */
public class ControllerViewPesquisaMatriz extends ControllerViewPesquisa {
    private final DaoBovino dao;
    private List<Bovino> list;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa Matriz.
     */
    public ControllerViewPesquisaMatriz(ViewPesquisaMatriz view) {
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
        String  tipo   = "MATRIZ";
        char    sexo   = 'F';
        Integer numero = getInteger(getView().getPanelPesquisa().getSpinnerNumero());
        boolean ativo  = getView().getPanelPesquisa().getCheckBoxAtivo().isSelected();
                list   = numero.equals(0) ? 
                         dao.filter(tipo, sexo, ativo) : 
                         dao.filter(tipo, sexo, numero, ativo);
    }
    
    @Override
    public void selecionar() {
        Integer indice  = getView().getTable().getSelectedRow();
        Integer tamanho = list.size();
        if (indice >= 0 && indice < tamanho) {
            getView().getView().setValue(list.get(indice));
            getView().dispose();
        }else {
            new ViewErro(getView(), "Selecione uma Matriz!").setVisible(true);
        }
    }

    @Override
    public ControllerBovino getController() {
        return new ControllerBovino();
    }
    
    @Override
    public ViewPesquisaMatriz getView() {
        return (ViewPesquisaMatriz) view;
    }
}