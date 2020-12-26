package visao.modal.editar.estruturais;

import controlador.visao.modal.editar.estruturais.ControllerViewEditarPesagem;
import java.awt.Dimension;
import modelo.entidade.estruturais.Pesagem;
import visao.modal.consulta.estruturais.ViewConsultaPesagem;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.estruturais.PanelEditarPesagem;

/**
 * <p>Classe de Visao <b>ViewEditarPesagem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao de Pesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.editar.estruturais.ControllerViewEditarPesagem
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.editar.ViewEditar
 */
public final class ViewEditarPesagem extends ViewEditar {
    private final Pesagem pesagem;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Pesagem.
     * @param pesagem_ Pesagem.
     */
    public ViewEditarPesagem(ViewConsultaPesagem view, Pesagem pesagem_) {
        super(view);
        pesagem    = pesagem_;
        title      = "Editar Pesagem";
        controller = new ControllerViewEditarPesagem(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(500, 240));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void addBody() {
        addPanel("panel_editar", new PanelEditarPesagem(this, pesagem));
        getContentPane().add(getPanelEditar());
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void setValues() {
        getPanelEditar().setValues();
    }
    
    /**
     * Metodo responsavel por retornar a Pesagem.
     * @return Pesagem.
     */
    public Pesagem getPesagem() {
        return pesagem;
    }
    
    @Override
    public PanelEditarPesagem getPanelEditar() {
        return (PanelEditarPesagem) super.getPanelEditar();
    }
}