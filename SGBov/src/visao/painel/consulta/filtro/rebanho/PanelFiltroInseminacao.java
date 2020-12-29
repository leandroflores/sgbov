package visao.painel.consulta.filtro.rebanho;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JTextField;
import visao.modal.consulta.rebanho.ViewConsultaInseminacao;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroInseminacao</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro da Inseminacao</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public final class PanelFiltroInseminacao extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Inseminacao.
     */
    public PanelFiltroInseminacao(ViewConsultaInseminacao view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Ano: ", 70));
        add(createYearTextField("ano"));
        add(createLabel("Data Pesagem*: ", 130));
        add(createDateTextField("inicio", new Date()));
        add(createDateTextField("final",  new Date()));
        add(createButtonAtualizar());
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Numero.
     * @return Text Field Ano.
     */
    public JTextField getTextFieldAno() {
        return getTextField("ano");
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
}