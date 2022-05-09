package leetCode;

import org.junit.Test;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author Stiles yu
 * @since 1.0
 */
public class Program26 {

    @Test
    public void exec() {
        int[] nums = new int[]{1, 1, 2, 4};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 使用原地算法，也就是不能通过额外存储空间来解决问题
     * 双指针
     *
     * @author Stilesyu
     * @since 1.0
     */
    //1 2 2 3 5
    //1 2 3  2 5
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

}
