package visao.estruturais.menu;

import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import visao.View;
import visao.painel.logo.PanelLogo;

/**
 * <p>Classe de Visao <b>ViewMenu</b>.</p> 
 * <p>Classe responsavel por definir a <b>View do Menu Principal</b> do SGBov.</p>
 * @author Leandro
 * @since  16/12/2020
 * @see    controlador
 * @see    visao.View
 */
public final class ViewMenu extends View {
    private JMenuBar menu;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public ViewMenu() {
        updateTitle("Menu Principal");
        setDefaultProperties();
        addComponents();
    }
    
    @Override
    protected void setDefaultProperties() {
        super.setDefaultProperties();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    protected void addComponents() {
        addMenu();
        addPanels();
    }
    
    /**
     * Metodo responsavel por adicionar o Menu de Barras.
     */
    private void addMenu() {
        menu = new JMenuBar();
            createMenuRebanho();
            createMenuFinanceiro();
        setJMenuBar(menu);
    }
    
    /**
     * Metodo responsavel por criar o Menu Rebanho da View Menu.
     */
    private void createMenuRebanho() {
        createMenu("rebanho", "Rebanho");
        
        createMenuItem("rebanho_consulta", "Consultar Rebanho", "rebanho/bovino");
        createMenuItem("rebanho_pesagem",  "Pesagem", "rebanho/pesagem");
        createMenuItem("rebanho_vacina",   "Vacina",  "rebanho/vacina");
        
        getMenu("rebanho").add(getMenuItem("rebanho_consulta"));
        getMenu("rebanho").add(getMenuItem("rebanho_pesagem"));
        getMenu("rebanho").add(getMenuItem("rebanho_vacina"));
        menu.add(getMenu("rebanho"));
    }
    
    /**
     * Metodo responsavel por criar o Menu Financeiro da View Menu.
     */
    private void createMenuFinanceiro() {
        createMenu("financeiro", "Financeiro");
        
        createMenuItem("financeiro_movimentacoes", "Movimentações Financeiras", "financeiro/movimentacao");
        
        createMenuItem("financeiro_despesas", "Despesas", "financeiro/despesa");
        createMenuItem("financeiro_receitas", "Receitas", "financeiro/receita");
        
        getMenu("financeiro").add(getMenuItem("financeiro_movimentacoes"));
        getMenu("financeiro").addSeparator();
        getMenu("financeiro").add(getMenuItem("financeiro_despesas"));
        getMenu("financeiro").add(getMenuItem("financeiro_receitas"));
        menu.add(getMenu("financeiro"));
    }
    
    @Override
    protected void addPanels() {
        addVerticalSpace(150);
        getContentPane().add(new PanelLogo());
    }
    
    
    
    public static void main(String[] args) {
        new ViewMenu().setVisible(true);
    }
}