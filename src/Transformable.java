/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class Transformable {

    public static int findMinChars(String searchWord, String resultWord){
        int continueFromIndex=0;
        for(int i=0; i<resultWord.length(); i++){
            boolean miss=true;
            for(int j=continueFromIndex; j<searchWord.length(); j++){
                if(searchWord.charAt(j) == resultWord.charAt(i)){
                    miss=false;
                    continueFromIndex = j+1;
                    break;
                }
            }
            if(miss) {
                return resultWord.length()-i;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        String s1="armaze";
        String s2="amazon";
        int result = findMinChars(s1, s1);
        System.out.println(result);
    }
}
