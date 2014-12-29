mongoConnect
============
<b>Java + Mongo Java Driver</b>


This project intends to be an simple approach to work  with mongoDB from Java, using a   lightweight and clear classes.
You will be able to map Domain Objects to Mongo Documents ( DBObjects ) using your POJOs.



How To
-----------

 1)  Clone this project.
 
    $ cd ~
    $ git clone https://github.com/darknautic/mongoConnect.git


 2)  Configure your paths

    $ vim ~/mongoConnect/mongoConnect.sh

     mongoConnectPath
     packagePath
 	


 3)  Create a link
 
    $ sudo ln -s ~/mongoConnect/mongoConnect.sh  /usr/local/bin/mongoConnnect 
    
    

 4)  Go to your project path where you want to create new classes.

    $ cd ~/myProject/model/
  

 5)  run command mongoConnect to generate your Car classes
 
    $ mongoConnect Car
    
    Car.java
    CarAdaptor.java
    CarsHandler.java


    



References and Links

Donwload driver.
+ http://central.maven.org/maven2/org/mongodb/mongo-java-driver/
