package visao.modal.excluir;

import controlador.visao.interfaces.Updatable;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewExcluir</b>.</p>'
 * <p>Classe responsavel por definir a <b>Interface de Exclusao</b> do SGBov.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    visao.modal.ViewModal
 * @see    visao.modal.consulta.ViewConsulta
 */
public abstract class ViewExcluir extends ViewModal {
    private final ViewModal view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Modal.
     */
    public ViewExcluir(ViewModal view) {
        super(view);
        this.view = view;
        setDefaultProperties();
    }
    
    /**
     * Metodo responsavel por definir as Propriedades Padroes das Views de Consulta.
     */
    private void setDefaultProperties() {
        setSize(650, 170);
    }
    
    /**
     * Metodo responsavel por adicionar os Componentes da View Excluir.
     * @param message Mensagem a ser exibida.
     */
    protected void addComponents(String message) {
        addHeader();
        getContentPane().add(createLabel("Confirma exclusão: " +  message + "?"));
        addFooter();
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(25));
        getContentPane().add(createLabelImage("icones/excluir"));
        getContentPane().add(getVerticalSpace(15));
    }
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("sim", "  Sim  ", "sim"));
               footer.add(createLabel("  "));
               footer.add(createButton("nao", "  Não  ", "excluir"));
        getContentPane().add(getVerticalSpace(10));
        getContentPane().add(footer);
    }
    
    /**
     * Metodo responsavel por retornar o Button Sim.
     * @return Button Sim.
     */
    public JButton getButtonSim() {
        return getButton("sim");
    }

    /**
     * Metodo responsavel por retornar o Button Nao.
     * @return Button Nao.
     */
    public JButton getButtonNao() {
        return getButton("nao");
    }
    
    /**
     * Metodo responsavel por retornar a View.
     * @return View.
     */
    public Updatable getView() {
        return (Updatable) view;
    }
}