import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Compare implements Comparator{

    int col_no;
    boolean asc;

    public Compare(int sortParameter,int sortOrder){

        this.col_no = sortParameter;
        if(sortOrder==0){
            this.asc = true;
        }
        else {
            this.asc = false;
        }

    }

    public int compare(Object o1,Object o2){


        Item i1 = (Item) o1;
        Item i2 = (Item) o2;

        if(asc){
            return i1.items.get(col_no).toString().compareTo(i2.items.get(col_no).toString());
        }
        else {
            return i2.items.get(col_no).toString().compareTo(i1.items.get(col_no).toString());
        }
    }

}

class Item{

    List<List<String>> items;
    int sortParameter;
    int sortOrder;
    int itemPerPage;
    int pageNumber;

    public Item(List<List<String>> items,int sortParameter,int sortOrder,int itemPerPage,int pageNumber){

        this.items = items;
        this.sortParameter = sortParameter;
        this.sortOrder = sortOrder;
        this.itemPerPage = itemPerPage;
        this.pageNumber = pageNumber;

    }

}

public class SameerVisaTestIII {

    public static void main(String args[]){

        List<List<String>> items = new ArrayList<>();

        items.add(new ArrayList<>());
        items.get(0).add("p1");
        items.get(0).add("1");
        items.get(0).add("2");

        items.add(new ArrayList<>());
        items.get(1).add("p2");
        items.get(1).add("2");
        items.get(1).add("1");

        int sortParameter = 1;
        int sortOrder = 0;
        int itemPerPage = 2;
        int pageNumber = 1;

        Collections.sort(items,new Compare(sortParameter,sortOrder));


        for (List<String> i:items){

            for (String s:i){

                System.out.print(s+"    ");

            }

            System.out.println();

        }

    }

}
