import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

    public static void main(String a[]){

        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};

        int ans = minMutation(start,end,bank);

        System.out.println(ans);
    }

    private static int minMutation(String start, String end, String[] bank){

        char chars[] = {'A','C','G','T'};
        if(start.equals(end) && contains(bank,start))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int level=0;
        while (!queue.isEmpty()){

            int size = queue.size();
            while (size>0){

                String current = queue.poll();
                if(current.equalsIgnoreCase(end))
                    return level;

                char[] charArray = current.toCharArray();
                for (int i=0;i<charArray.length;i++){

                    char temp = charArray[i];

                    for (int j=0;j<chars.length;j++){

                        charArray[i] = chars[j];
                        String ch = new String(charArray);

                        if(!visited.contains(ch) && contains(bank,ch)){
                            queue.offer(ch);
                            visited.add(ch);
                        }
                    }

                    charArray[i] = temp;

                }

                size--;

            }

            level++;
        }

        return -1;
    }

    private static boolean contains(String[] bank,String start){

        for (String s:bank){
            if(s.equalsIgnoreCase(start))
                return true;
        }
        return false;
    }

}
