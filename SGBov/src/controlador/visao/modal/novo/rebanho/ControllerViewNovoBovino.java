package controlador.visao.modal.novo.rebanho;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.event.ActionEvent;
import modelo.dao.rebanho.DaoBovino;
import modelo.entidade.rebanho.Bovino;
import visao.modal.mensagem.ViewMensagem;
import visao.modal.novo.rebanho.ViewNovoBovino;
import visao.painel.novo.rebanho.PanelNovoBovino;

/**
 * <p>Classe de Controle <b>ControllerViewNovoBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoBovino.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.entidade.rebanho.Bovino
 * @see    visao.modal.novo.rebanho.ViewNovoBovino
 */
public class ControllerViewNovoBovino extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Bovino.
     */
    public ControllerViewNovoBovino(ViewNovoBovino view) {
        super(view);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanelNovo().getRadioButtonMacho().equals(event.getSource())) {
            getPanelNovo().getRadioButtonMacho().setSelected(true);
            getPanelNovo().getRadioButtonFemea().setSelected(false);
        }else if (getPanelNovo().getRadioButtonFemea().equals(event.getSource())) {
            getPanelNovo().getRadioButtonMacho().setSelected(false);
            getPanelNovo().getRadioButtonFemea().setSelected(true);
        }
    }
    
    /**
     * Metodo responsavel por validar o Tipo do Bovino.
     * @return Tipo do Bovino e valido.
     */
    public boolean checkTipo() {
        return check(getPanelNovo().getComboBoxTipo(), "Selecione um Tipo!");
    }
    
    /**
     * Metodo responsavel por validar o Peso do Bovino.
     * @return Peso do Bovino e valido.
     */
    public boolean checkPeso() {
        return checkValor(getPanelNovo().getTextFieldPeso(), "Peso Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Nascimento do Bovino.
     * @return Data de Nascimento do Bovino e valida.
     */
    public boolean checkDataNascimento() {
        return checkData(getPanelNovo().getTextFieldDataNascimento(), "Data Inválida!");
    }
    
    @Override
    public boolean check() {
        return checkTipo()
            && checkPeso()
            && checkDataNascimento();
    }
    
    /**
     * Metodo responsavel por retornar o Sexo do Bovino.
     * @return Sexo do Bovino.
     */
    private char getSexo() {
        return getPanelNovo().getRadioButtonMacho().isSelected() ? 'M' : 'F';
    }
    
    @Override
    public void inserir() {
        Bovino bovino = new Bovino();
               bovino.setTipo(getValor(getPanelNovo().getComboBoxTipo()));
               bovino.setNumero(getInteger(getPanelNovo().getSpinnerNumero()));
               bovino.setSexo(getSexo());
               bovino.setPeso(getFloat(getPanelNovo().getTextFieldPeso()));
               bovino.setNascimento(getData(getPanelNovo().getTextFieldDataNascimento()));
        new DaoBovino().insert(bovino);
        new ViewMensagem(getView(), "Bovino cadastrado com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelNovoBovino getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoBovino getView() {
        return (ViewNovoBovino) view;
    }
}