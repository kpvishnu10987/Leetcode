class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int count = 0;

        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }

        if(kmp(sb.toString(),b)){
            return count;
        }

        sb.append(a);
        if(kmp(sb.toString(),b)){
            return count+1;
        }

        return -1;
    }

    private boolean kmp(String a,String b){
        int[] lps = lps(b);

        int i = 0 ;
        int j = 0;

        while(i < a.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
                if(j == b.length()) return true;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return false;
    }

    private int[] lps(String p){
        int[] arr = new int[p.length()];
        int i = 1;
        int len = 0;

        while(i < p.length()){
            if(p.charAt(i) == p.charAt(len)){
                len++;
                arr[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = arr[len-1];
                }else{
                    arr[i] = 0;
                    i++;
                }
            }
        }
        return arr;
    }
}