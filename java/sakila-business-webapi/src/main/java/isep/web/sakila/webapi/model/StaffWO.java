package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Staff;

public class StaffWO extends WebObject
{

	private static final long	serialVersionUID	= -1377067679473844279L;

	protected Byte						staffId;
	protected String					username;
	protected String					password;

	public StaffWO()
	{
		super();
	}

	public StaffWO(Byte staffId, String username, String password)
	{
		super();
		this.staffId = staffId;
		this.username = username;
		this.password = password;
	}

	public StaffWO(final Staff staff)
	{
		super();
		this.staffId = staff.getStaffId();
		this.username = staff.getUsername();
		this.password = staff.getPassword();
	}

	public Byte getStaffId() {
		return staffId;
	}

	public void setStaffId(Byte staffId) {
		this.staffId = staffId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public static long getSerialversionuid() {
		return serialVersionUID;
	}*/
	
	@Override
	public String toString()
	{
		return "Staff [id=" + this.staffId + ", Username=" + this.username + ", Password=" + this.password + "]";
	}
}
