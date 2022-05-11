#“On my honor as a student, I have neither given nor received any unauthorized aid on this assignment.”
#Joseph Kim 7th Period Programming
names = ["Safal", "Jonah", "Sher", "Ryan"]
print(names[0])
print(names[1])
print(names[2])
print(names[3])
friends = f'{names[0]} and {names[2]}'
print(friends+" know each other.")

guest_list = ["Reyna", "Raze", "Jett"]
print(f"Welcome {guest_list[0]}, you have been invited to this party!")
print(f"Welcome {guest_list[1]}, you have been invited to this party!")
print(f"Welcome {guest_list[2]}, you have been invited to this party!")
print(guest_list[2]+" will not be arriving.")
guest_list.pop(2)
guest_list.insert(2, "Neon")
print(f"Welcome {guest_list[2]}, you have been invited to this party!")
guest_list.insert(1, "Pheonix")
guest_list.insert(3, "Cypher")
guest_list.insert(5, "Sova")
not_arriving_1 = guest_list.pop(2)
not_arriving_2 = guest_list.pop(2)
print(f"We are sorry that you are not able to attend, {not_arriving_1}.")
print(f"We are sorry that you are not able to attend, {not_arriving_2}.")
print(guest_list)

places = ["Japan", "Korea", "Antarctica", "France"]
print(places)
print(sorted(places))
print(places)
print(sorted(places, reverse = True))
print(places)
places.reverse()
print(places)
places.reverse()
print(places)
places.sort()
print(places)
places.sort(reverse = True)
print(places)