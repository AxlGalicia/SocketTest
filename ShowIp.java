import java.lang.annotation.Target;
import java.net.InetAddress;

public class ShowIp {

    Window win2;

    String TAG="ShowIP>";

    public ShowIp(Window window){
        win2=window;
        FindIp();
    }

    private void FindIp(){
        try{
            String Ip=InetAddress.getLocalHost().getHostAddress();
            win2.textbox.setText(Ip);
            Log("FindIp : la direccion actual es "+Ip);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void Log(String information){
        System.out.println(TAG+information);
    } 

}