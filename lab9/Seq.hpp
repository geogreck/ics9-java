#ifndef SEQ_H
#define SEQ_H 1

#include <vector>
#include <iostream>
#include <algorithm>
#include <set>

template <typename T>
class Seq
{
private:
    std::vector<T> container;
public:
    Seq();
    Seq<T>& operator+= (const Seq<T>& obj){
        container.reserve(obj.container.size());
        container.insert(container.end(), obj.container.begin(), obj.container.end());
        std::sort(container.begin(), container.end());
        return *this;
    }
    Seq<T> operator+ (const Seq<T>& obj){
        return Seq<T>(*this) += obj;
    }
    Seq<T>& operator*=(const size_t k){
        std::vector<T> new_container;
        for (auto x : container)
        {
            for (size_t i = 0; i < k; i++)
            {
                new_container.push_back(x);
            }
        }
        container = new_container;
        return *this;
    }
    Seq<T> operator* (const size_t k){
        return Seq<T>(*this) *= k;
    }
    Seq<T> operator! (){
        std::set<T> s( container.begin(), container.end() );
        container.assign(s.begin(), s.end());
        return *this;
    }
    T& operator[] (size_t index){
        return container[index];
    }
    void insert(T data){
        container.push_back(data);
        std::sort(container.begin(), container.end());
    }
    void print(){
        for (auto x : container)
        {
            std::cout<<x<<" ";
        }
        std::cout<<'\n';
    }
    

};

template <typename T>
Seq<T>::Seq()
{
    container = {};
}

#endif
