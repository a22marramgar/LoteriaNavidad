package loteria;

public class Premio {
	private Integer _numero;
	private Integer _premio;
	
	public Premio(Integer numero, Integer premio) {
		this._numero = numero;
		this._premio = premio;
	}
	
	public Integer getNumero() {
		return this._numero;
	}

	public Integer getPremio() {
		return this._premio;
	}

}
