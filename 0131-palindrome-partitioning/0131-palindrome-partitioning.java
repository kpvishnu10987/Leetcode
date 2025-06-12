class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        gc(0,s,ans,path);
        return ans;
    }
    private void gc(int index,String s,List<List<String>> ans,List<String> path){
        int n = s.length();
        if(index == n){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index;i<n ;i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                gc(i+1,s,ans,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
