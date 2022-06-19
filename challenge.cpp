#include <iostream>

using namespace std;
//make a method that prints the scores that repeat.
int repeat(int scores[], int size);

int main()
{
    int scores[7] = {89, 88, 71, 64, 71, 88, 100};
    repeat(scores, 7);
    return 0;
}

int repeat(int scores[], int size)
{
    for(int i = 0; i < 7;i++){
        for(int j = i+1; j < 7; j++){
            if(scores[j] == scores[i]){
                    cout << scores[j] << endl;
            }
        }
    }
}
