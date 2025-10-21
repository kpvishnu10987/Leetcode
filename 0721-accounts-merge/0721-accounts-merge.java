import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int u) {
        if (u == parent.get(u)) return u;
        int root = findPar(parent.get(u));
        parent.set(u, root); // path compression
        return root;
    }

    public void unionBySize(int u, int v) {
        int up_u = findPar(u);
        int up_v = findPar(v);

        if (up_u == up_v) return; // same set

        if (size.get(up_u) < size.get(up_v)) {
            parent.set(up_u, up_v);
            size.set(up_v, size.get(up_v) + size.get(up_u));
        } else {
            parent.set(up_v, up_u);
            size.set(up_u, size.get(up_u) + size.get(up_v));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>(); // email → account index

        // Step 1: Union accounts that share any email
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) { // skip name
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        // Step 2: Collect emails for each parent
        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++) mergedMail.add(new ArrayList<>());

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergedMail.get(node).add(mail);
        }

        // Step 3: Build final merged accounts
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0) continue;
            Collections.sort(mergedMail.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // name
            temp.addAll(mergedMail.get(i));   // sorted emails
            ans.add(temp);
        }

        return ans;
    }
}
