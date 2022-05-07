//package leetCode;
//
//import org.junit.Test;
//
///**
// * 26. 删除有序数组中的重复项
// * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
// * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
// * 将最终结果插入nums 的前 k 个位置后返回 k 。
// * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
// *
// * @author Stiles yu
// * @since 1.0
// */
//public class Program26 {
//
//    @Test
//    public void exec() {
//        int[] nums = new int[]{1, 1, 2};
//
//    }
//
//    /**
//     * 使用原地算法，也就是不能通过额外存储空间来解决问题
//     * 1 1 1 2
//     * 1 _ _ 2
//     *
//     * @author Stilesyu
//     * @since 1.0
//     */
//    public int removeDuplicates(int[] nums) {
//        if (nums == null) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return 1;
//        }
//        int result = 0;
//        int swap = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int k = i + 1; k < nums.length; k++) {
//                if (nums[i] != nums[k]) {
//                    swap = nums[k];
//                    nums[i + 2] = swap;
//                }
//            }
//
//        }
//    }
//
//}
