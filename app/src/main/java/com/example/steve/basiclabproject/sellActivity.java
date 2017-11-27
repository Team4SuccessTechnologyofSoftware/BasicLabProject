package com.example.steve.basiclabproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Handler;
import java.util.logging.LogRecord;

import javax.net.ssl.HttpsURLConnection;

import static android.widget.Toast.LENGTH_LONG;
import static com.example.steve.basiclabproject.R.styleable.MenuGroup;

public class sellActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    String items[];
    Bitmap bitmap;
    String item;
    ImageView productImage;
Button uploadImageButton;
    TextView tVprodDescr;
    EditText edProdDescr;
EditText prodPrice;
    TextView tvEuro;
    Button submit;
    Button location;
    String myKeyUsername;
    String subcategory;
    String imageFile;
    Bitmap bit;
    String fileMess;
    private static final int REQUEST_CODE = 5;
    String lacti;
    String longi;

    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PRODNAME= "ProductName";
    public static final String KEY_PRICE = "Price";
    public static final String KEY_DESCR = "ProductDescription";
    public static final String KEY_CATEGORY= "Category";
    public static final String KEY_SUBCATEGORY = "subCategory";
    public static final String KEY_LOCATION = "Location";
    public static final String KEY_LACTITUDE="Lactitude";
    public static final String KEY_LONGTITUDE="Longtitude";
   // public static final String KEY_IMAGE = "Image";
    private static final String REGISTER_URL = "https://team4success.000webhostapp.com/uploadChance.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle extras= getIntent().getExtras();
        if(extras == null)
            return;
        myKeyUsername = extras.getString("usernamekey");


       // imageFile = extras.getString("ImageFileName");
        //Toast.makeText(this,imageFile,Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellscreen);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Please choose a category");
        categories.add("Homes");
        categories.add("Vehicles");
        categories.add("Computers");
        categories.add("Musical Organs");
        categories.add("Personal Objects");
        categories.add("Clothes");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.getMeasuredWidth();
        submit = (Button) findViewById(R.id.submitButton);
        location = (Button) findViewById(R.id.location);
        uploadImageButton =(Button) findViewById(R.id.uploadImageButton);
        submit.setOnClickListener(this);
        uploadImageButton.setOnClickListener(this);
        location.setOnClickListener(this);
    }
    //creating back up button options ---lefteris-----------
    private boolean didUserClickBackButton = false;
    @Override
    public void onBackPressed() {
        if(!didUserClickBackButton) {
            Toast.makeText(this, "If you want to return to home page Press Back again!", Toast.LENGTH_LONG).show();
            didUserClickBackButton = true;

        }else {
            finish();
            Intent intent = new Intent(sellActivity.this, welcomeScreenActivity.class);
            startActivity(intent);
        }
        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                didUserClickBackButton = false;

            }
        }.start();

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
            item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, LENGTH_LONG).show();

