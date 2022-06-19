#include <iostream>

using namespace std;

int main()
{
    srand(time(NULL));
    int random = rand()%6;
    cout << "Ask a question and press enter for an answer: " << endl;
    string pause;
    getline(cin, pause);
    if(random == 0)
        cout << "Yes" << endl;
    else if(random == 1)
        cout << "No" << endl;
    else if(random == 2)
        cout << "In 3 years" << endl;
    else if(random == 3)
        cout << "I dont know, ask your mom" << endl;
    else if(random == 4)
        cout << "Maybe" << endl;
    else if(random == 5)
        cout << "What do you think?" << endl;
}
