#include <ESP8266WiFi.h>
#include <FirebaseESP8266.h>


#define WIFI_SSID "sourav"
#define WIFI_PASSWORD "sairammm"

#define FIREBASE_HOST "https://gpsdata-fetch-feed-default-rtdb.firebaseio.com"
#define FIREBASE_AUTH "mArkr0RD4Dov1gkLNWeWasyMSY6wRghBZvaqOSFB"

float latitude = 0.0;
float longitude = 0.0;

FirebaseData firebaseData;


bool isinside = false;

unsigned long previousMillis = 0;   // stores the last time data was sent
const unsigned long interval = 2000; // interval at which to send data (in milliseconds)

const int buzzerPin = D0; // buzzer connected to D2 pin

void setup() {
  Serial.begin(115200);
  pinMode(buzzerPin, OUTPUT);

  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to WiFi...");
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print(".");
  }
  Serial.println("Connected");

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  
}

void loop() {
  unsigned long currentMillis = millis();   // get the current time


  if (Firebase.get(firebaseData, "isinside")) {
    bool isInside = firebaseData.boolData();
    Serial.println("isInside: " + String(isInside));

    if (!isInside) {
  digitalWrite(buzzerPin, HIGH); 
  delay(5000);
  digitalWrite(buzzerPin, LOW);// turn on buzzer
    }
  } else {
    
    Serial.println("Failed to get isInside parameter");
  }

  delay(1000);

  // Send data to Firebase every 2 seconds
  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;   // save the last time data was sent

    // Code to read latitude and longitude values from GPS module goes here

    // Set latitude and longitude values
    latitude = 20.276642528890726; // replace with actual latitude value
    longitude = 85.77588227939607; // replace with actual longitude value

    // Send data to Firebase
    Firebase.setFloat(firebaseData, "latitude", latitude);
    Firebase.setFloat(firebaseData, "longitude", longitude);
    
    Serial.println("Data sent to Firebase!");
  }
}