import java.util.*;

class Twitter {
    private static int timestamp = 0;

    private class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> followmap;
    private Map<Integer, List<Tweet>> tweetmap;

    public Twitter() {
        followmap = new HashMap<>();
        tweetmap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetmap.putIfAbsent(userId, new ArrayList<>());
        tweetmap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(10, Comparator.comparingInt(a -> a.time));
        Set<Integer> users = new HashSet<>();
        users.add(userId); // user themselves

        // Add all followees
        if (followmap.containsKey(userId)) {
            users.addAll(followmap.get(userId));
        }

        // Go through all users' tweets and maintain the top 10 recent
        for (int uid : users) {
            List<Tweet> tweets = tweetmap.getOrDefault(uid, new ArrayList<>());
            for (Tweet tweet : tweets) {
                minHeap.offer(tweet);
                if (minHeap.size() > 10) {
                    minHeap.poll(); // remove the oldest
                }
            }
        }

        // Extract tweets from heap and reverse them
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().tweetId);
        }
        Collections.reverse(result);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followmap.putIfAbsent(followerId, new HashSet<>());
        followmap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followmap.containsKey(followerId) && followerId != followeeId) {
            followmap.get(followerId).remove(followeeId);
        }
    }
}
