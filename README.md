# starships
Toy project inspired by SWAPI using Springboot.
# Mongodb
Via https://www.mongodb.com/download-center/community
or if you have mac with homebrew:
$brew install mongodb

##Setup data for mongodb
mkdir ~/data
You may have to set priviledges
$chmod 755 ~/data
##Run mongodb server
$mongod --dbpath ~/data 

##Run main in StarshipApplication
Assuming you have maven.
mvn spring-boot:run
or just run the main class from intellij.

##Call the starship rest API 
http://localhost:8787/starships/ordered/7

The result will be starships in descending order 
by costInCredits from highest to lowest.

Also try
http://localhost:8787/starships/all
to get all starships

Or
http://localhost:8787/starships/1
to get the starship with id 1.

##To view data in mongodb
I suggest using MongoDB Compass 
https://www.mongodb.com/download-center/compass




