package com.nguyenquochuy.duanmobile;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class docCauHoiTB {
    public String noidung;
    public String DA1;
    public String DA2;
    public String DA3;

    public String DA4;

    public String DA;
    public docCauHoiTB(String noidung, String DA1, String DA2, String DA3, String DA4, String DA) {
        this.noidung = noidung;
        this.DA1 = DA1;
        this.DA2 = DA2;
        this.DA3 = DA3;
        this.DA4 = DA4;
        this.DA = DA;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getDA1() {
        return DA1;
    }

    public void setDA1(String DA1) {
        this.DA1 = DA1;
    }

    public String getDA2() {
        return DA2;
    }

    public void setDA2(String DA2) {
        this.DA2 = DA2;
    }

    public String getDA3() {
        return DA3;
    }

    public void setDA3(String DA3) {
        this.DA3 = DA3;
    }

    public String getDA4() {
        return DA4;
    }

    public void setDA4(String DA4) {
        this.DA4 = DA4;
    }

    public String getDA() {
        return DA;
    }

    public void setDA(String DA) {
        this.DA = DA;
    }

    public static List<docCauHoiTB> layDSCauHoiTB(Context context) {
        String fileName = "dscauhoitb.txt";
        List<docCauHoiTB> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(fileName);
            br = new BufferedReader(new InputStreamReader(inputStream));
            String noidung;
            while ((noidung = br.readLine()) != null) {
                String DA1 = br.readLine();
                String DA2 = br.readLine();
                String DA3 = br.readLine();
                String DA4 = br.readLine();
                String DA = br.readLine();
                list.add(new docCauHoiTB(noidung, DA1, DA2, DA3, DA4, DA));
            }
        } catch (FileNotFoundException e) {
            Log.e("FileError", "Không tìm thấy file: " + fileName, e);
        } catch (IOException e) {
            Log.e("IOError", "Lỗi khi đọc file: " + fileName, e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Log.e("IOError", "Lỗi khi đóng BufferedReader", ex);
            }
        }
        return list;
    }
}
