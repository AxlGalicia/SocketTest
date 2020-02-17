
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class Principal {

    static private String TAG = "Principal>";
    public static void main(String[] args) {

        Window window = new Window();
        window.setVisible(true);
        ShowIp ip = new ShowIp(window);

        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (window.textbox_Port.getText().toString().equals("")
                        || CheckNumberPort(window.textbox_Port.getText().toString()) == false) {
                    Log("actionPerformed: Puerto Invalido");
                    JOptionPane.showMessageDialog(null,
                            "PUERTO INVALIDO, verifique si el puerto esta \n correctamente escrito.");
                } else {
                    Log("actionPerformed : El puerto a utilizar es "+window.textbox_Port.getText().toString());
                    ConnectionSocket cSocket = new ConnectionSocket(window);
                    cSocket.start();
                }
            }

        };
        Log("main : Se agrego el Listener al boton Conectar");
        window.buttonConnect.addActionListener(actionListener);


        ActionListener actionListener2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                window.Activacion=false;
                Log("actionPerformed : Desactivacion en curso....." );
                //System.out.println("Activacion windows: "+window.Activacion);
            }
           
        };
        Log("main : Se agrego el Listener al boton Desconectar");
        window.buttonDisconnect.addActionListener(actionListener2);




    }


    public static boolean CheckNumberPort(String number){
        try
        {
            double NumberTest = Double.parseDouble(number);
        }
        catch(NumberFormatException nfe)
        {  
            return false;
        }

        return true;
    }

    private static void Log(String information){
        System.out.println(TAG+information);
    }

}