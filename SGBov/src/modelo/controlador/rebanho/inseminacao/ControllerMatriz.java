package modelo.controlador.rebanho.inseminacao;

import java.util.ArrayList;
import java.util.List;
import modelo.controlador.ControllerEntidade;
import modelo.entidade.rebanho.inseminacao.Matriz;

/**
 * <p>Classe de Controle <b>ControllerMatriz</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador</b> da Classe de Entidade <b>Matriz</b>.</p>
 * @author Leandro
 * @since  30/12/2020
 * @see    modelo.controlador.ControllerEntidade
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 */
public class ControllerMatriz extends ControllerEntidade {
    
    /**
     * Metodo responsavel por retornar a Lista de Prenhas de uma Lista de Matrizes.
     * @param  list Lista de Matrizes.
     * @return Lista de Prenhas filtradas.
     */
    public List filterPrenhas(List<Matriz> list) {
        List   filter = new ArrayList();
        for (Matriz matriz : list) {
            if (matriz.isPrenha())
               filter.add(matriz);
        }
        return filter;
    }
}