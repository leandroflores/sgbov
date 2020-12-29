package visao.modal.consulta.rebanho;

import controlador.visao.modal.consulta.rebanho.ControllerViewConsultaInseminacao;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.rebanho.PanelFiltroInseminacao;

/**
 * <p>Classe de Visao <b>ViewConsultaInseminacao</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Inseminacao</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.consulta.rebanho.ControllerViewConsultaInseminacao
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaInseminacao extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaInseminacao(ViewMenu view) {
        super(view);
        title      = "Consulta de Inseminações";
        controller = new ControllerViewConsultaInseminacao(this);
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
    protected PanelFiltroInseminacao createFiltro() {
        return new PanelFiltroInseminacao(this);
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(900, 275));
        getTable().getColumnModel().getColumn(2).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(3).setCellRenderer(createRightRenderer());
        getTable().getColumnModel().getColumn(4).setCellRenderer(createRightRenderer());
    }
    
    @Override
    protected String[] getColumns() {
        return new String[] {"Id", "Ano", "Data Implante", "Data Hormônio", "Data Inseminação"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 150, 150, 150};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(getSpace(10, 1000));
    }
    
    @Override
    public PanelFiltroInseminacao getFiltro() {
        return (PanelFiltroInseminacao) super.getFiltro();
    }
}