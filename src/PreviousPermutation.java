public class PreviousPermutation {

    public static void main(String args[]){

        int nums[] = {4,5,3,1,2};

        previousPermutation(nums);
        for (int x:
             nums) {
            System.out.print(x+"    ");

        }
    }

    private static void previousPermutation(int[] nums){

        int i=nums.length-1;

        for (;i>=0;i--){

            if(nums[i-1]>nums[i]){

                for (int j=nums.length-1;j>=i;j--){

                    if(nums[j]<nums[i-1]){

                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;

                        break;

                    }

                }

                int left = i;int right = nums.length-1;
                while (left<right){

                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;

                    left++;
                    right--;

                }

                break;

            }

        }

        if(i==0){
            int left = 0;int right = nums.length-1;
            while (left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

    }

}
