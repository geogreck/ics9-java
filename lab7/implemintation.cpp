#include "declaration.h"
#include <iostream>
#include <algorithm>

StringMatrix::StringMatrix(size_t m, size_t amount): m(m), amount(amount){
    matrix = new std::string**[m];
    for (size_t i = 0; i < m; i++)
    {
        matrix[i] = new std::string*[m];
    }    
}

StringMatrix::StringMatrix(const StringMatrix &obj): m(obj.m), amount(obj.amount){
    matrix = new std::string**[m];
    for (size_t i = 0; i < m; i++)
    {
        matrix[i] = new std::string*[m];
    }
    for (size_t i = 0; i < m; i++)
    {
        for (size_t j = 0; j < m; j++)
        {
            matrix[i][j] = new std::string[amount];
        }
    }
     
    for (size_t i = 0; i < m; i++)
    {
        for (size_t j = 0; j < m; j++)
        {
            std::copy(obj.matrix[i][j], obj.matrix[i][j] + amount, this->matrix[i][j]);
        }
        
    }
}

size_t StringMatrix::getM(){
    return m;
}

size_t StringMatrix::getAmount(){
    return amount;
}

std::string** StringMatrix::operator[](size_t i){
    return matrix[i];
}

StringMatrix& StringMatrix::operator=(const StringMatrix& obj){
    if (this!= &obj){
        this->m = obj.m;
        matrix = new std::string**[m];
        for (size_t i = 0; i < m; i++)
        {
            matrix[i] = new std::string*[m];
        }
        for (size_t i = 0; i < m; i++)
        {
            for (size_t j = 0; j < m; j++)
            {
                matrix[i][j] = new std::string[amount];
            }
        }
        
        delete [] this->matrix;
        for (size_t i = 0; i < m; i++)
        {
            for (size_t j = 0; j < m; j++)
            {
                std::copy(obj.matrix[i][j], obj.matrix[i][j] + amount, this->matrix[i][j]);
            }
            
        }
    }

    return *this;
}

void StringMatrix::stringSetAdd(std::string** a, std::string* b, size_t cur_amount, size_t amount){
    for (size_t i = 0; i < amount - cur_amount; i++)
    {
        (*a)[i + cur_amount] = b[i];
    }
}

std::string* StringMatrix::stringSetMult(std::string* a, std::string* b, size_t amount){
    std::string* buf = new std::string[amount * amount];
    size_t k = 0;
    for (size_t i = 0; i < amount; i++)
    {
        for (size_t j = 0; j < amount; j++)
        {
            buf[k++] = a[i] + b[j];
        }
    }
    return buf;
}

StringMatrix* StringMatrix::multiply(){
    StringMatrix* temp = new StringMatrix(m, amount * amount * amount);
    for (size_t i = 0; i < m; i++)
        {
            for (size_t j = 0; j < m; j++)
            {
                temp->matrix[i][j] = new std::string[amount * amount * amount];
            }
        }
    for (size_t i = 0; i < m; i++){
        for (size_t j = 0; j < m; j++){
            size_t cur_amount = 0;
            size_t h = amount * amount;
            for (size_t k = 0; k < m; k++){
                std::string* foo = stringSetMult(matrix[i][k], matrix[k][j], amount);
                stringSetAdd(&(temp->matrix[i][j]), foo, cur_amount, h);
                cur_amount+= amount * amount;
                h *= amount;
                delete[] foo;
            }
        }
        
    }
    return temp;
    
}

StringMatrix::~StringMatrix(){
    //std::cout<<"Bye\n";
    for (size_t i = 0; i < m; i++)
    {
        for (size_t j = 0; j < m; j++)
        {
            delete[] matrix[i][j];
        }
        delete[] matrix[i];
    }
    delete[] matrix;
}
