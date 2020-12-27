package visao.modal.editar.estruturais;

import controlador.visao.modal.editar.estruturais.ControllerViewEditarBovino;
import java.awt.Dimension;
import modelo.entidade.estruturais.Bovino;
import visao.modal.consulta.estruturais.ViewConsultaBovino;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.estruturais.PanelEditarBovino;

/**
 * <p>Classe de Visao <b>ViewEditarBovino</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao do Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.modal.editar.estruturais.ControllerViewEditarBovino
 * @see    modelo.entidade.estruturais.Bovino
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
        bovino     = bovino_;
        title      = "Editar Bovino";
        controller = new ControllerViewEditarBovino(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(550, 330));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void addBody() {
        addPanel("panel_editar", new PanelEditarBovino(this, bovino));
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
    
    @Override
    public PanelEditarBovino getPanelEditar() {
        return (PanelEditarBovino) super.getPanelEditar();
    }
}