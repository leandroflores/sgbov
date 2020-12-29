package visao.painel.base.rebanho.inseminacao;

import controlador.visao.painel.base.rebanho.inseminacao.ControllerPanelBaseMatrizes;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import modelo.entidade.rebanho.Inseminacao;
import visao.painel.Panel;
import visao.painel.base.PanelBase;

/**
 * <p>Classe de Visao <b>PanelBaseMatrizes</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewBaseMatrizes</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.base.rebanho.inseminacao.ControllerPanelBaseMatrizes
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.base.PanelBase
 */
public final class PanelBaseMatrizes extends PanelBase {
    private final Inseminacao inseminacao;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Owner.
     * @param inseminacao_ Inseminacao.
     */
    public PanelBaseMatrizes(Panel panel, Inseminacao inseminacao_) {
        super(panel);
        inseminacao = inseminacao_;
        controller  = new ControllerPanelBaseMatrizes(this);
        setProperties();
        addComponents();
        setValues();
    }
    
    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(400, 525));
        setMaximumSize(new Dimension(400, 525));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    @Override
    protected void addComponents() {
        addHeader();
        addTable();
        addFooter();
    }
    
    private void addHeader() {
        add(getSpace(20, 10));
    }
    
    private void addTable() {
        createTable("matrizes");
        add(getScrollPane("matrizes"));
        addColumns("matrizes", new String[]{"Número", "Implante", "Hormônio", "Sêmen", "Prenha"});
        setColumnsSize("matrizes", new int[]{75, 50, 50, 50, 50});
        getScrollPane("matrizes").setPreferredSize(new Dimension(275, 210));
    }
    
    private void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("adicionar", "", "Adicionar", "inserir"));
               footer.add(createButton("editar",    "", " Editar  ", "editar"));
               footer.add(createButton("excluir",   "", " Excluir ", "excluir"));
        add(footer);
    }
    
    @Override
    public void setValues() {}
    
    /**
     * Metodo responsavel por retornar o Table Matrizes.
     * @return Table Matrizes.
     */
    public JTable getTable() {
        return getTable("matrizes");
    }
    
    /**
     * Metodo responsavel por retornar o Button Adicionar.
     * @return Button Adicionar.
     */
    public JButton getButtonAdicionar() {
        return getButton("adicionar");
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
}