#“On my honor as a student, I have neither given nor received any unauthorized aid on this assignment.”
#Joseph Kim 7th Period Programming
dictionary = {
    'Python':'Python is a high-level, general-purpose programming language.',
    'Function':'A function is a group of code. To run the code in a function, you must call the function.',
    'List':'A list is a data structure in Python that is a mutable, or changeable, ordered sequence of elements.',
    'Boolean':'Booleans are used to store two values, i.e True and False.',
    'String':'A string in Python is an immutable sequence of characters. It is a derived data type.',
    'Module':'Modules are files with the “. py” extension containing Python code that can be imported inside another Python Program.',
    'Loop':'A loop repeats something over and over until a particular condition is satisfied.',
    'Tuple':'Tuples are used to store multiple items in a single variable. It is ordered and unchangable.',
    'Variable':'A variable is a reserved memory location to store values. (numbers, lists, tuples, strings, etc.)',
    'Dictionary':'A dictionary is a collection of related pieces of information. Like this.'
}
word = input("Input a Python term, and this dictionary will try to define it:\n")
print(dictionary.get(word, 'Definition not found.'))