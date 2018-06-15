public class ArrayPartitionI {

    public static void main(String args[]){

        int nums[] = {1,2,6,43,2};
        int ans = arrayPairSum(nums);

        System.out.print(ans);

    }

    private static int arrayPairSum(int nums[]){

        int count[] = new  int[20001];
        int sum=0;
        boolean odd = true;

        for (int x:nums)
            count[x+10000]++;

        for (int i=0;i<count.length;i++){

            while (count[i] > 0){

                if(odd){
                    sum += (i - 10000);
                }

                odd = !odd;
                count[i]--;
            }

        }

        return sum;
    }

}
