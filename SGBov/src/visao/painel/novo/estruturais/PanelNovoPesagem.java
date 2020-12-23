package visao.painel.novo.estruturais;

import funct.FunctDate;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JButton;
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
        //setMinimumSize(new Dimension(350, 300));
        //setMaximumSize(new Dimension(350, 300));
        setLayout(new GridLayout(3, 3, 1, 1));
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
        getSpinnerNumero().setValue(0);
        
        getTextFieldDataPesagem().setText(new FunctDate().getFormattedDate(new Date()));
        getTextFieldValor().setText(new DecimalFormat("#,##0.00").format(0.00f));
        
        getSpinnerNumero().requestFocus();
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
    
    /**
     * Metodo responsavel por preencher os campos do Bovino.
     */
    public void setDadosBovino() {
        getTextFieldBovino().setText(bovino == null ? "" : bovino.toString());
    }
    
    /**
     * Metodo responsavel por definir o Bovino.
     * @param bovino_ Bovino.
     */
    public void setBovino(Bovino bovino_) {
        bovino = bovino_;
        setDadosBovino();
    }
    
    /**
     * Metodo responsavel por retornar o Spinner Numero.
     * @return Spinner Numero.
     */
    public JSpinner getSpinnerNumero() {
        return getSpinner("numero");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Bovino.
     * @return Text Field Bovino.
     */
    public JTextField getTextFieldBovino() {
        return getTextField("bovino");
    }
    
    /**
     * Metodo responsavel por retornar o Button Pesquisa.
     * @return Button Pesquisa.
     */
    public JButton getButtonPesquisa() {
        return getButton("pesquisa");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Data Pesagem.
     * @return Text Field Data Pesagem.
     */
    public JTextField getTextFieldDataPesagem() {
        return getTextField("data_pesagem");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Valor Pesagem.
     * @return Text Field Valor Pesagem.
     */
    public JTextField getTextFieldValor() {
        return getTextField("valor");
    }
}