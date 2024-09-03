import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPath {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("0", "0", "X"),
                List.of("0", "0", "0"),
                List.of("0", "0", "0"));
        System.out.println(countPath(0, 0, grid, new HashMap<>()));
    }

    private static int countPath(int r, int c, List<List<String>> grid, Map<List<Integer>, Integer> memo) {
        if(r == grid.size() || c == grid.get(0).size()) {
            return 0;
        }
        if(grid.get(r).get(c) == "X") {
            return 0;
        }
        if(r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return 1;
        }
        List<Integer> list = List.of(r,c);
        if(memo.containsKey(list)) {
            return memo.get(list);
        }

        int count =  countPath(r+1, c, grid, memo) + countPath(r, c+1, grid, memo);
        memo.put(list, count);
        return count;
    }
}
