package visao.modal.consulta.rebanho;

import controlador.visao.modal.consulta.rebanho.ControllerViewConsultaPesagem;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.rebanho.PanelFiltroPesagem;

/**
 * <p>Classe de Visao <b>ViewConsultaPesagem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Pesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.modal.consulta.rebanho.ControllerViewConsultaPesagem
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaPesagem extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaPesagem(ViewMenu view) {
        super(view);
        title      = "Consulta de Pesagens";
        controller = new ControllerViewConsultaPesagem(this);
        setProperties();
        addComponents();
        update();
    }

    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(1000, 530));
    }
    
    @Override
    protected PanelFiltroPesagem createFiltro() {
        return new PanelFiltroPesagem(this);
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(900, 275));
        getTable().getColumnModel().getColumn(3).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(4).setCellRenderer(createRightRenderer());
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Bovino", "Sexo", "Data Pesagem", "Valor"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 250, 100, 100, 125};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(super.getTableTotal());
        getContentPane().add(getSpace(10, 1000));
    }

    @Override
    public PanelFiltroPesagem getFiltro() {
        return (PanelFiltroPesagem) super.getFiltro();
    }
}