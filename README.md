
# react-native-launch-application [![npm version](https://img.shields.io/npm/v/sajjad-launch-application.svg)](https://www.npmjs.com/package/sajjad-launch-application)

this is a react-native library for launching the application when the application is closed . 
usually we can use this in headless js . (like fcm background messaging and etc)
## Getting started

`$ npm install sajjad-launch-application --save`

### Mostly automatic installation

`$ react-native link sajjad-launch-application`

### Manual installation


#### iOS

Not Available

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.SajjadLaunchApplicationPackage;` to the imports at the top of the file
  - Add `new SajjadLaunchApplicationPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':sajjad-launch-application'
  	project(':sajjad-launch-application').projectDir = new File(rootProject.projectDir, 	'../node_modules/sajjad-launch-application/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':sajjad-launch-application')
  	```


## Usage

You can use this library in headless js for example launching the application when a notification received even if your app swiped out . even if your screen locked.

```javascript
import SajjadLaunchApplication from 'sajjad-launch-application';
import type {RemoteMessage} from 'react-native-firebase';


//PackageName Must Be String For example "com.domain.application"
export default async (message: RemoteMessage) => {
    SajjadLaunchApplication.open(PackageName);
}


