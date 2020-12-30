package visao.painel.novo.rebanho.inseminacao;

import controlador.visao.painel.novo.rebanho.inseminacao.ControllerPanelNovoMatriz;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import modelo.entidade.rebanho.inseminacao.Matriz;
import visao.modal.novo.ViewNovo;
import visao.painel.base.rebanho.inseminacao.PanelBaseMatriz;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoMatriz</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoMatriz</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.novo.rebanho.inseminacao.ControllerPanelNovoMatriz
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoMatriz extends PanelNovo {
    private final Matriz matriz;
    protected JTabbedPane tabbedPane;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoMatriz(ViewNovo view) {
        super(view);
        matriz     = new Matriz();
        controller = new ControllerPanelNovoMatriz(this);
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
    public void clear() {
        
    }
    
    /**
     * Metodo responsavel por retornar o Panel Base Matriz.
     * @return Panel Base Matriz.
     */
    public PanelBaseMatriz getPanelBaseMatriz() {
        return (PanelBaseMatriz) getPanel("base_matriz");
    }
}