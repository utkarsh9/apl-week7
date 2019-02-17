Part1-Seventeen.java

Method1
To execute the second program please execute Command named "Command_Week7Part1"

Method2
You can also execute the following commands
cd /projects/Week7 
javac -classpath /projects/Week7: -sourcepath src: -d /projects/Week7/bin src/Seventeen.java 
java -classpath /projects/Week7:/projects/Week7/bin Seventeen pride-and-prejudice.txt stop-words.txt

__________________________________________________________________________________________________________________________________

Part2-Eighteen.java-Aspects

Method1
To execute the second program please execute Command named "Command_Week7Part2"

Method2
You can also execute the following commands
cd /projects/Week7 
javac -classpath /projects/Week7: -sourcepath src: -d /projects/Week7/bin src/Eighteen.java 
java -classpath /projects/Week7:/projects/Week7/bin Eighteen pride-and-prejudice.txt

__________________________________________________________________________________________________________________________________

Part3
Plugin projects - Week7Part2Main,Week7Part2PluginImpl1,Week7Part2PluginImpl2

Method
You have to execute the following commands one-by-one(Assuming that you are in the projects folder)
cd Week7Part2Main
mvn compile clean install
cd ..
cd Week7Part2PluginImpl1
mvn compile clean install
cd ..
cd Week7Part2PluginImpl2
mvn compile clean install
cd ..
cd Week7Part2Main
mvn exec:java -Dexec.mainClass="com.Week7.Part2.main.NineteenPart1Main" -Dexec.args="resources/pride-and-prejudice.txt"
mvn exec:java -Dexec.mainClass="com.Week7.Part2.main.NineteenPart2Main" -Dexec.args="resources/pride-and-prejudice.txt"

NineteenPart1Main.java has hardcoded printing logic
NineteenPart2Main.java has printer logic implemented in two styles

config.properties has all implementations listed.Please select all impl1 together and all impl2 together.Testing has not been
carried out with Impl1 and Impl2 combinations.

_____________________________________________________________________________________________
