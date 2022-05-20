class Solution {
      public static int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()){
            return -1;
        }
        for (int i=0; i<haystack.length() - needle.length() + 1 ; i++)  {
            int j = 0;
            while (haystack.charAt(i+j) == needle.charAt(j++)) {
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return needle.length() == 0  ?  0 : -1;

    }
}