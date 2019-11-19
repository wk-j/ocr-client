package wk;

import bcircle.ProImage;
import bcircle.SendImage;

public class Program {
    public static void main(String[] args) throws Exception {

        SendImage service = new SendImage("http://localhost:3000");

        String result = service.postImage(new ProImage() {
            {
                setProfile("profile");
                setPartimage("http/invoice.jpg");
            }
        });

        System.out.println("result: " + result);
    }
}