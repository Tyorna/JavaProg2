package progetto;

public class Libri extends Catalogo {

	protected String autore;
	protected String genere;

	public Libri(String title, String autore, String genere, String ISBN, int annoPubbl, int numeroPagine) {
		super(ISBN, title, annoPubbl, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", title=" + title + ", autore=" + autore + ", genere=" + genere + ", annoPubbl="
				+ annoPubbl + ", numeroPagine=" + numeroPagine + "]" + "\n";
	}
}
