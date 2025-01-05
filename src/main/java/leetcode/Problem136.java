package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem136 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 5, 6, 2, 6};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger output = new AtomicInteger();
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        map.forEach((x, y) -> {
            if(y == 1) {
                output.set(x);
            }
        });
        return output.get();
    }

}
