class Solution {

    public boolean[] transformStr(String s, String[] strs) {

        int onesS = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                onesS++;

        int zerosS = s.length() - onesS;

        List<Integer> sourceOnes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1')
                sourceOnes.add(i);

        boolean[] ans = new boolean[strs.length];

        for (int k = 0; k < strs.length; k++) {

            char[] t = strs[k].toCharArray();

            int fixedOne = 0;
            int fixedZero = 0;
            int q = 0;

            for (char c : t) {
                if (c == '1')
                    fixedOne++;
                else if (c == '0')
                    fixedZero++;
                else
                    q++;
            }

            int needZero = zerosS - fixedZero;
            int needOne = onesS - fixedOne;

            if (needZero < 0 || needOne < 0 || needZero + needOne != q) {
                ans[k] = false;
                continue;
            }

            for (int i = 0; i < t.length; i++) {
                if (t[i] == '?') {
                    if (needZero > 0) {
                        t[i] = '0';
                        needZero--;
                    } else {
                        t[i] = '1';
                    }
                }
            }

            List<Integer> targetOnes = new ArrayList<>();

            for (int i = 0; i < t.length; i++)
                if (t[i] == '1')
                    targetOnes.add(i);

            boolean ok = true;

            for (int i = 0; i < sourceOnes.size(); i++) {
                if (sourceOnes.get(i) > targetOnes.get(i)) {
                    ok = false;
                    break;
                }
            }

            ans[k] = ok;
        }

        return ans;
    }
}