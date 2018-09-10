public class SameerTest {

    public static void main(String a[]){

        String s = "aba";
        String ans;

        char c[] = s.toCharArray();
        int i;

        for (i=0;i<c.length;i++){

            if(c[i] != 'a'){
                c[i] = 'a';
                break;
            }

        }

        int left = 0;
        int right = s.length()-1;
        boolean flag = true;
        while(left<right){

            if(c[left] != c[right]){
                flag = false;
                break;
            }

            left++;
            right--;

        }

        if(s.length() <= 1 || flag) {
            ans = "IMPOSSIBLE";
        }else {
            ans = new String(c);
        }

        System.out.println(ans);

    }

}
