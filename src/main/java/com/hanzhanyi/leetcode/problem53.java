package com.hanzhanyi.leetcode;

/**
 * Created by hanzhanyi on 2019/10/23.
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路：
 * 示例: [a, b , c, d , e]
 * <p>
 * 解答这类题目, 省略不掉遍历, 因此我们先从遍历方式说起
 * <p>
 * 通常我们遍历子串或者子序列有三种遍历方式
 * <p>
 * 以某个节点为开头的所有子序列: 如 [a]，[a, b]，[ a, b, c] ... 再从以 b 为开头的子序列开始遍历 [b] [b, c]。
 * 根据子序列的长度为标杆，如先遍历出子序列长度为 1 的子序列，在遍历出长度为 2 的 等等。
 * 以子序列的结束节点为基准，先遍历出以某个节点为结束的所有子序列，因为每个节点都可能会是子序列的结束节点，因此要遍历下整个序列，如: 以 b 为结束点的所有子序列: [a , b] [b] 以 c 为结束点的所有子序列: [a, b, c] [b, c] [ c ]。
 * 第一种遍历方式通常用于暴力解法, 第二种遍历方式 leetcode (5. 最长回文子串 ) 中的解法就用到了。
 * <p>
 * 第三种遍历方式 因为可以产生递推关系, 采用动态规划时, 经常通过此种遍历方式, 如 背包问题, 最大公共子串 , 这里的动态规划解法也是以 先遍历出 以某个节点为结束节点的所有子序列 的思路
 * <p>
 * 对于刚接触动态规划的, 我感觉熟悉第三种遍历方式是需要抓住的核心
 * <p>
 * 因为我们通常的惯性思维是以子序列的开头为基准，先遍历出以 a 为开头的所有子序列，再遍历出以 b 为开头的...但是动态规划为了找到不同子序列之间的递推关系，恰恰是以子序列的结束点为基准的，这点开阔了我们的思路。
 * <p>
 * 我在网上看不少解答时，直接阅读其代码，总是感觉很理解很吃力，因为好多没有写清楚，一些遍历到底代表什么意思，看了许久仍不知所以然，下面的代码中摘录了 维基中的解释，感觉比较清楚，供大家理解参考。
 * <p>
 * 代码：
 * // Kadane算法扫描一次整个数列的所有数值，
 * // 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
 * // 该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
 * // 因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出,
 * // 该算法可看成动态规划的一个例子。
 * // 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
 * // 其中(sum[i]记录以a[i]为子序列末端的最大序子列连续和)
 * <p>
 * function  maxSubArray2  ( nums ) {
 * if (!nums.length) {
 * return;
 * };
 * // 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
 * let max_ending_here = nums[0];
 * let max_so_far = nums[0];
 * <p>
 * for (let i = 1; i < nums.length; i ++ ) {
 * // 以每个位置为终点的最大子数列 都是基于其前一位置的最大子数列计算得出,
 * <p>
 * max_ending_here = Math.max ( nums[i], max_ending_here + nums[i]);
 * max_so_far = Math.max ( max_so_far, max_ending_here);
 * };
 * <p>
 * return max_so_far;
 * };
 * var maxSubArray = function(nums) {
 * let ans = nums[0];
 * let sum = 0;
 * for(let num of nums) {
 * // if(sum > 0) { 可以写成这样
 * if(sum + num > num ){
 * sum = sum + num;
 * } else {
 * sum = num;
 * }
 * ans = Math.max(ans, sum);
 * };
 * return ans;
 * };
 * <p>
 * 第二块代码和 第一块代码 思路实现是完全一样的，但是如果第一次看到这类题目，直接阅读 第二块代码，理解起来很难，尤其是 如果改成 if (sum > 0 ) 对于刚接触的这题目的比较不好理解。
 * <p>
 * 作者：lao-hu-8
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/xiang-xi-jie-du-dong-tai-gui-hua-de-shi-xian-yi-li/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class problem53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] ;
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return dp[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = dp[0];
        for (int a : dp) {
            if (max < a) {
                max = a;
            }
        }
        return max;
    }
}
