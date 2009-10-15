#! /bin/sh
set -e

export JAVA_CMD=java

if [ `uname` == "Darwin" ]; then
  export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Home
  export JAVA_CMD=$JAVA_HOME/bin/java
fi

jars=`find build/lib/runtime -name "*.jar" -type f -exec echo -n \{\}: \;`
jars=${jars}gen/artifacts/jars/scoreboard.jar
echo $jars
#FIX switch around and kill hard coded config.
#java -cp $jars leapstream.scoreboard.core.entry.Main $*

$JAVA_CMD -cp $jars leapstream.scoreboard.core.entry.Main "file:config.js"
