#include "Seq.hpp"
#include <cmath>

struct radiusVector
{
    float x, y;
    bool operator<(radiusVector& obj){
        return (sqrt(x * 2 + y * 2) - sqrt(obj.x * 2 + obj.y * 2)) < 0;
    }
    bool operator==(radiusVector& obj){
        return (x == obj.x) && (y = obj.y);
    }
};


int main()
{
    Seq<int> test1;
    Seq<int> test2;
    test1.insert(30);
    test1.insert(10);
    test2.insert(20);

    Seq<int> test3 = test1 + test2; // Слияние
    test3.print();
    test3 = test3 * 2; //Умножение на число
    test3.print();
    !test3; // Уничтожение дупликатов
    test3.print();
    std::cout<<test3[0] << '\n'; // Индексация элементов

    Seq<radiusVector> testr1;
    Seq<radiusVector> testr2;
    testr1.insert({10, 10});
    testr2.insert({5, 10});
    Seq<radiusVector> testr3 = testr1 + testr2;
    radiusVector x = testr3[1];
    std::cout<<x.x << ' '<<x.y;
    return 0;
}
