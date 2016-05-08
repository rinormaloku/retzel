package rinor;

import net.egork.utils.io.InputReader;
import net.egork.utils.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int nth = in.readInt();
        int snaps = in.readInt();
        String binary = Integer.toBinaryString(snaps);

        if(binary.length() < nth) {
            out.print("Case #" + testNumber + ": OFF\n");
            return;
        }
        String subString = binary.substring(binary.length() - nth);

        for (char c: subString.toCharArray()) {
            if (c != '1') {
                out.print("Case #" + testNumber + ": OFF\n");
                return;
            }
        }

        out.print("Case #" + testNumber + ": ON\n");
    }
}
