// AJ Sijpenhof(1745798)

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
    private String naam;
    private Date gbdatum;
	private int reizigerid;
	private ArrayList<OVChipkaart> ovKaarten = new ArrayList<OVChipkaart>();

    public Reiziger(String naam, Date gbdatum, int reizigerid) {
        this.naam = naam;
        this.gbdatum = gbdatum;
        this.reizigerid = reizigerid;
    }

	public Reiziger(String naam, Date gbdatum) {
		this.naam = naam;
		this.gbdatum = gbdatum;
	}

	public int getReizigerid() {
		return reizigerid;
	}

	public void setReizigerid(int reizigerid) {
		this.reizigerid = reizigerid;
	}

    public String getNaam() {
        return naam;
    }

    public void setNaam(String nm) {
        this.naam = nm;
    }

    public Date getGBdatum() {
        return gbdatum;
    }

    public void setGBdatum(Date dt) {
        this.gbdatum = dt;
    }

	public String toString() {
		return getNaam() + " - " + getGBdatum().toString();
	}

	public void voegOVToe(OVChipkaart ov) {
		if (!this.ovKaarten.contains(ov)) {
			this.ovKaarten.add(ov);
		}
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reiziger other = (Reiziger) obj;
		if (gbdatum == null) {
			if (other.gbdatum != null)
				return false;
		} else if (!gbdatum.equals(other.gbdatum))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
}
