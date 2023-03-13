class Solution {
    public static int search(int[] nums, int target) {
        int a = -1;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] == target){
                a=i;}
        }
        return a;
    }
    public static void main(String[] args) {
    int nums[]={5,6,7,8,0,1,2};
    int target=0;
    System.out.print(search(nums,target));
    }
}
