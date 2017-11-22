package com.example.steve.basiclabproject.ClassesCreation;

        import android.app.Activity;
        import android.content.Intent;
        import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.example.steve.basiclabproject.user_profil_screen;

        import java.util.HashMap;
        import java.util.Map;

//------

public class signUp  {
    private static final String REGISTER_URL = "https://team4success.000webhostapp.com/usersRegister.php";
    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PASSWORD = "Password";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_LASTNAME= "lastName";
    public static final String KEY_FIRSTNAME= "firstName";
    public static final String KEY_PHONE= "PhoneNumber";

    public signUp() {

    }

    public  void signUpUser(final Activity mActivity,final String username,final String password,final String email,
                            final String lastName,final String firstName,final String phone) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(mActivity,response, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(mActivity,user_profil_screen.class);
                        intent.putExtra("usernamekey",username);
                        mActivity.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mActivity,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                params.put(KEY_FIRSTNAME, firstName);
                params.put(KEY_LASTNAME, lastName);
                params.put(KEY_PHONE, phone);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(mActivity);
        requestQueue.add(stringRequest);

    }



}