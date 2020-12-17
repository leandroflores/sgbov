package visao.modal.mensagem;

import controlador.visao.modal.mensagem.ControllerViewMensagem;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.View;
import visao.estilo.ViewStyle;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewMensagem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Mensagem</b> do Sistema.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.mensagem.ControllerViewMensagem
 * @see    visao.View
 * @see    visao.modal.ViewModal
 */
public final class ViewMensagem extends ViewModal {
    private final String texto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     * @param mensagem Mensagem a ser exibida.
     */
    public ViewMensagem(View view, String mensagem) {
        super(view);
        texto      = mensagem;
        controller = new ControllerViewMensagem(this);
        setDefaultProperties();
        initComponents();
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param view View Modal do Sistema.
     * @param mensagem Mensagem a ser exibida.
     */
    public ViewMensagem(ViewModal view, String mensagem) {
        super(view);
        texto      = mensagem;
        controller = new ControllerViewMensagem(this);
        setDefaultProperties();
        initComponents();
    }

    /**
     * Metodo responsavel por definir as Propriedades Padroes da View Mensagem.
     */
    protected void setDefaultProperties() {
        setTitle(ViewStyle.SISTEMA + "Mensagem");
        setSize(texto.length() + 400, 150);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void initComponents() {
        addHeader();
        addComponents();
        addFooter();
    }
    
    @Override
    public void addHeader() {
        add(createLabelImage("icones/mensagem"));
    }
    
    @Override
    public void addComponents() {
        add(createLabel(texto));
    }

    @Override
    public void addFooter() {
        add(createButton("ok", "   Ok   ", "sim"));
    }
    
    /**
     * Metodo responsavel por retornar o Botao Ok.
     * @return Botao Ok.
     */
    public JButton getButtonOk() {
        return getButton("ok");
    }
}