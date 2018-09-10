public class MergeSortedArray {

    public static void main(String args[]){

        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};

        int m = 3;
        int n = 3;

        merge(nums1,m, nums2,n);

        for (int x:nums1) {
            System.out.print(x+" ");
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n){

        int k = m+n-1;
        int i = m-1;
        int j = n-1;

        while (i>-1 && j>-1){

            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            }
            else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        while (i>-1)
            nums1[k--] = nums1[i--];

        while (j>-1)
            nums1[k--] = nums2[j--];

    }
}
