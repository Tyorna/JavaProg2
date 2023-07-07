package progetto;

public abstract class Catalogo {

	protected String ISBN;
	protected String title;
	protected int annoPubbl;
	protected int numeroPagine;

	public Catalogo(String ISBN, String title, int annoPubbl, int numeroPagine) {
		this.ISBN = ISBN;
		this.title = title;
		this.annoPubbl = annoPubbl;
		this.numeroPagine = numeroPagine;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public Integer getAnnoPubbl() {
		return annoPubbl;
	}

	public void setAnnoPubbl(int annoPubbl) {
		this.annoPubbl = annoPubbl;
	}

	public Integer getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
