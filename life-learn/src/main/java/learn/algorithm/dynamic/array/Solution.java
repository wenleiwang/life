package learn.algorithm.dynamic.array;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * @author WangWenLei
 * @DATE: 2021/7/28
 **/
public class Solution {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0 ; i < n - 1 ; i++){
            nums1[m+i] = nums2 [i];
        }
        sort(nums1,0,m);
    }

    private void sort(int[] nums, int i, int j) {
        // 跳出条件
        // 快速排序核心
        int sing = nums [i];
        if(sing > nums[j]){
            nums[i] = nums[j];
            nums[j] = sing;

        }
    }

}
