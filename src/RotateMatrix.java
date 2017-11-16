public class RotateMatrix {
    public static void main(String args[])
    {
        int a[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int first=0;
        int last=a.length-1;
        for(int layer=0;layer<a.length/2;layer++)
        {
            for (int i = first; i < last; i++) {
                int top = a[layer][i];
                a[layer][i] = a[a.length - i - 1][layer];
                a[a.length - i - 1][layer] = a[a.length - layer - 1][a.length - i - 1];
                a[a.length - layer - 1][a.length - i - 1] = a[i][a.length - layer - 1];
                a[i][a.length - layer - 1] = top;
            }

            first++;
            last--;
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+ " ");
            }

            System.out.println("\n");
        }

    }
}
