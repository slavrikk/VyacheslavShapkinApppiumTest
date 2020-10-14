# VyacheslavShapkinAppiumTest
In order to launch mobile tests, the maven profile should be chosen. There are 6 type of tests:

native,
web,
native-cloud-android,
native-cloud-ios,
web-cloud-android,
web-cloud-ios,

Example for launch: mvn clean test -P native

For connecting to the browserstack.com mobile devices in cloud tests login and token should be obtained.

Example for launch cloud test: mvn clean test -Dtoken=&{token} -Dlogin=&{login} -P native-cloud-android
