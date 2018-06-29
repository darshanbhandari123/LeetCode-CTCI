import java.util.Random;

public class ShuffleAnArray {

    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums){

        this.nums = nums;
        this.random = new Random();

    }

    public int[] reset(){

        return nums;

    }

    public int[] shuffle(){

        if(nums == null)
            return null;

        int a[] = nums.clone();
        for (int i=0;i<nums.length;i++){
            int j = random.nextInt(i+1);
            swap(a,i,j);
        }

        return a;
    }

    private void swap(int[] a,int i, int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void main(String args[]){

        int[] nums = {1,2,3};
        ShuffleAnArray obj = new ShuffleAnArray(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();

        for (int x:
             param_2) {
            System.out.print(x+"    ");
        }
        System.out.println();

        for (int y:
             param_1) {
            System.out.print(y+"    ");
        }
        System.out.println();


    }

}
