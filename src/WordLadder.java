import java.util.*;

public class WordLadder {

    public static void main(String args[])
    {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>();

        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        int ans = helper(beginWord,endWord,list);

        System.out.println(ans);
    }

    private static int helper(String start,String end,List<String> list)
    {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        queue.add(null);

        List<String> visited = new ArrayList<>();
        visited.add(start);

        int level = 1;
        while (!queue.isEmpty())
        {
            String str = queue.poll();
            if(str!=null)
            {
                for (int i=0;i<str.length();i++)
                {
                    char[] chars = str.toCharArray();
                    for (char ch ='a';ch<='z';ch++)
                    {
                        chars[i] = ch;

                        String x = new String(chars);
                        if(x.equals(end))
                            return level+1;

                        if(list.contains(x) && !visited.contains(x))
                        {
                            queue.add(x);
                            visited.add(x);
                        }
                    }
                }
            }
            else {

                level++;
                if (!queue.isEmpty())
                {
                    queue.add(null);
                }
            }
        }

        return 0;
    }



}
