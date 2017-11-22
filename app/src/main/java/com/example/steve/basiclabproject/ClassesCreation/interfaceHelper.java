package com.example.steve.basiclabproject.ClassesCreation;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

/**
 * Created by ADIS HP on 22/11/2017.
 */

    public class interfaceHelper  {

        public interfaceHelper() {
        }


        public void setVisibitility(View... mViews){
            for(int j=0; j<mViews.length; j++){
                mViews[j].setVisibility(View.VISIBLE);
            }
        }

        public boolean HideVisibitility(View... mViews){
            try{
                for(int j=0; j<mViews.length; j++){
                    mViews[j].setVisibility(View.INVISIBLE);
                }
                return true;
            }catch (Exception ex){
                return false;
            }
        }


        public void addRadioGroupViews(RelativeLayout layout, RadioGroup radioGroup, View... view){
            for(int j=0; j<view.length; j++){
                radioGroup.addView(view[j]);
            }
            layout.addView(radioGroup);
        }

        public void setRadioButtonText(String[] text,RadioButton... views){
            for(int j=0; j<views.length; j++){
                views[j].setText(text[j]);
            }
        }

    }

