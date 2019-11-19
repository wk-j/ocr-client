package wk;

import bcircle.ProImage;
import bcircle.Profile;
import bcircle.SendImage;
import bcircle.SendProfile;

public class Program {
    public static void main(String[] args) throws Exception {

        String url = "http://localhost:3000";
        String profileName = "invoice";

        {
            SendProfile profileClient = new SendProfile(url);
            Profile profile = new Profile() {
                {
                    setProfile(profileName);
                    setX(0);
                    setY(0);
                    setWidth(5);
                    setHeight(5);
                }
            };
            profileClient.postProfile(profile);
        }

        {
            SendImage service = new SendImage(url);
            String result = service.postImage(new ProImage() {
                {
                    setProfile(profileName);
                    setPartImage("/Users/wk/GitHub/OcrClient/http/invoice.jpg");
                }
            });

            System.out.println("result: " + result);
        }
    }
}