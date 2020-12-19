package controlador.visao.modal.novo.estruturais;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.event.ActionEvent;
import modelo.dao.estruturais.DaoBovino;
import modelo.entidade.estruturais.Bovino;
import visao.modal.mensagem.ViewMensagem;
import visao.modal.novo.estruturais.ViewNovoBovino;
import visao.painel.novo.estruturais.PanelNovoBovino;

/**
 * <p>Classe de Controle <b>ControllerViewNovoBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoBovino.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.modal.novo.estruturais.ViewNovoBovino
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
        if (getPanel().getRadioButtonMacho().equals(event.getSource())) {
            getPanel().getRadioButtonMacho().setSelected(true);
            getPanel().getRadioButtonFemea().setSelected(false);
        }else if (getPanel().getRadioButtonFemea().equals(event.getSource())) {
            getPanel().getRadioButtonMacho().setSelected(false);
            getPanel().getRadioButtonFemea().setSelected(true);
        }
    }
    
    /**
     * Metodo responsavel por validar o Tipo do Bovino.
     * @return Tipo do Bovino e valido.
     */
    public boolean checkTipo() {
        return check(getPanel().getComboBoxTipo(), "Selecione um Tipo!");
    }
    
    /**
     * Metodo responsavel por validar o Peso do Bovino.
     * @return Peso do Bovino e valido.
     */
    public boolean checkPeso() {
        return checkValor(getPanel().getTextFieldPeso(), "Peso Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Nascimento do Bovino.
     * @return Data de Nascimento do Bovino e valida.
     */
    public boolean checkDataNascimento() {
        return checkData(getPanel().getTextFieldDataNascimento(), "Data Inválida!");
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
        return getPanel().getRadioButtonMacho().isSelected() ? 'M' : 'F';
    }
    
    @Override
    public void inserir() {
        Bovino bovino = new Bovino();
               bovino.setTipo(getValor(getPanel().getComboBoxTipo()));
               bovino.setNumero(getInteger(getPanel().getSpinnerNumero()));
               bovino.setSexo(getSexo());
               bovino.setPeso(getFloat(getPanel().getTextFieldPeso()));
               bovino.setNascimento(getData(getPanel().getTextFieldDataNascimento()));
        new DaoBovino().insert(bovino);
        new ViewMensagem(getView(), "Bovino cadastrado com Sucesso!").setVisible(true);
        //this.viewCadastroBovino.getView().atualizar();
        getView().dispose();
    }
    
    public PanelNovoBovino getPanel() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoBovino getView() {
        return (ViewNovoBovino) view;
    }
}