public class WiggleSort {

    public static void main(String args[])
    {
        int nums[] = {3,1,5,7,2,6};
        sort(nums);

        for (int x:nums) {
            System.out.print(x+" ");
        }
    }

    private static void sort(int nums[])
    {
        for (int i=0;i<nums.length-1;i++)
        if(i%2==0)
        {
            if(nums[i]>nums[i+1])
                swap(nums,i,i+1);
        }
        else
        {
            if(nums[i]<nums[i+1])
                swap(nums,i,i+1);
        }

    }

    private static void swap(int nums[],int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
