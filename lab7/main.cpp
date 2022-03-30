#include "declaration.h"
#include <iostream>

void display(StringMatrix stM){
    for (size_t i = 0; i < stM.getM(); i++)
    {
        for (size_t j = 0; j < stM.getM(); j++)
        {
            std::cout<<"|";
            for (size_t k = 0; k < stM.getAmount(); k++)
            {
                std::cout<<stM[i][j][k]<<", ";
            }
            std::cout<<"|";
        }
        std::cout<<"\n";
    }
    std::cout<<"\n";
}

void foo(StringMatrix stM){
    stM[1][1][0] = "f";
    display(stM);
}

int main(){
    StringMatrix test(2, 2);
    std::string* foo1 = new std::string[2]{"a", "b"}; // a, b | c, d
    std::string* foo2 = new std::string[2]{"c", "d"}; // _____|_____
    std::string* foo3 = new std::string[2]{"e", "f"}; //      |  
    std::string* foo4 = new std::string[2]{"h", "g"}; // e, f | h, g
    test[0][0] = foo1;
    test[1][0] = foo3;
    test[0][1] = foo2;
    test[1][1] = foo4;
    foo(test); // Проверка работы конструктора копий
    display(test); //Копия изменилась, сам объект не изменился
    StringMatrix t = test; //Присваиваем объект переменной
    StringMatrix* foo = test.multiply(); //Умножение матрицы на саму себя возвращает нам новую матрицу
    display(*foo);
    delete foo;

    return 0;
}