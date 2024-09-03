import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPathSum {
    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(1, 3, 12),
                List.of(5, 6, 2));
        System.out.println(maxPathSum(0,0,grid, new HashMap<>()));
    }

    private static int maxPathSum(int r, int c, List<List<Integer>> grid, Map<List<Integer>, Integer> memo) {
        if(r == grid.size() || c == grid.get(0).size()) {
            return 0;
        }
        if(r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return grid.get(r).get(c);
        }
        List<Integer> list = List.of(r,c);
        if(memo.containsKey(list)) {
            memo.get(list);
        }

        int result = grid.get(r).get(c) + Math.max(maxPathSum(r+1, c, grid, memo), maxPathSum(r, c+1, grid, memo));
        memo.put(list, result);
        return result;
    }
}
