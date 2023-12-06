package com.nguyenquochuy.duanmobile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class docCauHoiDe {
    public docCauHoiDe(){

    }
    public String noidung;
    public String DA1;
    public String DA2;
    public String DA3;

    public String DA4;

    public String DA;
    public docCauHoiDe(String noidung, String DA1, String DA2, String DA3, String DA4, String DA) {
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

    public static List<docCauHoiDe> layDSCauHoiDe() {
        String fileName = "D:\\Hoc_tap\\AndroidPrograms\\63CLC1-MobileDev\\DuAnMobile\\app\\src\\main\\java\\com\\nguyenquochuy\\ddscauhoide.txt";
        List<docCauHoiDe> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            docCauHoiDe item = new docCauHoiDe();
            while ((item.noidung = br.readLine()) != null) {
                item.DA1=br.readLine();
                item.DA2=br.readLine();
                item.DA3=br.readLine();
                item.DA4=br.readLine();
                item.DA=br.readLine();
                list.add(new docCauHoiDe(item.noidung,item.DA1,item.DA2,item.DA3,item.DA4,item.DA));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
