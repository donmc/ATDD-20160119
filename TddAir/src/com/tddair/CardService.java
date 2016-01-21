package com.tddair;

public class CardService {
	
	private double balance;

	public boolean approve(String cardNo, double d) throws Exception   
	{
		if(cardNo == null || !isCreditCardValid(cardNo)) {
			throw new Exception("Invalid Card!!");
		}
		
		if (isBalanceSufficient(d)) {
			return true;
		}
		else 
		{
			throw new Exception("Insuffient balance !!");
		}
	}

	protected boolean isCreditCardValid(String cardNo) {
		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
		        "(?<mastercard>5[1-5][0-9]{14})|" +
		        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
		        "(?<amex>3[47][0-9]{13})|" +
		        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
		        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
		String cardCoCleaned = cardNo.replaceAll("-", "");
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(cardCoCleaned);
		return m.matches();
	}
	
	protected boolean isBalanceSufficient(double purchaseAmount) {
		return getBalance() > purchaseAmount;
		
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
