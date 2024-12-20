package com.mastercoding.quadraticequationsolver;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.mastercoding.quadraticequationsolver.databinding.ActivityMainBinding;

public class Equation extends BaseObservable {

    String a;
    String b;
    String c;
    ActivityMainBinding dataBinding;

    public Equation(ActivityMainBinding dataBinding) {
        this.dataBinding = dataBinding;
    }

    public Equation() {
    }


    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void EquationSolver(View view){

        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        //calculate discriminant
        double discriminant = b * b - 4 * a * c;

        //finding the solution (roots)
        double x1, x2;
        if (discriminant > 0) {
            //two real roots and distinct root
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            //display the results in text view
            dataBinding.resultTxv.setText("x1 = " + x1 + " x2 = " + x2);
        } else if (discriminant < 0) {
            dataBinding.resultTxv.setText("Roots are imaginary");
        }else {
            //one real root
            x1 = -b / (2.0 * a);
            dataBinding.resultTxv.setText("x1 = x2 = " + x1);
        }

    }
}
