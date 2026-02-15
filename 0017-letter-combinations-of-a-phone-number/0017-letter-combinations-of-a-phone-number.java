class Solution {
    Map<Integer,String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        helper(0,n,digits,map,new String(),ans);
        return ans;
    }

    private void helper(int start,int n,String digits,Map<Integer,String> map,String sub,List<String> ans){
        if(sub.length() == n){
            ans.add(new String(sub));
            return;
        }

        int num = digits.charAt(start)-'0';
        String rel = map.get(num);
        for(int j = 0 ; j<rel.length() ; j++){
            helper(start+1,n,digits,map,sub+rel.charAt(j),ans);
        }
        
    }
}