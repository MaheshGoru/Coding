/*

You're given an array of non-negative integers where each non-zero integer
represents the height of a pillar of width 1. Imagine water being
poured over all of the pillars; write a function that returns the surface area
of the water trapped between the pillars viewed from the front. Note that
spilled water should be ignored.

You can refer to the first three minutes of this question's video explanation
for a visual example.
Sample Input
heights = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
Sample Output
48
// Below is a visual representation of the sample input.
// The dots and vertical lines represent trapped water and pillars, respectively.
// Note that there are 48 dots.
//        |
//        |
//  |.....|
//  |.....|
//  |.....|
//  |..|..|
//  |..|..|
//  |..|..|.....|
//  |..|..|.....|
// _|..|..|..||.|
*/
class WaterArea{
    public static void main(String args[]){
        int heights[] = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        int waterAreaValueByDP = waterAreaByDP(heights);
        System.out.println(waterAreaValueByDP);
        int waterAreaValue = waterArea(heights);
        System.out.println(waterAreaValue);
    }

    public static int waterArea(int heights[]){
        if(heights.length == 0) return 0;
        int leftIdx = 0;
        int rightIdx = heights.length-1;
        int leftMax = heights[leftIdx];
        int rightMax = heights[rightIdx];
        int totalArea = 0;
        while(leftIdx < rightIdx){
            if(heights[leftIdx] < heights[rightIdx]){
                leftIdx++;
                leftMax = Math.max(leftMax, heights[leftIdx]);
                totalArea += leftMax-heights[leftIdx];
            }else{
                rightIdx--;
                rightMax = Math.max(rightMax, heights[rightIdx]);
                totalArea += rightMax-heights[rightIdx];
            }
        }
        return totalArea;
    }

    public static int waterAreaByDP(int[] heights){
        int leftMaxArr[] = new int[heights.length];
        int rightMaxArr[] = new int[heights.length];
        int leftMax = 0;
        for(int i=0;i<leftMaxArr.length;i++){
            leftMaxArr[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }
        int rightMax = 0;
        for(int i=heights.length-1;i>=0;i--){
            rightMaxArr[i] = rightMax;
            rightMax = Math.max(rightMax, heights[i]);
        }
        int totalWater = 0;
        for(int i=0;i<heights.length;i++){
            int minHeight = Math.min(leftMaxArr[i], rightMaxArr[i]);
            if(heights[i] < minHeight){
                totalWater += minHeight - heights[i];
            }
        }
        return totalWater;
    }
}