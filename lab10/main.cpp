#include <iostream>
#include "SquareSeq.hpp"

int main()
{
    SquareSeq test(2);
    test[0] = Square(10, 10, 10);
    test[1] = Square(10, 10, 20);
    for (size_t i = 0; i < 2; i++){
        std::cout<< test[i].length() << ' ';
    }
    std::cout<<'\n';
    for (auto &square : test){
        square *= 20;
    }
    for (size_t i = 0; i < 2; i++){
        std::cout<< test[i].length() << ' ';
    }
    
    std::cout<<'\n';
    return 0;
}
