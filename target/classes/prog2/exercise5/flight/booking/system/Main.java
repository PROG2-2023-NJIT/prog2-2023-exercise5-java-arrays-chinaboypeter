package prog2.exercise4.flight.booking.system;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println("please enter your name:");
        Scanner sc= new Scanner(System.in);
        String pF=sc.next();

        System.out.println("please choose your BookingClass:");
        System.out.println("1.First");
        System.out.println("2.Business");
        System.out.println("3.Economy");
        String c= sc.next();
        String a1=null;
        if(c.equals("1")){
            a1="F";
        }
        else if(c.equals("2")){
            a1="B";
        }
        else{
            a1="E";
        }

        System.out.println("please enter your tripTpye:");
        System.out.println("1.One_way");
        System.out.println("2.Return");
        String t= sc.next();
        String a2=null;
        if(t.equals("1")){
            a2="11";
        }
        else if(t.equals("2")){
            a2="22";
        }

        System.out.println("please enter your depatureDate:");
        String depatureDate= sc.next();
        LocalDate dD=LocalDate.parse(depatureDate);

        System.out.println("please enter your returnDate:");
        String returnDate= sc.next();
        LocalDate rD=LocalDate.parse(returnDate);

        if(rD.compareTo(dD)==1){
            rD=rD.plusDays(1);
        }
        else if(rD.compareTo(dD)==0){
            rD=rD.plusDays(2);
        }


        System.out.println("please choose your TripSource:");
        System.out.println("1.NANJING");
        System.out.println("2.BEIJING");
        System.out.println("3.SHANGHAI");
        System.out.println("4.OULU");
        System.out.println("5.HELSINKI");
        System.out.println("6.PARIS");
        String TripSource= sc.next();

        String TripDestination=null;
        for(int i=1;i>0;i++) {
            System.out.println("please ensure your TripSource and choose your TripDestination:");
            System.out.println("1.NANJING");
            System.out.println("2.BEIJING");
            System.out.println("3.SHANGHAI");
            System.out.println("4.OULU");
            System.out.println("5.HELSINKI");
            System.out.println("6.PARIS");
            TripDestination = sc.next();
            if(TripSource.equals(TripDestination)==false){
                break;
            }
        }

        int x=Integer.parseInt(TripSource);
        int y=Integer.parseInt(TripDestination);
        String a3=null;
        if(x<4 && y<4){
            a3="DOM";
        }
        else if(3<x && x<5 && 5>y && y>3){
            a3="DOM";
        }
        else{
            a3="INT";
        }


        System.out.println("please enter the number of childPassengers:");
        int i= sc.nextInt();

        System.out.println("please enter the number of adultPassengers:");
        int j= sc.nextInt();

        String tn;
        Random r=new Random();
        int id=r.nextInt(9899)+100;
        String idstring=Integer.toString(id);
        if(id<1000){
            tn=a2+a1+'0'+idstring+a3;
        }
        else{
            tn=a2+a1+idstring+a3;
        }

        FlightBooking fb = new FlightBooking(pF, dD, rD, i, j);
        int expResult = i+j;
        fb.setTotalPassengers(i,j);
        int result = fb.getTotalPassengers();
        fb.setPassengerFullName(pF);
        fb.setTicketNumber(tn);
        fb.setBookingClass(c);
        fb.setTripType(t);
        fb.setTripSource(TripSource) ;
        fb.setTripDestination(TripSource,TripDestination);
        fb.setFlightCompany("Flights-of-Fancy");
        fb.setDepartureDate(dD);
        fb.setReturnDate(rD);
        fb.setDepartingTicketPrice(i,j);
        fb.setTotalTicketPrice();

        sc.close();

        System.out.println("Dear"+" "+fb.getPassengerFullName() + "."+"Thank you for booking your flight with"+" "+fb.getFlightCompany());
        System.out.println("Following are the details of your booking and the trip:");
        System.out.println("Ticket Number: "+fb.getTicketNumber());
        System.out.println("BookingClass:"+fb.getBookingClass());
        System.out.println("From"+" "+fb.getTripSource()+" to "+fb.getTripDestination());
        System.out.println("Date of departure:" + fb.getDepartureDate());
        System.out.println("Date of return: " + fb.getReturnDate());
        System.out.println("Total passengers: " + fb.getTotalPassengers());
        System.out.println("Total ticket price in Euros: "+fb.getTotalTicketPrice());


    }
}