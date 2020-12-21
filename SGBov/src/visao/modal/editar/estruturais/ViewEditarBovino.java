package visao.modal.editar.estruturais;

import modelo.entidade.estruturais.Bovino;
import visao.modal.consulta.estruturais.ViewConsultaBovino;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.estruturais.PanelEditarBovino;

/**
 * <p>Classe de Visao <b>ViewEditarBovino</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao do Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.editar.ControllerViewEditarBovino
 * @see    modelo.controlador.estruturais.ControllerBovino
 * @see    modelo.entidades.estruturais.Bovino
 * @see    visao.editar.ViewEditar
 */
public final class ViewEditarBovino extends ViewEditar {
    private final Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Bovino.
     * @param bovino_ Bovino.
     */
    public ViewEditarBovino(ViewConsultaBovino view, Bovino bovino_) {
        super(view);
        //controller = new ControllerViewEditarBovino(this);
        bovino     = bovino_;
        title      = "Editar Bovino";
        initComponents();
    }
    
    @Override
    public void initComponents() {
        setSize(550, 370);
        addHeader();
        addComponents();
        addFooter();
        setValues();
    }
    
    @Override
    public void addComponents() {
        getContentPane().add(getVerticalSpace(20));
        addPanel("panel_bovino", new PanelEditarBovino(this, bovino));
        getContentPane().add(getPanelEditar());
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void setValues() {
        getPanelEditar().setValues();
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
    
    /**
     * Metodo responsavel por retornar o Panel Editar Bovino.
     * @return Panel Editar Bovino.
     */
    public PanelEditarBovino getPanelEditar() {
        return (PanelEditarBovino) getPanel("panel_bovino");
    }
}