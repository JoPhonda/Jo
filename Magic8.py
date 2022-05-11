#“On my honor as a student, I have neither given nor received any unauthorized aid on this assignment.”
#Joseph Kim 7th Period Programming
from ntpath import join
import random
name = input("What is your name?\n")
question = input(f"Ok {name}, ask a yes or no question.\n")
answer = []
random_number = random.randint(1,9)
#print(random_number)
if random_number == 1:
    answer = "Yes, definitely."
elif random_number == 2:
    answer = "It is decidely so."
elif random_number == 3:
    answer = "Without a doubt."
elif random_number == 4:
    answer = "Reply hazy, try again."
elif random_number == 5:
    answer = "Ask again later."
elif random_number == 6:
    answer = "Better not tell you now."
elif random_number == 7:
    answer = "My sources say no."
elif random_number == 8:
    answer = "Outlook not so good."
elif random_number == 9:
    answer = "Very doubtful."
if question == "":
    print("No question inputted, cannot answer.")
elif name == "":
    print(f"Question: {question}\n8 Ball's answer: {answer}")
else:
    print(f"{name} asks: {question}\n8 Ball's answer: {answer}")