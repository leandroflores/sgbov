package visao.painel.consulta.filtro.financeiro;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JTextField;
import visao.modal.consulta.ViewConsulta;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroSimples</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro de Movimentacao Simples</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public final class PanelFiltroSimples extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta.
     */
    public PanelFiltroSimples(ViewConsulta view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setMaximumSize(new Dimension(900, 200));
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Data Pagamento*: ", 140));
        add(createDateTextField("inicio", new Date()));
        add(createDateTextField("final",  new Date()));
        add(createLabel("Descrição: ", 100));
        add(createTextField("descricao", "", 20));
        add(createButtonAtualizar());
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Inicio.
     * @return Text Field Inicio.
     */
    public JTextField getTextFieldInicio() {
        return getTextField("inicio");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Final.
     * @return Text Field Final.
     */
    public JTextField getTextFieldFinal() {
        return getTextField("final");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Descricao.
     * @return Text Field Descricao.
     */
    public JTextField getTextFieldDescricao() {
        return getTextField("descricao");
    }
}