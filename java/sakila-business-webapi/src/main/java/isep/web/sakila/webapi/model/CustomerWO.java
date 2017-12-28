package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Customer;


public class CustomerWO extends WebObject
{

	private static final long	serialVersionUID	= -1377067679473844279L;

	protected int						customerId;
	protected String					lastName;
	protected String					firstName;
	protected String					email;
	protected String					address;
	protected int						active;
	protected int 						storeId;
	
	public CustomerWO()
	{
		super();
	}

	public CustomerWO(int customerId, String lastName, String firstName, String email, String address, int active, int storeId)
	{
		super();
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.active = active;
		this.storeId = storeId;
	}

	public CustomerWO(final Customer customer)
	{
		super();
		this.customerId = customer.getCustomerId();
		this.lastName = customer.getLastName();
		this.firstName = customer.getFirstName();
		this.email = customer.getEmail();
		this.address = customer.getAddress().getAddress();
		this.active = customer.getActive();
		this.storeId = customer.getStore().getStoreId();
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public int getActive()
	{
		return active;
	}
	
	public int getStoreId()
	{
		return storeId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString()
	{
		return "Customer [id=" + this.customerId + ", LastName=" + this.lastName + ", FirstName=" + this.firstName + ", Email= "+ this.email + ", Store: "+ this.address + ", Address= "+this.address+", Active = "+this.active+"]";
	}
}
