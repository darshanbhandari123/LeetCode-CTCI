public class GasStation {

    public static void main(String args[])
    {
        int gas[] = {5,1,2,3,4};
        int cost[] = {4,4,1,5,1};

        int ans = canCompleteCircle(gas,cost);

        System.out.println(ans);
    }

    private static int canCompleteCircle(int gas[],int cost[]) {

        int start = 0;
        int remain = 0;
        int debt = 0;

        for(int i=0;i<gas.length;i++){

            remain += gas[i] - cost[i];
            if(remain < 0){
                start = i+1;
                debt = debt + (-1 * remain);
                remain = 0;
            }
        }

        if(remain >= debt){
            return start;
        }

        return -1;

    }

}
