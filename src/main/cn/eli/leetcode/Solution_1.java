package cn.eli.leetcode;

/**
 * 从排序数组中删除重复项
 *
 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution_1 {

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int index = 0;
        boolean repeat = false;
        for(int i = 1; i< size; i++){
            for(int j = 0; j<i; j++){
                if(nums[i] == nums[j]){
                    repeat = true;
                    break;
                }
            }
            if(!repeat){
                nums[++index] = nums[i];
            }else{
                repeat = false;
            }
        }
        return index+1;
    }

    public static void main(String[] args) {

    }
}
