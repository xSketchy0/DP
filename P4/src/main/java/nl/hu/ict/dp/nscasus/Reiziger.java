package nl.hu.ict.dp.nscasus;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reiziger")
public class Reiziger {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reiziger_Sequence")
    @SequenceGenerator(name = "reiziger_Sequence", sequenceName = "REIZIGER_SEQ")
	private int reizigerid;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;
	
	@OneToMany(mappedBy="reiziger")
	private List<OVChipkaart> kaarten;
	
	public Reiziger() {
		
	}
	
	public List<OVChipkaart> getKaarten() {
		return kaarten;
	}

	public void setKaarten(List<OVChipkaart> kaarten) {
		this.kaarten = kaarten;
	}
	
	public void addKaart(OVChipkaart ov) {
		this.kaarten.add(ov);
	}

	public int getReizigerid() {
		return reizigerid;
	}

	public void setReizigerid(int reizigerid) {
		this.reizigerid = reizigerid;
	}

	public Date getGbdatum() {
		return gbdatum;
	}
	
	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	public String getVoorletters() {
		return voorletters;
	}
	
	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}
	
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	@Override
	public String toString() {
		return "Reiziger [reizigerid=" + reizigerid + ", voorletters=" + voorletters + ", tussenvoegsel="
				+ tussenvoegsel + ", achternaam=" + achternaam + ", gbdatum=" + gbdatum + "]";
	}
	
}
