
/*-----------Imports Class----------*/
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Window extends JFrame{
/*-----------Attributes----------*/ 
    JPanel panel_area;
    JPanel panel_connection;

    JTextArea text_area;
    JTextField textbox;
    JTextField textbox_Port;

    JButton buttonConnect;
    JButton buttonDisconnect;

    public boolean Activacion=true;

    private String TAG = "Window>";

    public Window(){
        Log("Window Constructor: Se creo un objeto de la clase Window");
        InitComponents();
    }

    private void InitComponents(){
        Form();
        AddPanel();
        AddTextArea();
        AddJTextField();
        AddJLabel();
        AddButtons();
        AddScroll();
    }

    private void Form(){
        this.setSize(400,250);
        this.setTitle("SocketTest USAC-EVAT");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    private void AddPanel(){
        /*---------Panel Text Area----------*/ 
        panel_area = new JPanel();
        panel_area.setBounds(5, 5, 200,200);
        panel_area.setLayout(null);
       // panel_area.setBackground(Color.RED);
       /*---------Panel Connection----------*/ 
        panel_connection = new JPanel();
        panel_connection.setBounds(210,5,175,200);
        panel_connection.setLayout(null);
       // panel_connection.setBackground(Color.BLUE);
        /*--------Add Panel to Window-------*/
        this.getContentPane().add(panel_connection);
        this.getContentPane().add(panel_area);
    }

    private void AddTextArea(){
        text_area= new JTextArea("Bienvenido al test de socket....");
        text_area.setLineWrap(true);
        text_area.setWrapStyleWord(true);
      //  text_area.setBounds(0, 0, panel_area.getWidth(), panel_area.getHeight());
       // panel_area.add(text_area);
    }

    private void AddJTextField(){
        /*----------IP TextBox--------------*/
        textbox=new JTextField();
        textbox.setBounds(45,40,90,25);
        textbox.setEditable(false);
        /*----------Port TextBox------------*/
        textbox_Port=new JTextField();
        textbox_Port.setBounds(45, 110, 90, 25);
        /*-------Add TextBoxs to Panel------*/
        panel_connection.add(textbox_Port);
        panel_connection.add(textbox);

    }

    private void AddJLabel(){
        /*----------JLabel IP---------*/
        JLabel TagIP=new JLabel();
        TagIP.setText("IP Actual");
        TagIP.setBounds(60,20,100,20);
        /*----------JLabel Port---------*/
        JLabel TagPort=new JLabel();
        TagPort.setText("Puerto a utilizar");
        TagPort.setBounds(45,90,100,20);
        /*------Add JLabel to Panels-----*/
        panel_connection.add(TagIP);
        panel_connection.add(TagPort);
    }

    private void AddButtons(){
        /*-------- Button Connect--------*/
        buttonConnect=new JButton();
        buttonConnect.setText("CONECTAR");
        buttonConnect.setBounds(35, 150, 115, 20);
        /*--------Button Disconnect------*/
        buttonDisconnect=new JButton();
        buttonDisconnect.setText("DESCONECTAR");
        buttonDisconnect.setBounds(25, 180, 135, 20);
       /*--------Add Buttons to Panel------*/
        panel_connection.add(buttonConnect);
        panel_connection.add(buttonDisconnect);
    }

    private void AddScroll(){
        JScrollPane s =new JScrollPane(text_area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setBounds(0,0,200,200);
        s.setBounds(0, 0, panel_area.getWidth(), panel_area.getHeight());
        panel_area.add(s);
    }

    private void Log(String information){
        System.out.println(TAG+information);
    }


}