class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<=nums.length;i++) {
            res^=i;
            if(i<nums.length) 
                res^=nums[i];
        }
        return res;
    }
}
