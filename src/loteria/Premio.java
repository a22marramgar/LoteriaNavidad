package loteria;

public class Premio {

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
