package visao.modal.consulta.financeiro;

import controlador.visao.modal.consulta.financeiro.ControllerViewConsultaMovimentacao;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.financeiro.PanelFiltroMovimentacao;

/**
 * <p>Classe de Visao <b>ViewConsultaMovimentacao</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Movimentacao</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.modal.consulta.financeiro.ControllerViewConsultaMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaMovimentacao extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaMovimentacao(ViewMenu view) {
        super(view);
        title      = "Consulta de Movimentações Financeiras";
        controller = new ControllerViewConsultaMovimentacao(this);
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
    public void addHeader() {
        getContentPane().add(getSpace(20, 1000));
        addPanel("panel_filtro", new PanelFiltroMovimentacao(this));
        getContentPane().add(getPanelFiltro());
        getContentPane().add(getSpace(20, 1000));
    }
    
    @Override
    protected void setTableHeader() {
        super.setTableHeader();
        getScrollPane().setPreferredSize(new Dimension(900, 275));
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

    /**
     * Metodo responsavel por retornar o Panel Filtro Movimentacao.
     * @return Panel Filtro Movimentacao.
     */
    public PanelFiltroMovimentacao getPanelFiltro() {
        return (PanelFiltroMovimentacao) getPanel("panel_filtro");
    }
}