package visao.modal.excluir.estruturais;

import controlador.visao.modal.excluir.estruturais.ControllerViewExcluirBovino;
import java.awt.Dimension;
import modelo.entidade.estruturais.Bovino;
import visao.modal.consulta.estruturais.ViewConsultaBovino;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Visao <b>ViewExluirBovino</b>.</p>
 * <p>Classe responsavel por definir uma <b>Interface de Exclusao do Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  20/12/2020
 * @see    controlador.visao.modal.excluir.estruturais.ControllerViewExcluirBovino
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.modal.excluir.ViewExcluir
 */
public final class ViewExcluirBovino extends ViewExcluir {
    private final Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Bovino.
     * @param bovino_ Bovino.
     */
    public ViewExcluirBovino(ViewConsultaBovino view, Bovino bovino_) {
        super(view);
        bovino     = bovino_;
        title      = "Excluir Bovino";
        controller = new ControllerViewExcluirBovino(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(650, 165));
    }
    
    @Override
    public void addBody() {
        super.addMessage(bovino.getRotulo());
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
}