package SBA3;

import java.util.Date;

public class Cards {
	private int CardNumber;
	private Accounts AccountNumber;
	private Customer UCI;
	private String CardType;
	private String CardName;
	private String Password;
	private int CVV;
	private Date Expiry;
	
	public int getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}
	public Accounts getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(Accounts accountNumber) {
		AccountNumber = accountNumber;
	}
	public Customer getUCI() {
		return UCI;
	}
	public void setUCI(Customer uCI) {
		UCI = uCI;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public String getCardName() {
		return CardName;
	}
	public void setCardName(String cardName) {
		CardName = cardName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public Date getExpiry() {
		return Expiry;
	}
	public void setExpiry(Date expiry) {
		Expiry = expiry;
	}
	public Cards(int cardNumber, Accounts accountNumber, Customer uCI, String cardType, String cardName,
			String password, int cVV, Date expiry) {
		super();
		CardNumber = cardNumber;
		AccountNumber = accountNumber;
		UCI = uCI;
		CardType = cardType;
		CardName = cardName;
		Password = password;
		CVV = cVV;
		Expiry = expiry;
	}
	
	

}
