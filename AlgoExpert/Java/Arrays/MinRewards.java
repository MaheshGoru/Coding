/*

Imagine that you're a teacher who's just graded the final exam in a class. You
        have a list of student scores on the final exam in a particular order (not
        necessarily sorted), and you want to reward your students. You decide to do so
        fairly by giving them arbitrary rewards following two rules:
1.All students must receive at least one reward.
2.Any given student must receive strictly more rewards than an adjacent
        student (a student immediately to the left or to the right) with a lower
        score and must receive strictly fewer rewards than an adjacent student with
        a higher score.


        Write a function that takes in a list of scores and returns the minimum number
        of rewards that you must give out to students to satisfy the two rules.

        You can assume that all students have different scores; in other words, the
        scores are all unique.
        Sample Input
scores = [8, 4, 2, 1, 3, 6, 7, 9, 5]
Sample Output
25// you would give out the following rewards: [4, 3, 2, 1, 2, 3, 4, 5, 1]
*/
import java.util.*;
class MinRewards{
    public static void main(String args[]){
        int[] scores = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        int minRewards = minRewards(scores);
        System.out.println(minRewards);
    }

    // O(n^2) Time Complexity | O(n) Space Complexity
    public static int minRewards1(int[] scores){
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for(int i=1;i<scores.length;i++){
            if(scores[i-1] < scores[i])
                rewards[i] = rewards[i-1]+1;
            else{
                int j = i-1;
                while(j >= 0 && scores[j] > scores[j+1]){
                    rewards[j] = Math.max(rewards[j], rewards[j+1]+1);
                    j--;
                }
            }
        }
        int minRewards = 0;
        for(int i=0;i<scores.length;i++)
            minRewards += rewards[i];
        return minRewards;
    }

    public static List<Integer> getLocalMins(int[] scores){
        List<Integer> localMins = new ArrayList<Integer>();
        if(scores.length == 1) {
            localMins.add(0);
            return localMins;
        }
        for(int i=0;i<scores.length;i++){
            if(i == 0 && scores[i] < scores[i+1]) localMins.add(i);
            if(i == scores.length-1 && scores[i] < scores[i-1]) localMins.add(i);
            if(i == 0 || i == scores.length-1) continue;
            if(scores[i-1] > scores[i] && scores[i] < scores[i+1]) localMins.add(i);
        }
        return localMins;
    }

    // O(n) Time Complexity | O(n) Space Complexity
    public static int minRewards2(int[] scores){
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        List<Integer> localMins = getLocalMins(scores);
        for(int i=0;i<localMins.size();i++){
            int idx = localMins.get(i)+1;
            while(idx < scores.length && scores[idx-1] < scores[idx]){
                rewards[idx] = rewards[idx-1] + 1;
                idx++;
            }
            idx = localMins.get(i)-1;
            while(idx >= 0 && scores[idx] > scores[idx+1]){
                rewards[idx] = Math.max(rewards[idx], rewards[idx+1]+1);
                idx--;
            }
        }
        int minRewards = 0;
        for(int i=0;i<scores.length;i++)
            minRewards += rewards[i];
        return minRewards;
    }

    // O(n) Time Complexity | O(n) Space Complexity
    public static int minRewards(int[] scores){
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for(int i=1;i<scores.length;i++){
            if(scores[i-1] < scores[i])
                rewards[i] = rewards[i-1] + 1;
        }
        for(int j=scores.length-2;j>=0;j--){
            if(scores[j] > scores[j+1])
                rewards[j] = Math.max(rewards[j], rewards[j+1]+1);
        }
        int minRewards = 0;
        for(int i=0;i<scores.length;i++)
            minRewards += rewards[i];
        return minRewards;
    }
}