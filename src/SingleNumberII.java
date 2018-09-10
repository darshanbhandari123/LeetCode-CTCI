public class SingleNumberII {

    public static void main(String args[]){

        int nums[] = {3,3,2,3};

        //System.out.println(~(0&3));

        int ans = getSingleNumber(nums);
        System.out.println(ans);


        //refer to link https://www.careercup.com/question?id=7902674

    }

    private static int getSingleNumber(int[] nums){

        int ones = 0;
        int twos = 0;
        int common_bit_mask = 0;

        for (int i=0;i<nums.length;i++){

            System.out.println("Value of twos before: "+i+" iteration"+twos);
            System.out.println("Value of ones before: "+i+" iteration"+ones);

            System.out.println();

            twos = twos | (ones & nums[i]);
            ones = ones ^ nums[i];

            System.out.println("Value of twos midway: "+i+" iteration"+twos);
            System.out.println("Value of ones midway: "+i+" iteration"+ones);

            System.out.println();

            common_bit_mask = ~(ones & twos);

            ones = ones & common_bit_mask;
            twos = twos & common_bit_mask;

            System.out.println("Value of common bit mask after: "+i+" iteration"+common_bit_mask);
            System.out.println("Value of twos after: "+i+" iteration"+twos);
            System.out.println("Value of ones after: "+i+" iteration"+ones);


            System.out.println();
            System.out.println();

        }

        return ones;
    }

}
