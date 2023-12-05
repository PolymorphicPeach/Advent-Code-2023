#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <array>
#include "Matrix.h"

using std::cout, std::endl, std::ifstream, std::vector, 
    std::string, std::array;

int main(){
    Matrix m;
    vector<string> matrix;

    ifstream data;
    data.open("Day3.txt", std::ios::in);
    string line;

    // Padding
    m.addRow(std::move(string(142, '.')));
    while(!data.eof()){
        getline(data, line);
        cout << line.length() << endl;
        m.addRow(std::move('.' + line + '.'));

        //matrix.push_back(line);
    }
    data.close();
    // Padding
    m.addRow(std::move(string(142, '.')));

    //m.printMatrix();
    m.evaluate();
    cout << "Sum = " << m.getSum() << endl;


    return 0;
};