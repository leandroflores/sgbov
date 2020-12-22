package visao.modal.consulta.estruturais;

import controlador.visao.modal.consulta.estruturais.ControllerViewConsultaBovino;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import modelo.controlador.estruturais.ControllerBovino;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;

/**
 * <p>Classe de Visao <b>ViewConsultaBovino</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.consulta.estruturais.ControllerViewConsultaBovino
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaBovino extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaBovino(ViewMenu view) {
        super(view);
        title      = "Consulta de Bovinos";
        controller = new ControllerViewConsultaBovino(this);
        setProperties();
        addComponents();
        update();
    }

    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(1000, 560));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getSpace(20, 1000));
        
        getContentPane().add(createLabel("Tipo: ", 100));
        getContentPane().add(createComboBox("tipo", ControllerBovino.TIPOS, 200));
        getComboBoxTipo().setPreferredSize(new Dimension(125, 30));
        getContentPane().add(createLabel("Data Nasc.*: ", 140));
        getContentPane().add(createTextFieldDate("data_inicio", new Date()));
        getContentPane().add(createTextFieldDate("data_final",  new Date()));
        
        getContentPane().add(getSpace(10, 1000));
        
        getContentPane().add(createLabel("Sexo: ", 100));
        getContentPane().add(createComboBox("sexo", new String[]{"MACHO", "FEMEA"}, 200));
        getComboBoxSexo().setPreferredSize(new Dimension(125, 30));
        getContentPane().add(createLabel("Número: ", 100));
        getContentPane().add(createSpinnerEditable("numero"));
        getContentPane().add(createLabel("Ativo: ",  80));
        add(createCheckBox("ativo", "", true));
        getContentPane().add(createLabel("", 10));
        getContentPane().add(createButton("pesquisa", "", "atualizar"));
        
        getContentPane().add(getSpace(10, 1000));
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(900, 275));
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Tipo", "Número", "Sexo", "Data Nascimento", "Peso"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 150, 100, 100, 125};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(getSpace(10, 1000));
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Combo Box Tipo.
     */
    public JComboBox getComboBoxTipo() {
        return getComboBox("tipo");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Data Inicio.
     * @return Text Field Data Inicio.
     */
    public JTextField getTextFieldDataInicio() {
        return getTextField("data_inicio");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Data Final.
     * @return Text Field Data Final.
     */
    public JTextField getTextFieldDataFinal() {
        return getTextField("data_final");
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Sexo.
     * @return Combo Box Sexo.
     */
    public JComboBox getComboBoxSexo() {
        return getComboBox("sexo");
    }
    
    /**
     * Metodo responsavel por retornar o Spinner Numero.
     * @return Spinner Numero.
     */
    public JSpinner getSpinnerNumero() {
        return getSpinner("numero");
    }
    
    /**
     * Metodo responsavel por retornar o Check Box Ativo.
     * @return Check Box Ativo.
     */
    public JCheckBox getCheckBoxAtivo() {
        return getCheckBox("ativo");
    }
}