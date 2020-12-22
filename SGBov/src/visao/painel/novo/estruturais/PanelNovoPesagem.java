package visao.painel.novo.estruturais;

import funct.FunctDate;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import modelo.entidade.estruturais.Bovino;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoPesagem</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoPesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  22/12/2020
 * @see    controlador.visao.painel.novo.estruturais.
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoPesagem extends PanelNovo {
    private Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoPesagem(ViewNovo view) {
        super(view);
        //controller = new ControllerPanelNovoBovino(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        //setLayout(new GridLayout(6, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createLabel("Número*: ", 120));
        add(createSpinnerEditable("numero"));
        getSpinnerNumero().addChangeListener(controller);
        add(createTextFieldNoEditable("bovino", "", 20));
        add(createButton("pesquisa", "", "pesquisa"));
        
        add(createLabel("Data Pesagem*: ", 120));
        add(createDateTextField("data_pesagem", new Date()));
        
        add(createLabel("Valor Pesagem*: ", 120));
        add(this.createDecimalTextField("valor", 0.0f, 7));
    }
    
    @Override
    public void clear() {
        getComboBoxTipo().setSelectedIndex(0);
        getSpinnerNumero().setValue(1);
        getRadioButtonMacho().setSelected(true);
        getRadioButtonFemea().setSelected(false);
        getTextFieldPeso().setText("0,00");
        getTextFieldDataNascimento().setText(new FunctDate().getFormattedDate(new Date()));
        
        getRadioButtonMacho().setEnabled(true);
        getRadioButtonFemea().setEnabled(true);
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