package visao.modal.pesquisa.estruturais;

import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.pesquisa.ViewPesquisa;
import visao.painel.pesquisa.estruturais.PanelPesquisaBovino;

/**
 * <p>Classe de Visao <b>ViewPesquisaBovino</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Pesquisa de Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.modal.pesquisa.
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.modal.pesquisa.ViewPesquisa
 */
public final class ViewPesquisaBovino extends ViewPesquisa {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewPesquisaBovino(ViewModal view) {
        super(view);
        title      = "Pesquisa de Bovinos";
        //controller = new ControllerViewConsultaBovino(this);
        setProperties();
        addComponents();
        update();
    }

    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(1000, 560));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getSpace(20, 1000));
        addPanel("panel_pesquisa", new PanelPesquisaBovino(this));
        getContentPane().add(getPanelPesquisa());
        getContentPane().add(getSpace(10, 1000));
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(500, 275));
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Tipo", "Número", "Sexo"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 150, 100};
    }
    
    @Override
    public PanelPesquisaBovino getPanelPesquisa() {
        return (PanelPesquisaBovino) getPanel("panel_pesquisa");
    }
}