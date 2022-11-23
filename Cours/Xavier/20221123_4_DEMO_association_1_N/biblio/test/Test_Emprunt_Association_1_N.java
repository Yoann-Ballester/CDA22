package biblio.test;

import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

import biblio.metier_EcritureClasseMetierEntite.Livre;
import biblio.metier_EcritureClasseMetierEntite.Utilisateur;


public class Test_Emprunt_Association_1_N {

	public static void main(String[] args) throws ParseException {
		
	
		//////////////////////////////////
		//////////////////////////////////
		//SCENARIO DE TEST POUR ASSOC 1-N
		// 1) EMPRUNT D'UN premier LIVRE
		// 2) EMPRUNT D'UN deuxième LIVRE
		//
		//	affichage du nombre d'emprunts
		//vous pourriez mettre à jour le toString de l'utilisateur pour qu'il affiche le nb d'emprunts
		//	affichage de tous les  titres de livre empruntés
		

		Livre l1 = new Livre("Asterix", "Uderzo", 56, Livre.sdf.parse("01/02/2016"), true);
		Livre l2 = new Livre("tintin", "Ergé");

		Utilisateur u1 = new Utilisateur("MARIE JOSEPH", "Carthy", "34890");


		System.out.println();
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("*****     ASSOC 1-N unidir  *****************");
		System.out.println("*********************************************");
		System.out.println("*****     EMPRUNT DE PLUSIEURS LIVRES *******");
		System.out.println("*********************************************");
		
		u1.addLivre(l1);
		u1.addLivre(l2);
		System.out.println("toString() de l'utilisateur u1 :" + u1);
		
		System.out.println("nb d'emprunts de l'utilisateur u1 : " + u1.getLivres().size());

		System.out.println();
		System.out.println("Voici la liste des livres empruntés par u1 :");
		System.out.println("------------------------------------------ :");

		if(u1.getLivres().size() >=1 )
		{
			Iterator<Livre> it = u1.getLivres().iterator();
			Livre l;
			while( it.hasNext()){
				l = it.next();
				System.out.println("\t" + l.getTitre());
			}
		}
		else
			System.out.println("Pas de livre emprunté");
		
		//////////////////////////////////
		// suite du SCENARIO DE TEST 
		// A CONTINUER AVEC LE RETOUR DE certains LIVRES
		
		
	}

}
