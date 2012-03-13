#!/bin/sh

# The main program to run
PROGRAM=vn.hus.nlp.tagger-4.2.0.jar

# Get the java command
#
if [ -z "$JAVACMD" ] ; then 
  if [ -n "$JAVA_HOME"  ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then 
      JAVACMD="$JAVA_HOME/jre/sh/java"
    else
      JAVACMD="$JAVA_HOME/bin/java"
    fi
  else
    JAVACMD=`which java 2> /dev/null`
    if [ -z "$JAVACMD" ] ; then 
      JAVACMD=java
    fi
  fi
fi

# Run the programme
#
$JAVACMD -mx500m  -jar $PROGRAM $@



