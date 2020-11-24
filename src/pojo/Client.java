package pojo;

public class Client extends Personne {
	public final static String role =  "client";
	private Integer age;
	public  Client(int id , String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom, Integer age) {
		super(id,role,motDePasse,nomUtilisateur,adresse,prenom,nom);
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public boolean register() {
		return personneDAO.create(((Client) this));
	}
}
