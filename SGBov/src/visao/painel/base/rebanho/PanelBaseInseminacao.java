package visao.painel.base.rebanho;

import controlador.visao.painel.base.rebanho.ControllerPanelBaseInseminacao;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import modelo.controlador.rebanho.inseminacao.ControllerMatriz;
import modelo.entidade.rebanho.Inseminacao;
import modelo.entidade.rebanho.inseminacao.Matriz;
import visao.painel.Panel;
import visao.painel.base.PanelBase;

/**
 * <p>Classe de Visao <b>PanelBaseInseminacao</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewBaseInseminacao</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.base.rebanho.ControllerPanelBaseInseminacao
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    visao.painel.base.PanelBase
 */
public final class PanelBaseInseminacao extends PanelBase {
    private final Inseminacao inseminacao;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Owner.
     * @param inseminacao_ Inseminacao.
     */
    public PanelBaseInseminacao(Panel panel, Inseminacao inseminacao_) {
        super(panel);
        inseminacao = inseminacao_;
        controller  = new ControllerPanelBaseInseminacao(this);
        setProperties();
        addComponents();
        setValues();
    }
    
    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(400, 525));
        setMaximumSize(new Dimension(400, 525));
        setLayout(new GridLayout(6, 2));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Ano*: "));
        add(createYearTextField("ano"));
        
        add(createRightLabel("Data Implante*: "));
        add(createDateTextField("implante", new Date()));
        
        add(createRightLabel("Data Hormônio*: "));
        add(createDateTextField("hormonio", new Date()));
        
        add(createRightLabel("Data Inseminação: "));
        add(createDateTextField("inseminacao", new Date()));
        
        add(createRightLabel("Total de Matrizes: "));
        add(createTextFieldNoEditable("matrizes", "0", 8));
        
        add(createRightLabel("Total de Prenhas: "));
        add(createTextFieldNoEditable("prenhas", "0", 8));
    }
    
    @Override
    public void setValues() {
        getTextFieldAno().setText(Integer.toString(inseminacao.getAno()));
        getTextFieldImplante().setText(new FunctDate().getFormattedDate(inseminacao.getDataImplante()));
        getTextFieldHormonio().setText(new FunctDate().getFormattedDate(inseminacao.getDataHormonio()));
        getTextFieldInseminacao().setText(new FunctDate().getFormattedDate(inseminacao.getDataInseminacao()));
        getTextFieldMatrizes().setText(Integer.toString(inseminacao.getTotal()));
        getTextFieldPrenhas().setText(Integer.toString(inseminacao.getPrenhas()));
    }
    
    /**
     * Metodo responsavel por atualizar o Painel de Matrizes.
     * @param matrizes Lista de Matrizes.
     */
    public void updateMatrizes(List<Matriz> matrizes) {
        getTextFieldMatrizes().setText(Integer.toString(matrizes.size()));
        getTextFieldPrenhas().setText(Integer.toString(new ControllerMatriz().filterPrenhas(matrizes).size()));
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Ano.
     * @return Text Field Ano.
     */
    public JTextField getTextFieldAno() {
        return getTextField("ano");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Implante.
     * @return Text Field Implante.
     */
    public JTextField getTextFieldImplante() {
        return getTextField("implante");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Hormonio.
     * @return Text Field Hormonio.
     */
    public JTextField getTextFieldHormonio() {
        return getTextField("hormonio");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Inseminacao.
     * @return Text Field Inseminacao.
     */
    public JTextField getTextFieldInseminacao() {
        return getTextField("inseminacao");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Matrizes.
     * @return Text Field Matrizes.
     */
    public JTextField getTextFieldMatrizes() {
        return getTextField("matrizes");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Prenhas.
     * @return Text Field Prenhas.
     */
    public JTextField getTextFieldPrenhas() {
        return getTextField("prenhas");
    }
}