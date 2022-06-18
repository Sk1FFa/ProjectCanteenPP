package com.example.projectpp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.Statement;

public class SecondActivity extends AppCompatActivity {

    Connection connection;

    TextView selectfd, selectsd, selectgar, selectsal, selectbev, selectbak;

    final int a1 =1;
    final int a2 =2;
    final int a3 =3;
    final int a4 =4;
    final int a5 =5;
    final int a6 =6;
    final int b1 =7;
    final int b2 =8;
    final int b3 =9;
    final int b4 =10;
    final int b5 =11;
    final int b6 =12;
    final int b7 =13;
    final int b8 =14;
    final int c1 =15;
    final int c2 =16;
    final int c3 =17;
    final int c4 =18;
    final int d1 =19;
    final int d2 =20;
    final int d3 =21;
    final int e1 =22;
    final int e2 =23;
    final int f1 =24;
    final int f2 =25;
    final int f3 =26;
    final int f4 =27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn= findViewById(R.id.btnorder);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView selectfd = findViewById(R.id.selectfd);
                String Txtselectfd = selectfd.getText().toString();
                TextView selectsd = findViewById(R.id.selectsd);
                String Txtselectsd = selectsd.getText().toString();
                TextView selectgar = findViewById(R.id.selectgar);
                String Txtselectgar = selectgar.getText().toString();
                TextView selectsal = findViewById(R.id.selectsal);
                String Txtselectsal = selectsal.getText().toString();
                TextView selectbev = findViewById(R.id.selectbev);
                String Txtselectbev = selectbev.getText().toString();
                TextView selectbak = findViewById(R.id.selectbak);
                String Txtselectbak = selectbak.getText().toString();

                TextView servingfd = findViewById(R.id.servingfd);
                String Txtservingfd = servingfd.getText().toString();
                TextView servingsd = findViewById(R.id.servingsd);
                String Txtservingsd = servingsd.getText().toString();
                TextView servinggar = findViewById(R.id.servinggar);
                String Txtservinggar = servinggar.getText().toString();
                TextView servingsal = findViewById(R.id.servingsal);
                String Txtservingsal = servingsal.getText().toString();
                TextView servingbev = findViewById(R.id.servingbev);
                String Txtservingbev = servingbev.getText().toString();
                TextView servingbak = findViewById(R.id.servingbak);
                String Txtservingbak = servingbak.getText().toString();

                TextView fio = findViewById(R.id.fio);
                String Txtfio = fio.getText().toString();
                TextView shift = findViewById(R.id.shift);
                String Txtshift = shift.getText().toString();

                ConSQL c= new ConSQL();
                connection = c.conclass();
                String sqlstatement = "insert orders(surnamesecond, shift, namefood, servings) values('"+Txtfio+"',"+Txtshift+",'"+Txtselectfd+"',"+Txtservingfd+");"+
                        "insert orders(surnamesecond, shift, namefood, servings) values('"+Txtfio+"',"+Txtshift+",'"+Txtselectsd+"',"+Txtservingsd+");"+
                        "insert orders(surnamesecond, shift, namefood, servings) values('"+Txtfio+"',"+Txtshift+",'"+Txtselectgar+"',"+Txtservinggar+");"+
                        "insert orders(surnamesecond, shift, namefood, servings) values('"+Txtfio+"',"+Txtshift+",'"+Txtselectsal+"',"+Txtservingsal+");"+
                        "insert orders(surnamesecond, shift, namefood, servings) values('"+Txtfio+"',"+Txtshift+",'"+Txtselectbev+"',"+Txtservingbev+");"+
                        "insert orders(surnamesecond, shift, namefood, servings) values('"+Txtfio+"',"+Txtshift+",'"+Txtselectbak+"',"+Txtservingbak+");";
                try (Statement set = connection.createStatement())
                {
                    set.executeQuery(sqlstatement);
                    connection.close();
                }
                catch (Exception ex)
                {
                    Log.e("Error: ",ex.getMessage());
                }

                fio.setText("");
                shift.setText("");

