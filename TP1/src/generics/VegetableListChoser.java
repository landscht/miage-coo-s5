package generics;

import scanner.*;
import java.util.*;

public class VegetableListChoser {

    // methode chose
    // elle est similaire a celle de ListChoser simplement elle ne fonctionne
    // qu'avec des listes d'objets de type Legume (cf. interface Legume)
    // quel changement apporter a la methode de ListChoser  ?
    
    public static void main(String[] args) {
		List<Carrot> lCarrots = new ArrayList<Carrot>();
		lCarrots.add(new Carrot(1));
		lCarrots.add(new Carrot(2));
		lCarrots.add(new Carrot(3));

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		lApples.add(new Apple(2));
		lApples.add(new Apple(3));

		VegetableListChoser lcl = new VegetableListChoser();

		Carrot chosenCarrot = lcl.chose("which carrot ? ", lCarrots);
		System.out.println("You have chosen : " + chosenCarrot);

		// NE COMPILE PAS
		//Apple chosenApple = lcl.chose("which apple ? ",lApples);


    }

	public <T extends Vegetable> T chose(String string, List<T> lT) {
		String s = "Choisissez un élément :\n";
		s+="0 - Aucun\n";
		for(int i=0;i<lT.size();i++){
			s+=i+1+" - "+lT.get(i)+"\n";
		}
		System.out.println(s);
		int j;
		do{
			j = ScannerInt.readInt(lT.size()+1);
		}while(j<0 || j> lT.size()+1);
		if(j==0){
			return null;
		}
		return lT.get(j-1);
	}
}
