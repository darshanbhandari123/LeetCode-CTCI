public class SetMatrixZeros {

    public static void main(String a[]){

        int matrix[][] = {{1,0,1},{1,0,1},{0,0,1},{1,1,1}};

        setZeros(matrix);
        for (int[] x:matrix){
            for (int y:
                 x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix){

        boolean r = false;
        boolean c = false;

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){

                if(matrix[i][j] == 0){
                    if(i==0)
                        r = true;
                    if(j==0)
                        c = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){

                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }

            }
        }

        if(r){
            for (int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }

        if(c){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }

    }

}
