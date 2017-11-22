package com.example.steve.basiclabproject.ClassesCreation;


        import android.app.Activity;
        import android.content.Intent;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.example.steve.basiclabproject.SignIn;
        import com.example.steve.basiclabproject.user_profil_screen;

        import java.util.HashMap;
        import java.util.Map;

//

public class login {

    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PASSWORD = "Password";
    private static final String REGISTER_URL = "https://team4success.000webhostapp.com/login_in.php";

    private EditText editTextUsername;
    private EditText editTextPassword;

    public login (){


    }

    public void userLogin(final String  userName,final String passWord,final Activity loginActivity){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(loginActivity, response.toString(), Toast.LENGTH_LONG).show();
                        if (response.toString().endsWith("successfully")) {
                            Intent intent = new Intent(loginActivity, user_profil_screen.class);
                            // String userName = editTextUsername.getText().toString();
                            intent.putExtra("usernamekey", userName);
                            loginActivity.startActivity(intent);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(loginActivity, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, userName);
                params.put(KEY_PASSWORD, passWord);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(loginActivity);
        requestQueue.add(stringRequest);

    }



}
