package lab7;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Bai2Server extends javax.swing.JFrame {

    ServerSocket server = null;
    Socket client = null;
    OutputStream out;
    PrintStream ps;
    int port;

    public Bai2Server() {
    	getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
        initComponents();
        setLocationRelativeTo(null);
        btnSend.setEnabled(false);
    }
   
    @SuppressWarnings("unchecked")
  private void initComponents() {

    lblPortNo = new javax.swing.JLabel();
    lblPortNo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
    txtPort = new javax.swing.JTextField();
    txtPort.setFont(new Font("Times New Roman", Font.PLAIN, 13));
    scrpn = new javax.swing.JScrollPane();
    txtClient = new javax.swing.JTextArea();
    lblClientSay = new javax.swing.JLabel();
    lblClientSay.setFont(new Font("Times New Roman", Font.PLAIN, 13));
    btnStart = new javax.swing.JButton();
    btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 13));
    txtServer = new javax.swing.JTextField();
    btnSend = new javax.swing.JButton();
    btnSend.setFont(new Font("Times New Roman", Font.PLAIN, 13));

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Server");

    lblPortNo.setText("Port No.");

    txtPort.setText("9998");

    txtClient.setColumns(20);
    txtClient.setEditable(false);
    txtClient.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
    txtClient.setForeground(new java.awt.Color(0, 0, 153));
    txtClient.setRows(5);
    scrpn.setViewportView(txtClient);

    lblClientSay.setText("Client say :");

    btnStart.setText("Start");
    btnStart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnStartActionPerformed(evt);
      }
    });

    txtServer.setFont(new Font("Times New Roman", Font.PLAIN, 13));

    btnSend.setText("Send");
    btnSend.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSendActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(33, 33, 33)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblClientSay)
          .addComponent(scrpn, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(lblPortNo)
            .addGap(38, 38, 38)
            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnStart))
          .addGroup(layout.createSequentialGroup()
            .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnSend)))
        .addContainerGap(37, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblPortNo)
          .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnStart))
        .addGap(18, 18, 18)
        .addComponent(lblClientSay)
        .addGap(2, 2, 2)
        .addComponent(scrpn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSend))
        .addContainerGap(40, Short.MAX_VALUE))
    );

    pack();
  }

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            port = Integer.parseInt(txtPort.getText().trim());
            server = new ServerSocket(port);
            // server chờ client kết nối
            client = server.accept();
            btnStart.setEnabled(false);
            btnSend.setEnabled(true);

            out = client.getOutputStream();
            ps = new PrintStream(out);
            Thread t = new Thread(new ServerThread(client, txtClient));
            t.start();
            JOptionPane.showMessageDialog(btnStart, "Server started and waiting for clients on port " + port, "Server Started", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {
        String s = txtServer.getText().trim();
        ps.println(s);
}

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai2Server().setVisible(true);
            }
        });
    }

  private javax.swing.JButton btnSend;
  private javax.swing.JButton btnStart;
  private javax.swing.JLabel lblPortNo;
  private javax.swing.JLabel lblClientSay;
  private javax.swing.JScrollPane scrpn;
  private javax.swing.JTextArea txtClient;
  private javax.swing.JTextField txtPort;
  private javax.swing.JTextField txtServer;

}

class ServerThread implements Runnable {

    Socket client;
    JTextArea txtClient;
    InputStream in;
    BufferedInputStream bi;
    DataInputStream dis;

    public ServerThread(Socket client, JTextArea txtClient) {
        this.client = client;
        this.txtClient = txtClient;
        try {
            in = client.getInputStream();
            bi = new BufferedInputStream(in);
            dis = new DataInputStream(bi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
    	String s = "";
    	while (true) {
            try {
                s = dis.readLine();
                txtClient.append(s + "\n\r");
                JOptionPane.showMessageDialog(null, "Bạn có một tin nhắn đến từ Client: " + s, "New Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
