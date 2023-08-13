package lab7;


import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Bai2Client extends javax.swing.JFrame {
    int port;
    Socket client;
    OutputStream out;
    PrintStream ps;
    public Bai2Client() {
        initComponents();
        setLocationRelativeTo(null);
        btnSend.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
  private void initComponents() {

    lblPortNo = new javax.swing.JLabel();
    lblPortNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    txtPort = new javax.swing.JTextField();
    txtPort.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    btnConnect = new javax.swing.JButton();
    btnConnect.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    scrpn = new javax.swing.JScrollPane();
    txtServer = new javax.swing.JTextArea();
    txtSend = new javax.swing.JTextField();
    btnSend = new javax.swing.JButton();
    btnSend.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    lblServer = new javax.swing.JLabel();
    lblServer.setFont(new Font("Times New Roman", Font.PLAIN, 14));

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Client");

    lblPortNo.setText("Port No.");

    txtPort.setText("9998");

    btnConnect.setText("Connect");
    btnConnect.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConnectActionPerformed(evt);
      }
    });

    txtServer.setColumns(20);
    txtServer.setEditable(false);
    txtServer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    txtServer.setForeground(new java.awt.Color(153, 0, 0));
    txtServer.setRows(5);
    scrpn.setViewportView(txtServer);

    txtSend.setFont(new Font("Times New Roman", Font.PLAIN, 14));

    btnSend.setText("Send");
    btnSend.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSendActionPerformed(evt);
      }
    });

    lblServer.setText("Server");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblServer)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(layout.createSequentialGroup()
              .addComponent(lblPortNo)
              .addGap(38, 38, 38)
              .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(18, 18, 18)
              .addComponent(btnConnect))
            .addGroup(layout.createSequentialGroup()
              .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(scrpn)))
        .addContainerGap(21, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(lblPortNo)
              .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(btnConnect))
            .addGap(27, 27, 27)
            .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(btnSend))
        .addGap(73, 73, 73)
        .addComponent(lblServer)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrpn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(36, Short.MAX_VALUE))
    );

    pack();
  }
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {
      try {
        port = Integer.parseInt(txtPort.getText().trim());
        client = new Socket("127.0.0.1",port);
        out = client.getOutputStream();
        ps = new PrintStream(out);

        btnConnect.setEnabled(false);
        btnSend.setEnabled(true);
        Thread t = new Thread(new ClientThread(client, txtServer));
        t.start();

      } catch (Exception ex) {
        ex.printStackTrace();
      }
}
    
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {
      ps.println(txtSend.getText().trim());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai2Client().setVisible(true);
            }
        });
    }


  private javax.swing.JButton btnConnect;
  private javax.swing.JButton btnSend;
  private javax.swing.JLabel lblPortNo;
  private javax.swing.JLabel lblServer;
  private javax.swing.JScrollPane scrpn;
  private javax.swing.JTextField txtPort;
  private javax.swing.JTextField txtSend;
  private javax.swing.JTextArea txtServer;
 

}

class ClientThread implements Runnable{
  Socket client;
  JTextArea txtServer;
  InputStream in;
  BufferedInputStream bi;
  DataInputStream dis;
  OutputStream out;
  public ClientThread(Socket client, JTextArea txtServer){
    this.client = client;
    this.txtServer = txtServer;
    try{
      in = client.getInputStream();
      bi = new BufferedInputStream(in);
      dis = new DataInputStream(bi);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void run(){
    String s="";
    while (true) {
        try {
            s = dis.readLine();
            txtServer.append(s + "\n\r");
            JOptionPane.showMessageDialog(null, "Bạn có một tin nhắn đến từ Server: " + s, "New Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
  }
}
