#include <stdio.h>

/*parses one line from the input file and prints a record with all ratings and costs
(first part of printing)
in: file to read from
out: file to print to
total_bought: total number of books bought
total_sold: total sold
ratings_bought: total ratings of books bought
ratings_sold: same thing for sold
spent: total spent
profit: total profit*/
int parseLine(FILE *in, FILE *out, int *total_bought, int *total_sold, 
    int *ratings_bought, int *ratings_sold, 
    double *spent, double *profit) {

    char type;
    double price;
    int rating;
    char title[501];

    // reads the line and stores all values in type, price, rating, and title, then checks that all 4 values are captured
    if (fscanf(in, " %c : $%lf : %d stars : %[^\n]\n", &type, &price, &rating, title) == 4){
        if (type == 'B'){ //if bought, increase all values by whatever we got, then prints what we got out
            (*total_bought)++;
            *ratings_bought += rating;
            *spent += price;
            fprintf(out, "Bought %s (%d stars) for $%.2f.\n", title, rating, price);
        }
        else if (type == 'S'){ //if sold (same as bought)
            (*total_sold)++;
            *ratings_sold += rating;
            *profit += price;
            fprintf(out, "Sold %s (%d stars) for $%.2f.\n", title, rating, price);
        }
        return 1;
    }
    return 0;
}

/*prints the part where it says average ratings, bought and sold totals, average ratings for both, and spent/profit costs
(second part of printing)
same values as parseLine but no input file*/
void printSummary(FILE *out, int total_bought, int total_sold, 
    int ratings_bought, int ratings_sold, 
    double spent, double profit) {

    fprintf(out, "\nAverage Ratings:\n");
    if (total_bought != 0){ //avoids 0 error, also to 2 decimal points
        fprintf(out, "\t%d Bought: %.2f stars\n", total_bought, (double)ratings_bought / total_bought);
    }
    if (total_sold != 0){ //same here
        fprintf(out, "\t%d Sold: %.2f stars\n", total_sold, (double)ratings_sold / total_sold);
    }
    fprintf(out, "Costs:\n");
    fprintf(out, "\tSpent: $%.2f\n", spent);
    fprintf(out, "\tProfit: $%.2f\n", profit);
}
/*main file, does all of the file calling and calls the other methods
argc: number of arguments
argv: arguments in an array*/
int main(int argc, char* argv[]){

    if (argc != 3) { //checks if there are exactly 3 arguments, otherwise
        printf("Error: wrong number of arguments (not 3)");
        return 1; //prints an error
    }
    //stores input file from arg 1 and output file from 2
    FILE *in = fopen(argv[1], "r"); //reads for input
    FILE *out = fopen(argv[2], "w"); //writes for output
    if (!in) {//prints error if input file null
        perror("Error opening input file");
        return 1;
    }
    if (!out) {//same for output
        perror("Error opening output file");
        return 1;
    }
    int total_bought = 0, total_sold = 0, ratings_bought = 0, ratings_sold = 0;
    double spent = 0.0, profit = 0.0; //intiallizes all variables
    //loops while there are still values returned from parse
    while (parseLine(in, out, &total_bought, &total_sold, &ratings_bought, &ratings_sold, &spent, &profit)){
        //stores everything into each variable, so we use &
    }
    //calls printSummary method for the second half, no & bc we're not storing anything
    printSummary(out, total_bought, total_sold, ratings_bought, ratings_sold, spent, profit);
    //close both files
    fclose(in);
    fclose(out);
    return 0;
}