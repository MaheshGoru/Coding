//
//Write a function that takes in an array of integers and returns the length of
//        the longest peak in the array.
//
//        A peak is defined as adjacent integers in the array that are strictly
//        increasing until they reach a tip (the highest value in the peak), at which
//        point they become strictly decreasing. At least three integers are required to
//        form a peak.
//
//        For example, the integers 1, 4, 10, 2 form a peak, but the
//        integers 4, 0, 10 don't and neither do the integers
//        1, 2, 2, 0. Similarly, the integers 1, 2, 3 don't
//        form a peak because there aren't any strictly decreasing integers after the
//        3.
//Sample Input:
//array  = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
//Sample Output:
//6 // 0, 10, 6, 5, -1, -3
class LongestPeak{
    public static void main(String args[]){
        int[] array = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
        int longestPeakCount = longestPeak(array);
        System.out.println(longestPeakCount);
    }
    public static int longestPeak(int[] array){
        int longestPeakVal = 0;
        int currentPeak = 0;
        int currentIdx = 0;
        while(currentIdx < array.length){
            if(currentIdx > 0 && array[currentIdx-1] < array[currentIdx] && currentIdx < array.length-1 && array[currentIdx+1] < array[currentIdx]) {
                System.out.println(array[currentIdx]);
                int idx = currentIdx - 1;
                currentPeak = 1;
                while (idx >= 0 && array[idx] < array[idx + 1]) {
                    currentPeak++;
                    idx--;
                }
                idx = currentIdx + 1;
                while (idx < array.length && array[idx] < array[idx-1]){
                    currentPeak++;
                    idx++;
                }
                if(currentPeak > longestPeakVal) longestPeakVal = currentPeak;
                currentIdx = idx-1;
            }
            currentIdx++;
        }
        return longestPeakVal;
    }
}