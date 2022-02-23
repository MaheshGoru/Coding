#include <iostream>
#include <vector>
using namespace std;
//void setZeroes(vector<vector<int>> *);
void setZeroes(vector<vector<int>>& matrix){
    for(int i=0;i<matrix.size();i++){
        for(int j=0;j<matrix[i].size();j++){
            if(matrix[i][j] == 0){
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }
    for(int i=0;i<matrix.size();i++){
        for(int j=0;j<matrix[i].size();j++){
            if(matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
        }
    }
}
int main(){
    vector<vector<int>> matrix = {{1,1,1},{1,0,1},{1,1,1}};
    setZeroes(matrix);
    for(int i=0;i<matrix.size();i++){
        for(int j=0;j<matrix[i].size();j++){
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}
