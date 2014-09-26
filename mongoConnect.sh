#! /bin/bash

# This script create basic java files 



#mongoConnectPath="~/mongoConnect"
mongoConnectPath="/home/fermat/projects/mongoConnect"
#mongoConnectPath="~/projects/mongoConnect"

packagePath="com.lhweb.load.model"
#class name
PojoName=$1 
#object name of class 
pojoObjectName=`echo $1 | tr '[:upper:]' '[:lower:]'` 
#mongo collection
dbCollection=$pojoObjectName"s" 



#creating files
cp $mongoConnectPath/templates/PojoName.java  $PojoName".java"
cp $mongoConnectPath/templates/PojoNameAdaptor.java  $PojoName"Adaptor.java"
cp $mongoConnectPath/templates/PojoNamesHandler.java  $PojoName"sHandler.java"




function replace(){
	
	sed -i "s/packagePath/$packagePath/g" $1
	sed -i "s/PojoName/$PojoName/g" $1
	sed -i "s/pojoObjectName/$pojoObjectName/g" $1
	sed -i "s/dbCollection/$dbCollection/g" $1

}


replace $PojoName".java"
replace $PojoName"Adaptor.java"
replace $PojoName"sHandler.java"



#echo $packagePath
#echo $PojoName
#echo $pojoObjectName
#echo $dbCollection

echo $PojoName".java"
echo $PojoName"Adaptor.java"
echo $PojoName"sHandler.java"



