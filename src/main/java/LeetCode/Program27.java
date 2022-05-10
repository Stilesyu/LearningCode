package leetCode;

import org.junit.Test;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 输入：nums = [3,2,1,2,3], val = 3
 * 输出：2, nums = [2,2]
 *
 * @author Stiles yu
 * @since 1.0
 */
public class Program27 {


    @Test
    public void exec() {
        int[] nums = new int[]{3, 2, 3, 2, 3};
        removeElement(nums, 3);
    }


    /**
     * 使用双指针
     * 左指针和右指针，如果右指针和val不相同，将左边复制到右边。
     * 这种方式能够将指定值挪到数组最后位置
     *
     * @author Stilesyu
     * @since 1.0
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }



}
