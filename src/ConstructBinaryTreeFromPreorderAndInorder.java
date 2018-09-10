public class ConstructBinaryTreeFromPreorderAndInorder {

    static int preIndex = 0;

    public static void main(String a[]){

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder,inorder);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.right.left.data);
        System.out.println(root.right.right.data);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder){

        if(preorder == null || preorder.length == 0)
            return null;

        if(preorder.length == 1)
            return new TreeNode(preorder[0]);

        return helper(preorder,0,preorder.length-1,inorder);

    }

    private static TreeNode helper(int[] preorder,int start,int end,int[] inorder){

        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if(start == end){
            return root;
        }

        int num = root.data;
        int index = -1;


        for (int i=start;i<=end;i++){
            if(inorder[i] == num){
                index = i;
            }
        }

        root.left = helper(preorder,start,index-1,inorder);
        root.right = helper(preorder,index+1,end,inorder);

        return root;

    }

}
