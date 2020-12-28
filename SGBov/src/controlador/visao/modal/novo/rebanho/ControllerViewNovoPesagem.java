package controlador.visao.modal.novo.rebanho;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.event.ActionEvent;
import modelo.dao.rebanho.DaoPesagem;
import modelo.entidade.rebanho.Bovino;
import modelo.entidade.rebanho.Pesagem;
import visao.modal.mensagem.ViewErro;
import visao.modal.mensagem.ViewMensagem;
import visao.modal.novo.rebanho.ViewNovoPesagem;
import visao.modal.pesquisa.rebanho.ViewPesquisaBovino;
import visao.painel.novo.rebanho.PanelNovoPesagem;

/**
 * <p>Classe de Controle <b>ControllerViewNovoPesagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoPesagem.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.entidade.rebanho.Pesagem
 * @see    visao.modal.novo.rebanho.ViewNovoPesagem
 */
public class ControllerViewNovoPesagem extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Pesagem.
     */
    public ControllerViewNovoPesagem(ViewNovoPesagem view) {
        super(view);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanelNovo().getButtonPesquisa().equals(event.getSource()))
            new ViewPesquisaBovino(getView()).setVisible(true);
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
    
    /**
     * Metodo responsavel por validar a Data da Pesagem.
     * @return Data da Pesagem e valida.
     */
    public boolean checkData() {
        return checkData(getPanelNovo().getTextFieldData(), "Data Inválida!");
    }
    
    /**
     * Metodo responsavel por validar o Peso.
     * @return Peso e valido.
     */
    public boolean checkPeso() {
        return checkValor(getPanelNovo().getTextFieldPeso(), "Peso Inválido!");
    }
    
    @Override
    public boolean check() {
        return checkBovino()
            && checkData()
            && checkPeso();
    }
    
    @Override
    public void inserir() {
        Bovino  bovino  = getView().getBovino();
        Pesagem pesagem = new Pesagem();
                pesagem.setBovino(bovino);
                pesagem.setDataPesagem(getData(getPanelNovo().getTextFieldData()));
                pesagem.setValor(getFloat(getPanelNovo().getTextFieldPeso()));
        new DaoPesagem().insert(pesagem);
        new ViewMensagem(getView(), "Pesagem cadastrada com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelNovoPesagem getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoPesagem getView() {
        return (ViewNovoPesagem) view;
    }
}