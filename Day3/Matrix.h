#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using std::cout, std::endl, std::string, std::vector;

struct Number{
    int start;
    int end;
    string numStr = "";

};

class Matrix{
    private:
    vector<string> matrix;
    int sum;
    Number currentNumber;

    public:
    Matrix(){
        sum = 0;
    }

    void addRow(string row){
        matrix.push_back(std::move(row));
    }

    void evaluate(){
        for(int i = 1; i < matrix.size() - 1; ++i){
            for(int j = 1; j < matrix[i].length() - 1; ++j){
                cout << matrix[i][j];
            }
            cout << endl;
        }

        for(size_t i = 1; i < matrix.size() - 1; ++i){
            cout << "row = " << i << ": ";
            for (int j = 1; j < matrix[i].length() - 1; ++j){
                if(isdigit(matrix[i][j])){
                    int digits = getNumDigits(j, matrix[i]);
                    int number = stoi(matrix[i].substr(j, digits));
                    cout << number << " " << "{" << matrix[i].substr(j, digits).length() << "} ";

                    if(isValid(j, digits, i)){
                        sum += number;
                    }
                    j += digits;
                }
            }
            cout << endl;
        }
    }

    void process(int currentRow, int startIdx, int endIdx){

    }

    int getNumDigits(int startIdx, string line){
        int numDigits = 0;

        for(int k = startIdx; k < line.length(); ++k){
            if(isdigit(line[k])){
                numDigits += 1;
            }
            else{
                break;
            }
        }

        return numDigits;
    }

    bool isValid(int startIdx, int digits, int currentLine){
        if(!isdigit(matrix[currentLine][startIdx - 1]) && matrix[currentLine][startIdx - 1] != '.'){
            return true;
        }
        if(!isdigit(matrix[currentLine][startIdx + digits]) && matrix[currentLine][startIdx + digits] != '.'){
            return true;
        }
        for(int k = startIdx - 1; k < startIdx + digits + 1; ++k){
            if(!isdigit(matrix[currentLine - 1][k]) && matrix[currentLine - 1][k] != '.'){
                return true;
            }
            if(!isdigit(matrix[currentLine + 1][k]) && matrix[currentLine + 1][k] != '.'){
                return true;
            }
        }

        return false;
    }

    void printMatrix(){
        for(int i = 0; i < matrix.size(); ++i){
            cout << matrix[i] << endl;
        }
    }

    int getSum(){
        return sum;
    }


};