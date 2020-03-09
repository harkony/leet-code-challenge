package harkony;

public class ZigZagConversion {
    public static void main(String[] args) {
        String sample="PAYPALISHIRING";
        int numRows=4;
        String expected="PINALSIGYAHRPI";
        String actual= convert(sample,numRows);
        assert(actual.equals(expected));
        System.out.println(actual);

    }
    public static String convert(String s, int numRows) {
        int len=s.length();
        int nPerIteration = 2*numRows-2;
        if(nPerIteration==0)
            return s;
        int iteration= (len / (nPerIteration))+1;
        int nColPerInteration = numRows-1;
        char matrix[][]=new char[numRows][nColPerInteration*iteration];



        for(int index=0;index<len;index++){
            int carry= index/nPerIteration;
            int remain = index%nPerIteration;
            int baseCol=carry*nColPerInteration;
            if(remain==0){
                for(int low =0; low < numRows;low ++){
                    matrix[low][baseCol]=s.charAt(index++);
                    if(index==len)
                        return convertMatrixToString(matrix);
                }
                index-=1;
                continue;
            }
            int offset = remain-numRows+1;
            matrix[numRows-1-offset][baseCol+offset]= s.charAt(index);
        }
        return convertMatrixToString(matrix);
    }

    public static String convertMatrixToString(char matrix[][]){
        StringBuilder sb=new StringBuilder();
        for(int low=0;low<matrix.length;low++){
            for(int col=0;col<matrix[0].length;col++){
                char c= matrix[low][col];
                if(c!='\0')
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
