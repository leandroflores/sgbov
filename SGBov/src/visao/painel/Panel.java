package visao.painel;

import controlador.Controller;
import funct.FunctView;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import visao.ViewStyle;

/**
 * <p>Classe de Visao <b>View</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para os <b>Paineis Graficas</b> do SGBov.</p>
 * @author Leandro
 * @since  14/12/2020
 * @see    controlador.Controller
 * @see    javax.swing.JPanel
 */
public abstract class Panel extends JPanel {
    protected Controller controller;
    
    private HashMap buttons;
    private HashMap checks;
    private HashMap combos;
    private HashMap choosers;
    private HashMap lists;
    private HashMap panels;
    private HashMap scrolls;
    private HashMap tables;
    private HashMap colums;
    private HashMap models;
    private HashMap textAreas;
    private HashMap textFields;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Panel() {
        init();
        setDefaultSettings();
    }
    
    /**
     * Metodo responsavel por iniciar as Listas de Componentes.
     */
    private void init() {
        this.buttons    = new HashMap<>();
        this.checks     = new HashMap<>();
        this.combos     = new HashMap<>();
        this.choosers   = new HashMap<>();
        this.lists      = new HashMap<>();
        this.panels     = new HashMap<>();
        this.scrolls    = new HashMap<>();
        this.tables     = new HashMap<>();
        this.colums     = new HashMap<>();
        this.models     = new HashMap<>();
        this.textAreas  = new HashMap<>();
        this.textFields = new HashMap<>();
    }
    
    /**
     * Metodo responsavel por adicionar os Componentes do Painel.
     */
    protected abstract void addComponents();
    
    /**
     * Metodo responsavel por retornar a Cor Padrao.
     * @return Cor Padrao.
     */
    protected Color getDefaultColor() {
        return getBackground();
    }
    
    /**
     * Metodo responsavel por retornar a Cor de Foco.
     * @return Cor de Foco.
     */
    protected Color getFocusColor() {
        return ColorUIResource.LIGHT_GRAY;
    }
    
