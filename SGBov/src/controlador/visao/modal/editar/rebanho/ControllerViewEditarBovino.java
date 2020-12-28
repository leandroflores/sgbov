package controlador.visao.modal.editar.rebanho;

import controlador.visao.modal.editar.ControllerViewEditar;
import java.awt.event.ActionEvent;
import modelo.dao.rebanho.DaoBovino;
import modelo.entidade.rebanho.Bovino;
import visao.modal.editar.rebanho.ViewEditarBovino;
import visao.modal.mensagem.ViewMensagem;
import visao.painel.editar.rebanho.PanelEditarBovino;

/**
 * <p>Classe de Controle <b>ControllerViewEditarBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewEditarBovino.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.modal.editar.ControllerViewEditar
 * @see    modelo.entidade.rebanho.Bovino
 * @see    visao.modal.editar.rebanho.ViewEditarBovino
 */
public class ControllerViewEditarBovino extends ControllerViewEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Bovino.
     */
    public ControllerViewEditarBovino(ViewEditarBovino view) {
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
        return checkPeso()
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
    public void salvar() {
        Bovino bovino = getView().getBovino();
               bovino.setTipo(getValor(getPanel().getComboBoxTipo()));
               bovino.setNumero(getInteger(getPanel().getSpinnerNumero()));
               bovino.setSexo(getSexo());
               bovino.setPeso(getFloat(getPanel().getTextFieldPeso()));
               bovino.setNascimento(getData(getPanel().getTextFieldDataNascimento()));
        new DaoBovino().update(bovino);
        new ViewMensagem(getView(), "Bovino atualizado com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelEditarBovino getPanel() {
        return getView().getPanelEditar();
    }
    
    @Override
    public ViewEditarBovino getView() {
        return (ViewEditarBovino) view;
    }
}