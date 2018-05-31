public class GasStation {

    public static void main(String args[])
    {
        int gas[] = {5,1,2,3,4};
        int cost[] = {4,4,1,5,1};

        int ans = canCompleteCircle(gas,cost);

        System.out.println(ans);
    }

    private static int canCompleteCircle(int gas[],int cost[])
    {
        if(gas.length!=cost.length)
            return -1;

        int gasSum = 0;
        int costSum = 0;

        for (int x: gas) {
            gasSum += x;
        }

        for (int y:cost) {
            costSum +=y;
        }

        if(gasSum>=costSum)
        {
            for (int i =0;i<gas.length;i++)
            {
                boolean flag = checkGasLeft(gas,cost,i);
                if(flag)
                    return i;
            }
        }

        return -1;
    }

    private static boolean checkGasLeft(int gas[],int cost[],int i)
    {
        int index = i;
        int gasLeft = 0;
        for(int j = 0;j<gas.length;j++)
        {
            gasLeft += (gas[(index)%gas.length]-cost[(index)%gas.length]);
            index++;
            if(gasLeft<0)
                return false;
        }

        return true;
    }

}
