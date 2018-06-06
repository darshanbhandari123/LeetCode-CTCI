public class SortColors {

    public static void main(String args[]) {

        int nums[] = {1,0,2,0,2,1,0};
        sort(nums);

        for (int x: nums) {
            System.out.print(x +" ");
        }
    }

    private static void sort(int nums[]) {

        for (int i=0,j=0,k=0;k<nums.length;k++) {
            int temp = nums[k];
            nums[k] = 2;

            if(temp<2) {
                nums[j] = 1;
                j++;
            }

            if(temp<1)
            {
                nums[i] = 0;
                i++;
            }
        }
    }
}
