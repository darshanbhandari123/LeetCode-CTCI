public class MaximumBinaryTree {

    public static void main(String a[]){

        int nums[] = {3,2,1,6,0,5};

        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.right.data);
        System.out.println(root.left.right.right.data);
        System.out.println(root.right.left.data);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums){

        if(nums == null || nums.length == 0){
            return null;
        }

        return helper(nums,0,nums.length-1);

    }

    private static TreeNode helper(int[] nums,int start,int end){

        if(start>end)
            return null;

        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i=start;i<=end;i++){
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(max);

        node.left = helper(nums,start,index-1);
        node.right = helper(nums,index+1,end);

        return node;

    }

}
