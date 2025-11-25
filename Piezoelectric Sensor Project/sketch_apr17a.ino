/*Piezo sensor with Arduino.
  Serial monitor readings.
  created by the SriTu Tech team.
  Read the code below and use it for any of your creation
*/

void setup() {
  Serial.begin(9600);//enable serial monitor
  for (byte a = 2; a <= 6; a++) { //set all pins 2-6 (that host the LEDs) to OUTPUT
    pinMode(a, OUTPUT);
  }
}
void loop() {
  int value = analogRead(A1);//read input from A1
  Serial.println(value);
  for (int a = 1; a <= 5; a++) { //writes to all pins 1-5 as HIGH or LOW (0) depending on the value 
    if (value > a * 20) {
      digitalWrite(a + 1, HIGH);
    } else {
      digitalWrite(a + 1, LOW);
    }
  }
}