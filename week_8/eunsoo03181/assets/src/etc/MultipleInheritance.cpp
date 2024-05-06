#include <iostream>
using namespace std;

class Parent1 {
private:
	int a = 1;

public:
	int getA() {
		return a;
	}
};

class Parent2 {
private:
	int b = 1;

public:
	int getB() {
		return b;
	}
};

class Child : public Parent1, public Parent2 {
public:
	int getTotal() {
		return getA() + getB();
	}
};

int main() {
	Child ch;
	cout << "a + b = " << ch.getTotal() << endl;
}