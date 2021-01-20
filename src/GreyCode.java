import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreyCode {
    public static void main(String[] args) {
        /*List<Integer> rs=new ArrayList<>();
        rs.add(0);
        for(int i=0;i<3;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);
        }*/
        String s = "  HEY AM ";

        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        if(s == null || "".equals(s) || s.length() == 1)
            return "";

        //reverse string
        char[] ch = s.toCharArray();

        int i=0, j=0;
        int count = 0; // to keep track of consecutive space count

        //trim leading zeroes
        while(ch[j++] == ' ');

        --j;

        while(j < ch.length){
            if(ch[j] != ' ' || count == 0) {
                if(ch[j] != ' ')
                    count = 0;
                else
                    ++count;
                ch[i++] = ch[j++];
            }

            else {
                ++count;
                ++j;
            }
        }

        //ch[i-1] = '\0';
        --i;

        s = String.valueOf(ch);

        return s.charAt(i) == ' ' ? s.substring(0, i) : s.substring(0,i+1);
    }
}
