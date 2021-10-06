# WakeUpPal_JamesJack_2021

James Jack 2021
Wake Up Pal

NOTICE: this app requires a Google Maps APi Key in order to work  
In order to get an API key go to: https://console.cloud.google.com/project/_/google/maps-apis/credentials?_ga=2.152336313.1832798688.1633562270-144018838.1621188809  
Add API key to local.properties gradle file that contains the SDK location as MAPS_API_KEY = *your api key here*  
if that does not work use this link for steps to add one: https://developers.google.com/maps/documentation/android-sdk/start  

This application uses the TimePicker class and Google Maps API

This app sets an alarm to go off at specified user time  
There are two methods to do so:  
    Clock view  
    Analog selection  
The Weather and Traffic page:  
    -Displays current Android device location (must be added manually to emulator settings)  
    -Shows current location with view of current traffic flow  
    -Weather is displayed via Webview on Weather.com for Chicago Area  
        -In order to change default display the URL must be altered in the Java class for WakeScreen  
        -A full page Chrome tab is opened if the webview elements are clicked on  
The map location does not allow the use of custom routes for traffic at this time  
Designed by James Jack  
Permissions file added from public Google Repository(link can be found in code)  
