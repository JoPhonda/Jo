#“On my honor as a student, I have neither given nor received any unauthorized aid on this assignment.”
#Joseph Kim 7th Period Programming

# 

class User:
    def __init__(self, first_name, last_name, ID, login_attempts):
        self.first_name = first_name
        self.last_name = last_name
        self.ID = ID
        self.login_attempts = login_attempts
    def __repr__(self):
        return f"Name: {self.first_name} {self.last_name}. ID: {self.ID}"
    def greet_user(self):
        return f"Welcome back, {self.first_name} {self.last_name} #{self.ID}."
    def reset_attempts(self):
        self.login_attempts = 0
        return self.login_attempts
    def increment_attempts(self):
        self.login_attempts += 1
        return self.login_attempts
class Admin(User):
    def __init__(self, first_name, last_name, ID, login_attempts, privileges):
        super().__init__(first_name, last_name, ID, login_attempts)
        self.privileges = privileges
    def show_privileges():

steve = User("Steve", "Wright", "1234", 1)
print(steve)
print(steve.greet_user())
print(steve.reset_attempts())
print(steve.increment_attempts())
print(steve.increment_attempts())
print(steve.reset_attempts())