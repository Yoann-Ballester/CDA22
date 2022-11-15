package bookstore.metier;




public class Comptable {
	
	private static double somme = 0;
	
	public static double getTotalPrix() {
		return somme;
	}
	
	public void comptabilise(Livre unLivre) {
		
		somme = somme + unLivre.getPrix();
		
	}
	

	public static void main(String[] args) {
		

	}

}
