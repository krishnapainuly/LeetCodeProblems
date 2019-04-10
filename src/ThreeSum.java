import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {

    public static void main(String[] args) {

        int array_nums[] = { -1, 0, 1, 2, -1, -4 };
        ThreeSumSolution sol = new ThreeSumSolution();
        List<List<Integer>> threeSum = sol.threeSum(array_nums);
        threeSum.forEach(sum -> {
            sum1 -> {
                sum1.
            }
        });
        System.out.println();
    }
}

class ThreeSumSolution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Integer sum_arr[] = { nums[i], nums[j], nums[k] };
                        Arrays.sort(sum_arr);
                        if (threeSum.contains(Arrays.asList(sum_arr))) {
                            threeSum.add(Arrays.asList(sum_arr));
                        }
                    }
                }
            }
        }
        return threeSum;
    }
}