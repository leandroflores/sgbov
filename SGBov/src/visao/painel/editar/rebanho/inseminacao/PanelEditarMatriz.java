package visao.painel.editar.rebanho.inseminacao;

import controlador.visao.painel.editar.rebanho.inseminacao.ControllerPanelEditarMatriz;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import modelo.entidade.rebanho.inseminacao.Matriz;
import visao.modal.editar.ViewEditar;
import visao.painel.base.rebanho.inseminacao.PanelBaseMatriz;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>PanelEditarMatriz</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewEditarMatriz</b> do SGBov.</p>
 * @author Leandro
 * @since  31/12/2020
 * @see    controlador.visao.painel.editar.rebanho.inseminacao.ControllerPanelEditarMatriz
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.editar.PanelEditar
 */
public final class PanelEditarMatriz extends PanelEditar {
    private final Matriz matriz;
    protected JTabbedPane tabbedPane;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar.
     * @param matriz_ Matriz.
     */
    public PanelEditarMatriz(ViewEditar view, Matriz matriz_) {
        super(view);
        matriz     = matriz_;
        controller = new ControllerPanelEditarMatriz(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(475, 230));
    }
    
    @Override
    protected void addComponents() {
        addPanels();
        add(tabbedPane);
    }
    
    protected void addPanels() {
        addPanelBaseMatriz();
    }
    
    /**
     * Metodo responsavel por adicionar o Panel Base Matriz.
     */
    public void addPanelBaseMatriz() {
        addPanel("base_matriz", new PanelBaseMatriz(this, matriz));
        createScrollPane("base_matriz",  getPanelBaseMatriz());
        getScrollPane("base_matriz").setViewportView(getPanelBaseMatriz());
        tabbedPane.add("Matriz", getScrollPane("base_matriz"));
    }
    
    @Override
    public void setValues() {
        
    }
    
    /**
     * Metodo responsavel por retornar o Panel Base Matriz.
     * @return Panel Base Matriz.
     */
    public PanelBaseMatriz getPanelBaseMatriz() {
        return (PanelBaseMatriz) getPanel("base_matriz");
    }
}