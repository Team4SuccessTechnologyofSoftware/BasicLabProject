package com.example.steve.basiclabproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

//import com.example.steve.basiclabproject.Helper.viewsHelper.interfaceHelper;

import com.example.steve.basiclabproject.ClassesCreation.interfaceHelper;

import java.util.ArrayList;
import java.util.List;

public class sellActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


      private  Button button=null;
      private  String items[]=null;
      private  String item=null;
      private  ImageView productImage=null;
      private  Button uploadImageButton=null;
      private  TextView tVprodDescr=null;
      private  EditText edProdDescr=null;
      private  EditText prodPrice=null;
      private  TextView tvEuro=null;
      private  Button submit=null;
      private  Button location=null;
      private interfaceHelper intr=null;

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
         submit = (Button) findViewById(R.id.submitButton);
         location= (Button) findViewById(R.id.location);

        intr = new interfaceHelper();

        if(item == "Homes") {
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            RadioButton apartement = new RadioButton(getApplicationContext());
            RadioButton residence = new RadioButton(getApplicationContext());
            RadioButton country = new RadioButton(getApplicationContext());
            intr.setRadioButtonText(new String[]{"apartement","residence","Country House"},apartement,residence,country);
            intr.addRadioGroupViews(lp,gp,apartement,residence,country);
            intr.setVisibitility(productImage,uploadImageButton,tVprodDescr,edProdDescr,prodPrice,tvEuro,submit,location);
        }
        else if(item == "Vehicles"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            RadioButton cars = new RadioButton(getApplicationContext());
            RadioButton motos = new RadioButton(getApplicationContext());
            RadioButton bicycles = new RadioButton(getApplicationContext());
            intr.setRadioButtonText(new String[]{"cars","motorbikes","bicycles"},cars,motos,bicycles);
            intr.addRadioGroupViews(lp,gp,cars,motos,bicycles);
            intr.setVisibitility(productImage,uploadImageButton,tVprodDescr,edProdDescr,prodPrice,tvEuro,submit,location);
        }
        else if(item == "Computers"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            RadioButton pc = new RadioButton(getApplicationContext());
            RadioButton laptop = new RadioButton(getApplicationContext());
            RadioButton parts = new RadioButton(getApplicationContext());
            RadioButton mobile = new RadioButton(getApplicationContext());
            intr.setRadioButtonText(new String[]{"PC","laptop","Computer/Laptop parts","Mobile Phones"},pc,laptop,parts,mobile);
            intr.addRadioGroupViews(lp,gp,pc,laptop,parts,mobile);
            intr.setVisibitility(productImage,uploadImageButton,tVprodDescr,edProdDescr,prodPrice,tvEuro,submit,location);
        }
        else if(item == "Musical Organs"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            RadioButton drums= new RadioButton(getApplicationContext());
            RadioButton guitars = new RadioButton(getApplicationContext());
            RadioButton basses = new RadioButton(getApplicationContext());
            RadioButton pneumatics= new RadioButton(getApplicationContext());
            RadioButton classicals = new RadioButton(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            intr.setRadioButtonText(new String[]{"Guitars","Basses","Drums","Pneumatics","Classical Organs"},guitars,basses,drums,pneumatics,classicals);
            intr.addRadioGroupViews(lp,gp,guitars,basses,drums,pneumatics,classicals);
            intr.setVisibitility(productImage,uploadImageButton,tVprodDescr,edProdDescr,prodPrice,tvEuro,submit,location);        }
        else if(item == "Personal Objects"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            RadioButton furnitures= new RadioButton(getApplicationContext());
            RadioButton homeDev= new RadioButton(getApplicationContext());
            RadioButton jewellery= new RadioButton(getApplicationContext());
            RadioButton design= new RadioButton(getApplicationContext());
            RadioButton hobbys= new RadioButton(getApplicationContext());
            intr.setRadioButtonText(new String[]{"furnitures","Home Devices","Jewells","Design","Hobbies"},furnitures,homeDev,jewellery,design,hobbys);
            intr.addRadioGroupViews(lp,gp,furnitures,homeDev,jewellery,design,hobbys);
            intr.setVisibitility(productImage,uploadImageButton,tVprodDescr,edProdDescr,prodPrice,tvEuro,submit,location);
        }
        else if(item == "Clothes"){
            lp.removeAllViews();
            RadioGroup gp = new RadioGroup(getApplicationContext());
            gp.setOrientation(LinearLayout.VERTICAL);
            RadioButton women = new RadioButton(getApplicationContext());
            RadioButton men = new RadioButton(getApplicationContext());
            RadioButton girls = new RadioButton(getApplicationContext());
            RadioButton boys= new RadioButton(getApplicationContext());
            intr.setRadioButtonText(new String[]{"women","men","girls","boys"},women,men,girls,boys);
            intr.addRadioGroupViews(lp,gp,women,men,boys,girls);
            intr.setVisibitility(productImage,uploadImageButton,tVprodDescr,edProdDescr,prodPrice,tvEuro,submit,location);
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
