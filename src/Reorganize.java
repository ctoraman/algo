import java.util.ArrayList;
import java.util.List;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class Reorganize {


    public static String reorganizeString(String s) {
        return reorganizeStringRecursive(s);
    }

    public static String reorganizeStringRecursive(String s){
        if( !s.isEmpty()) {
            List<String> result = reorganizeStringHelper(s);
            if (result == null) {
                return "";
            }
            if (result != null && result.get(1) == null) {
                return s;
            }
            String out = result.get(0);
            String other = result.get(1);
            String next = reorganizeStringRecursive(other);
            if (next.isEmpty() && out.length() > 0){
                //mix them
                String newOut = "";
                int i=0, j=0;
                for(; i<other.length() && j<out.length(); i++,j++){
                    newOut += other.charAt(i) + "" + out.charAt(j);
                }
                while(i<other.length()){
                    newOut += other.charAt(i++);
                }
                while(j<out.length()){
                    newOut += out.charAt(j++);
                }
                out = newOut;
            }
            return out + next;
        }else{
            return "";
        }
    }

    public static List reorganizeStringHelper(String s) {
        //1. count char occurrences
        int[] counts = new int[26]; //since input is English lowercase
        for(int i=0; i<s.length(); i++){
            counts[s.charAt(i) - 'a']++;
        }
        int max=counts[0], maxIndex=0;
        for(int i=1; i<counts.length; i++){
            if( counts[i] > max){
                max = counts[i];
                maxIndex = i;
            }
        }
        char maxChar = (char)('a' + maxIndex);
//        System.out.println("max: "+max);
//        System.out.println("maxChar: "+maxChar);
        if(max==1){
            List result = new ArrayList<>();
            result.add(s);
            result.add(null);
            return result;
        }

        //2. place most frequent char into a stack, others into another stack
        char[] stackFreq = new char[max];
        char[] stackOther = new char[s.length()-max];
        int m=0, n=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( c == maxChar){
                stackFreq[m++] = c;
            }else{
                stackOther[n++] = c;
            }
        }
        m--; n--;
//        System.out.println("stackFreq: "+ Arrays.toString(stackFreq));
//        System.out.println("stackOther: "+ Arrays.toString(stackOther));

        //3. pop from frequent stack and other stack consecutively, unless either is empty.
        char[] output = new char[s.length()];
        int o=0;
        boolean startFromFreq = stackFreq.length > stackOther.length;
        while(m>=0 && n>=0){
            if(startFromFreq) {
                output[o++] = stackFreq[m--];
                output[o++] = stackOther[n--];
            }else{
                output[o++] = stackOther[n--];
                output[o++] = stackFreq[m--];
            }
        }
        if(startFromFreq && m==0) {
            output[o++] = stackFreq[m--];
        }
        if(!startFromFreq && n==0) {
            output[o++] = stackOther[n--];
        }

        //4. if there exists some items in frequent stack, then failed.
        if( m>0){
            return null;
        }else{
            String outputStr = "";
            for (int i = 0; i < o; i++) {
                outputStr += output[i];
            }
            String stackOtherStr = "";
            for (int i = 0; i <= n; i++) {
                stackOtherStr += stackOther[i];
            }
            List result = new ArrayList<>();
            result.add(outputStr);
            result.add(stackOtherStr);
            return result;
        }
    }

    public static void main(String[] args) {
        String[] strs = {/*"aab","aaab","vvvlo","baabb","blflxll","bfrbs","zhmyo","wfndrin",*/
                "eyunyjremkzgblsfsrtmomdydeshldqxmwikjtfnupbcwhfcipzvuciehpelkmtnuttectqzeaeswritrfrrchkuqswcgsuoshkxvthzjjcxfgtcezgxblhkdgubhempnaoossyypewihccbzbkdjjxbqvnzqycdlwmrjjfykuitkzfhchuambdagictmjatwnttpcenraowhzmlgfvxcyamfonupldrrnvnebtzqxdjongapktgmiytqiqseizonpitnknfzwuendmvxhbsobidnqwhplolahpijafzjistxtnfdcxxkrruxbphmjqzanebmioyqmyqwayunokwbvmckgpmcxoeqtadafkbxnjvknhmjtlzkiqxirobjcpsikcyhvmoehsompftkxxfkmneqtpjntrcatlwgvgmrrvaraytvhpbidajyqolnzqchxwvpdvchgfnhohypbkzohgdchxspsylhxaefbpzaomwgxghpniy"
        };
        for(String s: strs) {
            System.out.println(s.length());
            String result = reorganizeString(s);
            System.out.println("result: " + result);
            System.out.println(result.length());
        }
        //Runtime: 10 ms, faster than 11.09% of Java online submissions for Reorganize String.
        //Memory Usage: 39.5 MB, less than 8.16% of Java online submissions for Reorganize String.
    }
}