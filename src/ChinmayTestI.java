public class ChinmayTestI {

    public static void main(String a[]){

        String s1 = "My keyboaRd is broken!";
        String s2 = "\"Baa, Baa!\" said the sheep";

        String ans = pfA(s2);
        System.out.println(ans);

    }

    private static String pfA(String message){

        boolean capsOn = false;
        StringBuffer sb = new StringBuffer();

        for (int i=0;i<message.length();i++){

            if(message.charAt(i) == 'a' || message.charAt(i) == 'A'){
                capsOn = !capsOn;
            }
            else {
                if(capsOn){
                    if(Character.isLowerCase(message.charAt(i))) {
                        sb.append((char)(message.charAt(i) - 32));
                    }
                    else {
                        sb.append(message.charAt(i));
                    }
                }
                else {
                    sb.append(message.charAt(i));
                }
            }

        }

        return sb.toString();

    }

}
