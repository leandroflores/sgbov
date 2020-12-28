package visao.painel.editar.rebanho;

import controlador.visao.painel.editar.rebanho.ControllerPanelEditarPesagem;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JTextField;
import modelo.entidade.rebanho.Pesagem;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>PanelEditarPesagem</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewEditarPesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.painel.editar.estruturais.
 * @see    modelo.entidade.rebanho.Pesagem
 * @see    visao.painel.editar.PanelEditar
 */
public final class PanelEditarPesagem extends PanelEditar {
    private final Pesagem pesagem;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Pesagem.
     * @param pesagem_ Pesagem.
     */
    public PanelEditarPesagem(ViewEditar view, Pesagem pesagem_) {
        super(view);
        pesagem    = pesagem_;
        controller = new ControllerPanelEditarPesagem(this);
        setProperties();
        addComponents();
        setValues();
        getController().setReady();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(400, 525));
        setMaximumSize(new Dimension(400, 525));
        setLayout(new GridLayout(4, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createLabel("Id: ", 70));
        add(createTextFieldNoEditable("id", "", 20));
        
        add(createLabel("Bovino: ", 70));
        add(createTextFieldNoEditable("bovino", "", 20));
        
        add(createLabel("Data*: ", 70));
        add(createDateTextField("data", new Date()));
        
        add(createLabel("Peso*: ", 70));
        add(createDecimalTextField("peso", 0.0f, 7));
    }
    
    @Override
    public void setValues() {
        getTextFieldId().setText(Long.toString(pesagem.getId()));
        getTextFieldBovino().setText(pesagem.getBovino().toString());
        getTextFieldData().setText(new FunctDate().getFormattedDate(pesagem.getDataPesagem()));
        getTextFieldPeso().setText(new DecimalFormat("#,##0.00").format(pesagem.getValor()));
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Id.
     * @return Text Field Id.
     */
    public JTextField getTextFieldId() {
        return getTextField("id");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Bovino.
     * @return Text Field Bovino.
     */
    public JTextField getTextFieldBovino() {
        return getTextField("bovino");
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