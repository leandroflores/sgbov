package visao.modal.consulta.financeiro;

import controlador.visao.modal.consulta.financeiro.ControllerViewConsultaDespesa;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.financeiro.PanelFiltroSimples;

/**
 * <p>Classe de Visao <b>ViewConsultaDespesa</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Despesa</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.modal.consulta.financeiro.ControllerViewConsultaDespesa
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaDespesa extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaDespesa(ViewMenu view) {
        super(view);
        title      = "Consulta de Despesas";
        controller = new ControllerViewConsultaDespesa(this);
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
    protected PanelFiltroSimples createFiltro() {
        return new PanelFiltroSimples(this);
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
        return new String[] {"Id", "Tipo", "Descrição", "Data Pagamento", "Valor"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 250, 100, 125};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(super.getTableTotal());
        getContentPane().add(getSpace(10, 1000));
    }

    @Override
    public PanelFiltroSimples getFiltro() {
        return (PanelFiltroSimples) super.getFiltro();
    }
}