package dsa.eetac.upc.edu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean decimal=false;
    boolean par=false;
    boolean rad=false;
    //Operaciones
    boolean add=false;
    boolean substratct=false;
    boolean division=false;
    boolean multiply=false;
    boolean sin=false;
    boolean cos=false;
    boolean tan=false;

    Double[] numbers =new Double[20];
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button zero=(Button)findViewById(R.id.btn0);
        zero.setOnClickListener(this);
        Button one = (Button)findViewById(R.id.btn1);
        one.setOnClickListener(this);
        Button two = (Button)findViewById(R.id.btn2);
        two.setOnClickListener(this);
        Button three = (Button)findViewById(R.id.btn3);
        three.setOnClickListener(this);
        Button four = (Button)findViewById(R.id.btn4);
        four.setOnClickListener(this);
        Button five = (Button)findViewById(R.id.btn5);
        five.setOnClickListener(this);
        Button six = (Button)findViewById(R.id.btn6);
        six.setOnClickListener(this);
        Button seven = (Button)findViewById(R.id.btn7);
        seven.setOnClickListener(this);
        Button eight = (Button)findViewById(R.id.btn8);
        eight.setOnClickListener(this);
        Button nine = (Button)findViewById(R.id.btn9);
        nine.setOnClickListener(this);
        Button pi = (Button)findViewById(R.id.piBtn);
        pi.setOnClickListener(this);

        Button commma = (Button)findViewById(R.id.commaBtn);
        commma.setOnClickListener(this);

        Button add = (Button)findViewById(R.id.addBtn);
        add.setOnClickListener(this);
        Button substract = (Button)findViewById(R.id.subBtn);
        substract.setOnClickListener(this);
        Button multiply = (Button)findViewById(R.id.multiBtn);
        multiply.setOnClickListener(this);
        Button divide = (Button)findViewById(R.id.divBtn);
        divide.setOnClickListener(this);

        Button sin = (Button)findViewById(R.id.sinBtn);
        sin.setOnClickListener(this);
        Button cos = (Button)findViewById(R.id.cosBtn);
        cos.setOnClickListener(this);
        Button tan = (Button)findViewById(R.id.tanBtn);
        tan.setOnClickListener(this);

        Button clear = (Button)findViewById(R.id.clearBtn);
        clear.setOnClickListener(this);

        Button equal = (Button)findViewById(R.id.equalBtn);
        equal.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        //Creamos una variable para guardar lo mostrado por
        TextView display=(TextView)findViewById(R.id.resultTxt);
        int selection = v.getId();
        String a=display.getText().toString(); //Guardamos en esta variable lo ingresado en pantalla
        try{
            switch(selection){
                case R.id.btn0:
                    display.setText((a+"0"));
                    break;
                case R.id.btn1:
                    display.setText(a+"1");
                    break;
                case R.id.btn2:
                    display.setText(a+"2");
                    break;
                case R.id.btn3:
                    display.setText(a+"3");
                    break;
                case R.id.btn4:
                    display.setText(a+"4");
                    break;
                case R.id.btn5:
                    display.setText(a+"5");
                    break;
                case R.id.btn6:
                    display.setText(a+"6");
                    break;
                case R.id.btn7:
                    display.setText(a+"7");
                    break;
                case R.id.btn8:
                    display.setText(a+"8");
                    break;
                case R.id.btn9:
                    display.setText(a+"9");
                    break;
                case R.id.piBtn:
                    display.setText(a+"π");
                    break;
                case R.id.commaBtn:
                    if(decimal==false) {
                        display.setText(a + ",");
                        decimal = true;
                    }else{
                        return;}
                    break;
                case R.id.subBtn:
                    substratct=true;
                    numbers[0]=Double.parseDouble(a);//el numero se guarde en a
                    display.setText("");//Para que no se vea el signo de restar
                    decimal=false;
                case R.id.addBtn:
                    add=true;
                    numbers[0]=Double.parseDouble(a);
                    display.setText("");
                    decimal=false;
                    break;
                case R.id.multiBtn:
                    multiply=true;
                    numbers[0]=Double.parseDouble(a);
                    display.setText("");
                    decimal=false;
                    break;
                case R.id.divBtn:
                    division=true;
                    numbers[0]=Double.parseDouble(a);
                    display.setText("");
                    decimal=false;
                    break;
                case R.id.tanBtn:
                    tan=true;
                    numbers[0]=Double.parseDouble(a);
                    display.setText("");
                    result = Math.tan(numbers[0]*Math.PI/180);//Tiene que estar en radianes la variable
                    display.setText(String.valueOf(result));
                    decimal=false;
                    break;
                case R.id.cosBtn:
                    cos=true;
                    numbers[0]=Double.parseDouble(a);
                    display.setText("");
                    result = Math.cos(numbers[0]*Math.PI/180);//Tiene que estar en radianes la variable
                    display.setText(String.valueOf(result));
                    decimal=false;
                    break;
                case R.id.sinBtn:
                    sin=true;
                    numbers[0]=Double.parseDouble(a);
                    display.setText("");
                    result = Math.sin(numbers[0]*Math.PI/180);//Tiene que estar en radianes la variable
                    display.setText(String.valueOf(result));
                    decimal=false;
                    break;
                case R.id.equalBtn:
                    numbers[1]=Double.parseDouble(a);
                    if(substratct){
                        result=numbers[1]-numbers[2];
                        display.setText((String.valueOf(result)));
                    }else if(add==true){
                        result=numbers[1]+numbers[2];
                        display.setText((String.valueOf(result)));
                    }else if(division==true){
                        result=numbers[1]/numbers[2];
                        display.setText((String.valueOf(result)));
                    }else if(multiply==true){
                        result=numbers[1]*numbers[2];
                        display.setText((String.valueOf(result)));
                    }
                    decimal=false;
                    substratct=false;
                    add=false;
                    division=false;
                    multiply=false;
                    sin=false;
                    cos=false;
                    tan=false;

                    break;
                case R.id.clearBtn:
                    display.setText("");
                    decimal=false;
                    break;
            }

        }catch(Exception e){
            display.setText("ERROR");
        }
    }
}