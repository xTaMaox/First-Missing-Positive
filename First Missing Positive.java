class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) i++;
            else {
                if (nums[i] - 1 >= nums.length || nums[i] - 1 < 0 || nums[nums[i] - 1] == nums[i]) i++;
                else {
                    int tmp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[tmp - 1] = tmp;
                }
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}