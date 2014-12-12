BATTLEFREE / OPEN WARFARE

Contributors:
shicks1000 - Hicks, Steven
mannebind  - Koekebakker, Endre
pnenad     - Petkovic, Nenad
iEzpeN     - Strømland, Espen

Repository:
https://github.com/pnenad/hellhounds.git

GitHub:
http://github.com/pnenad/hellhounds

Webpage:
http://pnenad.github.io/hellhounds

Project type:
Opensource school project

License:
This project uses theApache License, Version 2.0 (the "License")
http://www.apache.org/licenses/LICENSE-2.0

Description:
We will make a tactical turn based 1vs1 game.
For information about the project, game rules, units overview,
licensing information and more, please visit our project site:
http://pnenad.github.io/hellhounds/

This is an ongoing project, and it is far from done. Please check
back at regular intervals to see the progress.

After finishing the current work on the game engine and GUI, the
next planned major branch is implementing SQL to handle storable
game information and history.

The current state of the project is pre-alpha, with only a few
runnable demonstrational methods to help show the progress
in the different branches and areas of the application.


----------------------------------------------------------------

Game engine test:

Compile and run GameInit. Doing this will print to screen a
simple sample game. Two players are generated, and they are
given three units each. Resources are generated each round
to the players, based on how many units the player has alive.

The units battle against one another, using the same targets
for each round, and not spending any resources doing so (
because payment functionality is not yet added).

You may edit this class yourself to try out different unit
and target combination, or change the name of the players.

----------------------------------------------------------------

Run and test Client and Server:

1. Make sure you have ssh installed on your PC. Windows users can use putty.
2. Compile and Run server:
    2.1. Login on server:
        Linux terminal:
            $ssh <username>@<server ip>
        Windows:
            Open putty and in host window type <server ip>
    *From now on it's the same for both terminal and putty users.
    2.2. Navigate to root folder and update repository:
        $cd hellhounds/hellhounds
        $git pull
    2.3. Compile the code:
        $make
    2.4. Run server:
        $java -cp bin:lib/gson-2.3.jar com.hellhounds.battlefree.server.Server
    *At this point you should get a message in terminal saying:
        $Starting server.
        $Server running
    That means that server is up and running. Leave the window open and keep an eye on it.
3. Compile and run ClientTest.
    3.1. Update your git repository
        $git pull
    3.2. Compile the code:
        $make
    3.3. Start Client test object:
        $java -cp bin:lib/gson-2.3.jar com.hellhounds.battlefree.server.ClientTest
    *At this point you should get a message:
        $Please enter your command in following format: threadid;command
        3.3.1. Enter the desired command and thread id:
            At the moment it's a very unstable environment and user must keep track of thread id's.
            There are 4 thread commands (start, pause, resume, stop) and 1 server command (quit).
            Every time you send a message the game object will shutdown itself. You need the re-run
            ClientTest every time you want to provide a server with a command.
            $1;start  - start thread nr.1
            $2;start  - start thread nr.2
            $1;pause  - pause thread nr.2
            $2;resume - gives a message that thread is already running
            $2;pause  - pause thread nr. 2
            $2;resume - resume thread nr. 2
            $1;resume - resume thread nr. 1
            To turn the server off type following:
            $0;quit

This was the demonstration of client - server communication and how server multithreading is set up.

----------------------------------------------------------------

SQL:

1. Add a file named "database.properties" to mysql folder
2. What it should contain:
    db.url = 'the url to your database' 
             --> "jdbc:mysql://localhost:3306/yourdatabase"
    db.user = 'the username for your database'
    db.passwd = 'your database user password'

----------------------------------------------------------------

Android GUI:

In order to see the current progress of the Android GUI,
you have to open the project through Android Studio and
run it with an emulator (or connected tablet or android phone).
