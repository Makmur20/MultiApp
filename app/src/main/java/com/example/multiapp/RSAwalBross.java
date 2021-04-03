package com.example.multiapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross  extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listAction = new String[]{"Call Center",  "SMS Center"
                , "Driving Direction", "Website", "Info Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listAction));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilahan(pilihan);

    }

    private void tampilkanpilahan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String nomortelpon = "tel:0813532453";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortelpon));

            } else if (pilihan.equals("SMS Center")){
                String smsText = "Makmur Mulyono";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:0813767533"));
                a.putExtra("sms_body", smsText);

            } else if (pilihan.equals("Driving Direction")) {
                String lokasirs ="https://www.google.com/maps/dir//lokasi+rumah+sakit+awal+bros+riau+pekanbaru/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x31d5aea46b46e5f1:0xdbacb5fecaf89643?sa=X&ved=2ahUKEwjXyvjwjuHvAhUzmuYKHcGGB64Q9RcwAHoECAgQBQ";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")) {
                String website = "http://awalbros.com/branch/pekanbaru/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            } else if (pilihan.equals("Info Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah sakit Awal Bros");

        }else if (pilihan.equals("Exit")){

            }
            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}