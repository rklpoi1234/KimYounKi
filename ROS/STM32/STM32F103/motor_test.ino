int Xval; int Yval;

void setup() {
    Serial.begin(9600);
    pinMode(5, OUTPUT);
    pinMode(6, OUTPUT);
    pinMode(10, OUTPUT);
    pinMode(11, OUTPUT);
    pinMode(A0, INPUT);
    pinMode(A1, INPUT);
}
int motorl=150;
int motorr=150;
void loop()
{
    Xval = analogRead(A0);
    Yval = analogRead(A1);

    if (Xval > 1&& Yval>1) {
        analogWrite(5, Xval);
        analogWrite(6, motorl);
        analogWrite(10, Yval);
        analogWrite(11, motorr);
    }
    else if (Xval > 1 && Yval == 0) {
    analogWrite(5, Xval);
    analogWrite(6, motorl);
    analogWrite(10, motorr);
    analogWrite(11, Yval);
    }
    else if (Xval==0 && Yval>1) {
    analogWrite(5, motorl);
    analogWrite(6, Xval);
    analogWrite(10, Yval);
    analogWrite(11, motorr);
    }
    else if (Xval==0 && Yval==0) {
    analogWrite(5, Xval);
    analogWrite(6, motorl);
    analogWrite(10, motorr);
    analogWrite(11, Yval);
    }
}
