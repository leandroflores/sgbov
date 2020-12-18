package modelo.controlador;

import java.util.List;
import modelo.entidade.Entidade;

/**
 * <p>Classe de Controle <b>ControllerEntidade</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador</b> da Classe de Modelo <b>Entidade</b>.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    modelo.entidade.Entidade
 */
public abstract class ControllerEntidade {
 
    /**
     * Metodo responsavel por retornar uma Matriz com os Dados das Entidades.
     * @param  lista Lista de Entidades.
     * @return Matriz com os Dados das Entidades.
     */
    public String[][] getMatriz(List<? extends Entidade> lista) {
        String dados[][] = new String[lista.size()][];
        for (int i = 0; i < lista.size(); i++)
               dados[i]  = lista.get(i).getDados();
        return dados;
    }
}