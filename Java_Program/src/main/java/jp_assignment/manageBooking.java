
package jp_assignment;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class manageBooking extends customer_room{
    
    //normal methods and encapsulation OOP
    
    public void Customer(String checkIn, String checkOut, String view, String roomID, String cusName, String IC, String contactNum, String email, String total) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.view = view;
        this.roomID = roomID;
        this.cusName = cusName;
        this.IC = IC;
        this.contactNum = contactNum;
        this.email = email;
        this.total = total;
    }
    
    public void addBooking(){
    
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date checkin = sdf.parse(checkIn);
            Date checkout = sdf.parse(checkOut);
            
            //calculate days
            long diff = checkout.getTime() - checkin.getTime();
            float daysdiff = (diff / (1000*60*60*24));
            int days = (int) daysdiff;
            String line, last=null;
            String[] lineArr;
            
            //read booking.txt
            BufferedReader booking = new BufferedReader (new FileReader("booking.txt"));
            
            //get last line
            while(((line = booking.readLine()) != null)) {
                last = line;
            }
            lineArr = last.split("\\|");
            int increment;
            try {
                
                //set increment value to last line value in booking.txt
                increment = Integer.parseInt(lineArr[0]);
            }catch(NumberFormatException e ){
                increment = 0;
            }
            
            //write data in booking.txt
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("booking.txt", true)));
            
            pw.println(
                     ++increment + "|" +
                     cusName + "|" +
                     roomID + "|" +
                     view + "|" +
                     IC + "|" +
                     contactNum + "|" +
                     email + "|" +
                     checkIn + "|" +
                     checkOut + "|" +
                     days + "|" +
                     total

            );

            booking.close();
            pw.flush();
            pw.close();
            
        } catch (ParseException ex) {
            Logger.getLogger(manageBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(manageBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(manageBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean deleteBooking(String bookID){
        this.bookID = bookID;
        boolean success = false;
        
        int yesno = JOptionPane.showConfirmDialog(null, "Do you want to delete this row of record?", "WARNING",JOptionPane.YES_NO_OPTION);
        
        if (yesno == JOptionPane.YES_OPTION) {
                
            try {
                //read original file
                BufferedReader br = new BufferedReader(new FileReader("booking.txt"));

                //write in temp file
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tempdeletefile.txt")));


                String line;
                String[] lineArr;
                while ((line = br.readLine()) != null) {
                    //split line with "|"
                    lineArr = line.split("\\|");

                    if(!lineArr[0].equals(bookID)){
                        pw.println(line);
                    }
                }
                br.close();
                pw.flush();
                pw.close();

                //delete oldfile and rename newfile to oldfile

                File oldbookingFile = new File("booking.txt");
                File newbookingFile = new File("tempdeletefile.txt");

                oldbookingFile.delete();

                File dump = new File("booking.txt");

                newbookingFile.renameTo(dump);

                success = true;

            } catch (FileNotFoundException ex) {
                Logger.getLogger(manageRoom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(manageRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
              success = false; 
        }
        return success;
    }
    
    public void room(String roomNum, String view, String pax, String status) {
        this.roomID = roomNum;
        this.view = view;
        this.pax = pax;
        this.status = status;
    }
    
    public void modifyRoom(){
        try {
            //read original file
            BufferedReader br = new BufferedReader(new FileReader("room.txt"));
            
            //write in temp file
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tempfile.txt")));
            String line;
            String[] lineArr;
            
            //loop ends when no more line
            while ((line = br.readLine()) != null) {
                //split line with "|"
                  lineArr = line.split("\\|");
                  
                  if (lineArr[0].contains(roomID)){
                      //if roomNum in file is same as roomNum chosen in table
                      //then write new value
                      pw.println(
                              roomID + "|" +
                              view + "|" +
                              status + "|" +
                              pax     
                              );
                  } else {
                      //else write the value as it is
                      pw.println(line);
                  }
            }
            br.close();
            pw.flush();
            pw.close();
            
            //delete oldfile and rename newfile to oldfile
            File oldFile = new File("room.txt");
            File newFile = new File("tempfile.txt");
            
            oldFile.delete();
            File dump = new File("room.txt");

            newFile.renameTo(dump);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(manageBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(manageBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void booking(String bookid, String cusName, String ic, String num, String email, String roomid, String view, String checkIn, String checkOut, String day, String total){
        this.bookID = bookid;
        this.cusName = cusName;
        this.IC = ic;
        this.contactNum = num;
        this.email = email;
        this.roomID = roomid;
        this.view = view;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.day = day;
        this.total = total;
    }
    
    public boolean modifyBooking(){
        boolean success = false;
        
        try {
             //read original file
             BufferedReader br = new BufferedReader(new FileReader("booking.txt"));
             //write in temp file
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tempfile.txt")));
             String line;
             String[] lineArr;

             //loop ends when no more line
             while ((line = br.readLine()) != null) {
                 //split line with "|"
                   lineArr = line.split("\\|");

                   if (lineArr[0].contains(bookID)){
                       //if book id in file is same as book id chosen in table
                       //then write new value
                       pw.println(
                            bookID + "|" +
                            cusName + "|" +
                            roomID + "|" +
                            view + "|" +
                            IC + "|" +
                            contactNum + "|" +
                            email + "|" +
                            checkIn + "|" +
                            checkOut + "|" +
                            day + "|" +
                            total
                                       
                        );

                   } else {
                       //else write the value as it is
                       pw.println(line);

                   }
             }
             br.close();
             pw.flush();
             pw.close();

             //delete oldfile and rename newfile to oldfile
             File oldFile = new File("booking.txt");
             File newFile = new File("tempfile.txt");

             oldFile.delete();

             File dump = new File("booking.txt");

             newFile.renameTo(dump);
             success = true;
             
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(manageBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(manageBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public void date(String checkin, String checkout){
        this.checkIn = checkin;
        this.checkOut = checkout;
    }
    
    public Date indateConversion(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate checkinDate = LocalDate.parse(checkIn, formatter);
       
        Date indate = Date.from(checkinDate.atStartOfDay(defaultZoneId).toInstant());
        
        return indate; 
        
    }
           
    public Date outdateConversion(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate checkoutDate = LocalDate.parse(checkOut, formatter);
       
        Date outdate = Date.from(checkoutDate.atStartOfDay(defaultZoneId).toInstant());
        
        return outdate; 
        
    }
    
    //encapsulation OOP
    
    private double roomCharge, tourismTax, serviceTax, totalFee;
    public double  getRoomCharge(){
        return roomCharge;
    }
    
    public void setRoomCharge(double price, double DayInt) {
        roomCharge = price * DayInt;
    }
    
    public double getTourismTax() {
        return tourismTax;
    }
    
    public void setTourismTax(double fee, double DayInt) {
        
        tourismTax = fee * DayInt;
    }
    
    public double getServiceTax() {
        return serviceTax;
    }
    
    public void setServiceTax(double roomcharge, double percent) {
        serviceTax = roomcharge * percent;
    }
    
    public double getTotalFee(){
        return totalFee;
    }
    
    public void setTotalFee(double roomcharge, double tourismtax, double servicetax) {
        
        totalFee = roomcharge + tourismtax + servicetax;
    }
    
    
    //Overloading OOP
    
    
}


