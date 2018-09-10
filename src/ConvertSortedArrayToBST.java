public class ConvertSortedArrayToBST {

    public static void main(String a[]){

        int nums[] = {-10,-3,0,5,9};
        TreeNode ans = sortedArrayToBST(nums);
        System.out.println(ans.data);

    }

    private static TreeNode sortedArrayToBST(int nums[]){

        if(nums.length == 0)
            return null;

        TreeNode node = helper(nums,0,nums.length-1);
        return node;
    }

    private static TreeNode helper(int[] nums,int low,int high){
        if(low>high)
            return null;

        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,low,mid-1);
        node.right = helper(nums,mid+1,high);

        return node;
    }

}
