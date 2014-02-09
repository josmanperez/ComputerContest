package coursera.perez.computercontest;

public class Puntos {

	private int _puntos;

	public Puntos() {
		_puntos = 0;
	}

	public void addPuntos() {
		_puntos = _puntos + 2;
		
	}
	
	public void subsPuntos(){
		_puntos = _puntos - 1;
	}

	public int mostrarPuntos(){
		return this._puntos;
	}
}
