package it.unibs.TesteAnnidate;

public class Pietra {

	private Elementi elementoRiferimento;

	public Pietra(Elementi elemento) {
		this.elementoRiferimento = elemento;
	}

	public Elementi getElementoRiferimento() {
		return elementoRiferimento;
	}

	public void setElementoRiferimento(Elementi elementoRiferimento) {
		this.elementoRiferimento = elementoRiferimento;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pietra other = (Pietra) obj;
		if (!(elementoRiferimento.toString().equals(other.elementoRiferimento.toString())))
			return false;
		return true;
	}
	

}
