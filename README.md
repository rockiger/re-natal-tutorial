Re-Natal-Tutorial
=================

These branches are my the React Native tutorial with re-natal. (The "The Basics" part).

Every code example is put in a different branch. I tried to stay close to the naming of the tutorial.

I developed on Linux for Android.  Before you can get started you need Re-natal obviously.

Start Project
-------------

Here is what I did:

	$ npm install -g re-natal
	$ re-natal init ReNatalTutorial -i reagent6
	$ cd re-natal-tutorial
	$ re-natal use-figwheel
	$ lein figwheel android

in new cli also in re-natal-tutorial directory

	$ adb reverse tcp:8081 tcp:8081
	$ adb reverse tcp:3449 tcp:3449
	$ react-native run-android
	$ react-native start # only needed if packager couldn't be started by the previous command


Resume Project
--------------

	$ cd [path to re-natal-tutorial]
	$ lein figwheel android

in new cli also in re-natal-tutorial directory

	$ adb reverse tcp:8081 tcp:8081
	$ adb reverse tcp:3449 tcp:3449
	$ react-native start
	$ react-native run-android

Sometimes I had problems after resuming my laptop from suspend.


## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
