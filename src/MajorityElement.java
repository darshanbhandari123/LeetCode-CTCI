public class MajorityElement {          //this program implements boyer-moore voting algorithm for majority element, basically returns the element which occurs more than n/2 times in an random array.
                                        //majority element is an element that occurs more than n/2 times. Therefore, any array can have only one such element.
    public static void main(String args[]){

        int nums[] = {2,8,2,5,2,2};                 //this algorithm will only works if the array definitely has a majority element.

        int ans = findMajority(nums);
        System.out.print(ans);

    }

    private static int findMajority(int nums[]){

        int ans = -1;                               //this will contain the majority element at every point.
        int count = 0;

        for (int i=0;i<nums.length;i++){

            if(count == 0){
                ans = nums[i];
                count = 1;
            }
            else {
                if (ans == nums[i]){                //check if the element is same as already found majority element.
                    count++;
                }
                else {
                    count--;
                }
            }
        }

        return ans;
    }

}
