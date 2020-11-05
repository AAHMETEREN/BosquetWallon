package pojo;

public class Client extends Personne {
	private Integer age;
	public  Client(String motDePasse , String nomUtilisateur, String adresse ,String prenom ,String nom, Integer age) {
		super(motDePasse, nomUtilisateur , adresse , prenom , nom);
		this.age = age;
	}
	
	public Client() {
		
	}

	public Integer getAge() {
		return this.age;
	}

}
