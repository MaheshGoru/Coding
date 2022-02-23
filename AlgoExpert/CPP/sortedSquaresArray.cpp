#include <iostream>
#include <vector>
using namespace std;
vector<int> sortedSquaredArray(vector<int>);
int main(){
    vector<int> array = {-7,-3,-1,0,2,3,6};
    vector<int> squaresArray = sortedSquaredArray(array);
    for(int i=0;i<squaresArray.size();i++){
        cout << squaresArray[i] << " ";
    }
}
vector<int> sortedSquaredArray(vector<int> array){
    int left = 0;
    int right = array.size() - 1;
    int count = array.size()-1;
    vector<int> squaredArray(array.size());
    while(left <= right){
        if(abs(array[left]) > abs(array[right])){
            squaredArray[count--] = array[left] * array[left];
            left++;
        }else{
            squaredArray[count--] = array[right] * array[right];
            right--;
        }
    }
    return squaredArray;
}