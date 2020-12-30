package controlador.visao.modal.novo.rebanho.inseminacao;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.event.ActionEvent;
import modelo.entidade.rebanho.inseminacao.Matriz;
import visao.modal.mensagem.ViewErro;
import visao.modal.novo.rebanho.inseminacao.ViewNovoMatriz;
import visao.modal.pesquisa.rebanho.ViewPesquisaMatriz;
import visao.painel.base.rebanho.inseminacao.PanelBaseMatriz;
import visao.painel.novo.rebanho.inseminacao.PanelNovoMatriz;

/**
 * <p>Classe de Controle <b>ControllerViewNovoMatriz</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoMatriz.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.modal.novo.rebanho.inseminacao.ViewNovoMatriz
 */
public class ControllerViewNovoMatriz extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Matriz.
     */
    public ControllerViewNovoMatriz(ViewNovoMatriz view) {
        super(view);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanelBase().getButtonPesquisa().equals(event.getSource()))
            new ViewPesquisaMatriz(getView()).setVisible(true);
    }
    
    /**
     * Metodo responsavel por validar o Bovino.
     * @return Bovino e valido.
     */
    public boolean checkBovino() {
        if (getView().getBovino() == null) {
            new ViewErro(getView(), "Selecione um Bovino!").setVisible(true);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean check() {
        return checkBovino();
    }
    
    @Override
    public void inserir() {
        Matriz matriz = new Matriz();
               matriz.setBovino(getView().getBovino());
               matriz.setImplante(getPanelBase().getCheckBoxImplante().isSelected());
               matriz.setHormonio(getPanelBase().getCheckBoxHormonio().isSelected());
               matriz.setSemen(getPanelBase().getCheckBoxInseminacao().isSelected());
               matriz.setPrenha(getPanelBase().getCheckBoxPrenha().isSelected());
        getView().getView().getPanelNovo().addMatriz(matriz);
        getView().getView().update();
        getView().dispose();
    }
    
    public PanelBaseMatriz getPanelBase() {
        return getPanelNovo().getPanelBaseMatriz();
    }
    
    @Override
    public PanelNovoMatriz getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoMatriz getView() {
        return (ViewNovoMatriz) view;
    }
}