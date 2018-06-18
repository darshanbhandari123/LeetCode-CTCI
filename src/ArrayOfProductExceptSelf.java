public class ArrayOfProductExceptSelf {

    public static void main(String args[]){

        int nums[] = {1,4,6,10};

        int res[] = findProduct(nums);
        for (int x:res) {
            System.out.print(x+" ");
        }
    }

    private static int[] findProduct(int[] nums){

        int output[] = new int[nums.length];
        output[0] = 1;

        for (int i=1;i<nums.length;i++){
            output[i] = output[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i=nums.length-1;i>-1;i--){

            output[i] = output[i] * right;
            right = right * nums[i];

        }

        return output;
    }

}
