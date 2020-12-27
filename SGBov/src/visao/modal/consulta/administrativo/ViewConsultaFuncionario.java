package visao.modal.consulta.administrativo;

import controlador.visao.modal.consulta.administrativo.ControllerViewConsultaFuncionario;
import java.awt.Dimension;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.administrativo.PanelFiltroFuncionario;

/**
 * <p>Classe de Visao <b>ViewConsultaFuncionario</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Consulta de Funcionario</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.consulta.administrativo.ControllerViewConsultaFuncionario
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.modal.consulta.ViewConsulta
 */
public final class ViewConsultaFuncionario extends ViewConsulta {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewConsultaFuncionario(ViewMenu view) {
        super(view);
        title      = "Consulta de Funcionários";
        controller = new ControllerViewConsultaFuncionario(this);
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
        addPanel("panel_filtro", new PanelFiltroFuncionario(this));
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
        return new String[] {"Id", "CPF", "Nome", "Data Nascimento", "Salário"};
    }
    
    @Override
    protected Integer[] getSizes() {
        return new Integer[] {50, 100, 250, 100, 125};
    }
    
    @Override
    protected void addTableFooter() {
        getContentPane().add(getSpace(10, 1000));
        getContentPane().add(super.getTableCount());
        getContentPane().add(getSpace(10, 1000));
    }

    /**
     * Metodo responsavel por retornar o Panel Filtro Funcionario.
     * @return Panel Filtro Funcionario.
     */
    public PanelFiltroFuncionario getPanelFiltro() {
        return (PanelFiltroFuncionario) getPanel("panel_filtro");
    }
}