
package csomag;

import java.util.Arrays;
import java.util.Scanner;

public class BekaJatek {

    static Scanner sc = new Scanner(System.in);
    static final String BEKA = "🐸";
    static final String MAJOM = "🐒";
    static final String URES = "___";
    
    public static void main(String[] args) {
        
        
        String[] jatekter = {BEKA, BEKA, BEKA, URES, MAJOM, MAJOM, MAJOM};
        String[] jatekVege = {MAJOM, MAJOM, MAJOM, URES, BEKA, BEKA, BEKA};
        
        megjelenites(jatekter);
        
        while (!Arrays.equals(jatekter, jatekVege)) {
            String kezdo;
            do {
                System.out.print("Mivel akarsz lépni? (B-M): ");
                kezdo = sc.next();
            } while (!kezdo.contentEquals("B") && !kezdo.contentEquals("M"));
            
            if (kezdo.contentEquals("B")) {
                lepes(jatekter, BEKA);
                
                megjelenites(jatekter);
            }
            else {
                lepes(jatekter, MAJOM);
                
                megjelenites(jatekter);
            }
        }
        System.out.println("Gratulálok, nyertél!");
    }

    private static void lepes(String[] jatekter,String karakter) {
        int lepes;
        do {
            System.out.printf("Melyik %s -al lépsz? ", karakter);
            lepes = sc.nextInt();
        } while (!lephetKarakterrel(lepes-1, karakter, jatekter));
        
        for (int i = 0; i < jatekter.length; i++) {
            if (jatekter[i].contentEquals(URES)) {
                jatekter[i] = karakter;
            }
        }
        jatekter[lepes-1] = URES;
    }

    private static void megjelenites(String[] jatekter) {
        for (int i = 0; i < jatekter.length; i++) {
            System.out.printf("| %s ", jatekter[i]);
        }
        System.out.println("|");
        for (int i = 0; i < jatekter.length; i++) {
            System.out.printf("%3d  ", i+1);
        }
        System.out.println();
    }
    
    static boolean lephetKarakterrel(int index, String karakter, String[] felallas) {
        boolean lephet = false;
        if (index == 0) {
            if (felallas[index].contentEquals(karakter)) {
                if (felallas[index+1].contentEquals(URES) || felallas[index+2].contentEquals(URES)) {
                    lephet = true;
                }
            }
        }
        else if (index == 1) {
            if (felallas[index].contentEquals(karakter)) {
                if (felallas[index+1].contentEquals(URES) || felallas[index+2].contentEquals(URES) || felallas[index-1].contentEquals(URES)) {
                    lephet = true;
                }
            }
        }
        else if (index >= 2 && index <= 4) {
            if (felallas[index].contentEquals(karakter)) {
                if (felallas[index+1].contentEquals(URES) || felallas[index+2].contentEquals(URES) || felallas[index-1].contentEquals(URES) || felallas[index-2].contentEquals(URES)) {
                    lephet = true;
                }
            }
        }
        else if (index == 5) {
            if (felallas[index].contentEquals(karakter)) {
                if (felallas[index+1].contentEquals(URES) || felallas[index-2].contentEquals(URES) || felallas[index-1].contentEquals(URES)) {
                    lephet = true;
                }
            }
        }
        else {
            if (felallas[index].contentEquals(karakter)) {
                if (felallas[index-2].contentEquals(URES) || felallas[index-1].contentEquals(URES)) {
                    lephet = true;
                }
            }
        }
        return lephet;
    }
}
