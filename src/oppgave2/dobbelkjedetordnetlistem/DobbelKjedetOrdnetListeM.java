package oppgave2.dobbelkjedetordnetlistem;

import oppgave2.adt.DobbelKjedetOrdnetListeMADT;

//********************************************************************
//  
//  Representerer en dobbeltkjedet ordnet liste med midtpeker.
//********************************************************************
;

public class DobbelKjedetOrdnetListeM<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T> {
//M for midtpeker
	private DobbelNode<T> first;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;

	/******************************************************************
	 * Oppretter en tom liste.
	 ******************************************************************/
	// Konstrukt�r

	public DobbelKjedetOrdnetListeM(T minVerdi, T maksVerdi) {

		// F�rste node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		first = nyNode1;
		midten = first;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	@Override
	public void leggTil(T el) {

		// Setter inn ordnet f�r den noden p peker p�
		DobbelNode<T> p;

		if ((el.compareTo(first.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + first.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			antall++;

			if (el.compareTo(midten.getElement()) >= 0) {// Finn plass i siste
															// halvdel
				p = midten.getNeste();
			} else { // Finn plass i f�rste halvdel
				p = first.getNeste();
			}

			while (el.compareTo(p.getElement()) >= 0) {
				p = p.getNeste();
			} // while

			// Setter inn:
			// Innsett foran noden som p peker p�

			DobbelNode<T> nyNode = new DobbelNode<T>(el);
				nyNode.setNeste(p);
				nyNode.setForrige(p.getForrige());
				nyNode.getNeste().setForrige(nyNode);
				nyNode.getForrige().setNeste(nyNode);



//				if(el.compareTo(first.getNeste().getElement()) <0)
//					first=nyNode;
//				if(el.compareTo(siste.getForrige().getElement()) >0)
//					siste=nyNode;


			// Fyll ut med noen f� setninger

			// Oppdaterer ny midten
			nyMidten();

		} // else lovlige

	}//

	// **********************************************************************************
	// Hjelpemetode til � finne ny midten.
	// Mindre effektiv fordi vi m� gjennomg� ca halve listen, men greit nok,
	// ellers kan en teste p� om antall er partall er oddetall ved oppdatering
	// av midtpeker
	// *********************************************************************************
	private void nyMidten() {
		int midtNR = antall / 2;
		DobbelNode<T> p = first.getNeste();
		for (int i = 1; i <= midtNR; i++) {
			p = p.getNeste();
		}
		midten = p;
	}//

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
	@Override
	public boolean fins(T el) {
		boolean funnet = false;
		DobbelNode<T> p = null;
		if ((el.compareTo(first.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + first.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
				p = midten; // Midten defineres � tilh�re siste del
			} else { // Let i f�rste halvdel
				p = first.getNeste();
			}

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while

			// Test p� funnet
			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}
		} // else
		return funnet;
	}//

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
    // Omskrive til � bruke finn-metoden
	@Override
	public T fjern(T el) {
		// Ugyldig. Alternativt kan vi ha det som et forkrav!
		if ((el.compareTo(first.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0))
			System.out.println("Ugyldig verdi. verdi > " + first.getElement() + "verdi < " + siste.getElement());
		DobbelNode<T> p = finn(el);
		if(p == null)
			return null;
		antall--;
		p.getForrige().setNeste(p.getNeste());
		p.getNeste().setForrige(p.getForrige());
		nyMidten();
		return p.getElement();
	}//

	/* Alternativ kan fjern-metoden bruke finn-metoden */

	private DobbelNode<T> finn(T el) {
		DobbelNode<T> node = null;
		DobbelNode<T> p = null;

		// Kun lovlige verdier
		if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			p = midten; // Midten defineres � tilh�re siste del
		} else { // Let i f�rste halvdel
			p = first.getNeste();
		}
		while (el.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} // while

		// Test p� funnet
		if (el.compareTo(p.getElement()) == 0) {
			node = p;
		}
		return node;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	public void skrivListe() {
		DobbelNode<T> p = first;

		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}

		System.out.println(
				"Foerste:" + first.getElement() + " Midten:" + midten.getElement() + " Siste:" + siste.getElement());
		System.out.println();

	}//

}// class
