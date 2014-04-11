package com.project;


import  com.projectC.stockC;

public class Main {



    public static void main(String[] args) {

        System.out.println("project Z");

        stockC myVar = new stockC();
        myVar._offset = 7;
        int a = myVar.riseBy(7);
        System.out.println(a);

        for (String s : myVar.collectionList("javaDB")) {
            System.out.println(s);
        }

    }
}
