.PHONY: all clean
all: Test.class
	java Test

Test.class: Test.java EquasionsSet.java NameComparator.java
	javac Test.java

clean:
	-rm  *.class