public class MedianOfTwoSortedArrays {

    public static void main(String a[]){

        int nums1[] = {1,3};
        int nums2[] = {2};

        try {
            double ans = findMedianSortedArrays(nums1,nums2);
            System.out.println(ans);
        }
        catch (Exception e){

        }
    }

    private static double findMedianSortedArrays(int[] nums1,int[] nums2) throws IllegalAccessException {

        double result = 0;

        if((nums1 == null ||nums1.length == 0) && (nums2 == null ||nums2.length == 0))
            return result;

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = x;

        while (start <= end){

            int partitionX = (start+end)/2;
            int partitionY = (x+y+1)/2 - partitionX;

            int maxLeftX;
            if(partitionX>0){
                maxLeftX = nums1[partitionX-1];
            }
            else {
                maxLeftX = Integer.MIN_VALUE;
            }

            int maxLeftY;
            if (partitionY>0){
                maxLeftY = nums2[partitionY-1];
            }
            else {
                maxLeftY = Integer.MIN_VALUE;
            }

            int minRightX;
            if (partitionX<nums1.length){
                minRightX = nums1[partitionX];
            }
            else {
                minRightX = Integer.MAX_VALUE;
            }

            int minRightY;
            if (partitionY<nums2.length){
                minRightY = nums2[partitionY];
            }
            else {
                minRightY = Integer.MAX_VALUE;
            }

            if(maxLeftX <= minRightY && maxLeftY<= minRightX){

                if((x+y)%2 == 0){

                    int n = Math.max(maxLeftX,maxLeftY);
                    int m = Math.min(minRightX,minRightY);

                    return (double) (n+m)/2;

                }
                else {
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }
            else if (maxLeftX > minRightY){
                end = partitionX - 1;
            }
            else {
                start = partitionX + 1;
            }

        }


        throw new IllegalAccessException();

    }

}
