package org.codeinmotion.model;

public class Car implements PersistentDomainObject{
	
	private String _id;
	private String name;
	

	public Car(){		
	}
	
	public Car(String name){
		this.name=name;
	}
	
	public Car(String _id, String name){		
		this._id =_id;
		this.name=name;	
	}
	
		
	
	/* ---   POJO Methods*/
	public String get_id() {
		return _id;
		
	}
	
	public String getName() {
		return name;
		
	}
	
	
	public void set_id(String _id) {
		this._id = _id;
		
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	
	
	
	
	/* ---    Interface Methods*/
	public void create(){		
		if(this._id == null){
			this.set_id(CarsHandler.create(this));
			
		}
		else{
			CarsHandler.create(this);
			
		}
	}
	
	
	public void update(){
		CarsHandler.update(this);
		
	}
	
	
	public void delete(){		
		    CarsHandler.delete(this);
			this.clone(new Car()); /*empty all object*/
		
	}
	
	
	public void load(String id){
		this.clone(CarsHandler.load(id));
		
	}
	
	
	public void print(){
		System.out.println("_Id => " + this.get_id() + 
							"\nName => " + this.getName());
		
	}
	
	
	public void  clone(Car car){
		/**
		 *   Clone an Object , add missing sets here 
		 *   useful to clone objects in runtime , a copy in DB is not created.  */ 
		this.set_id(car.get_id());
		this.setName(car.getName());
		
 	} 
	
	
}
