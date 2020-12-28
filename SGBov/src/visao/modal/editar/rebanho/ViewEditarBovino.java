package visao.modal.editar.rebanho;

import controlador.visao.modal.editar.rebanho.ControllerViewEditarBovino;
import java.awt.Dimension;
import modelo.entidade.rebanho.Bovino;
import visao.modal.consulta.rebanho.ViewConsultaBovino;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.rebanho.PanelEditarBovino;

/**
 * <p>Classe de Visao <b>ViewEditarBovino</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao do Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.modal.editar.rebanho.ControllerViewEditarBovino
 * @see    modelo.entidade.rebanho.Bovino
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
    protected PanelEditarBovino createPanel() {
        return new PanelEditarBovino(this, bovino);
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