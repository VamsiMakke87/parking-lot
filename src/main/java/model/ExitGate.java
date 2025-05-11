package model;

import java.time.LocalDateTime;

public class ExitGate extends Gate {
    @Override
    public void run() {

        try {
            Ticket ticket=null;
            while(true) {
                System.out.println("Enter Ticket-Id");
                String ticketId = sc.nextLine();
                ticket = parkingLotApplication.getTicket(ticketId);

                if (ticket==null){
                    System.out.println("Ticket Id not found! Please enter again");
                }else if(ticket.isExpired()){
                    System.out.println("Ticket expired or already used");
                }else{
                    ticket.setExitTime(LocalDateTime.now());
                    break;
                }
            }

            double price= ticket.unpark();

            System.out.println(ticket);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
