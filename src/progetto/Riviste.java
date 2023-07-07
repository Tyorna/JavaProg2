package progetto;

public class Riviste extends Catalogo {

	protected Type periodicita;

	public Riviste(String title, Type periodicita, String ISBN, int annoPubbl, int numeroPagine) {
		super(ISBN, title, annoPubbl, numeroPagine);
		this.periodicita = periodicita;
	}

	public Type getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Type periodicita) {
		this.periodicita = periodicita;
	}
	@Override
	public String toString() {
		return "Riviste [ISBN=" + ISBN + ", title=" + title + ", periodicita=" + periodicita + ", annoPubbl="
				+ annoPubbl
				+ ", numeroPagine=" + numeroPagine + "]" + "\n";
	}
}
