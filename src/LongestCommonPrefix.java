public class LongestCommonPrefix {

    public static void main(String args[]){
        String[] strs = {"dog","racecar","car","cargtgg",""};

        String s = findPrefix(strs);
        System.out.print(s);
    }

    private static String findPrefix(String[] strs){
        String prefix = "";
        if(strs == null || strs.length==0)
            return "";

        prefix = strs[0];

        for (int i=1;i<strs.length;i++){

            while (strs[i].indexOf(prefix)!=0)
                prefix = prefix.substring(0,prefix.length()-1);

        }
        return prefix;
    }

}
