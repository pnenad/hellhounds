game:
	mkdir -p bin
	javac -classpath src src/com/hellhound/battlefree/game/GameInit.java -d bin

clean:
	rm -rf bin
