package controlador.visao.modal.novo.rebanho;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.event.ActionEvent;
import modelo.dao.rebanho.DaoInseminacao;
import modelo.entidade.rebanho.Inseminacao;
import visao.modal.mensagem.ViewMensagem;
import visao.modal.novo.rebanho.ViewNovoInseminacao;
import visao.modal.novo.rebanho.inseminacao.ViewNovoMatriz;
import visao.painel.base.rebanho.PanelBaseInseminacao;
import visao.painel.base.rebanho.inseminacao.PanelBaseMatrizes;
import visao.painel.novo.rebanho.PanelNovoInseminacao;

/**
 * <p>Classe de Controle <b>ControllerViewNovoInseminacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoInseminacao.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.dao.rebanho.DaoInseminacao
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.modal.novo.rebanho.ViewNovoInseminacao
 */
public class ControllerViewNovoInseminacao extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Inseminacao.
     */
    public ControllerViewNovoInseminacao(ViewNovoInseminacao view) {
        super(view);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getMatrizes().getButtonAdicionar().equals(event.getSource()))
            addMatriz();
        else if (getMatrizes().getButtonEditar().equals(event.getSource()))
            System.out.println("Edit");
        else if (getMatrizes().getButtonExcluir().equals(event.getSource()))
            System.out.println("Del");
    }
    
    /**
     * Metodo responsavel por adicionar uma Nova Matriz para Inseminacao.
     */
    private void addMatriz() {
        new ViewNovoMatriz(view).setVisible(true);
    }
    
    /**
     * Metodo responsavel por validar o Ano da Inseminacao.
     * @return Ano da Inseminacao e valida.
     */
    public boolean checkAno() {
        return checkAno(getPanelBase().getTextFieldAno(), "Ano Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Implante.
     * @return Data de Implante e valida.
     */
    public boolean checkImplante() {
        return checkData(getPanelBase().getTextFieldImplante(), "Data de Implante Inválida!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Hormonio.
     * @return Data de Hormonio e valida.
     */
    public boolean checkHormonio() {
        return checkData(getPanelBase().getTextFieldHormonio(), "Data de Hormônio Inválida!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Inseminacao.
     * @return Data de Inseminacao e valida.
     */
    public boolean checkInseminacao() {
        return checkData(getPanelBase().getTextFieldInseminacao(), "Data de Inseminação Inválida!");
    }
    
    @Override
    public boolean check() {
        return checkAno()
            && checkImplante()
            && checkHormonio()
            && checkInseminacao();
    }
    
    @Override
    public void inserir() {
        Inseminacao inseminacao = new Inseminacao();
                    inseminacao.setAno(getInteger(getPanelBase().getTextFieldAno()));
                    inseminacao.setDataImplante(getData(getPanelBase().getTextFieldImplante()));
                    inseminacao.setDataHormonio(getData(getPanelBase().getTextFieldHormonio()));
                    inseminacao.setDataInseminacao(getData(getPanelBase().getTextFieldInseminacao()));
        new DaoInseminacao().insert(inseminacao);
        new ViewMensagem(getView(), "Inseminação cadastrada com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    public PanelBaseMatrizes getMatrizes() {
        return getPanelNovo().getPanelBaseMatrizes();
    }
    
    public PanelBaseInseminacao getPanelBase() {
        return getPanelNovo().getPanelBaseInseminacao();
    }
    
    @Override
    public PanelNovoInseminacao getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoInseminacao getView() {
        return (ViewNovoInseminacao) view;
    }
}