public class VersionNumber {

    public static void main(String args[])
    {
        String v1 = "7.5.24";
        String v2 = "7.5.3";

        int result = compareVersion(v1,v2);

        System.out.println(result);
    }

    private static int compareVersion(String v1,String v2)
    {
        String s1[] = v1.split("\\.");
        String s2[] = v2.split("\\.");

        int length = Math.max(s1.length,s2.length);
        for(int i=0;i<length;i++)
        {
            Integer i1 = i<s1.length? Integer.parseInt(s1[i]):0;
            Integer i2 = i<s2.length? Integer.parseInt(s2[i]):0;

            int compare = i1.compareTo(i2);
            if (compare!=0)
                return compare;
        }

        return 0;

    }
}
