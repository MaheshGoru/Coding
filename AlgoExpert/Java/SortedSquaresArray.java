class SortedSquaresArray{
    public static void main(String args[]){
        int[] array = {-7,-3,-1,0,2,3,6};
        int[] squaresArray = sortedSquaredArray(array);
        for(int i=0;i<squaresArray.length;i++){
            System.out.print(squaresArray[i]+" ");
        }
    }
    public static int[] sortedSquaredArray(int[] array){
        int leftIdx = 0;
        int rightIdx = array.length - 1;
        int count = array.length - 1;
        int[] squaresArray = new int[array.length];
        while(leftIdx <= rightIdx){
            if(Math.abs(array[leftIdx]) > Math.abs(array[rightIdx])){
                squaresArray[count--] = array[leftIdx] * array[leftIdx];
                leftIdx++;
            }else{
                squaresArray[count--] = array[rightIdx] * array[rightIdx];
                rightIdx--;
            }
        }
        return squaresArray;
    }
}