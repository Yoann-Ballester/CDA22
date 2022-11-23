package biblio.test;

import java.text.ParseException;
import java.util.Date;

import biblio.metier_EcritureClasseMetierEntite.Livre;
import biblio.metier_EcritureClasseMetierEntite.Utilisateur;


public class Test_Emprunt_Association_1_1 {

	public static void main(String[] args) throws ParseException {
		
		//////////////////////////////////
		//////////////////////////////////
		//SCENARIO DE TEST POUR ASSOC 1-1
		// 1) EMPRUNT DE LIVRE
		//	affichage du titre de livre emprunté
		// 2) RETOUR DE LIVRE par convention: ref de livre à null
		// 3) EMPRUNT d'un autre LIVRE
		//	affichage du titre de livre emprunté
		//	Attention: test la ref de livre null pour éviter NullPointerException
		//////////////////////////////////
		//////////////////////////////////
		System.out.println();
		System.out.println();
		System.out.println("**********************************");
		System.out.println("*****     ASSOC 1-1 unidir  ******");
		System.out.println("**********************************");
		System.out.println("*****     EMPRUNT DE LIVRE *******");
		System.out.println("**********************************");

/*		Livre l1=null;
		Livre l2=null;*/
		
		Livre l1 = new Livre("Asterix", "Uderzo", 56, Livre.sdf.parse("01/02/2016"), true);
		Livre l2 = new Livre("tintin", "Ergé");

		Utilisateur u1 = new Utilisateur("MARIE JOSEPH", "Carthy", "34890");

		///////////////////////////////////////////////////
		//
		System.out.println("u1 emprunte un livre l1");
		System.out.println("-----------------------");
		u1.setEmprunt(l1);
//		l1.setDisponible(false);//NON
//		l1.setDateEmprunt(new Date());//NON
		u1.getEmprunt().setDisponible(false);//On navigue l'association
		u1.getEmprunt().setDateEmprunt(new Date());
		System.out.println("toString() de utilisateur u1 :" + u1);
		
		///////////////////////////////////////////
		//afficher le titre du livre emprunté
		// "On navigue l'association"
		System.out.println("Quel est le titre du livre emprunté par u1? :" + u1.getEmprunt().getTitre());

		//MIEUX
/*		if( u1.getEmprunt()!= null)
			System.out.println("Le livre emprunté est :" + u1.getLivre().getTitre());
		else
			System.out.println("Pas de livre emprunté");*/
		
		System.out.println("tostring() de utilisateur u1 " + u1);
		
		
		System.out.println();
		System.out.println("**********************************");
		System.out.println("*****      RETOUR DE LIVRE *****");
		System.out.println("**********************************");
		//On rend le livre
		System.out.println("u1 rend son livre");
		System.out.println("-----------------");
		u1.getEmprunt().setDisponible(true); //Désormais, attention au NullPointerException
		u1.setEmprunt(null); //attention au NullPointerException
		System.out.println("tostring() de utilisateur u1 " + u1);

		//affichage du titre du livre emprunté
		if( u1.getEmprunt()!= null)
			System.out.println("Le livre emprunté est :" + u1.getEmprunt().getTitre());
		else
			System.out.println("Pas de livre emprunté");
		
		
		
		//On emprunte un autre livre
		System.out.println();
		System.out.println("*****************************************");
		System.out.println("*****   EMPRUNT D'UN AUTRE LIVRE    *****");
		System.out.println("*****************************************");
		u1.setEmprunt(l2);
		u1.getEmprunt().setDisponible(false);
		u1.getEmprunt().setDateEmprunt(new Date());
		System.out.println("toString() de utilisateur u1 :" + u1);

		//affichage du titre du livre emprunté
		if( u1.getEmprunt()!= null)
			System.out.println("Le livre emprunté :" + u1.getEmprunt().getTitre());
		else
			System.out.println("Pas de livre emprunté");
		
		//////////////////////////////////
		// Evolution possible (si nécessaire)
		// assoc 1_1 bidirectionnelle 

		//////////////////////////////////
		//////////////////////////////////
		//SCENARIO DE TEST POUR ASSOC 1-N
		// 1) EMPRUNT D'UN premier LIVRE
		// 2) EMPRUNT D'UN deuxième LIVRE
		// 3)	affichage de tous les  titres de livre empruntés
		
	}

}
