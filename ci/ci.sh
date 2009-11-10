#!/bin/sh 

export JAVA_CMD=java

if [ `uname -s` == "Darwin" ]; then
  export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Home
  export JAVA_CMD=$JAVA_HOME/bin/java
fi

BASE_DIR=`dirname $0`
HUDSON_HOME=$BASE_DIR/work

export HUDSON_HOME

exec $JAVA_CMD -jar $BASE_DIR/hudson.war

