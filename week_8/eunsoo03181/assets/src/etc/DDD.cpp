#include <iostream>
using namespace std;

class Parent1 {
public:

	void printA() {
		cout << "A" << endl;
	}

	void method() {
		cout << "Hello, World!" << endl;
	}
};

class Parent2 {
public:

	void printB() {
		cout << "B" << endl;
	}

	void method() {
		cout << "This is cpp world!" << endl;
	}
};

class Child : public Parent1, public Parent2 {
public:
	void getAandB() {
		printA();
		printB();
	}

	void getMethod() {
		// method(); > 오류: method 엑세스가 모호합니다.
		Parent1::method();
		Parent2::method();
	}
};

int main() {
	Child ch;
	ch.printA();
	ch.printB();
	ch.getAandB();
	ch.getMethod();
	//ch.method(); > 오류
	ch.Parent1::method();
	ch.Parent2::method();
}