package model.entities;

public class Invoice {

			private Double basiPayment;
			private  Double tax;
			
			public Invoice() {}

			public Invoice(Double basiPayment, Double tax) {
				this.basiPayment = basiPayment;
				this.tax = tax;
			}

			public Double getBasiPayment() {
				return basiPayment;
			}

			public void setBasiPayment(Double basiPayment) {
				this.basiPayment = basiPayment;
			}

			public Double getTax() {
				return tax;
			}

			public void setTax(Double tax) {
				this.tax = tax;
			}
			
	
	public Double getTotalPayment() {
		return getBasiPayment() + getTax();
	}
}
