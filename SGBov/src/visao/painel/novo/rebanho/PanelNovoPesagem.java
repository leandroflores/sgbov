package visao.painel.novo.rebanho;

import controlador.visao.painel.novo.rebanho.ControllerPanelNovoPesagem;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextField;
import modelo.entidade.rebanho.Bovino;
import visao.interfaces.Searchable;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoPesagem</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoPesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  22/12/2020
 * @see    controlador.visao.painel.novo.rebanho.ControllerPanelNovoPesagem
 * @see    modelo.entidade.rebanho.Pesagem
 * @see    visao.interfaces.Searchable
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoPesagem extends PanelNovo implements Searchable {
    private Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoPesagem(ViewNovo view) {
        super(view);
        controller = new ControllerPanelNovoPesagem(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(400, 525));
        setMaximumSize(new Dimension(400, 525));
        setLayout(new GridBagLayout());
    }
    
    @Override
    protected void addComponents() {
        add(createLabel("Bovino*: ", 120), createConstraints(1, 1, 0, 0));
        add(createTextFieldNoEditable("bovino", "", 20), createConstraints(3, 1, 1, 0));
        getTextField("bovino").setMinimumSize(new Dimension(150, 30));
        add(createButton("pesquisa", "", "pesquisa"), createConstraints(1, 1, 4, 0));
        
        add(createRightLabel("Id: "), createConstraints(1, 1, 0, 1));
        add(createTextFieldNoEditable("id", "", 5), createConstraints(1, 1, 1, 1));
        getTextField("id").setMinimumSize(new Dimension(90, 30));
        add(createRightLabel("Tipo: "), createConstraints(1, 1, 2, 1));
        add(createTextFieldNoEditable("tipo", "", 5), createConstraints(1, 1, 3, 1));
        getTextField("tipo").setMinimumSize(new Dimension(100, 30));
        add(createLabel(""), createConstraints(1, 1, 4, 1));
        
        add(createRightLabel("N.: "), createConstraints(1, 1, 0, 2));
        add(createTextFieldNoEditable("numero", "", 5), createConstraints(1, 1, 1, 2));
        getTextField("numero").setMinimumSize(new Dimension(90, 30));
        add(createRightLabel("Sexo: "), createConstraints(1, 1, 2, 2));
        add(createTextFieldNoEditable("sexo", "", 5), createConstraints(1, 1, 3, 2));
        getTextField("sexo").setMinimumSize(new Dimension(100, 30));
        add(createLabel(""), createConstraints(1, 1, 4, 2));
        
        
        add(createLabel("Data*: ", 150), createConstraints(1, 1, 0, 3));
        add(createDateTextField("data", new Date()), createConstraints(1, 1, 1, 3));
        getTextFieldData().setMinimumSize(new Dimension(90, 30));
        add(createLabel("Peso*: ", 150), createConstraints(1, 1, 2, 3));
        add(createDecimalTextField("peso", 0.0f, 7), createConstraints(1, 1, 3, 3));
        getTextFieldPeso().setMinimumSize(new Dimension(100, 30));
        add(createLabel(""), createConstraints(1, 1, 4, 3));
    }
    
    @Override
    public void clear() {
        bovino = null;
        update();
        
        getTextFieldData().setText(new FunctDate().getFormattedDate(new Date()));
        getTextFieldPeso().setText(new DecimalFormat("#,##0.00").format(0.00f));
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
    
    /**
     * Metodo responsavel por atualizar os Dados.
     */
    public void update() {
        if (bovino == null)
            clearBovino();
        else
            setDadosBovino();
    }
    
    /**
     * Metodo responsavel por preencher os campos do Bovino.
     */
    private void setDadosBovino() {
        getTextField("bovino").setText(bovino.toString());
        getTextField("id").setText(Long.toString(bovino.getId()));
        getTextField("tipo").setText(bovino.getTipo());
        getTextField("numero").setText(Integer.toString(bovino.getNumero()));
        getTextField("sexo").setText("" + bovino.getSexo());
    }
    
    /**
     * Metodo responsavel por Limpar os Dados de Bovino.
     */
    private void clearBovino() {
        getTextField("bovino").setText("");
        getTextField("id").setText("");
        getTextField("tipo").setText("");
        getTextField("numero").setText("");
        getTextField("sexo").setText("");
    }
    
    @Override
    public void setValue(Object bovino_) {
        bovino = (Bovino) bovino_;
        setDadosBovino();
    }
    
    /**
     * Metodo responsavel por retornar o Button Pesquisa.
     * @return Button Pesquisa.
     */
    public JButton getButtonPesquisa() {
        return getButton("pesquisa");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Data.
     * @return Text Field Data.
     */
    public JTextField getTextFieldData() {
        return getTextField("data");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Peso.
     * @return Text Field Peso.
     */
    public JTextField getTextFieldPeso() {
        return getTextField("peso");
    }
}