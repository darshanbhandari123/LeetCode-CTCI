import java.util.*;

class RandomizedSet{

    Set<Integer> set;
    List<Integer> list;

    public RandomizedSet(){
        this.set = new HashSet<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {

        if(set.contains(val)){
            return false;
        }
        else {
            set.add(val);
            list.add(val);
            return true;
        }

    }


    public boolean remove(int val) {

        if(set.contains(val)){
            set.remove(val);
            list.remove(new Integer(val));
            return true;
        }
        else {
            return false;
        }

    }


    public int getRandom() {

        int x = set.size();
        if(x == 0)
            return -1;
        int index = (int)(Math.random()*x);

        return list.get(index);

    }

}

public class InsertDeleteGetRandom {

    public static void main(String a[]){

        int val = 5;
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(val);
        boolean param_2 = obj.remove(val);
        int param_3 = obj.getRandom();

        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);

    }

}
