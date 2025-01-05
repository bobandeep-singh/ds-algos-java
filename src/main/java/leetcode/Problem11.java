package leetcode;

public class Problem11 {

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxVolume = Integer.MIN_VALUE;

        while(left < right){
            System.out.println("length: "+(right-left));
            int vol = (right-left) * Math.min(height[left], height[right]);
            System.out.println("Start - Volume: " +vol+ " - left: " +left+ " - right: " +right+ " - maxVolume: " +maxVolume+ " - height[left]: " +height[left]+ " - height[right]: " +height[right]);
            maxVolume = Math.max(maxVolume, vol);
            System.out.println("height[left] > height[right]: "+(height[left] > height[right]));
            if(height[left] < height[right])  left++;
            else right--;

            System.out.println("End Volume: " +vol+ " - left: " +left+ " - right: " +right+ " - maxVolume: " +maxVolume+ " - height[left]: " +height[left]+ " - height[right]: " +height[right]);
            System.out.println();
        }
        return maxVolume;
    }
}
