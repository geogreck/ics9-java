#ifndef SQUARE_SEQ
#define SQUARE_SEQ 1

#include <iterator>
#include <cmath>

struct Square {
    int x, y;
    size_t area;
    Square(int x, int y, int a) : x(x), y(y), area(a * a) {};
    Square() {x = y =  0; area = 0;};
    size_t length() {
        return (size_t)sqrt((double)area);
    }
};

class SquareSeq{
private:
    Square* arr;
    size_t n;
public:
    SquareSeq(size_t n): n(n) {
        arr = new Square[n];
    }
    ~SquareSeq(){
        delete [] arr;
    }
    Square& operator[] (size_t index){
        return arr[index];
    }
    struct Iterator{
        using iterator_category = std::forward_iterator_tag;
        using diffrence_type = std::ptrdiff_t;
        using value_type = size_t;
        using pointer = size_t*;
        using reference = size_t&;

        Iterator(Square* ptr, size_t n) : ptr(ptr), n(n) {};

        reference operator* () const {
            return (*ptr).area;
        }
        pointer operator-> () {
            return &(*ptr).area;
        }
        Iterator& operator++ () {
            ptr++;
            return *this;
        }
        Iterator operator++(int) {
            Iterator tmp = *this;
            ++(*this);
            return tmp;
        }
        friend bool operator==(const Iterator& lhs, const Iterator& rhs){
            return lhs.ptr == rhs.ptr;
        }
        friend bool operator!=(const Iterator& lhs, const Iterator& rhs){
            return !(lhs == rhs);
        }
    private:
        Square* ptr;
        size_t n;
    };
    Iterator begin() {
        return Iterator(&arr[0], n);
    }
    Iterator end() {
        return Iterator(&arr[n], n);
    }
};

#endif
