package visao.painel.editar.rebanho;

import controlador.visao.painel.editar.rebanho.ControllerPanelEditarBovino;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import modelo.entidade.rebanho.Bovino;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>PanelEditarBovino</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewEditarBovino</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.painel.editar.rebanho.ControllerPanelEditarBovino
 * @see    modelo.entidade.rebanho.Bovino
 * @see    visao.painel.editar.PanelEditar
 */
public final class PanelEditarBovino extends PanelEditar {
    private final Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Bovino.
     * @param bovino_ Bovino.
     */
    public PanelEditarBovino(ViewEditar view, Bovino bovino_) {
        super(view);
        bovino     = bovino_;
        controller = new ControllerPanelEditarBovino(this);
        setProperties();
        addComponents();
        setValues();
        getController().setReady();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        setLayout(new GridLayout(7, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Identificador: "));
        add(this.createTextFieldNoEditable("identificador", "", 5));
        
        add(createRightLabel("Tipo*: "));
        add(createComboBox("tipo", getTipos(), 30));
        
        add(createRightLabel("Número*: "));
        add(createSpinnerEditable("numero"));
        
        add(createRightLabel("Sexo*: "));
        add(createRadioButton("macho", "Macho"));
        add(createRightLabel(""));
        add(createRadioButton("femea", "Fêmea"));
        
        add(createRightLabel("Peso (kg)*: "));
        add(createDecimalTextField("peso", 0.0f, 10));
        
        add(createRightLabel("Data Nascimento*: "));
        add(createDateTextField("data_nascimento", new Date()));
    }
    
    @Override
    public void setValues() {
        getTextFieldIdentificador().setText(Long.toString(bovino.getId()));
        getComboBoxTipo().setSelectedItem(bovino.getTipo());
        getSpinnerNumero().setValue(bovino.getNumero());
        getRadioButtonMacho().setSelected(bovino.isMacho());
        getRadioButtonFemea().setSelected(bovino.isFemea());
        getTextFieldPeso().setText(bovino.getPesoFormatado());
        getTextFieldDataNascimento().setText(bovino.getDataNascimentoFormatada());
        
        getComboBoxTipo().requestFocus();
    }
    
    /**
     * Metodo responsavel por retornar os Tipos de Bovino.
     * @return Tipos de Bovino.
     */
    public String[] getTipos() {
        return new String[]{"BEZERRO", "NOVILHA", "MATRIZ", "TOURO"};
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Identificador.
     * @return Text Field Identificador.
     */
    public JTextField getTextFieldIdentificador() {
        return getTextField("identificador");
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Combo Box Tipo.
     */
    public JComboBox getComboBoxTipo() {
        return getComboBox("tipo");
    }
    
    /**
     * Metodo responsavel por retornar o Spinner Numero.
     * @return Spinner Numero.
     */
    public JSpinner getSpinnerNumero() {
        return getSpinner("numero");
    }
    
    /**
     * Metodo responsavel por retornar o Radio Button Macho.
     * @return Radio Button Macho.
     */
    public JRadioButton getRadioButtonMacho() {
        return getRadioButton("macho");
    }
    
    /**
     * Metodo responsavel por retornar o Radio Button Femea.
     * @return Radio Button Femea.
     */
    public JRadioButton getRadioButtonFemea() {
        return getRadioButton("femea");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Peso.
     * @return Text Field Peso.
     */
    public JTextField getTextFieldPeso() {
        return getTextField("peso");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Data Nascimento.
     * @return Text Field Data Nascimento.
     */
    public JTextField getTextFieldDataNascimento() {
        return getTextField("data_nascimento");
    }
}