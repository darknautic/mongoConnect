package packagePath;

public class PojoName implements PersistentDomainObject{
	
	private String _id;
	private String name;
	

	public PojoName(){		
	}
	
	public PojoName(String name){
		this.name=name;
	}
	
	public PojoName(String _id, String name){		
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
			this.set_id(PojoNamesHandler.create(this));
			
		}
		else{
			PojoNamesHandler.create(this);
			
		}
	}
	
	
	public void update(){
		PojoNamesHandler.update(this);
		
	}
	
	
	public void delete(){		
		    PojoNamesHandler.delete(this);
			this.clone(new PojoName()); /*empty all object*/
		
	}
	
	
	public void load(String id){
		this.clone(PojoNamesHandler.load(id));
		
	}
	
	
	public void print(){
		System.out.println("_Id => " + this.get_id() + 
							"\nName => " + this.getName());
		
	}
	
	
	public void  clone(PojoName film){
		/**
		 *   Clone an Object , add missing sets here 
		 *   useful to clone objects in runtime , a copy in DB is not created.  */ 
		this.set_id(film.get_id());
		this.setName(film.getName());
		
 	} 
	
	
}
