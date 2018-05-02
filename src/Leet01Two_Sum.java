import java.util.HashMap;
import java.util.Map;

/*Given nums = [2, 7, 11, 15], target = 9,
"Because nums[0] + nums[1] = 2 + 7 = 9,
"return [0, 1]."
*/

/*
1. base case nums == null nums.length ==0
2. HashMap<> key value pair, target - nums[i] --> key   i --> value (K, V)
 */
public class Leet01Two_Sum {
    public int[] twoSum(int[] nums, int target){
        //base
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (hashMap.containsKey(result)) {
                return new int[] {hashMap.get(result), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
