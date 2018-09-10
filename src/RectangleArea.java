import java.lang.management.MemoryManagerMXBean;

public class RectangleArea {

    public static void main(String args[]){

        int A = -3;
        int B = 0;
        int C = 3;
        int D = 4;
        int E = 0;
        int F = -1;
        int G = 9;
        int H = 2;

        int ans = computeArea(A,B,C,D,E,F,G,H);
        System.out.println(ans);

    }

    private static int computeArea(int A,int B,int C,int D,int E,int F,int G,int H){

        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);

        int left = Math.max(A,E);
        int right = Math.min(C,G);

        int top = Math.min(D,H);
        int bottom = Math.max(B,F);

        int overlap = 0;
        if(top>bottom && right>left){
            overlap = (top-bottom)*(right-left);
        }

        return area1 + area2 - overlap;

    }

}
