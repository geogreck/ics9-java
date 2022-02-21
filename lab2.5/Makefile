.PHONY: all clean

all: Universe.class
	java Universe

Universe.class: Universe.java Particle.java
	javac Universe.java

clean:
	-rm  *.class