package com.tddair;

public class Member {
	
	private String userName;
	private String email;
	private MemberStatus status;
	private long ytdMiles;
	private long balanceMiles;
	private int upgradeQTY;
	private CardService cardService = new CardService();
	
	public Member(String userName, String email)
	{
		setUserName(userName);
		setEmail(email);
	} 
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberStatus getStatus() {
		return status;
	}

	public void setStatus(MemberStatus status) {
		this.status = status;
	}

	public long getYtdMiles() {
		return ytdMiles;
	}

	public void setYtdMiles(long ytdMiles) {
		this.ytdMiles = ytdMiles;
	}

	public long getBalanceMiles() {
		return balanceMiles;
	}

	public void setBalanceMiles(long balanceMiles) {
		this.balanceMiles = balanceMiles;
	}

	public void completeFlight(int mileage) {
		ytdMiles += mileage;
		balanceMiles += mileage;
		status = MemberStatus.getStatus(ytdMiles);
	}

	public int purchaseUpgrade(int i) throws Exception  
	{ 
		if(i > 0)
		{
			long upgradeInMilesCost = status.getUpgradeInMile();
			
			if ((balanceMiles >= (i * upgradeInMilesCost)))
			{
				balanceMiles -= i * upgradeInMilesCost;
				upgradeQTY += i;
			} 
			else 
			{
				throw new Exception("Not enough Milage for upgrade !!");  
			}
		}
		
		return i;
	}

	public int purchaseUpgradeCC(int i, String cardNo) throws Exception  
	{
		if(i > 0)
		{
			double upgradeCost = status.getUpgradeInDollars();
			
			if(cardService.approve(cardNo, (i*upgradeCost)))
			{
				upgradeQTY += i;
			}
		}
		
		return i;
	}

	public int getUpgradeQTY() {
		return upgradeQTY;
	}

	public void setUpgradeQTY(int upgrade) {
		this.upgradeQTY = upgrade;
	}

	public String getEmail() {
		return email;
	}

	public void setCCService(CardServiceSpy cardServiceSpy) {
		cardService = cardServiceSpy;
		
	}
	
}
