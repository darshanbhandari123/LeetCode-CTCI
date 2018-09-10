import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZag {

    public static void main(String a[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> ans = zigzag(root);

        for (List<Integer> x:
             ans) {
            for (int y:
                 x) {

                System.out.print(y+"    ");

            }

            System.out.println();

        }
    }

    private static List<List<Integer>> zigzag(TreeNode root){

        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        compute(list,root,0);

        return list;

    }

    private static void compute(List<List<Integer>> list,TreeNode root,int level){

        if(root == null)
            return;

        if (list.size() == level){
            list.add(new ArrayList<>());
        }

        if (level%2 ==0 )
            list.get(level).add(root.data);
        else
            list.get(level).add(0,root.data);


        compute(list,root.left,level+1);
        compute(list,root.right,level+1);

    }


}
