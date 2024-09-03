import java.util.HashMap;
import java.util.Map;

public class SummingSquare {
    public static void main(String[] args) {
        int input = 12;
        System.out.println(summingSquare(input, new HashMap<>()));
    }
    private static int summingSquare(int n, Map<Integer, Integer> memo) {
        if(n == 0) {
            return 0;
        }
        if(n < 0) {
            return -1;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        int minEdges = -1;
        for(int i = 1; i<= Math.sqrt(n); i++) {
            int perfectSquare = i*i;
            int subInput =  summingSquare(n-perfectSquare, memo);
            if(subInput != -1) {
                int numEdges = subInput+1;
                if(numEdges < minEdges || minEdges == -1) {
                    minEdges = numEdges;
                }
            }
        }
        memo.put(n, minEdges);
        return minEdges;
    }
}
