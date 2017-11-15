public class IsUnique {
    public static void main(String args[])
    {
        String s=new String ("abh");
        StringBuffer sb = new StringBuffer();

        char x[] = s.toCharArray();
        sb.append(x[0]);
        for(int i=1;i<x.length;i++)
        {
            if(sb.indexOf(String.valueOf(x[i]))==-1)
                sb.append(x[i]);
        }

        String ans=sb.toString();
        System.out.println(s.equals(ans));
    }
}
