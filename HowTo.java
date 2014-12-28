import org.example.model.*;

public class HowTo {
    public static void main (String[] args){

    	
    	
        System.out.println("mongoConnect - How To.\n");
        
        
        /*Print all documents ------- */
      /*  System.out.println("\nPrint all.");
        for (Car car: CarsHandler.getAllDocuments()){
        	System.out.println(car.get_id());
        }
        */
        
        
        /* Film class */
        
        /* Update Test -------------------*/
        /*Film myFilm =  new Film("Toy Story");
        myFilm.create();
        myFilm.print();        
        myFilm.setName("SwordFish");
        myFilm.update();
        myFilm.load(myFilm.get_id());
        myFilm.print();                
        */
        
        
        /*Delete Test -------------------*/
       /*Film myFilm = new Film("title 01");        
        myFilm.create();
        myFilm.print();
        myFilm.delete();
        myFilm.print();
       */
        
        
        /*Film myFilm = new Film();        
        myFilm.load("54a031a7d95e5735f15a9da3");
        myFilm.print();
        myFilm.delete();
        myFilm.print();
        */
        
        /*Massive Deletion ------- */
           /*for(film myFilm : filmsHandler.getAllDocuments()){
        	   myFilm.delete();
           }*/
        
        
        
        
    }
} //Class Main
