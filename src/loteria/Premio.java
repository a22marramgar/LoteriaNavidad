package loteria;

import java.io.Serializable;

/**
 * Emmagatzemarem a la clase Premio el numero i el premi que ha tocat
 * @author ausias
 */

public class Premio implements Serializable {

    private String _numero;
    private Integer _premio;

    /**
     * Constructor de Premio
     *
     * @param numero
     * @param premio
     */
    public Premio(String numero, Integer premio) {
        this._numero = numero;
        this._premio = premio;
    }

    /**
     * Demana a Premio el numero
     *
     * @return Numero del Premio
     */
    public String getNumero() {
        return this._numero;
    }

    /**
     * Demana a Premio el premi
     *
     * @return Premi del Premio
     */
    public Integer getPremio() {
        return this._premio;
    }

}
