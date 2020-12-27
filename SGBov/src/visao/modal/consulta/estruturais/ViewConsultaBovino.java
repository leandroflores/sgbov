package visao.modal.consulta.estruturais;

import controlador.visao.modal.consulta.estruturais.ControllerViewConsultaBovino;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.estruturais.PanelFiltroBovino;

/**
 * <p>Classe de Visao <b>ViewConsultaBovino</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.consulta.estruturais.ControllerViewConsultaBovino
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaBovino extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaBovino(ViewMenu view) {
        super(view);
        title      = "Consulta de Bovinos";
        controller = new ControllerViewConsultaBovino(this);
        setProperties();
        addComponents();
        update();
    }

    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(1000, 570));
    }
    
    @Override
    protected PanelFiltroBovino createFiltro() {
        return new PanelFiltroBovino(this);
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(900, 275));
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Tipo", "Número", "Sexo", "Data Nascimento", "Peso"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 150, 100, 100, 125};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(getSpace(10, 1000));
    }
    
    @Override
    public PanelFiltroBovino getFiltro() {
        return (PanelFiltroBovino) super.getFiltro();
    }
}