runOnUiThread();
        }
    }


    private void runOnUiThread() {
        RelativeLayout lp = (RelativeLayout) findViewById(R.id.checkLayout);
         productImage = (ImageView) findViewById(R.id.productImage);
         tVprodDescr = (TextView) findViewById(R.id.tVdescrOfProd);
         edProdDescr = (EditText) findViewById(R.id.productDescription);
         prodPrice = (EditText) findViewById(R.id.prodPrice);
         tvEuro = (TextView) findViewById(R.id.tVeuro);
        location= (Button) findViewById(R.id.location);

        if(item == "Homes") {
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            final RadioButton apartement = new RadioButton(getApplicationContext());
            apartement.setText("apartement");
         apartement.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 subcategory = apartement.getText().toString();
                 Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
             }
         });
            final RadioButton residence = new RadioButton(getApplicationContext());
            residence.setText("residence");
            residence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = residence.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            RadioButton country = new RadioButton(getApplicationContext());
            country.setText("Country House");
            residence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = residence.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            gp.addView(apartement);
            gp.addView(residence);
            gp.addView(country);
            lp.addView(gp);
            productImage.setVisibility(View.VISIBLE);
            uploadImageButton.setVisibility(View.VISIBLE);
            tVprodDescr.setVisibility(View.VISIBLE);
            edProdDescr.setVisibility(View.VISIBLE);
            prodPrice.setVisibility(View.VISIBLE);
            tvEuro.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
        }
        else if(item == "Vehicles"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            final RadioButton cars = new RadioButton(getApplicationContext());
            cars.setText("cars");
            cars.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = cars.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton motos = new RadioButton(getApplicationContext());
            motos.setText("motorbikes");
            motos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = motos.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton bicycles = new RadioButton(getApplicationContext());
            bicycles.setText("bicycles");
            bicycles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bicycles.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            gp.addView(cars);
            gp.addView(motos);
            gp.addView(bicycles);
            lp.addView(gp);
            productImage.setVisibility(View.VISIBLE);
            uploadImageButton.setVisibility(View.VISIBLE);
            tVprodDescr.setVisibility(View.VISIBLE);
            edProdDescr.setVisibility(View.VISIBLE);
            prodPrice.setVisibility(View.VISIBLE);
            tvEuro.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
        }
        else if(item == "Computers"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            final RadioButton pc = new RadioButton(getApplicationContext());
            pc.setText("PC");
            pc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = pc.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton laptop = new RadioButton(getApplicationContext());
            laptop.setText("laptop");
            laptop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = laptop.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton parts = new RadioButton(getApplicationContext());
            parts.setText("Computer/Laptop parts");
            parts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   subcategory = parts.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton mobile = new RadioButton(getApplicationContext());
            mobile.setText("Mobile Phones");
            mobile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = mobile.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            gp.addView(pc);
            gp.addView(laptop);
            gp.addView(parts);
            gp.addView(mobile);
            lp.addView(gp);
            productImage.setVisibility(View.VISIBLE);
            uploadImageButton.setVisibility(View.VISIBLE);
            tVprodDescr.setVisibility(View.VISIBLE);
            edProdDescr.setVisibility(View.VISIBLE);
            prodPrice.setVisibility(View.VISIBLE);
            tvEuro.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
        }
        else if(item == "Musical Organs"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            final RadioButton guitars = new RadioButton(getApplicationContext());
            guitars.setText("Guitars");
            guitars.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = guitars.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton basses = new RadioButton(getApplicationContext());
            basses.setText("Basses");
            basses.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = basses.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton drums= new RadioButton(getApplicationContext());
            drums.setText("Drums");
            drums.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = drums.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton pneumatics= new RadioButton(getApplicationContext());
            pneumatics.setText("Pneumatics");
            pneumatics.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = pneumatics.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton classicals = new RadioButton(getApplicationContext());
            classicals.setText("Classical Organs");
            classicals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = classicals.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            gp.addView(guitars);
            gp.addView(basses);
            gp.addView(drums);
            gp.addView(pneumatics);
            gp.addView(classicals);
            lp.addView(gp);
            productImage.setVisibility(View.VISIBLE);
            uploadImageButton.setVisibility(View.VISIBLE);
            tVprodDescr.setVisibility(View.VISIBLE);
            edProdDescr.setVisibility(View.VISIBLE);
            prodPrice.setVisibility(View.VISIBLE);
            tvEuro.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
        }
        else if(item == "Personal Objects"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            final RadioButton furnitures= new RadioButton(getApplicationContext());
            furnitures.setText("furnitures");
            furnitures.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = furnitures.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton homeDev= new RadioButton(getApplicationContext());
            homeDev.setText("Home Devices");
            homeDev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = homeDev.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton jewellery= new RadioButton(getApplicationContext());
            jewellery.setText("Jewells");
            jewellery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = jewellery.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton design= new RadioButton(getApplicationContext());
            design.setText("Design");
            design.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = design.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton hobbys= new RadioButton(getApplicationContext());
            hobbys.setText("Hobbies");
            hobbys.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = hobbys.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            gp.addView(furnitures);
            gp.addView(homeDev);
            gp.addView(jewellery);
            gp.addView(design);
            gp.addView(hobbys);
            lp.addView(gp);
            productImage.setVisibility(View.VISIBLE);
            uploadImageButton.setVisibility(View.VISIBLE);
            tVprodDescr.setVisibility(View.VISIBLE);
            edProdDescr.setVisibility(View.VISIBLE);
            prodPrice.setVisibility(View.VISIBLE);
            tvEuro.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
        }
        else if(item == "Clothes"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            final RadioButton women = new RadioButton(getApplicationContext());
            women.setText("women");
            women.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = women.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton men = new RadioButton(getApplicationContext());
            men.setText("men");
            men.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = men.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton girls = new RadioButton(getApplicationContext());
            girls.setText("girls");
            girls.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = girls.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            final RadioButton boys= new RadioButton(getApplicationContext());
            boys.setText("boys");
            boys.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subcategory = boys.getText().toString();
                    Toast.makeText(sellActivity.this, subcategory,Toast.LENGTH_SHORT).show();
                }
            });
            gp.addView(women);
            gp.addView(men);
            gp.addView(boys);
            gp.addView(girls);
            lp.addView(gp);
            productImage.setVisibility(View.VISIBLE);
            uploadImageButton.setVisibility(View.VISIBLE);
            tVprodDescr.setVisibility(View.VISIBLE);
            edProdDescr.setVisibility(View.VISIBLE);
            prodPrice.setVisibility(View.VISIBLE);
            tvEuro.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void uploadChance() {
        edProdDescr = (EditText) findViewById(R.id.productDescription);
        prodPrice = (EditText) findViewById(R.id.prodPrice);
        tVprodDescr = (EditText) findViewById(R.id.tVdescrOfProd);
        location = (Button) findViewById(R.id.location);
        final String prodName = tVprodDescr.getText().toString().trim();
        final String Price = prodPrice.getText().toString().trim();
        final String prodDesc = edProdDescr.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(sellActivity.this, response.toString(), LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(sellActivity.this, error.toString(), LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, myKeyUsername);
                params.put(KEY_PRODNAME, prodName );
                params.put(KEY_DESCR, prodDesc);
                params.put(KEY_PRICE, Price);
                params.put(KEY_CATEGORY, item);
                params.put(KEY_SUBCATEGORY, subcategory);
                params.put(KEY_LACTITUDE,lacti);
                params.put(KEY_LONGTITUDE,longi);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        imageFile = intent.getStringExtra("fileNa");
        if (imageFile != null) {
            Toast.makeText(sellActivity.this, imageFile, Toast.LENGTH_SHORT).show();
            bitmap = BitmapFactory.decodeFile(imageFile);
            productImage.setImageBitmap(bitmap);
        }

    }

    ///////////
    @Override
    public void onClick(View v) {
        if (v == submit){
            Toast.makeText(getApplicationContext(),"HEy",Toast.LENGTH_SHORT).show();
            ImageUploadToServerFunction();
        }
        else if(v == uploadImageButton) {
            Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickPhoto, 1);
        }
        else if(v == location) {
            Intent intent = new Intent(this, setLocationActivity.class);
            startActivityForResult(intent, 5);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 5
        if(requestCode == 5){
            lacti=  data.getExtras().getString("lact");
            longi = data.getExtras().getString("long");
            Toast.makeText(sellActivity.this,lacti+"\n"+longi,Toast.LENGTH_LONG).show();
            //tVprodDescr.setText(lacti+"\n"+longi);

        }else if (requestCode==1){
            if(resultCode == RESULT_OK){
                Uri tweet_image_uri = data.getData();
                Uri imageUri = data.getData();
                try {
                    bitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    productImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }}
    }


    boolean check = true;

    ///////////////////////////////////////

    public void ImageUploadToServerFunction(){

        ByteArrayOutputStream byteArrayOutputStreamObject ;

        byteArrayOutputStreamObject = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject);

        byte[] byteArrayVar = byteArrayOutputStreamObject.toByteArray();

        final String ConvertImage = Base64.encodeToString(byteArrayVar, Base64.DEFAULT);

        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

//                progressDialog = ProgressDialog.show(MainActivity.this,"Image is Uploading","Please Wait",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                // Dismiss the progress dialog after done uploading.
//                progressDialog.dismiss();

                // Printing uploading success message coming from server on android app.
                Toast.makeText(getApplicationContext(),"The image is been uploading, Please wait",Toast.LENGTH_LONG).show();

                // Setting image as transparent after done uploading.
//                imageView.setImageResource(android.R.color.transparent);


            }

            String ImageName = "image_name" ;

            String ImagePath = "image_path" ;

            String ServerUploadPath ="https://team4success.000webhostapp.com/img_upload_to_server.php" ;



            @Override
            protected String doInBackground(Void... params) {

                ImageProcessClass imageProcessClass = new ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();

                HashMapParams.put(ImageName, "image");

                HashMapParams.put(ImagePath, ConvertImage);

                String FinalData = imageProcessClass.ImageHttpRequest("https://team4success.000webhostapp.com/img_upload_to_server.php", HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();

        AsyncTaskUploadClassOBJ.execute();
    }

    public class ImageProcessClass{

        public String ImageHttpRequest(String requestURL,HashMap<String, String> PData) {

            StringBuilder stringBuilder = new StringBuilder();

            try {
                URL url;
                HttpURLConnection httpURLConnectionObject ;
                OutputStream OutPutStream;
                BufferedWriter bufferedWriterObject ;
                BufferedReader bufferedReaderObject ;
                int RC ;

                url = new URL(requestURL);

                httpURLConnectionObject = (HttpURLConnection) url.openConnection();

                httpURLConnectionObject.setReadTimeout(19000);

                httpURLConnectionObject.setConnectTimeout(19000);

                httpURLConnectionObject.setRequestMethod("POST");

                httpURLConnectionObject.setDoInput(true);

                httpURLConnectionObject.setDoOutput(true);

                OutPutStream = httpURLConnectionObject.getOutputStream();

                bufferedWriterObject = new BufferedWriter(

                        new OutputStreamWriter(OutPutStream, "UTF-8"));

                bufferedWriterObject.write(bufferedWriterDataFN(PData));

                bufferedWriterObject.flush();

                bufferedWriterObject.close();

                OutPutStream.close();

                RC = httpURLConnectionObject.getResponseCode();

                if (RC == HttpsURLConnection.HTTP_OK) {
                    Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                    bufferedReaderObject = new BufferedReader(new InputStreamReader(httpURLConnectionObject.getInputStream()));

                    stringBuilder = new StringBuilder();

                    String RC2;

                    while ((RC2 = bufferedReaderObject.readLine()) != null){

                        stringBuilder.append(RC2);
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Not OK",Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Exception",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {

            StringBuilder stringBuilderObject;

            stringBuilderObject = new StringBuilder();

            for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {

                if (check)

                    check = false;
                else
                    stringBuilderObject.append("&");

                stringBuilderObject.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

                stringBuilderObject.append("=");

                stringBuilderObject.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
            }

            return stringBuilderObject.toString();
        }

    }




}

