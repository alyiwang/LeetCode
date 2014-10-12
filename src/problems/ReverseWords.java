package problems;

public class ReverseWords {
    public String reverseWords(String s) {
        String st = s.trim();
        if (st.length() == 0)
            return "";
        
        String[] a = st.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].equals(""))
                sb.append(a[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = rw.reverseWords("   a  ");
        System.out.println(s);
    }
}
