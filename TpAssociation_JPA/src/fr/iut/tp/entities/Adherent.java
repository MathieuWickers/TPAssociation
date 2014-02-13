package fr.iut.tp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.iut.tp.entities.Commande;

@Entity
@Table (name="ADHERENT",schema="ROOT")
public class Adherent {

	@Id
	@Column(name="ADHERENT_ID", nullable=false)
	private int adherent_id;
	
	@Column(name="LOGIN", nullable=false)
	private String login;
	
	@Column(name="PASSWORD", nullable=false)
	private String pwd;
	
	@Column(name="FIRST_NAME")
	private String prenom;
	
	@Column(name="LAST_NAME")
	private String nom;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ZIP_CODE")
	private int zip;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;
	
	@OneToMany(mappedBy="adherent")
	private List<Commande> commandes;
	
	public Adherent(int adherent_id, String login, String pwd, String prenom,
			String nom, String address, int zip, String city, String country) {
		super();
		this.adherent_id = adherent_id;
		this.login = login;
		this.pwd = pwd;
		this.prenom = prenom;
		this.nom = nom;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.country = country;
	}
	
	public Adherent(){
		super();
	}

	public int getAdherent_id() {
		return adherent_id;
	}

	public void setAdherent_id(int adherent_id) {
		this.adherent_id = adherent_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
