public class GasStation {

    public static void main(String args[])
    {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};

        int ans = canCompleteCircle(gas,cost);

        System.out.println(ans);
    }

    private static int canCompleteCircle(int gas[],int cost[])
    {
        int gasSum = 0;
        int costSum = 0;

        for (int x: gas) {
            gasSum += x;
        }

        for (int y:cost) {
            costSum +=y;
        }

        if(gasSum>=costSum)
            return 1;
        else
            return -1;
    }

}
