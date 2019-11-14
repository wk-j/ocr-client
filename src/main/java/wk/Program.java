package wk;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.json.JSONWriter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Program {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        Profile profile = new Profile() {
            {
                setProfile("profile");
                setX(0);
                setX(0);
                setWidth(5);
                setWidth(5);
            }
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(profile);
        StringEntity params = new StringEntity(json);

        params.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        HttpPost httpPost = new HttpPost("https://ocr-fix-position.herokuapp.com/setprofile");
        httpPost.setEntity(params);
        HttpResponse response = httpClient.execute(httpPost);

        if (response != null) {
            InputStream in = response.getEntity().getContent();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            System.out.println(responseStrBuilder.toString());
            // JSONObject jsonResponse = new JSONObject(responseStrBuilder.toString());
        } else {
            System.out.println("Response was null");
        }
    }
}

class Profile {
    private String profile;
    private double x;
    private double y;
    private double width;
    private double height;

    public String getProfile() {
        return profile;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}