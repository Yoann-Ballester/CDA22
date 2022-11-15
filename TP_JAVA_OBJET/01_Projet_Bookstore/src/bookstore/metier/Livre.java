package bookstore.metier;

import java.text.DecimalFormat;
import java.util.Objects;

public class Livre {
	
	
	// var
	private String titre, auteur;
	private int nbPages;
	private double PrixL= -1;
	
	
	
	private boolean prixFixe=false;
	
	
	static Comptable comptable = new Comptable();
	
	
	// contructeur
	
	public Livre(String unAuteur, String unTitre, int Pages, double Prix) {
		auteur = unAuteur;
		titre = unTitre;
		nbPages = Pages;
		setPrix(Prix);
		//Comptable.comptabilise(this);
		
	}
	
	
	public Livre(String unAuteur, String unTitre, int Pages) {
		auteur = unAuteur;
		titre = unTitre;
		nbPages = Pages;
		
	}
	
	public Livre(String unAuteur, String unTitre) {
		auteur = unAuteur;
		titre = unTitre;
		
		
	}
	
	public Livre() {
		
	}
	
	
	
	
	// accesseur
	public String getAuteur( ) {
		return auteur;
	}
	
	public String getTitre( ) {
		return titre;
	}
	
	public int getNbPages( ) {
		
		return nbPages;
	}
	
	
	public double getPrix( ) {
		return PrixL;
	}
	
	// mutateur
	public void setNBpages(int n) {
		
		if (n<0) {
			System.err.print("erreur n ne peut pas etre negatif");
			return;
		}
		nbPages = n;
	}
	
	public void setAuteur(String a) {
		auteur = a;
	}
	
	public void setTitre(String b) {
		titre = b;
	}
	
	public void setPrix(double c) {
		if (c <0)
		{
			System.err.print("non");
			return;
		}
		if (prixFixe)
		{
			System.err.println("Le prix est fixé");
			return;
		}
		
		
		PrixL = c;
		prixFixe = true;
		
		comptable.comptabilise(this);
		
	}
	
		
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nbPages);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return nbPages == other.nbPages;
	}


	public int compare(Livre obj) {
		
		if (this.nbPages==obj.nbPages ) {
			return 0;
		}
		else if (this.nbPages>obj.nbPages) {
			return 1;
		}else {
			return -1;
		}
		
		
		
	}
	
	
	public void afficheToi() {
		
		toString();
	}
	
	@Override public String toString() {
		
		if (PrixL<0) {
			return("Auteur :"+ auteur+"\n" + "titre : "+ titre +"\n"+ "nombre de pages : "+ nbPages + " \nPrix : "+ "Prix indertermine" );
		}
			
		else {
			return("Auteur :"+ auteur+"\n" + "titre : "+ titre +"\n"+ "nombre de pages : "+ nbPages + " \nPrix : "+ new DecimalFormat("#.##").format(PrixL) );
		}
		
	}
	
	
		public static double getTotalPrix() {
		
		return Comptable.getTotalPrix();
	}

	
	public static void main(String[] args) {
		
		
	}



}