    /**
     * Metodo responsavel por definir as Propriedades Padroes.
     */
    private void setDefaultSettings() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    /**
     * Metodo responsavel por retornar um Novo Label.
     * @param  title Titulo do Label.
     * @return Novo Label.
     */
    protected JLabel createLabel(String title) {
        JLabel label = new JLabel(title);
               label.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
               label.addKeyListener(controller);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Label.
     * @param  title Titulo do Label.
     * @param  size Tamanho do Label.
     * @return Novo Label.
     */
    protected JLabel createLabel(String title, int size) {
        JLabel label = createLabel(title);
               label.setHorizontalAlignment(SwingConstants.RIGHT);
               label.setPreferredSize(new Dimension(size, ViewStyle.ALTURA));
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Label Centralizado.
     * @param  title Titulo do Label.
     * @param  size Tamanho do Label.
     * @return Novo Label Centralizado.
     */
    protected JLabel createCenterLabel(String title, int size) {
        JLabel label = createLabel(title, size);
               label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Image Label.
     * @param  path Caminho da Imagem.
     * @return Novo Image Label.
     */
    protected JLabel createLabelImage(String path) {
        return new JLabel(new FunctView().createImage(path));
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title) {
        JButton button = new JButton();
                button.setText(title);
                button.setToolTipText(title);
                button.setPreferredSize(new Dimension(75, 30));
                button.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                button.addActionListener(controller);
                button.addKeyListener(controller);
                this.buttons.put(id, button);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  path Caminho da Imagem do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String path) {
        JButton button = createButton(id, title);
                button.setIcon(new FunctView().createImage("icones/" + path));
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  focus Titulo do Foco do Button.
     * @param  path Caminho da Imagem do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String focus, String path) {
        JButton button = createButton(id, title, path);
                button.setToolTipText(focus);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Button.
     * @param  id Identificador do Button.
     * @param  title Titulo do Button.
     * @param  focus Titulo do Foco do Button.
     * @param  path Caminho da Imagem do Button.
     * @param  dimension Dimensao do Button.
     * @return Novo Button.
     */
    protected JButton createButton(String id, String title, String focus, String path, Dimension dimension) {
        JButton button = createButton(id, title, focus, path);
                button.setPreferredSize(dimension);
        return  button;
    }
    
    /**
     * Metodo responsavel por retornar o Button pelo Identificador.
     * @param  id Identificador do Button.
     * @return Button pelo Identificador.
     */
    protected JButton getButton(String id) {
        return (JButton) buttons.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Check Box.
     * @param  id Identificador do Check Box.
     * @param  title Titulo do Check Box.
     * @param  selected Tag Selected do Check Box.
     * @return Novo Check Box.
     */
    protected JCheckBox createCheckBox(String id, String title, boolean selected) {
        JCheckBox checkBox = new JCheckBox(title);
                  checkBox.setSelected(selected);
                  checkBox.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                  checkBox.addActionListener(controller);
                  checkBox.addKeyListener(controller);
                  this.checks.put(id, checkBox);
        return    checkBox;
    }
    
    /**
     * Metodo responsavel por retornar o Check Box pelo Identificador.
     * @param  id Identificador do Check Box.
     * @return Check Box pelo Identificador.
     */
    protected JCheckBox getCheckBox(String id) {
        return (JCheckBox) checks.get(id);
    }
    
    /**
     * Metodo responsavel por retornar um Novo Combo Box.
     * @param  id Identificador do Combo Box.
     * @param  values Valores do Combo Box.
     * @param  size Tamanho do Combo Box.
     * @return Novo Combo Box.
     */
    protected JComboBox createComboBox(String id, Object[] values, int size) {
        JComboBox comboBox = new JComboBox(values);
                  comboBox.setAlignmentX(CENTER_ALIGNMENT);
                  comboBox.setAlignmentY(CENTER_ALIGNMENT);
                  comboBox.setFont(new Font(ViewStyle.ESTILO, ViewStyle.NEGRITO, ViewStyle.TAMANHO));
                  comboBox.setPreferredSize(new Dimension(size, ViewStyle.ALTURA));
                  comboBox.addActionListener(controller);
                  comboBox.addKeyListener(controller);
                  this.combos.put(id, comboBox);
        return    comboBox;
    }
    
    /**
     * Metodo responsavel por retornar um Novo Combo Box.
     * @param  id Identificador do Combo Box.
     * @param  values Valores do Combo Box.
     * @param  size Tamanho do Combo Box.
     * @param  object Objeto Selecionado do Combo Box.
     * @return Novo Combo Box.
     */
    protected JComboBox createComboBox(String id, Object[] values, int size, Object object) {
        JComboBox comboBox = createComboBox(id, values, size);
                  comboBox.setSelectedItem(object);
        return    comboBox;
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box pelo Identificador.
     * @param  id Identificador do Combo Box.
     * @return Combo Box pelo Identificador.
     */
    protected JComboBox getComboBox(String id) {
        return (JComboBox) combos.get(id);
    }
    
    /**
     * Method responsible for returning a New File Chooser.
     * @param  id File Chooser Id.
     * @return New File Chooser.
     */
    protected JFileChooser createFileChooser(String id) {
        JFileChooser fileChooser = new JFileChooser();
                     fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                     fileChooser.setFileFilter(new FileNameExtensionFilter("SMARTY", "smty", "smty"));
                     this.choosers.put(id, fileChooser);
        return       fileChooser;
    }
    
    /**
     * Method responsible for returning a New Directory Chooser.
     * @param  id Directory Chooser Id.
     * @return New Directory Chooser.
     */
    protected JFileChooser createDirectoryChooser(String id) {
        JFileChooser fileChooser = new JFileChooser();
                     fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                     this.choosers.put(id, fileChooser);
        return       fileChooser;
    }
    
    /**
     * Method responsible for returning the File Chooser by Id.
     * @param  id File Chooser Id.
     * @return File Chooser found.
     */
    protected JFileChooser getFileChooser(String id) {
        return (JFileChooser) this.choosers.get(id);
    }
    
    /**
     * Method responsible for returning a New List.
     * @param  id List Id.
     * @return New List.
     */
    protected JList createList(String id) {
        JList  list = new JList();
               list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
               list.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
               list.addKeyListener(this.controller);
               this.createScrollPane(id, list);
               this.lists.put(id, list);
        return list;
    }
    
    /**
     * Method responsible for returning the List by Id.
     * @param  id List Id.
     * @return List found.
     */
    protected JList getList(String id) {
        return (JList) this.lists.get(id);
    }
    
    /**
     * Method responsible for adding a Panel.
     * @param id Panel Id.
     * @param panel Panel.
     */
    protected void addPanel(String id, Panel panel) {
        this.panels.put(id, panel);
    }
    
    /**
     * Method responsible for returning a Panel by Id.
     * @param  id Panel Id.
     * @return Panel found.
     */
    protected Panel getPanel(String id) {
        return (Panel) this.panels.get(id);
    }
    
    /**
     * Method responsible for removing a Panel.
     * @param id Panel Id.
     */
    protected void removePanel(String id) {
        this.panels.remove(id);
    }
    
    /**
     * Method responsible for returning a New Scroll Pane.
     * @param  id Scroll Pane Id.
     * @return New Scroll Pane.
     */
    protected JScrollPane createScrollPane(String id) {
        JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    this.scrolls.put(id, scrollPane);
        return      scrollPane;
    }
    
    /**
     * Method responsible for returning a New Scroll Pane of a Panel.
     * @param  id Scroll Pane Id.
     * @param  panel Panel.
     * @return New Scroll Pane of a Panel.
     */
    protected JScrollPane createScrollPane(String id, JPanel panel) {
        JScrollPane scrollPane = this.createScrollPane(id);
                    scrollPane.setPreferredSize(new Dimension(390, 120));
                    scrollPane.setViewportView(panel);
        return      scrollPane;
    }
    
    /**
     * Method responsible for returning a New Scroll Pane of a List.
     * @param  id Scroll Pane Id.
     * @param  list List.
     * @return New Scroll Pane of a JList.
     */
    private JScrollPane createScrollPane(String id, JList list) {
        JScrollPane scrollPane = this.createScrollPane(id);
                    scrollPane.setViewportView(list);
                    scrollPane.setPreferredSize(new Dimension(390, 120));
        return      scrollPane;
    }
    
    /**
     * Method responsible for returning a New Scroll Pane of a Text Area.
     * @param  id Scroll Pane Id.
     * @param  textArea Text Area.
     * @return New Scroll Pane of a Text Area.
     */
    private JScrollPane createScrollPane(String id, JTextArea textArea) {
        JScrollPane scrollPane = this.createScrollPane(id);
                    scrollPane.setViewportView(textArea);
                    scrollPane.setPreferredSize(new Dimension(200, 100));
        return      scrollPane;
    }
    
    /**
     * Method responsible for returning a new Scroll Pane of a Table.
     * @param  id Scroll Pane Id.
     * @param  table Table.
     * @return New Scroll Pane of a Table.
     */
    private JScrollPane createScrollPane(String id, JTable table) {
        JScrollPane scrollPane = this.createScrollPane(id);
                    scrollPane.setViewportView(table);
                    scrollPane.setPreferredSize(new Dimension(380, 150));
        return      scrollPane;
    }
    
    /**
     * Method responsible for returning the Scroll Pane by Id.
     * @param  id Scroll Pane Id.
     * @return Scroll Pane found.
     */
    protected JScrollPane getScrollPane(String id) {
        return (JScrollPane) this.scrolls.get(id);
    }
    
    /**
     * Method responsible for returning a New Table.
     * @param  id Table Id.
     * @return New Table.
     */
    protected JTable createTable(String id) {
        JTable table = new JTable(this.createTableModel());
               table.addKeyListener(this.controller);
               this.createScrollPane(id, table);
               this.models.put(id, table.getModel());
               this.colums.put(id, table.getColumnModel());
               this.tables.put(id, table);
        return table;
    }
    
    /**
     * Method responsible for returning a New Table Model.
     * @return New Table Model.
     */
    private DefaultTableModel createTableModel() {
        return 
            new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {   
                    return true;
                }};
    }
    
    /**
     * Method responsible for adding the Columns on Table.
     * @param id Table Id.
     * @param values Column Values.
     */
    protected void addColumns(String id, String[] values) {
        for (String value : values)
            ((DefaultTableModel) this.models.get(id)).addColumn(value);
    }
    
    /**
     * Method responsible for setting the Columns Size on Table.
     * @param id Table Id. 
     * @param size Size Array.
     */
    protected void setColumnsSize(String id, int[] size) {
        for (int i = 0; i < size.length; i++)
            this.getTable(id).getColumnModel().getColumn(i).setPreferredWidth(size[i]);
    }
    
    /**
     * Method responsible for cleaning the Table.
     * @param id Table Id.
     */
    protected void clearTable(String id) {
        while (this.getTableModel(id).getRowCount() > 0)
            this.getTableModel(id).removeRow(0);
        this.getTable(id).removeAll();
    }
    
    /**
     * Method responsible for adding the Line Values on Table.
     * @param id Table Id. 
     * @param values Line Values.
     */
    protected void addRows(String id, Object[][] values) {
        this.clearTable(id);
        for (Object[] value : values) {
            this.getTableModel(id).addRow(value);
            this.getTable(id).setEditingRow(JTable.AUTO_RESIZE_NEXT_COLUMN);
            this.getTable(id).setEditingRow(0);
        }
    }
    
    /**
     * Method responsible for returning the Table by Id.
     * @param  id Table Id.
     * @return Table found.
     */
    protected JTable getTable(String id) {
        return (JTable) this.tables.get(id);
    }
    
    /**
     * Method responsible for returning the Table Model by Id.
     * @param  id Table Model Id.
     * @return Table Model found.
     */
    protected DefaultTableModel getTableModel(String id) {
        return (DefaultTableModel) this.models.get(id);
    }
    
    /**
     * Method responsible for returning the Table Column by Id.
     * @param  id Table Column Id.
     * @return Table Column found.
     */
    protected TableColumnModel getTableColumn(String id) {
        return (TableColumnModel) this.colums.get(id);
    }
    
    /**
     * Method responsible for returning a New Text Area.
     * @param  id Text Area Id.
     * @return New Text Area.
     */
    protected JTextArea createTextArea(String id) {
        JTextArea textArea = new JTextArea(5, 10);
                  textArea.addKeyListener(this.controller);
                  textArea.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                  this.textAreas.put(id, textArea);
                  this.createScrollPane(id, textArea);
        return    textArea;
    }
    
    /**
     * Method responsible for returning a New Text Area.
     * @param  id Text Area Id.
     * @param  text Text Area Text.
     * @return New Text Area.
     */
    protected JTextArea createTextArea(String id, String text) {
        JTextArea textArea = this.createTextArea(id);
                  textArea.setText(text);
        return    textArea;
    }
    
    /**
     * Method responsible for returning the Text Area by Id.
     * @param  id Text Area Id.
     * @return Text Area found.
     */
    protected JTextArea getTextArea(String id) {
        return (JTextArea) this.textAreas.get(id);
    }
    
    /**
     * Method responsible for returning a New Text Field.
     * @param  id Text Field Id.
     * @param  value Text Field Value.
     * @param  size Text Field Size.
     * @return New Text Field.
     */
    protected JTextField createTextField(String id, String value, int size) {
        JTextField textField = new JTextField(size);
                   textField.setText(value);
                   textField.addActionListener(this.controller);
                   textField.addKeyListener(this.controller);
                   textField.setPreferredSize(new Dimension(ViewStyle.LARGURA, ViewStyle.ALTURA));
                   textField.setFont(new Font(ViewStyle.ESTILO, ViewStyle.PADRAO, ViewStyle.TAMANHO));
                   this.textFields.put(id, textField);
        return     textField;
    }
    
    /**
     * Method responsible for returning a New No Editable Text Field.
     * @param  id Text Field Id.
     * @param  value Text Field Value.
     * @param  size Text Field Size.
     * @return New No Editable JTextField.
     */
    protected JTextField createTextFieldNoEditable(String id, String value, int size) {
        JTextField textField = this.createTextField(id, value, size);
                   textField.setEditable(false);
        return     textField;
    }
    
    /**
     * Method responsible for returning the Text Field by Id.
     * @param  id Text Field Id.
     * @return Text Field found.
     */
    protected JTextField getTextField(String id) {
        return (JTextField) this.textFields.get(id);
    }
    
    /**
     * Method responsible for returning the New Constraints.
     * @param  width Width Constraints.
     * @param  height Height Constraints.
     * @param  x X Position Grid.
     * @param  y Y Position Grid.
     * @return New Constraints.
     */
    protected GridBagConstraints createConstraints(int width, int height, int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();
                           constraints.gridheight = height;
                           constraints.gridwidth  = width;
                           constraints.gridx      = x;
                           constraints.gridy      = y;
                           constraints.fill       = GridBagConstraints.HORIZONTAL;
        return constraints;
    }
    
    /**
     * Method responsible for returning the New Start Constraint.
     * @return New Start Constraint.
     */
    protected GridBagConstraints createStartConstraint() {
        return this.setStartConstraint(new GridBagConstraints());
    }
    
    /**
     * Method responsible for setting the Start Constraint.
     * @param  constraint Grid Bag Constraint.
     * @return Start Constraint.
     */
    protected GridBagConstraints setStartConstraint(GridBagConstraints constraint) {
               constraint.anchor  = GridBagConstraints.PAGE_START;
               constraint.fill    = GridBagConstraints.HORIZONTAL;
               constraint.gridx   = 0;
               constraint.gridy   = 0;
               constraint.weightx = 1.0;
               constraint.weighty = 0.25;
        return constraint;
    }
    
    /**
     * Method responsible for returning the New Body Constraint.
     * @return New Body Constraint.
     */
    protected GridBagConstraints createBodyConstraint() {
        return this.setBodyConstraint(new GridBagConstraints());
    }
    
    /**
     * Method responsible for setting the Body Constraint.
     * @param  constraint Grid Bag Constraint.
     * @return Body Constraint.
     */
    protected GridBagConstraints setBodyConstraint(GridBagConstraints constraint) {
               constraint.anchor     = GridBagConstraints.FIRST_LINE_START;
               constraint.fill       = GridBagConstraints.BOTH;
               constraint.gridx      = 0;
               constraint.gridy      = 1;
               constraint.weightx    = 1.0;
               constraint.weighty    = 11.75;
               constraint.gridheight = GridBagConstraints.RELATIVE;
               constraint.gridwidth  = GridBagConstraints.RELATIVE;
        return constraint;       
    }
}