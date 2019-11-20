package wk;

import bcircle.ProImage;
import bcircle.Profile;
import bcircle.SendOCR;

public class Program {
    public static void main(String[] args) throws Exception {

        String url = "http://localhost:3000";
        String profileName = "invoice";

        SendOCR client = new SendOCR(url);
        Profile profile = new Profile() {
            {
                setProfile(profileName);
                setX(0);
                setY(0);
                setWidth(2);
                setHeight(5);
            }
        };
        client.postProfile(profile);

        String result = client.postImage(new ProImage() {
            {
                setProfile(profileName);
                setPartImage("http/invoice.jpg");
            }
        });

        System.out.println("result: " + result);
    }
}