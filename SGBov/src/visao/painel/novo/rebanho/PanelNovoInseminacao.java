package visao.painel.novo.rebanho;

import controlador.visao.painel.novo.rebanho.ControllerPanelNovoInseminacao;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTabbedPane;
import modelo.controlador.rebanho.ControllerBovino;
import modelo.entidade.rebanho.Inseminacao;
import modelo.entidade.rebanho.inseminacao.Matriz;
import visao.modal.novo.ViewNovo;
import visao.painel.base.rebanho.PanelBaseInseminacao;
import visao.painel.base.rebanho.inseminacao.PanelBaseMatrizes;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoInseminacao</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoInseminacao</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.novo.rebanho.ControllerPanelNovoInseminacao
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoInseminacao extends PanelNovo {
    private final Inseminacao  inseminacao;
    private final HashMap matrizes;
    protected JTabbedPane tabbedPane;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoInseminacao(ViewNovo view) {
        super(view);
        inseminacao = new Inseminacao();
        matrizes    = new HashMap<>();
        controller  = new ControllerPanelNovoInseminacao(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(600, 330));
    }
    
    @Override
    protected void addComponents() {
        addPanels();
        add(tabbedPane);
    }
    
    protected void addPanels() {
        addPanelBaseInseminacao();
        addPanelBaseMatrizes();
    }
    
    /**
     * Metodo responsavel por adicionar o Panel Base Inseminacao.
     */
    public void addPanelBaseInseminacao() {
        addPanel("base_inseminacao", new PanelBaseInseminacao(this, inseminacao));
        createScrollPane("base_inseminacao",  getPanelBaseInseminacao());
        getScrollPane("base_inseminacao").setViewportView(getPanelBaseInseminacao());
        tabbedPane.add("Inseminação", getScrollPane("base_inseminacao"));
    }
    
    /**
     * Metodo responsavel por adicionar o Panel Base Matrizes.
     */
    public void addPanelBaseMatrizes() {
        addPanel("base_matrizes", new PanelBaseMatrizes(this, inseminacao));
        createScrollPane("base_matrizes",  getPanelBaseMatrizes());
        getScrollPane("base_matrizes").setViewportView(getPanelBaseMatrizes());
        tabbedPane.add("Matrizes", getScrollPane("base_matrizes"));
    }
    
    public void addMatriz(Matriz matriz) {
        matrizes.put(matriz.getBovino().getId(), matriz);
    }
    
    public void removeMatriz(Matriz matriz) {
        matrizes.remove(matriz.getBovino().getId());
    }
    
    public void update() {
        getPanelBaseInseminacao().updateMatrizes(new ArrayList(matrizes.values()));
        getPanelBaseMatrizes().addRows("matrizes", new ControllerBovino().getDadosPesquisa(new ArrayList(matrizes.values())));
    }
    
    @Override
    public void clear() {
        
    }
    
    /**
     * Metodo responsavel por retornar o Panel Base Inseminacao.
     * @return Panel Base Inseminacao.
     */
    public PanelBaseInseminacao getPanelBaseInseminacao() {
        return (PanelBaseInseminacao) getPanel("base_inseminacao");
    }
    
    /**
     * Metodo responsavel por retornar o Panel Base Matrizes.
     * @return Panel Base Matrizes.
     */
    public PanelBaseMatrizes getPanelBaseMatrizes() {
        return (PanelBaseMatrizes) getPanel("base_matrizes");
    }
    
    @Override
    public ControllerPanelNovoInseminacao getController() {
        return (ControllerPanelNovoInseminacao) super.getController();
    }
}