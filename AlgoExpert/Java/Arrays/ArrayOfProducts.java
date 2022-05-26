//
//Write a function that takes in a non-empty array of integers and returns an
//array of the same length, where each element in the output array is equal to
//the product of every other number in the input array.
//
//In other words, the value at output[i]  is equal to the product of
//every number in the input array other than input[i].
//Note that you're expected to solve this problem without using division.
//Sample Input:
//array  = [5, 1, 4, 2]
//Sample Output:
//[8, 40, 10, 20]
class ArrayOfProducts{
    public static void main(String args[]){
        int[] array = {5,1,4,2};
        int[] products = arrayOfProducts(array);
        for(int i=0;i<products.length;i++){
            System.out.print(products[i]+" ");
        }
        System.out.println();
    }
    public static int[] arrayOfProducts(int[] array){
        int[] products = new int[array.length];
        int leftProduct = 1;
        for(int i=0;i<array.length;i++){
            products[i] = leftProduct;
            leftProduct *= array[i];
        }
        int rightProduct = 1;
        for(int i=array.length-1;i>=0;i--){
            products[i] *= rightProduct;
            rightProduct *= array[i];
        }
        return products;
    }
}