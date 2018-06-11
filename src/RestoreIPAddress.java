import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public static void main(String args[]){
        String s = "10152154";
        List<String> result;

        //System.out.println(String.valueOf(Integer.parseInt("00")));

        result = computeAll(s);
        for (int k=0;k<result.size();k++)
        {
            System.out.println(result.get(k));
        }
    }

    private static List<String> computeAll(String s){
        if(s.length()<4 || s.length()>12)
            return new ArrayList<>();

        List<String> result =  new ArrayList<>();
        char[] temp = new char[s.length()+3];
        dfs(result,temp,s,0,0);
        return result;
    }

    private static void dfs(List<String> result,char[] temp,String s,int startIndex,int elementIndex){
        if(elementIndex == 4){                      //terminating condition for any IP address i.e. having 4 elements (w.x.y.z)
            if(startIndex == s.length()){           // the entire string needs to be parsed
                result.add(String.valueOf(temp));
            }

            return;
        }

        int number = 0;
        for (int i=startIndex; i<s.length() && i<startIndex+3;i++){
            if(s.charAt(startIndex) == '0' && i!=startIndex){   // any IP address element cannot have more than 1 number if the 1st number is one
                break;
            }

            number = number*10 +(s.charAt(i)-'0');
            if(number>255){             //maximum numeric value of any element can be 255
                break;
            }

            temp[i+elementIndex] = s.charAt(i); // elementIndex also keeps track of the number of fullstops('.') in the temp array and hence helps in new insertion accordingly.
            if(elementIndex!=3){
                temp[i+elementIndex+1] = '.';   // an IP address should only have 3 fullstops
            }

            dfs(result,temp,s,i+1,elementIndex+1);
        }
    }
}
