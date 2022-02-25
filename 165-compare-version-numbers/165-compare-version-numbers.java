class Solution {
    public int compareVersion(String version1, String version2) {
        for (int i = 0, j = 0, m, n; i < version1.length() || j < version2.length(); i++, j++) {
            m = n = 0;
            while (i < version1.length() && version1.charAt(i) != '.') 
                m = m * 10 + version1.charAt(i++) - '0';
            while (j < version2.length() && version2.charAt(j) != '.') 
                n = n * 10 + version2.charAt(j++) - '0';
            
            if (m > n) return 1;
            if (m < n) return -1;
        }
        return 0;
    }
}
