package request;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;


public class Requests extends AsyncTask<String, String, String> {
    private String content = "";
    public String URL = "http://10.106.3.105:8000/spas/relay1";

    @Override
    public String doInBackground(String... params) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(params[0]);
            connection.setConnectTimeout(1000);
            connection.connect();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (params[0] == "POST") return post(connection, params[1]);
        else return get(connection);
    }


    static String post(HttpURLConnection connection, String json) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(json);
            out.flush();
            out.close();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    static String get(HttpURLConnection connection) {
        String content = "";
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                content += line + "\n";
            }
        } catch (Exception e) {

        }
        return content;
    }
}