package bookstore.test;

import java.util.HashSet;

import bookstore.metier.Livre;

public class TestSetLivre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashSet<Livre> col = new HashSet<Livre>();
		
		Livre L1 = new Livre("Aaaaa","Bbbbb",145,14.5);
		Livre L2 = new Livre("Ccccc","Ddddd",120,64.5);
		Livre L3 = new Livre("Eeeee","Fffff",145,24.5);
		Livre L4 = new Livre("Ggggg","Hhhhh",165,24.5);
		
		col.add(L1);
		col.add(L2);
		col.add(L3);
		col.add(L4);
		
		
		for(Livre Val:col)
			System.out.println("\n"+Val);
		System.out.println(col.contains(L3));
		
	}
	
	
	
		
}
