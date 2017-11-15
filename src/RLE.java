public class RLE {
    public static void main(String args[])
    {
        String s = new String("ababxxxxxbbccfffcccaaa0");
        StringBuffer sb=new StringBuffer();

        int hash[] = new int[256];
        char c[]=s.toCharArray();

        for(int i=0;i<c.length-1;i++)
        {
            if(c[i]==c[i+1])
            {
                hash[c[i]]++;
            }
            else
            {
                sb.append(c[i]);
                sb.append(hash[c[i]]+1);
                hash[c[i]]=0;
            }
        }

        String ans = sb.toString();
        System.out.println(ans);
    }
}

