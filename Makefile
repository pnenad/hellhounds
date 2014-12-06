game:
	mkdir -p bin
	javac -classpath src src/com/hellhounds/battlefree/game/GameInit.java -d bin

clean:
	rm -rf bin
