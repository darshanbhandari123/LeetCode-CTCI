public class KthLargest {

    public static void main(String args[])
    {
        int nums[] = {1,5,4,8};
        int k=2;

        int ans = findKthLargest(nums,k);

        System.out.println(ans);
    }

    private static int findKthLargest(int nums[],int k)
    {
        int len = nums.length;

        for (int i=len/2-1;i>=0;i--)
        {
            heapify(nums,len,i);
        }

        for (int i = len-1;i>=len-k;i--)
        {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            heapify(nums,i,0);
        }

        return nums[len-k];
    }

    private static void heapify(int nums[],int len,int i)
    {
        int largest = i;
        int l = 2*i +1;
        int r = 2*i +2;

        if(l<len && nums[l]>nums[largest])
            largest = l;
        if(r<len && nums[r]>nums[largest])
            largest = r;

        if(largest!=i)
        {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            heapify(nums,len,largest);
        }
    }

}
