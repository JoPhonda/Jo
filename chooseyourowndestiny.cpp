#include <iostream>
#include <string>
#include <ios>
#include <limits>

using namespace std;

class Game
{
private:
    int choice;
public:
    Game()
    {
        cout << "You're walking in the woods one day and you come across a bear.  What do you do?" << endl;
        cout << "1. Turn back and go back to where you came from." << endl;
        cout << "2. Try and sneak past." << endl;
        cout << "3. Poke it with a stick." << endl;
        cout << "4. Give Up."<< endl;
        choice = getInput(4);
        if(choice == 1){
            returnHome();
        }
        else if(choice == 2){
            bearWakes();
        }
        else if(choice == 3){
            angryBear();
        }
        else if(choice == 4){
            playDead();
        }
    }
private:
    void playAgain(){
        cout << endl;
        cout << "Would you like to play again? Type 1 for YES and Type 2 for NO." << endl;
        choice = getInput(2);
        if(choice == 1){
            new Game();
        }
    }
    void returnHome(){
        cout << "You go back home, and play Among Us." << endl;
        playAgain();
    }
    void wokeBear(){
        cout << endl;
        cout << "The bear wakes. What do you do?" << endl;
        cout << "1. Fight the bear." << endl;
        cout << "2. Run away." << endl;
        choice = getInput(2);
        if(choice == 1){
            cout << "You try to fight, but you die to the bear." << endl;
            playAgain();
        }
        else if(choice == 2){
            cout << "You outrun the bear, and live." << endl;
            playAgain();
        }
    }
    void bearWakes(){
        wokeBear();
    }
    void angryBear(){
        cout << "The bear wakes, furious, and you die a gruesome death." << endl;
        playAgain();
    }
    void playDead(){
        cout << "You play dead. The bear decides to leave you alone." << endl;
        playAgain();
    }
    int getInput(int numChoices)  {
        while(true) {
            int input = 0;
            cin >> input;
            cin.get();
            if(cin.fail())  {
                cout << "Please enter a NUMBER." << endl;
                cin.clear();
                cin.ignore(256, '\n');
            } else  {
                if(input > 0 && input < 5)  {
                    return input;
                }
                else    {
                    cout <<"Please enter a number BETWEEN 1-4." << endl;
                }
            }
        }
    }
};


int main()
{
    new Game();
    return 0;
}
