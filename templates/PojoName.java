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
		PojoNamesHandler.create(this);		
	}
	
	public void update(){
		
	}
	
	public void delete(){
			
	}
	
	public void print(){
		System.out.println("_Id => " + this.get_id() + 
							"\nName => " + this.getName());
	}
	
	

	
}
