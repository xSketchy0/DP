// AJ Sijpenhof(1745798)

import java.sql.Date;
import java.util.ArrayList;

public class OVChipkaart {
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerId;
	private ArrayList<Product> producten;

	public ArrayList<Product> getProducten() {
		return producten;
	}

	public OVChipkaart(int kaartNummer, Date geldigTot, int klasse, double saldo, int reizigerId) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerId = reizigerId;
	}
	
	public int getKaartNummer() {
		return kaartNummer;
	}
	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}
	public Date getGeldidgTot() {
		return geldigTot;
	}
	public void setGeldidgTot(Date geldidgTot) {
		this.geldigTot = geldidgTot;
	}
	public int getKlasse() {
		return klasse;
	}
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double d) {
		this.saldo = d;
	}
	public int getReizigerId() {
		return reizigerId;
	}
	public void setReizigerId(int reizigerId) {
		this.reizigerId = reizigerId;
	}
}
