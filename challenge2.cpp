

#include <iostream>

using namespace std;
int oldest(int ages[],int size);
int youngest(int ages[],int size);
int even(int ages[],int size);

int main()
{
    int ages[6]={24,30,80,10,50,75};
    cout<<"The oldest person is "<<oldest(ages,6)<<" years old"<<endl;
    cout<<"The youngest person is "<<youngest(ages,6)<<" years old"<<endl;
    even(ages,6);
}
int oldest(int ages[], int size){
    int oldest=-1;
    for (int i=0;i<size;i=i+1)
    {
        if(ages[i]>oldest){
            oldest=ages[i];

        }
    }
    return oldest;
}
int youngest(int ages[], int size){
    int youngest=100000000;
    for (int i=0;i<size;i=i+1)
    {
        if(ages[i]<youngest){
            youngest=ages[i];

        }
    }
    return youngest;
}
int even(int ages[], int size){
    for(int i = 0; i<size; i++){
          if(ages[i]%2==0){
              cout<<ages[i]<<endl;
          }

    }

}
// print the oldest, youngest, and even ages
