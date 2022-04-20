#include "List.hpp"
#include <iostream>
#include <cstdlib>
#include <string>

int main() {
    List<int> a;
    
    a.push(10); // Вставка значения
    a.push(20);
    a.push(40);
    a.push(80);

    a.print();
    a.Delete(40); // Удаление значения
    a.print();
    std::cout<< a.countSum() << std::endl; // Сумма списка для Int
    auto c = a.ListSearch(10); // Поиск значения в списке
    std::cout<< a.pop() << std::endl << c << std::endl;

    List<std::string> b; // Работает с разными типами
    b.push("abc");
    b.push("1246");
    b.print();
    return 0;
}
