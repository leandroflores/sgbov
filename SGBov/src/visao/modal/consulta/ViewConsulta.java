package visao.modal.consulta;

import controlador.visao.interfaces.Updatable;
import controlador.visao.modal.consulta.ControllerViewConsulta;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import visao.View;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewConsulta</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.consulta.ControllerViewConsulta
 * @see    visao.interfaces.InterfaceView
 * @see    visao.modal.ViewModal
 */
public abstract class ViewConsulta extends ViewModal implements Updatable {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     */
    public ViewConsulta(View view) {
        super(view);
    }
    
    @Override
    public void setProperties() {
        updateTitle();
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    
    @Override
    public void update() {
        getController().pesquisar();
    }
    
    /**
     * Metodo responsavel por adicionar a Tabela na View de Consulta.
     */
    protected void addTable() {
        createTable("consulta");
        getContentPane().add(getScrollPane("consulta"));
    }
    
    /**
     * Metodo responsavel por definir o Cabecalho da Tabela na View de Consulta.
     */
    protected abstract void setTableHeader();
    
    /**
     * Metodo responsavel por adicionar o Rodape da Tabela na View de Consulta.
     */
    protected void addTableFooter() {
        getContentPane().add(createLabel("Total: "));
        getContentPane().add(createTextFieldNoEditable("total", "0", 5));
    }
    
    /**
     * Metodo responsavel por atualizar o Total de Registros encontrados.
     * @param total Total de Registros.
     */     
    public void setTotal(int total) {
        String text = total > 0 ? Integer.toString(total) : "0";
        getTextField("total").setText(text);
    }
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("novo",    "  Novo   ", "inserir"));
               footer.add(createButton("editar",  " Editar  ", "editar"));
               footer.add(createButton("excluir", " Excluir ", "excluir"));
               footer.add(createButton("voltar",  " Voltar  ", "voltar"));
        getContentPane().add(footer);
    }

    /**
     * Metodo responsavel por retornar o Text Field Pesquisa.
     * @return Text Field Pesquisa.
     */
    public JTextField getTextFieldPesquisa() {
        return getTextField("pesquisa");
    }

    /**
     * Metodo responsavel por retornar o Button Pesquisa.
     * @return Button Pesquisa.
     */
    public JButton getButtonPesquisa() {
        return getButton("pesquisa");
    }

    /**
     * Metodo responsavel por retornar a Tabela de Consulta.
     * @return Tabela de Consulta.
     */
    public JTable getTable() {
        return getTable("consulta");
    }

    /**
     * Metodo responsavel por retornar o Modelo da Tabela de Consulta.
     * @return Modelo da Tabela de Consulta.
     */
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) getTableModel("consulta");
    }

    /**
     * Metodo responsavel por retornar o Scroll Pane da Tabela de Consulta.
     * @return Scroll Pane da Tabela de Consulta.
     */
    public JScrollPane getScrollPane() {
        return getScrollPane("consulta");
    }
    
     /**
     * Metodo responsavel por retornar o Button Novo.
     * @return Button Novo.
     */
    public JButton getButtonNovo() {
        return getButton("novo");
    }
    
    /**
     * Metodo responsavel por retornar o Button Editar.
     * @return Button Editar.
     */
    public JButton getButtonEditar() {
        return getButton("editar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Excluir.
     * @return Button Excluir.
     */
    public JButton getButtonExcluir() {
        return getButton("excluir");
    }
    
    /**
     * Metodo responsavel por retornar o Button Voltar.
     * @return Button Voltar.
     */
    public JButton getButtonVoltar() {
        return getButton("voltar");
    }
    
    /**
     * Metodo responsavel por retornar o Controller da View Consulta.
     * @return Controller da View Consulta.
     */
    public ControllerViewConsulta getController() {
        return (ControllerViewConsulta) controller;
    }
}