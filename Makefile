all: server client

server:
	mkdir -p bin
	javac -classpath src:lib/gson-2.3.jar src/com/hellhound/battlefree/server/Server.java -d bin

client:
	mkdir -p bin
	javac -classpath src:lib/gson-2.3.jar src/com/hellhound/battlefree/server/ClientTest.java -d bin

clean:
	rm -rf bin
