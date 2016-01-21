package com.tddair;

public class Member {

	private String userName;
	private Category status;
	private Integer milesBalance;
	private Integer ytdMiles;
	private Integer upgrades;	
	private CAS creditCardSystem;

	public Member(String userName) {
		super();
		this.userName = userName;
		milesBalance = new Integer(0);
		ytdMiles = new Integer(0);
		upgrades = new Integer(0);
		status = Category.Red;
	}

	public String getUserName() {
		return userName;
	}

	public Category getStatus() {
		return this.status;
	}
	
	public void setStatus(Category status) {
		this.status = status;
	}


	public Integer getYtdMiles() {
		return this.ytdMiles;
	}

	public void setYtdMiles(Integer ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	public Integer getMilesBalance() {
		return this.milesBalance;
	}

	public void setMilesBalance(Integer milesBalance) {
		this.milesBalance = milesBalance;
	}

	public void completeFlight(Flight completedFlight) throws FlightNotFoundException{
		if (completedFlight == null)
			throw new FlightNotFoundException("No flight found");
		
		addMiles(completedFlight.getMileage());
		calculateStatus();
	}

	private void addMiles(int miles)
	{
		this.milesBalance = this.milesBalance + miles;
		this.ytdMiles = this.ytdMiles + miles;
	}
	private void calculateStatus()
	{
		status = status.getCategoryForMiles(ytdMiles);
	}

	public int purchaseUpgradeWithMiles(int quantity) {
		// TODO Auto-generated method stub
		int cost = quantity * status.getUpgradePurchasePrice();
		if (cost < milesBalance )
		{
		  this.upgrades = this.upgrades + quantity;
		  milesBalance= milesBalance - cost;
		  return quantity;
		}
		else {
		  return 0;
		}
	}

	public Integer getUpgrades() {
		return upgrades;
	}

	public int purchaseUpgradeWithCreditCard(int quantity, String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	//Used for unit testing purposes
	protected void setCreditCardSystem(CAS creditCardSystem) {
		this.creditCardSystem = creditCardSystem;
	}

}
