
package jp_assignment;


import java.io.*;
import java.text.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.util.logging.*;
import javax.swing.JOptionPane;


public class bookRoom extends javax.swing.JFrame {

    public bookRoom() {
        
        initComponents();
        roomTxt.setEnabled(false);
        confirmBtn.setEnabled(false);

    }

    public void submitForm() {
        customer_room Customer = new customer_room();
        
        //assign getText value to variables
        Customer.checkIn = cusCheckInField.getText();
        Customer.checkOut = cusCheckOutField.getText();
        Customer.cusName = cusFormField.getText();
        Customer.view = cusViewField.getText();
        Customer.roomID = cusRoomField.getText();
        Customer.total = totalField.getText();
        
        Customer.IC = icTxt.getText();
        Customer.contactNum = numTxt.getText();
        Customer.email = emailTxt.getText();
        
        //add booking 
        manageBooking mb = new manageBooking();
        
        mb.Customer(Customer.checkIn, Customer.checkOut, Customer.view, Customer.roomID, Customer.cusName, Customer.IC, Customer.contactNum, Customer.email, Customer.total);

        mb.addBooking();

        JOptionPane.showMessageDialog(null, "Successfully Booked.");

    }
    
    public void sendToForm() {
        boolean empty =  cusNameTxt.getText().equals("") && icTxt.getText().equals("") && numTxt.getText().equals("") && emailTxt.getText().equals("") ;
        
        //if input is empty or room comboBox is not enabled then show Message else run following code
        if (empty || !roomTxt.isEnabled()) {

            JOptionPane.showMessageDialog(this, "Please Fill In all fields. *Make Sure Validate Button is Clicked.*");
            
            
        } else {
            
            //get value from input and comboBox
            cusFormField.setText(cusNameTxt.getText());
            cusRoomField.setText(roomTxt.getSelectedItem().toString());

            if(jungleBtn.isSelected()){
                cusViewField.setText("Jungle");
            } else if(seaBtn.isSelected()){
                cusViewField.setText("Sea");
            } 

            feeField.setText("RM 350");

            try {
                manageBooking mb = new manageBooking();
                
                //get days
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String checkIn = sdf.format(checkin_date.getDate());
                String checkOut = sdf.format(checkout_date.getDate());
                

                Date checkin = sdf.parse(checkIn);
                Date checkout = sdf.parse(checkOut);
                long diff = checkout.getTime() - checkin.getTime();
                float daysdiff = (diff / (1000*60*60*24));
                int dayInt = (int) daysdiff;
                String days = String.valueOf(dayInt);

                dayField.setText(days + " Day/s");
                cusCheckInField.setText(checkIn);
                cusCheckOutField.setText(checkOut);

                //set value for roomcharge, service, tourism tax and total
                mb.setRoomCharge(350, dayInt);
                mb.setServiceTax(mb.getRoomCharge(), (0.1));
                mb.setTourismTax(10, dayInt);
                mb.setTotalFee(mb.getRoomCharge(), mb.getServiceTax(), mb.getTourismTax());

                //get value from getters
                String serviceTaxString = String.valueOf(mb.getServiceTax());
                serviceTaxField.setText("RM " + serviceTaxString);    

                String tourismTaxString = String.valueOf(mb.getTourismTax());
                tourismTaxField.setText("RM " + tourismTaxString);

                String totalFeeString = String.valueOf(mb.getTotalFee());
                totalField.setText("RM " + totalFeeString);
                roomTxt.setEnabled(false);
                confirmBtn.setEnabled(true);
            } catch (ParseException ex) {
                Logger.getLogger(bookRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
            
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewBtnGroup = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        checkin_date = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        roomTxt = new javax.swing.JComboBox<>();
        checkout_date = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jungleBtn = new javax.swing.JRadioButton();
        seaBtn = new javax.swing.JRadioButton();
        validateBtn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cusNameTxt = new javax.swing.JTextField();
        icTxt = new javax.swing.JTextField();
        numTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cusFormField = new javax.swing.JTextField();
        cusRoomField = new javax.swing.JTextField();
        cusViewField = new javax.swing.JTextField();
        cusCheckInField = new javax.swing.JTextField();
        cusCheckOutField = new javax.swing.JTextField();
        feeField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        serviceTaxField = new javax.swing.JTextField();
        tourismTaxField = new javax.swing.JTextField();
        totalField = new javax.swing.JTextField();
        confirmBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Javanese Text", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hotel.png"))); // NOI18N
        jLabel1.setText("Room Booking System");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkin_date.setToolTipText("");
        checkin_date.setDateFormatString("dd MMM yyyy");

        jLabel3.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("View:");

        jLabel5.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Room:");

        jLabel2.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Check In:");

        roomTxt.setEnabled(false);

        checkout_date.setDateFormatString("dd MMM yyyy");

        jLabel6.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Check Out:");

        viewBtnGroup.add(jungleBtn);
        jungleBtn.setFont(new java.awt.Font("Javanese Text", 1, 14)); // NOI18N
        jungleBtn.setForeground(new java.awt.Color(255, 255, 255));
        jungleBtn.setText("Jungle View");

        viewBtnGroup.add(seaBtn);
        seaBtn.setFont(new java.awt.Font("Javanese Text", 1, 14)); // NOI18N
        seaBtn.setForeground(new java.awt.Color(255, 255, 255));
        seaBtn.setText("Sea View");

        validateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/validate.png"))); // NOI18N
        validateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                validateBtnMouseClicked(evt);
            }
        });
        validateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateBtnActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*Press Validate Button First before Submit.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(roomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(validateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkout_date, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkin_date, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jungleBtn)
                    .addComponent(seaBtn))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkin_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkout_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jungleBtn)))
                .addGap(18, 18, 18)
                .addComponent(seaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(validateBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(41, 41, 41))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer Name:");

        jLabel7.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("IC/Passport:");

        jLabel8.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contact Number:");

        jLabel9.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email:");

        icTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                icTxtKeyTyped(evt);
            }
        });

        numTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numTxtKeyTyped(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        submitBtn.setText("Submit");
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cusNameTxt)
                    .addComponent(icTxt)
                    .addComponent(numTxt)
                    .addComponent(emailTxt)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(resetBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(submitBtn)))
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cusNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(icTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(numTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBtn)
                    .addComponent(submitBtn))
                .addGap(32, 32, 32))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Days Booked:");

        jLabel11.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fee Per Room:");

        jLabel12.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Service Tax:");

        jLabel13.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tourism Tax:");

        jLabel14.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total Fees:");

        jLabel15.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Room Number:");

        jLabel16.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("View:");

        jLabel17.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("From:");

        jLabel18.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("To:");

        jLabel19.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Customer Name:");

        cusFormField.setEditable(false);
        cusFormField.setForeground(new java.awt.Color(0, 0, 0));

        cusRoomField.setEditable(false);
        cusRoomField.setForeground(new java.awt.Color(0, 0, 0));

        cusViewField.setEditable(false);
        cusViewField.setForeground(new java.awt.Color(0, 0, 0));

        cusCheckInField.setEditable(false);
        cusCheckInField.setForeground(new java.awt.Color(0, 0, 0));

        cusCheckOutField.setEditable(false);
        cusCheckOutField.setForeground(new java.awt.Color(0, 0, 0));

        feeField.setEditable(false);
        feeField.setForeground(new java.awt.Color(0, 0, 0));

        dayField.setEditable(false);
        dayField.setForeground(new java.awt.Color(0, 0, 0));

        serviceTaxField.setEditable(false);
        serviceTaxField.setForeground(new java.awt.Color(0, 0, 0));

        tourismTaxField.setEditable(false);
        tourismTaxField.setForeground(new java.awt.Color(0, 0, 0));

        totalField.setEditable(false);
        totalField.setForeground(new java.awt.Color(0, 0, 0));

        confirmBtn.setText("Confirm Booking");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cusFormField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cusRoomField, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(cusCheckInField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cusViewField, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(cusCheckOutField))))
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmBtn)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(totalField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addComponent(tourismTaxField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(serviceTaxField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(feeField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dayField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(81, 81, 81))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(cusFormField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(143, 143, 143))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(cusRoomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(48, 48, 48))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGap(116, 116, 116)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(cusViewField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(cusCheckInField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cusCheckOutField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(feeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(serviceTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tourismTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(confirmBtn)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        exitBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exitBtn.setText("Logout");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(28, 28, 28)
                        .addComponent(exitBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn)
                            .addComponent(exitBtn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        mainmenu main = new mainmenu();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        
        cusNameTxt.setText(null);
        icTxt.setText(null);
        numTxt.setText(null);
        emailTxt.setText(null);
        viewBtnGroup.clearSelection();
        checkin_date.setDate(null);
        checkout_date.setDate(null);
        roomTxt.setEnabled(false);
        
        cusFormField.setText(null);
        cusRoomField.setText(null);
        cusViewField.setText(null);
        cusCheckInField.setText(null);
        cusCheckOutField.setText(null);
        feeField.setText(null);
        dayField.setText(null);
        serviceTaxField.setText(null);
        tourismTaxField.setText(null);
        totalField.setText(null);
        
    }//GEN-LAST:event_resetBtnActionPerformed

    

    private void validateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_validateBtnMouseClicked
        //remove comboBox values once validate button click to refresh data
        roomTxt.removeAllItems();   
        
        //if check in and check out date not empty then proceed else show error
        if(checkin_date.getDate() != null && checkout_date.getDate() != null ) {
            
            //get today's date and user input date
            Date todate = new Date();
            Date checkin = checkin_date.getDate();
            Date checkout = checkout_date.getDate();
            
            //if checkin and checkout date is valid (After today's date) then proceed else show error message
            if(checkin.compareTo(todate) >= 0 && checkout.compareTo(todate) >= 0){
                
                //if check in date is before check out date then proceed else show error message
                if(checkin.compareTo(checkout) <= 0){
                    
                    //either of the button is selected then proceed else show error message
                    if(jungleBtn.isSelected() || seaBtn.isSelected()){
                        
                        roomTxt.setEnabled(true);
                        
                        //get date as string then convert it back to date type
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                        String checkIn = sdf.format(checkin_date.getDate());
                        String checkOut = sdf.format(checkout_date.getDate());

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                        LocalDate indate = LocalDate.parse(checkIn, formatter);
                        LocalDate outdate = LocalDate.parse(checkOut, formatter);

                        try {
                            //read room and booking text file
                            String line;
                            String[] lineArr;
                            BufferedReader room = new BufferedReader (new FileReader("room.txt"));
                            BufferedReader booking = new BufferedReader (new FileReader("booking.txt"));
                            
                            //while next line exist run if statement else stop loop
                            while ((line = room.readLine()) != null) {
                                lineArr = line.split("\\|");
                                
                                if(jungleBtn.isSelected()) {
                                    
                                    //add roomid into room comboBox if user select jungle and room is available
                                    if(lineArr[1].equals("Jungle") && lineArr[2].equals("Available")) {
                                        
                                        roomTxt.addItem(lineArr[0]);
                                    }
                                    
                                } else if (seaBtn.isSelected()) {
                                    
                                    //add roomid into room comboBox if user select sea and room is available
                                    if(lineArr[1].equals("Sea") && lineArr[2].equals("Available")) {
                                        roomTxt.addItem(lineArr[0]);
                                    }
                                }
                            }
                            
                            while ((line = booking.readLine()) != null) {

                                lineArr = line.split("\\|");
                                
                                //get booked check in and out date from text file and format into date type
                                String BookedCheckInDate = lineArr[7];
                                String BookedCheckOutDate = lineArr[8];

                                LocalDate checkinDate = LocalDate.parse(BookedCheckInDate, formatter);
                                LocalDate checkoutDate = LocalDate.parse(BookedCheckOutDate, formatter);

                                //validate user enter date with booked date if conflict then remove roomid from comboBox
                                if(indate.compareTo(checkoutDate) <= 0 && outdate.compareTo(checkinDate) >= 0){
                                    roomTxt.removeItem(lineArr[2]);
                                }
                            }
                            
                            //close file reader
                            room.close();
                            booking.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(bookRoom.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(bookRoom.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    } else {
                    JOptionPane.showMessageDialog(this, "Please Choose a View.", "Invalid View", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Check In Date Cannot be After Check Out Date. Please Try Other Date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Date Entered Cannot Before Today. Please Try Other Date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Choose Check In and Check Out Date.", "Empty Date", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_validateBtnMouseClicked

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        int yesno = JOptionPane.showConfirmDialog(null, "Do you want to add this row of record?", "WARNING",JOptionPane.YES_NO_OPTION);
        
        if (yesno == JOptionPane.YES_OPTION) {
        submitForm();
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked
        // TODO add your handling code here:
        sendToForm();
    }//GEN-LAST:event_submitBtnMouseClicked

    private void icTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icTxtKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_icTxtKeyTyped

    private void numTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTxtKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_numTxtKeyTyped

    private void validateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_validateBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private com.toedter.calendar.JDateChooser checkin_date;
    private com.toedter.calendar.JDateChooser checkout_date;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField cusCheckInField;
    private javax.swing.JTextField cusCheckOutField;
    private javax.swing.JTextField cusFormField;
    private javax.swing.JTextField cusNameTxt;
    private javax.swing.JTextField cusRoomField;
    private javax.swing.JTextField cusViewField;
    private javax.swing.JTextField dayField;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField feeField;
    private javax.swing.JTextField icTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jungleBtn;
    private javax.swing.JTextField numTxt;
    private javax.swing.JButton resetBtn;
    private javax.swing.JComboBox<String> roomTxt;
    private javax.swing.JRadioButton seaBtn;
    private javax.swing.JTextField serviceTaxField;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField totalField;
    private javax.swing.JTextField tourismTaxField;
    private javax.swing.JButton validateBtn;
    private javax.swing.ButtonGroup viewBtnGroup;
    // End of variables declaration//GEN-END:variables
}
