import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionSocket extends Thread{

    public Socket s;
    public ServerSocket ss;
    public InputStreamReader isr;
    public BufferedReader br;
    public String message;

    Window win1;
    String Port="";
    boolean FirtsSocket=false;
    String TAG="ConnectionSocket>";

    public ConnectionSocket(Window window){
        win1=window;
    }

    @Override
    public void run(){
        CreateSocket();
    }

    private void CreateSocket(){
        try
        {
              ss=new ServerSocket(Integer.parseInt(win1.textbox_Port.getText().toString()));
              Log("CreateSocket : Conexion Exitosa");
              win1.Activacion=true;
              while(win1.Activacion==true)
              {
                    s=ss.accept();
                    isr= new  InputStreamReader(s.getInputStream());
                    br=new BufferedReader(isr);
                    message=br.readLine();
                    Log("CreateSocket : Mensaje Recibido "+message);
                    
                    if(win1==null){
                        Log("CreateSocket : Objeto win1 es nulo");
                    }else{
                        Log("CreateSocket : Objeto win1 no es nulo");
                    }

                    if(win1.text_area.getText().toString().equals(""))
                    {
                        win1.text_area.setText("Android: "+message);
                    }else{
        
                        win1.text_area.setText(win1.text_area.getText()+"\n"+message);
                    }
                   // System.out.println("Activacion Socket: "+win1.Activacion);
                    
              }

              ss.close();
              win1.text_area.setText("ServerSocket Desconectado");
              Log("CreateSocket : Se desconecto el Socket");
        
        }catch(IOException e){
            e.printStackTrace();
            Log("CreateSocket : Fallo al crear el socket.........");
        }
        

    }
    private void Log(String information){
        System.out.println(TAG+information);
    }

}