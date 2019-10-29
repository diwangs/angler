java -jar antlr-4.7.2-complete.jar \
&& env CLASSPATH=antlr-4.7.2-complete.jar:$CLASSPATH javac Graph*.java 