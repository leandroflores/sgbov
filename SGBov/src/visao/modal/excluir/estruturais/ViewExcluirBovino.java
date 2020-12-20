package visao.modal.excluir.estruturais;

import controlador.visao.modal.excluir.estruturais.ControllerViewExcluirBovino;
import javax.swing.BoxLayout;
import modelo.entidade.estruturais.Bovino;
import visao.estilo.ViewStyle;
import visao.modal.consulta.estruturais.ViewConsultaBovino;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Visao <b>ViewExluirBovino</b>.</p>
 * <p>Classe responsavel por definir uma <b>Interface de Exclusao do Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  20/12/2020
 * @see    controlador.visao.modal.excluir.
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.modal.excluir.ViewExcluir
 */
public final class ViewExcluirBovino extends ViewExcluir {
    private final Bovino bovino;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Bovino.
     * @param bovino Bovino.
     */
    public ViewExcluirBovino(ViewConsultaBovino view, Bovino bovino) {
        super(view);
        this.controller = new ControllerViewExcluirBovino(this);
        this.bovino     = bovino;
        initComponents();
        addComponents();
    }

    @Override
    public void initComponents() {
        setTitle(ViewStyle.SISTEMA + "Excluir Bovino");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    @Override
    public void addComponents() {
        super.addComponents(bovino.toString());
    }
    
    /**
     * Metodo responsavel por retornar o Bovino.
     * @return Bovino.
     */
    public Bovino getBovino() {
        return bovino;
    }
}