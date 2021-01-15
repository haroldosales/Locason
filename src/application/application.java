package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;



public class application {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner (System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
			
			System.out.println("Enter rental data");
			System.out.print("Car model: ");
			String carModel = sc.nextLine();
			System.out.print("Pichup (dd/MM/yyyy hh:mm): ");
			Date start  = sdf.parse(sc.nextLine());
			System.out.print("Return (dd/MM/yyyy hh:mm): ");
			Date finish  = sdf.parse(sc.nextLine());
			CarRental cr = new CarRental(start, finish, new Vehicle(carModel));


			
			System.out.print("Enter price per hour: ");
			double priceHours = sc.nextDouble();
			System.out.print("Enter price per day:  ");
			double priceDay = sc.nextDouble();
			
			RentalService rentaService = new RentalService(priceDay, priceHours, new BrazilTaxService());
			
			rentaService.processInvoice(cr);
			System.out.println("INVOICE:");
			
			System.out.println("Basi Payment: " + String.format("%.2f", cr.getInvoice().getBasiPayment()));
			System.out.println("Tax : " + String.format("%.2f", cr.getInvoice().getTax()));
			System.out.println("Total Payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

			
			
			sc.close();
		
	}

}
