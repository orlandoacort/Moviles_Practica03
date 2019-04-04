package com.example.moviles_practica03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnEnviar);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String pedido =  pedidos();

                Toast.makeText(MainActivity.this,pedido,Toast.LENGTH_LONG).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,pedido);
                sendIntent.setType("text/plain");
                if (null != sendIntent.resolveActivity(getPackageManager())){

                    startActivity(Intent.createChooser(sendIntent,"SEND"));
                }

            }
        });

    }

    private String pedidos() {

        final CheckBox cbHamb = (CheckBox)findViewById(R.id.cbHamb);
        final CheckBox cbHotd = (CheckBox)findViewById(R.id.cbHotd);
        final CheckBox cbVeg = (CheckBox)findViewById(R.id.cbVeg);

        final CheckBox cbCHamb = (CheckBox)findViewById(R.id.cbCHamb);
        final CheckBox cbCHotd = (CheckBox)findViewById(R.id.cbCHotd);
        final CheckBox cbCfilete = (CheckBox)findViewById(R.id.cbCfilete);

        final CheckBox cbRHamb = (CheckBox)findViewById(R.id.cbRHamb);
        final  CheckBox cbRHotd = (CheckBox)findViewById(R.id.cbRHotd);
        final  CheckBox cbRfilete = (CheckBox)findViewById(R.id.cbRfilete);

        String pedido = "";

        if (cbHamb.isChecked()){
            pedido += "Hambuerguesa Clasica\n";
        }
        if (cbHotd.isChecked()){
            pedido += "HotDog\n";
        }
        if (cbVeg.isChecked()){
            pedido += "Vegetariano\n";
        }

        if (cbCHamb.isChecked()){
            pedido += "Cheese Burger\n";
        }

        if (cbCHotd.isChecked()){
            pedido += "HotDog Cheese\n";
        }

        if (cbCfilete.isChecked()){
            pedido += "Filete Cheese\n";
        }

        if (cbRHamb.isChecked()){
            pedido += "Hamburguesa Royal\n";
        }

        if (cbRHotd.isChecked()){
            pedido += "HotDog Royal\n";
        }

        if (cbRfilete.isChecked()){
            pedido += "Filete Royal\n";
        }

        if (pedido.equals("")){
            pedido = "NO ELEGISTE NADA!!!";
        }

        return pedido;

    }
}
