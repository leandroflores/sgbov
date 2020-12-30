package visao.modal.pesquisa.rebanho;

import controlador.visao.modal.pesquisa.rebanho.ControllerViewPesquisaMatriz;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.pesquisa.ViewPesquisa;
import visao.painel.pesquisa.rebanho.PanelPesquisaMatriz;

/**
 * <p>Classe de Visao <b>ViewPesquisaMatriz</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Pesquisa de Matriz</b> do SGBov.</p>
 * @author Leandro
 * @since  30/12/2020
 * @see    controlador.visao.modal.pesquisa.rebanho.ControllerViewPesquisaMatriz
 * @see    modelo.entidade.rebanho.Bovino
 * @see    visao.modal.pesquisa.ViewPesquisa
 */
public final class ViewPesquisaMatriz extends ViewPesquisa {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewPesquisaMatriz(ViewModal view) {
        super(view);
        title      = "Pesquisa de Matrizes";
        controller = new ControllerViewPesquisaMatriz(this);
        setProperties();
        addComponents();
        update();
    }

    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(750, 425));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getSpace(20, 750));
        addPanel("panel_pesquisa", new PanelPesquisaMatriz(this));
        getContentPane().add(getPanelPesquisa());
        getContentPane().add(getSpace(10, 750));
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(700, 275));
        getScrollPane().setMaximumSize(new Dimension(700, 275));
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
    public PanelPesquisaMatriz getPanelPesquisa() {
        return (PanelPesquisaMatriz) getPanel("panel_pesquisa");
    }
}