import java.net.*;
import java.util.*;
import java.io.*;

/*
2023.03
chatgpt
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Date date = new Date();
        System.out.println(date.toLocaleString());
        try {
            System.out.println("내부아이피 " + InetAddress.getLocalHost().getHostAddress());
            NetworkInterface networkinterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] mac = networkinterface.getHardwareAddress();
            String a = "";
            for (int i = 0; i < mac.length; i++) {
                a += (String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println("맥주소 " + a);
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println("외부아이피 " + in.readLine());
        } catch (UnknownHostException exception) {// ip
        } catch (SocketException exception) {// mac
        } catch (NullPointerException exception) {// mac
            System.out.println("인터넷 연결안됨");
        } catch (MalformedURLException exception) {// ip add
        } catch (IOException exception) {// ip add
        }
    }
}