package entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double heathSpending;
	private Double educattionSpending; 
	
	public TaxPayer () {
		
	}
	
	public TaxPayer (double salaryIncome, double servicesIncome, double capitalIncome, double heathSpending, double educattionSpending ) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.heathSpending = heathSpending;
		this.educattionSpending = educattionSpending;
		
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHeathSpending() {
		return heathSpending;
	}

	public void setHeathSpending(double heathSpending) {
		this.heathSpending = heathSpending;
	}

	public double getEducattionSpending() {
		return educattionSpending;
	}

	public void setEducattionSpending(double educattionSpending) {
		this.educattionSpending = educattionSpending;
	}

	public double salaryTax() {
		double monthlySalary = this.salaryIncome / 12;
		double monthlySalaryTax;
		if (monthlySalary < 3000) {
			 monthlySalaryTax = 0.0;
		} else if (monthlySalary >= 3000 && monthlySalary < 5000) {
			 monthlySalaryTax = this.salaryIncome * 0.10; 
		} else {
			monthlySalaryTax = this.salaryIncome * 0.20;
		}
		return monthlySalaryTax;
		
	}
	
	public double servicesTax() {
		double servicesTax = 0.0;
		if (this.servicesIncome > 0) {
			servicesTax = this.servicesIncome * 0.15;
		}
			return servicesTax;
	}
	
	public double capitalTax() {
		double capitalTax = 0.0;
		if (this.capitalIncome > 0) {
			capitalTax = this.capitalIncome * 0.20;
		}
		return capitalTax;
	}
	
	public double grossTax() {
		return this.salaryTax() + this.servicesTax() + this.capitalTax();
	}
	
	public double taxRebate() {
		double taxRebate = 0.0;
		double abatement = this.heathSpending + this.educattionSpending;
		double grossTax = this.grossTax() * 0.30;
		if (abatement > grossTax) {
			taxRebate = grossTax;
		} else {
			taxRebate = abatement;
		}
		return taxRebate;
	}
	
	public Double netTax() {
		return this.grossTax() - this.taxRebate();
		
	}
	
	
}
