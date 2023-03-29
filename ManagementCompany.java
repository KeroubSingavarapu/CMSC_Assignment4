import java.util.Arrays;

import javafx.scene.layout.Region;

public class ManagementCompany {
	
	private String name, taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private Plot plot;
	
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFeePer = 0;
		plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		
		plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		
		plot = new Plot(x,y,width,depth);
		
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		properties = new Property[MAX_PROPERTY];

	}
	
	public int getMAX_PROPERTY() {
		
		return MAX_PROPERTY;
	}
	
	public int addProperty(Property property) {
		
		if(property == null) {
			return -2;
			}
		
		if(!plot.encompasses(property.getPlot())) {
			return -3;
			}                
	
		for(int i = 0; i < properties.length; i++) {
			
			if(properties[i] != null) {
				
				if(property.getPlot().overlaps(properties[i].getPlot())) {
					return -4;
					}
				}
			else {
				properties[i] = property;
				return  i;
				}
			}
		return -1;
		}
	
	public int addProperty(String name, String city, double rent, String owner) {
		
		Property add_property = new Property(name, city, rent, owner,0, 0, 1, 1);
		return addProperty(add_property);
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		
		Property add_property = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(add_property);
	}
	
	public double totalRent() {
		
		double total = 0;
		
		for(int i = 0; i < properties.length; i++) {
			
			if(!(properties[i] == null))
				total += properties[i].getRentAmount();
			}
		return total;
		}
	
	public double maxRentProp() {
		
		double max = properties[0].getRentAmount();
	
		for(int i = 0; i < properties.length; i++) {
			
			if(!(properties[i] == null))
				if(properties[i].getRentAmount() > max)
					max = properties[i].getRentAmount();
			}
		return max;
		}
	
	public int maxRentPropertyIndex() {
		
		double max = maxRentProp();
	
		int result = 0;
		
		for(int i = 0; i < properties.length; i++) {
			if(!(properties[i] == null))
				if(properties[i].getRentAmount() == max)
					result = i;			
		}
		return result;
	}
	
	public void setTaxID(String taxID) {
		taxID = "";
	}
	public String getTaxID() {
		return taxID;
	}
	public void setName(String name) {
		name = "";
	}
	public String getName() {
		return name;
	}
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	public String toString() {
		return	"List of the properties for " + getName() + ", taxID: " + getTaxID()  
		+ "\n" + properties[0].toString() + "\n" + properties[1].toString()
				+ "\n" + properties[2].toString() + "\n" + properties[3].toString()
				+ "\n" + properties[4].toString() + "\n\n" + "Total management Fee: " + 
				(totalRent() * mgmFeePer) / 100;
	}
	public Plot getPlot() {
		return plot;
	}	
}