package progetto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class Archivio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Catalogo> catalogo = new ArrayList<>();
		System.out.println(catalogo.toString());
		Scanner input = new Scanner(System.in);
		
		creacatalogo: while (true) {
			System.out.println(
					"Che azione vuoi eseguire: 1 aggiungi, 2 rimuovi, 3 cerca con IBSN, 4 cerca con autore, 5 cerca per anno Pubblicazione, 6 salvare il catalogo, 0 per finire");
			String azione = input.nextLine();
			if (Integer.parseInt(azione) < 0 || Integer.parseInt(azione) > 6) {
				System.out.println("Hai inserito un numero non valido.");
			}
			switch (Integer.parseInt(azione)) {
			case 0:
				System.out.println("Hai finito");
				break creacatalogo;
			case 1:
				System.out.println("Aggiungi il codice ISBN");
				String codice = input.nextLine();
				System.out.println("Aggiungi il titolo");
				String titolo = input.nextLine();
				System.out.println("Aggiungi l'anno di pubblicazione");
				String anno = input.nextLine();
				int anno1 = Integer.parseInt(anno);
				System.out.println("Aggiungi il numero di pagine");
				String pagine = input.nextLine();
				int pagine1 = Integer.parseInt(pagine);
				System.out.println("Cosa vuoi creare: 1-libro, 2-rivista");
				String creazione = input.nextLine();
				int creazione1 = Integer.parseInt(creazione);
				if (creazione1 == 1) {
					System.out.println("Aggiungi l'autore");
					String autore = input.nextLine();
					System.out.println("Aggiungi il genere");
					String genere = input.nextLine();
					Libri libroagg = new Libri(titolo, autore, genere, codice, anno1, pagine1);
					catalogo.add(libroagg);
					System.out.println(catalogo.toString());
				} else if (creazione1 == 2) {
					System.out.println("Aggiungi la periodicita: 1 -Settimanale, 2-Mensile, 3-Semestrale");
					String periodicita = input.nextLine();
					switch (Integer.parseInt(periodicita)) {
					case 1:
						Riviste rivistaagg = new Riviste(titolo, Type.Settimanale, codice, anno1, pagine1);
					catalogo.add(rivistaagg);
					System.out.println(catalogo.toString());
					break;
				case 2:
					Riviste rivistaagg1 = new Riviste(titolo, Type.Mensile, codice, anno1, pagine1);
					catalogo.add(rivistaagg1);
					System.out.println(catalogo.toString());
					break;
				case 3:
					Riviste rivistaagg2 = new Riviste(titolo, Type.Semestrale, codice, anno1, pagine1);
					catalogo.add(rivistaagg2);
					System.out.println(catalogo.toString());
					break;
				default:
					System.err.println("Attenzione, inserimento numero sbagliato");
					continue creacatalogo;
				}
				}
				break;
			case 2:
				System.out.println(catalogo.toString());
				System.out.println("Inserisci il codice ISBN dell'elemento che vuoi rimuovere");
				String rimuovi = input.nextLine();
				List<Catalogo> resultDelete = catalogo.stream()
//						.filter(element -> ((Riviste) element).remove(element.getISBN().equals(rimuovi)))
//						.filter(element -> ((Libri) element).remove(element.getISBN().equals(rimuovi)))
						.collect(Collectors.toList());
				System.out.println(catalogo.toString());
				resultDelete
						.forEach(s -> System.out.println(s.getTitle() + " " + s.getAnnoPubbl() + " " + s.getISBN()));
				System.out.println(catalogo.toString());
				break;
			case 3:
				System.out.println(catalogo.toString());
				System.out.println("Inserisci il codice ISBN dell'elemento che vuoi cercare");
				String cerca = input.nextLine();
				List<Catalogo> resultFind = catalogo.stream().filter(element -> element.getISBN().equals(cerca))
						.collect(Collectors.toList());
				resultFind.forEach(s -> System.out.println(s.getTitle() + " " + s.getAnnoPubbl() + " " + s.getISBN()));
				break;
			case 4:
				System.out.println("Inserisci l'autore dell'elemento che vuoi cercare");
				String cercaAutore = input.nextLine();
				List<Catalogo> resultFindAutore = catalogo.stream().filter(elem -> elem instanceof Libri)
						.filter(elem -> cercaAutore.equals(((Libri) elem).getAutore())).collect(Collectors.toList());
				resultFindAutore.forEach(s -> System.out.println(s.getTitle()));
				break;
			case 5:
				System.out.println(catalogo.toString());
				System.out.println("Inserisci l'anno dell'elemento che vuoi cercare");
				String cercaAnno = input.nextLine();
				int cercaAnno1 = Integer.parseInt(cercaAnno);
				List<Catalogo> resultFindAnno = catalogo.stream()
						.filter(element -> element.getAnnoPubbl().equals(cercaAnno1))
						.collect(Collectors.toList());
				System.out.println(resultFindAnno.toString());
				resultFindAnno.forEach(s -> System.out.println(s.getTitle() + " " + s.getAnnoPubbl()));
				break;
			case 6:
				try {
					System.out.println(catalogo.toString());
					File foglio = new File("testo.txt");
					String nuovo = catalogo.toString();

					FileUtils.writeStringToFile(foglio, nuovo, "UTF-8");
					System.out.println("Dati salvati correttamente sul file ");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break creacatalogo;
			default:
				System.err.println("Attenzione, inserimento sbagliato");
				continue creacatalogo;
			}
		}
		input.close();
	}
}
	



