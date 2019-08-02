package sef.module9.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of a Radar 
 * 
 *
 */
public class RadarImpl implements Radar{


	private List<RadarContact> list_radars;
	/**
	 *  Constructs a new Radar 
	 */
	public RadarImpl(){
		list_radars = new ArrayList<>();
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
	 */
	public RadarContact addContact(RadarContact contact) {
		if (contact != null) {
			RadarContact A = getContact(contact.getContactID());
			if (getContact(contact.getContactID()) != null) {
				A.setBearing(contact.getBearing());
				A.setDistance(contact.getDistance());
			} else {
//				A = new RadarContactImpl(contact.getContactID(), contact.getBearing(), contact.getDistance());
				list_radars.add(contact);
			}
			return A;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContact(java.lang.String)
	 */
	public RadarContact getContact(String id) {
		for (int i = 0; i < list_radars.size(); i++) {
			if (id.equals(list_radars.get(i).getContactID()))
				return list_radars.get(i);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContactCount()
	 */
	public int getContactCount() {
		return list_radars.size();
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#removeContact(java.lang.String)
	 */
	public RadarContact removeContact(String id) {
		RadarContact A = getContact(id);
		if (A == null) return null;
		else {
			list_radars.remove(A);
			return A;
		}
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts()
	 */
	public List<RadarContact> returnContacts() {
		return new ArrayList<>(list_radars);
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
	 */
	public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
		List A = new ArrayList(list_radars);
		A.sort(comparator);
		return A;
//		return Collections.sort(arg0, new DistanceComparator());
	}

	
}
