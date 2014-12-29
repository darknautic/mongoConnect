#! /bin/bash

# This script creates basic java files  , use them as a template.
#		1)  Set your mongoConnect path, installation path.
#		2)  Set your package name.
# # # #
#  darknautic  >  comments or updates or just to say hi , please drop a email to blue.darknautic@gmail.com


mongoConnectPath="~/mongoConnect"
#mongoConnectPath="/projects/mongoConnect"

#packagePath="org.codeinmotion.model"
packagePath="org.example.model"


#class name
PojoName=$1 
# TODO : ensure capital letter for class name ,  echo aBcDeF | grep -o . | head -n 1 | tr '[:lower:]' '[:upper:]'
#object name of class 
pojoObjectName=`echo $1 | tr '[:upper:]' '[:lower:]'` 
#mongo collection
dbCollection=$pojoObjectName"s" 



function replace(){
	
	sed -i "s/packagePath/$packagePath/g" $1
	sed -i "s/PojoName/$PojoName/g" $1
	sed -i "s/pojoObjectName/$pojoObjectName/g" $1
	sed -i "s/dbCollection/$dbCollection/g" $1

}




#creating files
cp $mongoConnectPath/templates/PojoName.java  $PojoName".java"
cp $mongoConnectPath/templates/PojoNameAdaptor.java  $PojoName"Adaptor.java"
cp $mongoConnectPath/templates/PojoNamesHandler.java  $PojoName"sHandler.java"



#Database access classes
if [ -f Database.java ]
 then
        echo "Database.java already exists."
 else
        cp $mongoConnectPath/templates/Database.java .
        replace  Database.java
        echo "Database.java"
fi

if [ -f PersistentDomainObject.java ]
 then
        echo "PersistentDomainObject.java already exists."
 else
        cp $mongoConnectPath/templates/PersistentDomainObject.java .
        replace  PersistentDomainObject.java
        echo "PersistentDomainObject.java"
fi


replace $PojoName".java"
replace $PojoName"Adaptor.java"
replace $PojoName"sHandler.java"



#TODO : replace Database and Domain Persistent Objet class  : package name
# copy  classes to templates folder and verify if exists when run mongoconnect command


#echo $packagePath
#echo $PojoName
#echo $pojoObjectName
#echo $dbCollection

echo $PojoName".java"
echo $PojoName"Adaptor.java"
echo $PojoName"sHandler.java"



