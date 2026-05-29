#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "roster.h"
//returns the number of students enrolled in the course after the student is added
int add_student(FILE* in, FILE* out, char* students[], int current_students, int const max_students)
{
    char name[101];
    //reads input and stores the name in name
    fscanf(in, "%[^\n]\n", name);
    //prints command
    fprintf(out, "Command: add %s\n", name);

    if (current_students >= max_students) //if class is full
    {
        fprintf(out, "\tStudent %s not added. The class is already at capacity.\n", name);
        return current_students; //fails and returns count
    }

    students[current_students] = (char*)malloc(strlen(name) + 1); //frees memory space for new name + null terminator
    strcpy(students[current_students], name); //copies name into that space
    current_students++;

    fprintf(out, "\t%s was added. %d spot(s) remain.\n", name, max_students - current_students);
    return current_students; //success, remaining spots, and returns count
}
//searches list for name, if exists, replace with new name
void modify_name(FILE* in, FILE* out, char* students[], int current_students)
{
    char line[205]; //input message
    fscanf(in, "%[^\n]\n", line); //scans input for input message and stores in line

    fprintf(out, "Command: modify %s\n", line);

    char old[101], new[101];
    sscanf(line, "%[^:]:%[^\n]", old, new); //splits by : and stores in old/new

    for (int i = 0; i < current_students; i++) //for all students in roster
    {
        if (strcmp(students[i], old) == 0) //if that name matches old name
        {
            free(students[i]); //frees memory at that address
            students[i] = (char*)malloc(strlen(new) + 1); //creates new memory for new name
            strcpy(students[i], new); //copies into new name

            fprintf(out, "\tStudent %s name modified to %s.\n", old, new);
            return; //breaks if found
        }
    }

    fprintf(out, "\tNo student with name %s found.\n", old); //if not found
}
//returns number enrolled in course after student is removed
int remove_student(FILE* in, FILE* out, char* students[], int current_students, int const max_students)
{
    char name[101];
    //reads input and stores the name in name
    fscanf(in, "%[^\n]\n", name);

    fprintf(out, "Command: remove %s\n", name);

    for (int i = 0; i < current_students; i++) //for each student
    {
        if (strcmp(students[i], name) == 0) //if name matches
        {
            free(students[i]); //free memory from that address

            for (int j = i; j < current_students - 1; j++) //for each student after that
            {
                students[j] = students[j + 1]; //shift into next slot
            }

            current_students--;

            fprintf(out, "\tStudent %s removed. The course now has %d seats remaining.\n", name, max_students - current_students);
            return current_students; //print and return
        }
    }

    fprintf(out, "\tNo student named %s was found to remove.\n", name);
    return current_students;//if can't find student
}
//prints students currently enrolled
void display_class(FILE* out, char* students[], int current_students)
{
    fprintf(out, "Command: display\n\tCurrently Enrolled:\n");

    for (int i = 0; i < current_students; i++) //for all students
    {
        fprintf(out, "\t\tStudent %d: %s\n", i + 1, students[i]); //print that student with a corresponding number
    }
}
//removes all students in class without using remove_student
void delete_class(FILE* out, char* students[], int* current_students)
{
    fprintf(out, "Command: delete\n");

    for (int i = 0; i < *current_students; i++) //for all student pointers
    {
        fprintf(out, "\t%s removed in class delete.\n", students[i]);
        free(students[i]); //frees memory of each student
    }

    *current_students = 0;//sets current students to 0

    fprintf(out, "\tClass was restarted and reopened for enrollment.\n\n");
}