package visao.modal.mensagem;

import controlador.visao.modal.mensagem.ControllerViewErro;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.View;
import visao.estilo.ViewStyle;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewErro</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Erro</b> do Sistema.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.mensagens.ControllerViewErro
 * @see    visao.View
 * @see    visao.modal.ViewModal
 */
public final class ViewErro extends ViewModal {
    private final String texto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     * @param mensagem Mensagem a ser exibida.
     */
    public ViewErro(View view, String mensagem) {
        super(view);
        texto      = mensagem;
        controller = new ControllerViewErro(this);
        setDefaultProperties();
        initComponents();
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param view View Modal do Sistema.
     * @param mensagem Mensagem a ser exibida.
     */
    public ViewErro(ViewModal view, String mensagem) {
        super(view);
        texto      = mensagem;
        controller = new ControllerViewErro(this);
        setDefaultProperties();
        initComponents();
    }

    /**
     * Metodo responsavel por definir as Propriedades Padroes da View Erro.
     */
    protected void setDefaultProperties() {
        setTitle(ViewStyle.SISTEMA + "Erro");
        setSize(texto.length() + 500, 150);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void initComponents() {
        this.addHeader();
        this.addComponents();
        this.addFooter();
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(createLabelImage("icones/erro"));
    }
    
    @Override
    public void addComponents() {
        getContentPane().add(createLabel(texto));
    }
    
    @Override
    public void addFooter() {
        getContentPane().add(createButton("ok", "   Ok   ", "sim"));
    }

    /**
     * Metodo responsavel por retornar o Botao Ok.
     * @return Botao Ok.
     */
    public JButton getButtonOk() {
        return getButton("ok");
    }
}