package com.example.steve.basiclabproject;

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

import java.util.ArrayList;
import java.util.List;

import static com.example.steve.basiclabproject.R.styleable.MenuGroup;

public class sellActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button button;
    String items[];
    String item;
    ImageView productImage;
Button uploadImageButton;
    TextView tVprodDescr;
    EditText edProdDescr;
EditText prodPrice;
    TextView tvEuro;
    Button submit;
    Button location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

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
            RadioButton apartement = new RadioButton(getApplicationContext());
            apartement.setText("apartement");
            RadioButton residence = new RadioButton(getApplicationContext());
            residence.setText("residence");
            RadioButton country = new RadioButton(getApplicationContext());
            country.setText("Country House");
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
            RadioButton cars = new RadioButton(getApplicationContext());
            cars.setText("cars");
            RadioButton motos = new RadioButton(getApplicationContext());
            motos.setText("motorbikes");
            RadioButton bicycles = new RadioButton(getApplicationContext());
            bicycles.setText("bicycles");
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
            RadioButton pc = new RadioButton(getApplicationContext());
            pc.setText("PC");
            RadioButton laptop = new RadioButton(getApplicationContext());
            laptop.setText("laptop");
            RadioButton parts = new RadioButton(getApplicationContext());
            parts.setText("Computer/Laptop parts");
            RadioButton mobile = new RadioButton(getApplicationContext());
            mobile.setText("Mobile Phones");
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
            RadioButton guitars = new RadioButton(getApplicationContext());
            guitars.setText("Guitars");
            RadioButton basses = new RadioButton(getApplicationContext());
            basses.setText("Basses");
            RadioButton drums= new RadioButton(getApplicationContext());
            drums.setText("Drums");
            RadioButton pneumatics= new RadioButton(getApplicationContext());
            pneumatics.setText("Pneumatics");
            RadioButton classicals = new RadioButton(getApplicationContext());
            classicals.setText("Classical Organs");
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
            RadioButton furnitures= new RadioButton(getApplicationContext());
            furnitures.setText("furnitures");
            RadioButton homeDev= new RadioButton(getApplicationContext());
            homeDev.setText("Home Devices");
            RadioButton jewellery= new RadioButton(getApplicationContext());
            jewellery.setText("Jewells");
            RadioButton design= new RadioButton(getApplicationContext());
            design.setText("Design");
            RadioButton hobbys= new RadioButton(getApplicationContext());
            hobbys.setText("Hobbies");
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
            RadioButton women = new RadioButton(getApplicationContext());
            women.setText("women");
            RadioButton men = new RadioButton(getApplicationContext());
            men.setText("men");
            RadioButton girls = new RadioButton(getApplicationContext());
            girls.setText("girls");
            RadioButton boys= new RadioButton(getApplicationContext());
            boys.setText("boys");
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


}
