package visao.painel.editar.administrativo;

import controlador.visao.painel.editar.administrativo.ControllerPanelEditarFuncionario;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JTextField;
import modelo.entidade.administrativo.Funcionario;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>PanelEditarFuncionario</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewEditarFuncionario</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.painel.editar.administrativo.ControllerPanelEditarFuncionario
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.painel.editar.PanelEditar
 */
public final class PanelEditarFuncionario extends PanelEditar {
    private final Funcionario funcionario;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Funcionario.
     * @param funcionario_ Funcionario.
     */
    public PanelEditarFuncionario(ViewEditar view, Funcionario funcionario_) {
        super(view);
        funcionario = funcionario_;
        controller  = new ControllerPanelEditarFuncionario(this);
        setProperties();
        addComponents();
        setValues();
        getController().setReady();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        setLayout(new GridLayout(6, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Identificador: "));
        add(this.createTextFieldNoEditable("identificador", "", 5));
        
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
    public void setValues() {
        getTextFieldIdentificador().setText(Long.toString(funcionario.getId()));
        getTextFieldNome().setText(funcionario.getNome());
        getTextFieldCPF().setText(funcionario.getCpf());
        getTextFieldTelefone().setText(funcionario.getTelefone());
        getTextFieldSalario().setText(new DecimalFormat("R$ #,##0.00").format(funcionario.getSalario()));
        getTextFieldDataNascimento().setText(new FunctDate().getFormattedDate(funcionario.getNascimento()));
        
        getTextFieldNome().requestFocus();
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Identificador.
     * @return Text Field Identificador.
     */
    public JTextField getTextFieldIdentificador() {
        return getTextField("identificador");
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