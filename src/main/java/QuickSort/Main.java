/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

import javax.swing.JOptionPane;

/**
 *
 * @author lucaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final Object verrou = new Object();
    public static final Object verrou_ecran = new Object();
    public static int num_threads;
    public static final int Limit_Threads = 6;

    public static void main(String[] args) {
        // TODO code application logic here
        String N;
        int n;
        int c;
        int i;
        int f = 0;
        int flag;
        num_threads = 1;
        N = JOptionPane.showInputDialog("Nombre d'�lements du tableau");
        isNumber num = new isNumber(N);
        if (num.check(N) == true) {
            n = num.isN(N);
//            System.out.println(n);
            int[] T = new int[n];
            flag=JOptionPane.showConfirmDialog(null,"Est ce que tu veux cr�er le vecteur manuelement?","Random Vector",JOptionPane.YES_NO_OPTION);
            
            for (i = 0; i <= n - 1; i++) {
                if (flag==0){
                c = Integer.parseInt(JOptionPane.showInputDialog(String.format("�lement %d du tableau", i + 1)));
                }else{
                    c = (int) (Math.random()*100+1);
                }
                T[i] = c;
                if (i > 0 && f == 0) {
                    if (T[i - 1] > T[i]) {
                        f = 1;
                    }
                }
            }
//            System.out.println(T[1]);
            if (n == 1) {

            } else if (n == 2) {
                int aux;
                if (T[0] > T[1]) {

                    aux = T[1];
                    T[1] = T[0];
                    T[0] = aux;
                }
            } else if (f == 1 && n > 2) {
//                System.out.println("Entra");
//                for (int k = 0; k < T.length; k++) {
//                    System.out.print(T[k] + " ");
//                }
//                System.out.println("");
//                System.out.println("Entra primero");
//                flag = false;
                Triage tri = new Triage("1",T, n);
//                tri.isT();

                Thread th = new Thread(tri);
                th.start();
//                T = tri.isT();
            }
//            System.out.println("FIN ");
//            for (int k = 0; k < T.length; k++) {
//                System.out.print(T[k] + " ");
//            }
//            System.out.println(" ");
        }

    }
}
