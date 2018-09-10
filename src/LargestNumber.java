import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String args[]){

        int nums[] = {3,30,34,5,9};

        String ans = largestNumber(nums);
        System.out.println(ans);
    }

    private static String largestNumber(int nums[]){

        if(nums==null || nums.length==0)
            return null;

        String strs[] = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            strs[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String s1 = o1+o2;
                String s2 = o2+o1;

                return s2.compareTo(s1);

            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }

        return sb.toString();
    }

}
