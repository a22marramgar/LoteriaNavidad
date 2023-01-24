package loteria;

public class Premio {
	private String _numero;
	private Integer _premio;
	
	public Premio(String numero, Integer premio) {
		this._numero = numero;
		this._premio = premio;
	}
	
	public String getNumero() {
		return this._numero;
	}

	public Integer getPremio() {
		return this._premio;
	}

}
