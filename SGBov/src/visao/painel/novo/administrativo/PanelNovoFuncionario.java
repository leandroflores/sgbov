package visao.painel.novo.administrativo;

import controlador.visao.painel.novo.administrativo.ControllerPanelNovoFuncionario;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JTextField;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoFuncionario</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoFuncionario</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.painel.novo.administrativo.ControllerPanelNovoFuncionario
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoFuncionario extends PanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoFuncionario(ViewNovo view) {
        super(view);
        controller = new ControllerPanelNovoFuncionario(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        setLayout(new GridLayout(5, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Nome*: "));
        add(createTextField("nome", "", 30));
        
        add(createRightLabel("CPF*: "));
        add(createTextField("cpf", "", 30));
        
        add(createRightLabel("Telefone*: "));
        add(createTextField("telefone", "", 30));
        
        add(createRightLabel("Salário*: "));
        add(createPriceTextField("salario", 0.0f, 30));
        
        add(createRightLabel("Data Nascimento*: "));
        add(createDateTextField("data_nascimento", new Date()));
    }
    
    @Override
    public void clear() {
        getTextFieldNome().setText("");
        getTextFieldCPF().setText("");
        getTextFieldTelefone().setText("");
        getTextFieldSalario().setText(new DecimalFormat("R$ #,##0.00").format(0.0f));
        getTextFieldDataNascimento().setText(new FunctDate().getFormattedDate(new Date()));
        
        getTextFieldNome().requestFocus();
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Nome.
     * @return Text Field Nome.
     */
    public JTextField getTextFieldNome() {
        return getTextField("nome");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field CPF.
     * @return Text Field CPF.
     */
    public JTextField getTextFieldCPF() {
        return getTextField("cpf");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Telefone.
     * @return Text Field Telefone.
     */
    public JTextField getTextFieldTelefone() {
        return getTextField("telefone");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Salario.
     * @return Text Field Salario.
     */
    public JTextField getTextFieldSalario() {
        return getTextField("salario");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Data Nascimento.
     * @return Text Field Data Nascimento.
     */
    public JTextField getTextFieldDataNascimento() {
        return getTextField("data_nascimento");
    }
}