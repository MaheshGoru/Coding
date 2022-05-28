/*

You're given a non-empty array of arrays where each subarray holds three
integers and represents a disk. These integers denote each disk's width,
depth, and height, respectively. Your goal is to stack up the disks and to
maximize the total height of the stack. A disk must have a strictly smaller
width, depth, and height than any other disk below it.

Write a function that returns an array of the disks in the final stack,
starting with the top disk and ending with the bottom disk. Note that you
can't rotate disks; in other words, the integers in each subarray must
represent [width, depth, height] at all times.

You can assume that there will only be one stack with the greatest total
height.
Sample Input
disks  = [[2, 1, 2], [3, 2, 3], [2, 2, 8], [2, 3, 4], [1, 3, 1], [4, 4, 5]]
Sample Output
[[2, 1, 2], [3, 2, 3], [4, 4, 5]]
// 10 (2 + 3 + 5) is the tallest height we can get by
// stacking disks following the rules laid out above.*/
import java.util.*;
class DiskStacking{
    public static void main(String args[]){
        List<Integer[]> disks = new ArrayList<>();
        disks.add(new Integer[]{2,1,2});
        disks.add(new Integer[]{3,2,3});
        disks.add(new Integer[]{2,2,8});
        disks.add(new Integer[]{2,3,4});
        disks.add(new Integer[]{1,3,1});
        disks.add(new Integer[]{4,4,5});
        List<Integer[]> res = diskStacking(disks);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i)[0]+" "+res.get(i)[1]+" "+res.get(i)[2]);
        }
    }

    public static List<Integer[]> diskStacking(List<Integer[]> disks){
        Collections.sort(disks, (a,b) -> a[2] - b[2]);
        int heights[] = new int[disks.size()];
        int indexes[] = new int[disks.size()];
        int maxHeight = 0;
        int maxHeightIdx = -1;
        for(int i=0;i<disks.size();i++){
            heights[i] = disks.get(i)[2];
            indexes[i] = -1;
            Integer[] currentDisk = disks.get(i);
            for(int j=0;j<i;j++){
                Integer[] otherDisk = disks.get(j);
                if(otherDisk[0] < currentDisk[0] && otherDisk[1] < currentDisk[1] && otherDisk[2] < currentDisk[2]){
                    if(heights[i] < heights[j]+currentDisk[2]){
                        heights[i] = heights[j]+currentDisk[2];
                        indexes[i] = j;
                    }
                }
            }
            if(maxHeight < heights[i]){
                maxHeight = heights[i];
                maxHeightIdx = i;
            }
        }
        int idx = maxHeightIdx;
        List<Integer[]> res = new ArrayList<>();
        while(idx != -1){
            res.add(0, disks.get(idx));
            idx = indexes[idx];
        }
        return res;
    }
}