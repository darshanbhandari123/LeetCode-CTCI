public class RotateImage {

    public static void main(String args[]){

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        rotate(matrix);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix){

        int first = 0;
        int last = matrix.length-1;
        int n = matrix.length;

        for (int layer = 0;layer < n/2;layer++){

            for (int i=first;i<last;i++){

                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[n-i-1][layer];
                matrix[n-i-1][layer] = matrix[n-layer-1][n-i-1];
                matrix[n-layer-1][n-i-1] = matrix[i][n-layer-1];
                matrix[i][n-layer-1] = temp;

            }

            first++;
            last--;

        }

    }

}
