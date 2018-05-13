package cn.eli.leetcode;

/**
 * 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class Solution_2 {
    /**
     * 第一次尝试解题
     * 尝试结果
     * 异常:
     * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0  第50行
     * */
    public static int maxProfit(int[] prices) {
        //左起第一个降序中最后一个元素作为第一次买进，右起第一个升序中最后一个元素作为最后一次卖出
        int left=0,right=0;
        int size = prices.length;
        boolean findLeft = false;
        boolean findRight = false;

        int i = 0;
        while(!(findLeft && findRight) && i < size-1){
            if(!findLeft && prices[i] < prices[i+1]){
                left = i;
                findLeft = true;
            }
            if(!findRight && prices[size-i-1] > prices[size-i-2]){
                right = size - i -1;
                findRight = true;
            }
            i++;
        }
        //降序数组 无法盈利 没有交易产生
        if(i == size-1 && prices[i] < prices[size-1]){
            return 0;
        }

        //第一个买进后，要找到买进后剩余元素的第一个升序最后元素卖出
        i= left;
        boolean in = false;
        int sum = 0;
        while(i <= right){
            if(!in && prices[i] < prices[i+1]){
                in = true;
                sum -= prices[i];
            }
            if(in && (i == size-1 || prices[i] >= prices[i+1])){
                in = false;
                sum += prices[i];
            }
            i++;
        }
        return sum;
    }

    /**
     * 第二次尝试
     * 贪心算法
     */
    public static int maxProfit2(int[] prices) {
        int sum = 0, tmp = 0,size = prices.length;
        for (int i = 1; i < size; ++i) {
            tmp = prices[i] - prices[i-1];
            if(tmp > 0){
                sum += tmp;
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        int[] a = {7,1,1,5,3,6,4};
        int[] b = {1,2,3,4,5};
        int[] c = {7,6,4,3,1,1};
        int[] d = {6,5,7,8,9,10,10};
        System.out.println(maxProfit2(a));
        System.out.println(maxProfit2(b));
        System.out.println(maxProfit2(c));
        System.out.println(maxProfit2(d));

    }
}
