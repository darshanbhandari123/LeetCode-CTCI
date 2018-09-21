import java.util.*;

public class EvaluateDivision {

    public static void main(String args[]){

        String equations[][] = {{"a","b"},{"b","c"}};
        double values[] = {2.0,3.0};
        String queries[][] = {{"a","c"}};

        double[] result = calcEquation(equations,values,queries);

        System.out.println(result[0]);

    }

    private static double[] calcEquation(String[][] equations, double[] values, String[][] queries){

        double[] result = new double[queries.length];

        Map<String,ArrayList<String>> pairs = new HashMap<>();
        Map<String,ArrayList<Double>> valPairs = new HashMap<>();

        for (int i=0;i<equations.length;i++){
            String[] equation = equations[i];

            if(!pairs.containsKey(equation[0])){
                pairs.put(equation[0],new ArrayList<>());
                valPairs.put(equation[0],new ArrayList<>());
            }

            if(!pairs.containsKey(equation[1])){
                pairs.put(equation[1],new ArrayList<>());
                valPairs.put(equation[1],new ArrayList<>());
            }

            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valPairs.get(equation[0]).add(values[i]);
            valPairs.get(equation[1]).add(1/values[i]);

        }

        for (int i=0;i<queries.length;i++){

            String[] query = queries[i];
            result[i] = dfs(query[0],query[1],pairs,valPairs,new HashSet<>(),1.0);

            if(result[i] == 0.0){
                result[i] = -1.0;
            }

        }

        return result;
    }

    private static double dfs(String start, String end, Map<String,ArrayList<String>> pairs, Map<String,ArrayList<Double>> valPairs, Set<String> visited, double value){

        if(!pairs.containsKey(start)){
            return 0.0;
        }
        if(visited.contains(start)){
            return 0.0;
        }
        if(start.equals(end)){
            return value;
        }

        visited.add(start);

        List<String> adjlist = pairs.get(start);
        List<Double> valueList = valPairs.get(start);
        double temp = 0.0;

        for (int i=0;i<adjlist.size();i++){

            temp = dfs(adjlist.get(i),end,pairs,valPairs,visited,value*valueList.get(i));
            if(temp!=0.0){
                break;
            }

        }

        //visited.remove(start);

        return temp;
    }

}
