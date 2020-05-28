package server.LD;

import externalServices.Print;

public class Usuario_Pago implements Print{
	
	private String name;
	private String lastname;
	private String email;

	private float currency;
	
	// Para realizar pagos
	private double total_amount;
    private String concept;
	

	public Usuario_Pago(){
		
	}
	
	public Usuario_Pago(String name, String lastname, String email){
		this.name = name;
		this.lastname = lastname;
		this.email = email;
	}
	
	public Usuario_Pago(String name, String lastname, String email, float currency){
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.currency = currency;
	}
	
	public Usuario_Pago(String email, double total_amount, String concept) {
        this.email = email;
        this.total_amount = total_amount;
        this.concept = concept;
    }
	
	public Usuario_Pago(String email, float currency){
		this.email = email;
		this.currency = currency;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getCurrency() {
		return currency;
	}

	public void setCurrency(float currency) {
		this.currency = currency;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	@Override
	public void print() {
		System.out.println(
                "Printing Usuario" + "\n" +
                "Name: " + getName() + "\n" +
                "Last name: " + getLastname() + "\n" +
                "email: " + getEmail() + "\n" +
                "password: " + getCurrency() + "\n"
        );
		
	}
}
