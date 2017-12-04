package others;

/**
 * Created by biang on 2017/12/4.
 */
public class Newkewang_MagicCoin_NetEasy {
    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]) + 1;
        int zeros = Integer.numberOfLeadingZeros(n);
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '1') sb.append("2");
            else sb.append("1");
        }
        System.out.println(sb.toString().substring(1));
    }
}
