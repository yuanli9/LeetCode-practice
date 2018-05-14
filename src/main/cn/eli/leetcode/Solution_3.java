package cn.eli.leetcode;
/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class Solution_3 {
    /**
     * pass
     * 但是空间复杂度不符合O(1)要求
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] temp = new int[size];
        System.arraycopy(nums,0,temp,0,size);

        for(int i = 0; i< size; i++){
            nums[(i+k)% size] = temp[i];
        }

    }

    /**
     * pass
     * 空间复杂度O(1)
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int size = nums.length;

        int temp;
        while(k>0){

            temp = nums[size-1];

            for(int i = 1; i<size; i++){
                nums[size-i] = nums[size-i-1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
//        rotate(a,3);
        rotate2(a,3);

        for(int i = 0; i< a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}
