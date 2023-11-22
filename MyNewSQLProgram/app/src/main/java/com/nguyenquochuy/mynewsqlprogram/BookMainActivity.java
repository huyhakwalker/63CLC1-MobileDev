package com.nguyenquochuy.mynewsqlprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookMainActivity extends AppCompatActivity {

    SQLiteDatabase bookBD;
    Cursor cs;
    Button btnf, btnp, btnl, btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_main);
        bookBD = openOrCreateDatabase("Sach.db",MODE_PRIVATE, null);
        cs = bookBD.rawQuery("SELECT * FROM BOOKS", null);
        cs.moveToFirst();
        getWidget();
        btnf.setOnClickListener(xuLyFirst);
        btnf.setOnClickListener(xuLyNext);
    }
    void getWidget(){
        btnf = findViewById(R.id.first);
        btnp = findViewById(R.id.previous);
        btnl = findViewById(R.id.last);
        btnn = findViewById(R.id.next);
    }
    View.OnClickListener xuLyFirst = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cs.moveToFirst();
            //Lay du lieu, dat len cac dieu khien
            int ID = cs.getInt(0) ;
            String name  =cs.getString(1) ;
            int numPage = cs.getInt(2) ;
            float price = cs.getInt(3) ;
            String des= cs.getString(4);
            TextView tvID  = findViewById(R.id.tvBookId);
            TextView tvName  = findViewById(R.id.tvBookName);
            TextView tvPage  = findViewById(R.id.tvBookPage);
            TextView tvPrice  = findViewById(R.id.tvBookPrice);
            TextView tvDes  = findViewById(R.id.tvBookDes);
            tvID.setText( String.valueOf(ID) );
            tvName.setText(name);
            tvPage.setText(String.valueOf(numPage) );
            tvPrice.setText( String.valueOf(price) );
            tvDes.setText( des );


        }
    } ;
    void capNhatView() {
        //Lay du lieu, dat len cac dieu khien
        int ID = cs.getInt(0) ;
        String name  =cs.getString(1) ;
        int numPage = cs.getInt(2) ;
        float price = cs.getInt(3) ;
        String des= cs.getString(4);
        TextView tvID  = findViewById(R.id.tvBookId);
        TextView tvName  = findViewById(R.id.tvBookName);
        TextView tvPage  = findViewById(R.id.tvBookPage);
        TextView tvPrice  = findViewById(R.id.tvBookPrice);
        TextView tvDes  = findViewById(R.id.tvBookDes);
        tvID.setText( String.valueOf(ID) );
        tvName.setText(name);
        tvPage.setText(String.valueOf(numPage) );
        tvPrice.setText( String.valueOf(price) );
        tvDes.setText( des );
    }
    View.OnClickListener xuLyNext = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cs.moveToNext();
            //Lay du lieu, dat len cac dieu khien
            capNhatView();
        }
    };
}