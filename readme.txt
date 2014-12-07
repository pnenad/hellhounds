BATTLEFREE

Opensource school project

We will try to make an 1vs1 Android game.

Run Client and Server:

1. make
2. java -cp bin:lib/gson-2.3.jar com.hellhound.battlefree.server.Server &
3. java -cp bin:lib/gson-2.3.jar com.hellhound.battlefree.server.ClientTest


SQL:

1. Add a file named "database.properties" to mysql folder
2. What it should contain:
    db.url = 'the url to your database' 
             --> "jdbc:mysql://localhost:3306/yourdatabase"
    db.user = 'the username for your database'
    db.passwd = 'your database user password'

Run GameInit:

make game
java -cp bin com.hellhound.battlefree.game.GameInit
