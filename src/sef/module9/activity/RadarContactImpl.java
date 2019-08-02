package sef.module9.activity;

/**
 * Implementation of a RadarContact
 * 
 * @author John Doe
 *
 */
public class RadarContactImpl implements RadarContact {

	
	/**
	 * Creates a RadarContact with the specified ID, bearing and distance.  
	 * 
	 * @param contactID the contact's ID
	 * @param bearing the contact's bearing
	 * @param distance the contact's distance
	 */

	private String contactID;
	private double bearing;
	private double distance;

	public RadarContactImpl(String contactID, double bearing, double distance){
		this.setContactID(contactID);
		this.setBearing(bearing);
		this.setDistance(distance);
	}
	

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getBearing()
	 */
	public final double getBearing() {
		return bearing;
	}
	

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setBearing(double)
	 */
	public final void setBearing(double bearing) {
		if (bearing  < 0)
			this.bearing = (360 + (bearing%360))%360;
		else
			this.bearing = bearing%360;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getDistance()
	 */
	public final double getDistance() {
		return distance;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setDistance(double)
	 */
	public final void setDistance(double distance) {
		if (distance >= 0)
			this.distance = distance;
		else
			this.distance = 0.0;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getContactID()
	 */
	public final String getContactID() {
		return contactID;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setContactID(java.lang.String)
	 */
	public final void setContactID(String contactID) {
		this.contactID = contactID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "Contact ID: " + this.getContactID() + "; Bearing: " + this.getBearing() + "; Distance: " + this.getDistance() + ";";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		else {
			RadarContact tmp = (RadarContact) obj;
			if (this.getContactID().equals(tmp.getContactID()) && Math.abs(this.getBearing() - tmp.getBearing()) <= 0.0000001 && Math.abs(this.getDistance() - tmp.getDistance()) <= 0.000001)
				return true;
			else
				return false;
		}
	}
}
