package rinor;

import net.egork.utils.io.InputReader;
import net.egork.utils.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int startChar = 65;
//        HashMap<Character, Integer> polMap = new HashMap<>();
        int nParties = in.readInt();
        int [] polit = new int[nParties];

        int total = 0;
        for (int i = 0; i < nParties; i++) {
            polit[i] = in.readInt();
            total += polit[i];
        }

        out.print("Case #"+testNumber+": " + ejaculate(polit, total).trim() + "\n");


    }

    private String ejaculate(int[] polit, int total) {
        StringBuilder sb = new StringBuilder();
        while(total != 0) {
//            System.out.println("while loop-"+ total);
            int max = 0;
            int indexOfMax = -1;

        /*----*/
            int max2 = 0;
            int indexOfMax2 = -1;
            for (int i = 0; i < polit.length; i++) {
                if (max < polit[i]) {
                    max = polit[i];
                    indexOfMax = i;
                }
//                System.out.println("First loop");
            }
            polit[indexOfMax]--;
            total--;
            if (titlsTheBalance(polit, total)) {
                for (int i = 0; i < polit.length; i++) {
                    if (max2 < polit[i]) {
                        max2 = polit[i];
                        indexOfMax2 = i;
                    }
//                    System.out.println("second loop");
                }
                polit[indexOfMax2]--;
                total--;
                if (titlsTheBalance(polit, total)) {
                    polit[indexOfMax]++;
                    polit[indexOfMax2]++;
                    total += 2;
                    indexOfMax = -1;
                    indexOfMax2 = -1;
                }
            }
            if (indexOfMax != -1)
                sb.append(" " + (char) (indexOfMax + 65) + (indexOfMax2 != -1 ? (char) (indexOfMax2 + 65) : ""));

        }
        return sb.toString();
    }

    public static boolean titlsTheBalance(int[] polit, int total)
    {
        for (int i = 0; i < polit.length; i++) {
//            System.out.println("third loop n method");
            if (((double)polit[i]*100)/total > 50)
                return true;
        }
        return false;
    }

}
