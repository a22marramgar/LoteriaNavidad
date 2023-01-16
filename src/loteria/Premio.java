package loteria;

public class Premio {
	private String _numero;
	private String _premio;
	
	public Premio(String numero, String premio) {
		this._numero = numero;
		this._premio = premio;
	}
	
	public String getNumero() {
		return this._numero;
	}

	public String getPremio() {
		return this._premio;
	}

}
