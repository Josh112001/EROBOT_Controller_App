#include <Servo.h>

#define servoPIN1 3  // servo 1 (pick)
#define servoPIN2 5  // servo 2 (pick holder)
#define servoPIN3 6  // servo 3 (up/down)
#define servoPIN4 9  // servo 4 (base)

#define ENA 10
#define ENB 11

#define IN1 A0
#define IN2 A1
#define IN3 A2
#define IN4 A3

Servo servo1;
Servo servo2;
Servo servo3;
Servo servo4;

int speed = 200;
int rotateServo1 = 90, rotateServo2 = 90, rotateServo3 = 90, rotateServo4 = 90;  // Initial positions at 90 degrees
int addrotate1 = 5, addrotate2 = 5, addrotate3 = 5, addrotate4 = 5;
char data;

void setup() {
  Serial.begin(9600);

  pinMode(ENA, OUTPUT);
  pinMode(ENB, OUTPUT);
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(IN3, OUTPUT);
  pinMode(IN4, OUTPUT);

  servo1.attach(servoPIN1);
  servo2.attach(servoPIN2);
  servo3.attach(servoPIN3);
  servo4.attach(servoPIN4);
}

void forward() {
  analogWrite(ENA, speed);
  analogWrite(ENB, speed);

  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, HIGH);
  digitalWrite(IN4, LOW);
}
void backward() {
  analogWrite(ENA, speed);
  analogWrite(ENB, speed);

  digitalWrite(IN1, LOW);
  digitalWrite(IN2, HIGH);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, HIGH);
}
void left() {
  analogWrite(ENA, speed);
  analogWrite(ENB, speed);

  digitalWrite(IN1, LOW);
  digitalWrite(IN2, HIGH);
  digitalWrite(IN3, HIGH);
  digitalWrite(IN4, LOW);
}
void right() {
  analogWrite(ENA, speed);
  analogWrite(ENB, speed);

  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, HIGH);
}

void stop() {
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, LOW);
}

void loop() {
  if (Serial.available()) {
    data = Serial.read();
    Serial.write(data);
  }
  switch (data) {
    case 'A':
      forward();
      break;
    case 'B':
      backward();
      break;
    case 'C':
      left();
      break;
    case 'D':
      right();
      break;
    case '1':
      servo4.write(rotateServo4 - 10);
      rotateServo4 -= 10;
      delay(100);
      break;
    case '2':
      servo4.write(rotateServo4 + 10);
      rotateServo4 += 10;
      delay(100);
      break;
    case '3':
      servo3.write(rotateServo3 - 10);
      rotateServo3 -= 10;
      delay(100);
      break;
    case '4':
      servo3.write(rotateServo3 + 10);
      rotateServo3 += 10;
      delay(100);
      break;
    case '5':
      servo2.write(rotateServo2 - 10);
      rotateServo2 -= 10;
      delay(100);
      break;
    case '6':
      servo2.write(rotateServo2 + 10);
      rotateServo2 += 10;
      delay(100);
      break;
    case '7':
      servo1.write(rotateServo1 - 10);
      rotateServo1 -= 10;
      delay(100);
      break;
    case '8':
      servo1.write(rotateServo1 + 10);
      rotateServo1 += 10;
      delay(100);
      break;
    default:
      stop();
      break;
  }
}
