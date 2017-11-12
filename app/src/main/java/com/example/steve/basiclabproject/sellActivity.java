package com.example.steve.basiclabproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.steve.basiclabproject.R.styleable.MenuGroup;

public class sellActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button button;
    String items[];
    String item;
    String subcategory;
    ImageView productImage;
Button uploadImageButton;
    TextView tVprodDescr;
    EditText edProdDescr;
EditText prodPrice;
    TextView tvEuro;
    Button submit;
    Button location;
    String myKeyUsername;

    public static final String KEY_USERNAME = "Username";
    public static final String KEY_PRODNAME= "ProductName";
    public static final String KEY_PRICE = "Price";
    public static final String KEY_DESCR = "ProductDescription";
    public static final String KEY_CATEGORY= "Category";
    public static final String KEY_SUBCATEGORY = "subCategory";
    public static final String KEY_LOCATION = "Location";
   // public static final String KEY_IMAGE = "Image";
    private static final String REGISTER_URL = "https://team4success.000webhostapp.com/uploadChance.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle extras= getIntent().getExtras();
        if(extras == null)
            return;
        myKeyUsername = extras.getString("usernamekey");

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
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
            item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

runOnUiThread();
        }
    }


    private void runOnUiThread() {
        RelativeLayout lp = (RelativeLayout) findViewById(R.id.checkLayout);
         productImage = (ImageView) findViewById(R.id.productImage);
         uploadImageButton =(Button) findViewById(R.id.uploadImageButton);
         tVprodDescr = (TextView) findViewById(R.id.tVdescrOfProd);
         edProdDescr = (EditText) findViewById(R.id.productDescription);
         prodPrice = (EditText) findViewById(R.id.prodPrice);
         tvEuro = (TextView) findViewById(R.id.tVeuro);
         submit = (Button) findViewById(R.id.button3);
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

    /*
    private void uploadChance() {
        edProdDescr = (EditText) findViewById(R.id.productDescription);
        prodPrice = (EditText) findViewById(R.id.prodPrice);
        tVprodDescr = (EditText) findViewById(R.id.tVdescrOfProd);
        location = (Button) findViewById(R.id.location);
        final String prodName = edProdDescr.getText().toString().trim();
        final String Price = prodPrice.getText().toString().trim();
        final String prodDesc = tVprodDescr.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(sellActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(sellActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, myKeyUsername);
                params.put(KEY_PRODNAME, prodDesc );
                params.put(KEY_PRICE, Price);
                params.put(KEY_CATEGORY, item);
                // params.put(KEY_SUBCATEGORY, password);
                // params.put(KEY_LOCATION, username);
                // params.put(KEY_IMAGE, password);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

*/

}
