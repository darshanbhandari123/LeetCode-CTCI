public class PoorPigs {

    public static void main(String args[]){
        int buckets = 1000;
        int minutesToDie = 30;
        int minutesToTest = 60;

        int ans = poorPigs(buckets,minutesToDie,minutesToTest);
        System.out.print(ans);
    }

    private static int poorPigs(int buckets,int minutesToDie,int minutesToTest){
        int pigs = 0;
        int rowcol = minutesToTest/minutesToDie + 1;
        while (Math.pow(rowcol,pigs)<buckets)
            pigs++;

        return pigs;
    }

}
