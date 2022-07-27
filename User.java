import java.io.*;
import java.net.*;

public class User{
    private String username;
    private String password;

    public User(String username){
        this.setUsername(username);
    }

    public void setUsername(String username){
        this.username = username;
    }

    public boolean authentificate(String pwd) throws IOException{
        HttpURLConnection connection = null;
		String params = "email="+this.username+"&password="+pwd;
		Boolean valeurDeRetour = false;

        try {
            //Create connection
            URL url = new URL(InfoConnection.getPostUrl());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    
            connection.setRequestProperty("Content-Length", Integer.toString(params.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");  
    
            connection.setUseCaches(false);
            connection.setDoOutput(true);
    
            //Send request
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.writeBytes(params);
            wr.close();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //verify if the current url match with the home page url
                if(connection.getURL().toString().equals(InfoConnection.getHomeUrl())){
                    this.password = pwd;
                    System.out.println(connection.getURL().toString());
                    valeurDeRetour = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
		return valeurDeRetour;

    }
}
