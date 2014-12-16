package problems;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null)
            return 0;
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length, n2 = v2.length;
        
        for (int i = 0; i < n1 || i < n2; i++) {
            int t1 = i < n1 ? Integer.parseInt(v1[i]) : 0;
            int t2 = i < n2 ? Integer.parseInt(v2[i]) : 0;
            if (t1 > t2)
                return 1;
            if (t1 < t2)
                return -1;
        }
        return 0;
    }
    
    public static void main (String[] args) {
        CompareVersionNumbers cv = new CompareVersionNumbers();
        String v1 = "1.0";
        String v2 = "1";
        System.out.println(cv.compareVersion(v1, v2));
    }
}
