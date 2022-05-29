/*

Write a function that takes in an array of integers and returns the largest
possible value for the expression
array[a] - array[b] + array[c] - array[d], where a, b, c and d are indices of the array
and a < b < c < d.

If the input array has fewer than 4  elements, your function
should return 0.
Sample Input
array  = [3, 6, 1, -3, 2, 7]
Sample Output
4// Choose a = 1, b = 3, c = 4, and d = 5
// -> 6 - (-3) + 2 - 7 = 4*/
class MaximizeExpression{
    public static void main(String args[]){
        int[] array = {3, 6, 1, -3, 2, 7};
        int maxValByIteration = maximizeExpressionByIteration(array);
        System.out.println(maxValByIteration);
        int maxValByDP = maximizeExpression(array);
        System.out.println(maxValByDP);
    }

    public static int maximizeExpressionByIteration(int[] array){
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<array.length-3;i++){
            for(int j=i+1;j<array.length-2;j++){
                for(int k=j+1;k<array.length-1;k++){
                    for(int l=k+1;l<array.length;l++){
                        maxVal = Math.max(maxVal, array[i] - array[j] + array[k] - array[l]);
                    }
                }
            }
        }
        return maxVal == Integer.MIN_VALUE ? 0 : maxVal;
    }

    public static int maximizeExpression(int[] array){
        int[] maxOfA = new int[array.length];
        int[] maxOfAMinusB = new int[array.length];
        int[] maxOfAMinusBPlusC = new int[array.length];
        int[] maxOfAMinusBPlusCMinusD = new int[array.length];
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<array.length-3;i++){
            maxVal = Math.max(maxVal, array[i]);
            maxOfA[i] = maxVal;
        }
        maxVal = Integer.MIN_VALUE;
        for(int i=1;i<array.length-2;i++){
            maxVal = Math.max(maxVal, maxOfA[i-1] - array[i]);
            maxOfAMinusB[i] = maxVal;
        }
        maxVal = Integer.MIN_VALUE;
        for(int i=2;i<array.length-1;i++){
            maxVal = Math.max(maxVal, maxOfAMinusB[i-1] + array[i]);
            maxOfAMinusBPlusC[i] = maxVal;
        }
        maxVal = Integer.MIN_VALUE;
        for(int i=3;i<array.length;i++){
            maxVal = Math.max(maxVal, maxOfAMinusBPlusC[i-1] - array[i]);
            maxOfAMinusBPlusCMinusD[i] = maxVal;
        }
        return array.length < 4 ? 0 : maxVal;
    }
}