                selectfd.setText("");
                selectsd.setText("");
                selectgar.setText("");
                selectsal.setText("");
                selectbev.setText("");
                selectbak.setText("");

                servingfd.setText("");
                servingsd.setText("");
                servinggar.setText("");
                servingsal.setText("");
                servingbev.setText("");
                servingbak.setText("");

                openDialog();
            }
        });

        selectfd = findViewById(R.id.selectfd);
        selectsd = findViewById(R.id.selectsd);
        selectgar = findViewById(R.id.selectgar);
        selectsal = findViewById(R.id.selectsal);
        selectbev = findViewById(R.id.selectbev);
        selectbak = findViewById(R.id.selectbak);
        registerForContextMenu(selectfd);
        registerForContextMenu(selectsd);
        registerForContextMenu(selectgar);
        registerForContextMenu(selectsal);
        registerForContextMenu(selectbev);
        registerForContextMenu(selectbak);
    }

    public void openDialog(){
        Dialog exampleDialog = new Dialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch(v.getId()){
            case R.id.selectfd:
                menu.add(1, a1, 0,"Суп рисовый |300гр|31р|");
                menu.add(1, a2, 0,"Борщ Украинский с фрикадельками|300гр|48р|");
                menu.add(1, a3, 0,"Сырники творожные (завтрак) |100гр|53р|");
                menu.add(1, a4, 0,"Каша пшеничная молочная (завтрак) |200гр|30р|");
                menu.add(1, a5, 0,"Котлеты картофельные (завтрак) |100гр|19р|");
                menu.add(1, a6, 0,"Глазунья из двух яиц (завтрак) |80гр|26р|");
                break;
            case R.id.selectsd:
                menu.add(2, b1, 0,"Бедро куриное жареное |100гр|55р|");
                menu.add(2, b2, 0,"Шницель куриный рубленый |100гр|59р|");
                menu.add(2, b3, 0,"Печень жареная с луком |100гр|78р|");
                menu.add(2, b4, 0,"Биточек особый |100гр|60р|");
                menu.add(2, b5, 0,"Бифштекс рубленый из свинины |100гр|70р|");
                menu.add(2, b6, 0,"Грудка запеченная с помидорами |100гр|68р|");
                menu.add(2, b7, 0,"Горбуша запеченая с овощами |100гр|75р|");
                menu.add(2, b8, 0,"Котлета любительская |100гр|64р|");
                break;
            case R.id.selectgar:
                menu.add(3, c1, 0,"Пюре картофельное |200гр|25р|");
                menu.add(3, c2, 0,"Рис отварной |200гр|22р|");
                menu.add(3, c3, 0,"Капуста тушеная |200гр|38р|");
                menu.add(3, c4, 0,"Овощи тушёные |200гр|50р|");
                break;
            case R.id.selectsal:
                menu.add(4, d1, 0,"Салат Белая береза |100гр|43р|");
                menu.add(4, d2, 0,"Салат из морской капусты |100гр|40р|");
                menu.add(4, d3, 0,"Салат Закуска Робинзона |100гр|30р|");
                break;
            case R.id.selectbev:
                menu.add(5, e1, 0,"Компот из сухофруктов |200гр|13р|");
                menu.add(5, e2, 0,"Морс из свежих ягод |200гр|14р|");
                break;
            case R.id.selectbak:
                menu.add(6, f1, 0,"Кулебяка с картофелем |95гр|14р|");
                menu.add(6, f2, 0,"Булочка Устрица |80гр|23р|");
                menu.add(6, f3, 0,"Сосиска в тесте |100гр|30р|");
                menu.add(6, f4, 0,"Курник |120гр|23р|");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case a1:
                selectfd.setText("Суп рисовый\n|300гр|31р|");
                selectfd.setTextSize(15);
                selectfd.setTextColor(Color.BLACK);
                break;
            case a2:
                selectfd.setText("Борщ Украинский с фрикадельками\n|300гр|48р|");
                selectfd.setTextSize(15);
                selectfd.setTextColor(Color.BLACK);
                break;
            case a3:
                selectfd.setText("Сырники творожные (завтрак)\n|100гр|53р|");
                selectfd.setTextSize(15);
                selectfd.setTextColor(Color.BLACK);
                break;
            case a4:
                selectfd.setText("Каша пшеничная молочная (завтрак)\n|200гр|30р|");
                selectfd.setTextSize(15);
                selectfd.setTextColor(Color.BLACK);
                break;
            case a5:
                selectfd.setText("Котлеты картофельные (завтрак)\n|100гр|19р|");
                selectfd.setTextSize(15);
                selectfd.setTextColor(Color.BLACK);
                break;
            case a6:
                selectfd.setText("Глазунья из двух яиц (завтрак)\n|80гр|26р|");
                selectfd.setTextSize(15);
                selectfd.setTextColor(Color.BLACK);
                break;


            case b1:
                selectsd.setText("Бедро куриное жареное\n|100гр|55р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;
            case b2:
                selectsd.setText("Шницель куриный рубленый\n|100гр|59р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;
            case b3:
                selectsd.setText("Печень жареная с луком\n|100гр|78р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;
            case b4:
                selectsd.setText("Биточек особый\n|100гр|60р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;
            case b5:
                selectsd.setText("Бифштекс рубленый из свинины\n|100гр|70р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;
            case b6:
                selectsd.setText("Грудка запеченная с помидорами\n|100гр|68р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;
            case b7:
                selectsd.setText("Горбуша запеченая с овощами\n|100гр|75р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;
            case b8:
                selectsd.setText("Котлета любительская\n|100гр|64р|");
                selectsd.setTextSize(15);
                selectsd.setTextColor(Color.BLACK);
                break;

            case c1:
                selectgar.setText("Пюре картофельное\n|200гр|25р|");
                selectgar.setTextSize(15);
                selectgar.setTextColor(Color.BLACK);
                break;
            case c2:
                selectgar.setText("Рис отварной\n|200гр|22р|");
                selectgar.setTextSize(15);
                selectgar.setTextColor(Color.BLACK);
                break;
            case c3:
                selectgar.setText("Капуста тушеная\n|200гр|38р|");
                selectgar.setTextSize(15);
                selectgar.setTextColor(Color.BLACK);
                break;
            case c4:
                selectgar.setText("Овощи тушёные\n|200гр|50р|");
                selectgar.setTextSize(15);
                selectgar.setTextColor(Color.BLACK);
                break;

            case d1:
                selectsal.setText("Салат Белая береза\n|100гр|43р|");
                selectsal.setTextSize(15);
                selectsal.setTextColor(Color.BLACK);
                break;
            case d2:
                selectsal.setText("Салат из морской капусты\n|100гр|40р|");
                selectsal.setTextSize(15);
                selectsal.setTextColor(Color.BLACK);
                break;
            case d3:
                selectsal.setText("Салат Закуска Робинзона\n|100гр|30р|");
                selectsal.setTextSize(15);
                selectsal.setTextColor(Color.BLACK);
                break;

            case e1:
                selectbev.setText("Компот из сухофруктов\n|200гр|13р|");
                selectbev.setTextSize(15);
                selectbev.setTextColor(Color.BLACK);
                break;
            case e2:
                selectbev.setText("Морс из свежих ягод\n|200гр|14р|");
                selectbev.setTextSize(15);
                selectbev.setTextColor(Color.BLACK);
                break;

            case f1:
                selectbak.setText("Кулебяка с картофелем\n|95гр|14р|");
                selectbak.setTextSize(15);
                selectbak.setTextColor(Color.BLACK);
                break;
            case f2:
                selectbak.setText("Булочка Устрица\n|80гр|23р|");
                selectbak.setTextSize(15);
                selectbak.setTextColor(Color.BLACK);
                break;
            case f3:
                selectbak.setText("Сосиска в тесте\n|100гр|30р|");
                selectbak.setTextSize(15);
                selectbak.setTextColor(Color.BLACK);
                break;
            case f4:
                selectbak.setText("Курник\n|120гр|23р|");
                selectbak.setTextSize(15);
                selectbak.setTextColor(Color.BLACK);
                break;
        }

        return super.onContextItemSelected(item);
    }
}