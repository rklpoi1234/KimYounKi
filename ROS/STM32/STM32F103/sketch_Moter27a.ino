int Xval, Yval, Sel;

void setup() {
  Serial.begin(9600);
    pinMode(5, OUTPUT);
    pinMode(6, OUTPUT);
    pinMode(10, OUTPUT);
    pinMode(11, OUTPUT);
    pinMode(2, INPUT);
    pinMode(3, INPUT);
    pinMode(A0, INPUT);
    pinMode(A1, INPUT);
}
int motorl=150;
int motorr=150;
int c = 0;
void loop() {
    int lineL = digitalRead(2);
    int liner = digitalRead(3);
  Xval = analogRead(A0);
  Yval = analogRead(A1);
  
    if (lineL == 1 && liner == 1) {
        analogWrite(5, Xval);
        analogWrite(6, motorl);
        analogWrite(10, Yval);
        analogWrite(11, motorr);
    } else if (lineL == 0 && liner == 1) {
        analogWrite(5, Xval);
        analogWrite(6, motorl);
        analogWrite(10, motorr);
        analogWrite(11, Yval);
    } else if (lineL == 1 && liner == 0) {
        analogWrite(5, motorl);
        analogWrite(6, Xval);
        analogWrite(10, Yval);
        analogWrite(11, motorr);
    } else if (lineL == 0 && liner == 0) {
        analogWrite(5, Xval);
        analogWrite(6, motorl);
        analogWrite(10, motorr);
        analogWrite(11, Yval);
    }
    Serial.print("X축: ");
 Serial.print(analogRead(A0)); // X축 값 출력
 Serial.print("\t");  
 Serial.print("Y축: ");        
 Serial.print(analogRead(A1)); // Y축 값 출력
 Serial.print("\t");         
 delay(100);            
}
