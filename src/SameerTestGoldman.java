import java.util.ArrayList;
import java.util.List;

public class SameerTestGoldman {

    public static void main(String a[]){

        List<String> CSV = new ArrayList<>();
        CSV.add("Name,Course,Letter,Percent");
        CSV.add("Na,Cse,Ler,Percntage");
        CSV.add("Nme,urse,Leer,Ptage");
        CSV.add("ame,ourse,Ltter,centage");
        CSV.add("Ne,Curse,etter,Perge");

        String ans = csvFormat(CSV);

        System.out.println(ans);
    }

    private static String csvFormat(List<String> CSV){

        String ans="";
        int noOfCol = 0;
        String s = CSV.get(0);

        for (int i=0;i<s.length();i++){

            if(s.charAt(i)==','){
                noOfCol++;
            }

        }

        noOfCol++;

        String[][] temp = new String[CSV.size()][noOfCol];


        for (int i=0;i<CSV.size();i++){

            String[] x = CSV.get(i).split(",");

            for (int j=0;j<noOfCol;j++){

                temp[i][j] = x[j];

            }

        }

        int[] max = new int[noOfCol];

        for(int i=0;i<max.length;i++){

            for (int j=0;j<temp.length;j++){

                if(temp[j][i].length() > max[i]){
                    max[i] = temp[j][i].length();
                }

            }

        }


        for (int i=0;i<temp.length;i++){

            for (int j=0;j<noOfCol;j++){

                int len = max[j]+1;

                if(j!=0){
                    while (temp[i][j].length()!=len){

                        temp[i][j] = " "+temp[i][j];

                    }
                }
                else {
                    while (temp[i][j].length()!=len-1){

                        temp[i][j] = " "+temp[i][j];

                    }
                }

                if(j != noOfCol-1){
                    ans += temp[i][j]+",";
                }
                else {
                    ans += temp[i][j];
                }

            }

            if(i !=temp.length-1){
                ans += "\n";
            }

        }



        return ans;



    }

}
