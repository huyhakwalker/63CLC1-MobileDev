package com.nguyenquochuy.mynewsqlprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sqLiteDatabase = openOrCreateDatabase("Sach.db",MODE_PRIVATE, null);
//        String sqlXoaBangNeuCo = "DROP TABLE IF EXISTS BOOKS;\n";
//        String sqlTaoBang = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY, BookName text, Page integer, Price Float, Description text)";
//        sqLiteDatabase.execSQL(sqlXoaBangNeuCo);
//        sqLiteDatabase.execSQL(sqlTaoBang);
//        sqLiteDatabase.execSQL("INSERT INTO BOOKS VALUES(1, 'Java', 100, 9.99, 'sách về java')");
//        sqLiteDatabase.execSQL("INSERT INTO BOOKS VALUES(2, 'Java', 99, 9.99, 'sách về python')");
//        sqLiteDatabase.execSQL("INSERT INTO BOOKS VALUES(3, 'Java', 98, 9.99, 'sách về rubi')");
//        sqLiteDatabase.execSQL("INSERT INTO BOOKS VALUES(4, 'Java', 97, 9.99, 'sách về c++')");
//        sqLiteDatabase.close();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBookNav = new Intent(getBaseContext(), BookMainActivity.class);
                startActivity(iBookNav);
            }
        });
    }
}