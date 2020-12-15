package controlador.visao;

import controlador.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.View;

/**
 * <p>Classe de Controle <b>ControllerView</b>.</p>
 * <p>Classe responsavel por controlar os <b>Eventos</b> das Views do SGBov.</p>
 * @author Leandro
 * @since  15/12/2020
 * @see    controlador.Controller
 * @see    visao.View
 */
public abstract class ControllerView extends Controller {
    private final View view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ControllerView(View view) {
        this.view = view;
    }
    
    @Override
    public abstract void actionPerformed(ActionEvent event);

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == ESC)
            view.dispose();
    }
}