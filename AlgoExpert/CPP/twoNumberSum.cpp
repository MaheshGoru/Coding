 // Write a function that takes in a non-empty array of distinct integers and an
 //  integer representing a target sum. If any two numbers in the input array sum
 //  up to the target sum, the function should return them in an array, in any
 //  order. If no two numbers sum up to the target sum, the function should return
 //  an empty array.

 //  Note that the target sum has to be obtained by summing two different integers
 //  in the array; you can't add a single integer to itself in order to obtain the
 //  target sum.
  
 //  You can assume that there will be at most one pair of numbers summing up to
 //  the target sum. 
#include <vector>
#include <unordered_set>
#include <iostream>
#include <algorithm>
using namespace std;
vector<int> twoNumberSum(vector<int>, int);
int main(){
	vector<int> array = {3,5,-4,8,11,1,-1,6};
	int targetSum = 10;
	vector<int> result = twoNumberSum(array, targetSum);
	for(int i=0;i<result.size();i++){
		cout << result[i] << " ";
	}
	return 0;
}
// O(N) Time | O(N) Space
// vector<int> twoNumberSum(vector<int> array, int targetSum){
// 	unordered_set<int> visitedNums;
// 	for(int i=0;i<array.size();i++){
// 		int difference = targetSum - array[i];
// 		if(visitedNums.find(difference) == visitedNums.end()){
// 			visitedNums.insert(array[i]);
// 		}else{
// 			return vector<int>{array[i], difference};
// 		}
// 	}
// 	return vector<int>{};
// }

//O(NlogN) Time | O(1) Space
vector<int> twoNumberSum(vector<int> array, int targetSum){
	sort(array.begin(), array.end());
	int left = 0;
	int right = array.size() - 1;
	while(left < right){
		int sum = array[left] + array[right];
		if(sum == targetSum){
			return vector<int>{array[left], array[right]};
		}
		if(sum > targetSum)
			right--;
		else
			left++;
	}
	return vector<int>{};
}