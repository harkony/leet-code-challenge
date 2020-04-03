package harkony.weekly.week4;

public class ZigZagConversion {
    public static void main(String[] args) {
        String sample = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";
        String actual = convert(sample, numRows);
        assert (actual.equals(expected));
        System.out.println(actual);

    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        int nPerIteration = 2 * numRows - 2;
        if (nPerIteration == 0)
            return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();


        for (int index = 0; index < len; index++) {
            int remain = index % nPerIteration;
            if (remain == 0) {
                for (int low = 0; low < numRows; low++) {
                    sb[low].append(s.charAt(index++));
                    if (index == len)
                        return convertMatrixToString(sb);
                }
                index -= 1;
                continue;
            }
            int offset = remain - numRows + 1;
            sb[numRows - 1 - offset].append(s.charAt(index));
        }
        return convertMatrixToString(sb);
    }

    public static String convertMatrixToString(StringBuilder[] sbArray) {
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : sbArray) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
