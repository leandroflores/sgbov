package visao.painel.novo.estruturais;

import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import modelo.controlador.estruturais.ControllerBovino;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoBovino</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoBovino</b> do SGBov.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoBovino extends PanelNovo {
    
    /**
     * Default constructor method of Class.
     * @param view View New Instance.
     */
    public PanelNovoBovino(ViewNovo view) {
        super(view);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        setLayout(new GridLayout(6, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Tipo*: "));
        add(createComboBox("tipo", ControllerBovino.TIPOS, 30));
        
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
    public void clear() {
        getComboBoxTipo().setSelectedIndex(0);
        getSpinnerNumero().setValue(1);
        getRadioButtonMacho().setSelected(true);
        getRadioButtonFemea().setSelected(false);
        getTextFieldPeso().setText("0,00");
        getTextFieldDataNascimento().setText(new FunctDate().getFormattedDate(new Date()));
        getComboBoxTipo().requestFocus();
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