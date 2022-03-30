#ifndef STRING_MATRIX
#define STRING_MATRIX

#include <string>

class StringMatrix
{
private:
    std::string*** matrix;
    size_t m, amount;
    void stringSetAdd(std::string** a, std::string* b, size_t cur_amount, size_t amount);
    std::string* stringSetMult(std::string* a, std::string* b, size_t amount);
public:
    StringMatrix(size_t m, size_t amount);
    StringMatrix(const StringMatrix& obj);
    size_t getM();
    size_t getAmount();
    std::string** operator[](size_t i);
    StringMatrix& operator=(const StringMatrix& obj);
    StringMatrix* multiply();
    virtual ~StringMatrix();
};

#endif
