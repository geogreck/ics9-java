.PHONY: all clean
all: Test.class
	java Test

Test.class: Test.java CProgram.java
	javac Test.java

clean:
	-rm  *.class