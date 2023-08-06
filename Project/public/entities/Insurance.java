package entities;

public class Insurance {
	private boolean twoWheeler;
	private boolean fourWheeler;
    private String vehcileManufacturer;
    private String vehcileModel;
    private String drivingLicense;
    private String purchaseDate;
    private int registrationNumber;
    private String engineNumber ;
    private String chasisNumber;
    private boolean thirdPartyLiabilityInsurance;
	private boolean ComprehensiveInsurance;
	private boolean oneYear;
	private boolean twoYear;
	private boolean threeYear;
	private boolean planStatus;//active or not
	private int amount;
	public boolean isPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(boolean planStatus) {
		this.planStatus = planStatus;
	}
	public boolean isTwoWheeler() {
		return twoWheeler;
	}
	public void setTwoWheeler(boolean twoWheeler) {
		this.twoWheeler = twoWheeler;
	}
	public boolean isFourWheeler() {
		return fourWheeler;
	}
	public void setFourWheeler(boolean fourWheeler) {
		this.fourWheeler = fourWheeler;
	}
	public String getVehcileManufacturer() {
		return vehcileManufacturer;
	}
	public void setVehcileManufacturer(String vehcileManufacturer) {
		this.vehcileManufacturer = vehcileManufacturer;
	}
	public String getVehcileModel() {
		return vehcileModel;
	}
	public void setVehcileModel(String vehcileModel) {
		this.vehcileModel = vehcileModel;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	public String getChasisNumber() {
		return chasisNumber;
	}
	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}
	public boolean isThirdPartyLiabilityInsurance() {
		return thirdPartyLiabilityInsurance;
	}
	public void setThirdPartyLiabilityInsurance(boolean thirdPartyLiabilityInsurance) {
		this.thirdPartyLiabilityInsurance = thirdPartyLiabilityInsurance;
	}
	public boolean isComprehensiveInsurance() {
		return ComprehensiveInsurance;
	}
	public void setComprehensiveInsurance(boolean comprehensiveInsurance) {
		ComprehensiveInsurance = comprehensiveInsurance;
	}
	public boolean isOneYear() {
		return oneYear;
	}
	public void setOneYear(boolean oneYear) {
		this.oneYear = oneYear;
	}
	public boolean isTwoYear() {
		return twoYear;
	}
	public void setTwoYear(boolean twoYear) {
		this.twoYear = twoYear;
	}
	public boolean isThreeYear() {
		return threeYear;
	}
	public void setThreeYear(boolean threeYear) {
		this.threeYear = threeYear;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
