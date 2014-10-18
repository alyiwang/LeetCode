package problems;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "";

        String[] sa = path.split("/");
        List<String> list = new ArrayList<String>();
        for (String s : sa) {
            if (s.length() == 0 || s.equals("."))
                continue;
            if (s.equals("..")) {
                if (list.size() > 0)
                    list.remove(list.size() - 1);
            } else
                list.add(s);
        }

        if (list.size() == 0)
            return "/";        
        String out = "";
        for (String s : list) {
            out += "/" + s;
        }
        return out;
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String s = "/abc/...";
        System.out.println(sp.simplifyPath(s));
    }
}
