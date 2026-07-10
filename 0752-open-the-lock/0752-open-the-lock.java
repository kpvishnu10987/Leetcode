class Solution {

    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000"))
            return -1;

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer("0000");
        vis.add("0000");

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String cur = q.poll();

                if (cur.equals(target))
                    return steps;

                char[] arr = cur.toCharArray();

                for (int i = 0; i < 4; i++) {

                    char old = arr[i];

                    arr[i] = old == '9' ? '0' : (char) (old + 1);
                    String next = new String(arr);

                    if (!dead.contains(next) && vis.add(next))
                        q.offer(next);

                    arr[i] = old == '0' ? '9' : (char) (old - 1);
                    next = new String(arr);

                    if (!dead.contains(next) && vis.add(next))
                        q.offer(next);

                    arr[i] = old;
                }
            }

            steps++;
        }

        return -1;
    }
}