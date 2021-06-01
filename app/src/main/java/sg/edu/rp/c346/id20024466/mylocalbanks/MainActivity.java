package sg.edu.rp.c346.id20024466.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title;
    Button btnOcbc;
    Button btnDbs;
    Button btnUob;
    TextView description;

    String bankname = "";
    String link = "";
    String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.tvtitle);
        btnDbs = findViewById(R.id.btndbs);
        btnOcbc = findViewById(R.id.btnocbc);
        btnUob = findViewById(R.id.btnuob);
        description = findViewById(R.id.tvdescription);

        registerForContextMenu(btnDbs);
        registerForContextMenu(btnOcbc);
        registerForContextMenu(btnUob);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_hold, menu);

        if (v == btnDbs) {
            bankname = "DBS";
        } else if (v == btnOcbc) {
            bankname = "OCBC";
        } else if (v == btnUob) {
            bankname = "UOB";
        } else {
            bankname = "";
        }

        menu.setHeaderTitle(bankname + " is selected");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (bankname.equalsIgnoreCase("DBS")) {
            num = "18001111111";
            link = "https://www.dbs.com.sg";

        } else if (bankname.equalsIgnoreCase("UOB")) {
            num = "18002222121";
            link = "https://www.uob.com.sg";

        } else if (bankname.equalsIgnoreCase("OCBC")) {
            num = "18003633333";
            link = "https://www.ocbc.com";

        } else {
            num = "";
            link = "";
        }

        if (id == R.id.website) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(intent);
        } else if (id == R.id.contact) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(num));
            startActivity(intent);
        }

        if (id == R.id.favourite) {
            if (bankname.equalsIgnoreCase("DBS")) {
                btnDbs.setTextColor(Color.RED);
            }
            if (bankname.equalsIgnoreCase("OCBC")) {
                btnOcbc.setTextColor(Color.RED);
            }
            if (bankname.equalsIgnoreCase("UOB")) {
                btnUob.setTextColor(Color.RED);
            }
        } else if (id == R.id.unfavourite) {
            if (bankname.equalsIgnoreCase("DBS")) {
                btnDbs.setTextColor(Color.WHITE);
            }
            if (bankname.equalsIgnoreCase("OCBC")) {
                btnOcbc.setTextColor(Color.WHITE);
            }
            if (bankname.equalsIgnoreCase("UOB")) {
                btnUob.setTextColor(Color.WHITE);
            }
        }
        return super.onContextItemSelected(item);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            btnDbs.setText(getString(R.string.dbs));
            btnOcbc.setText(getString(R.string.ocbc));
            btnUob.setText(getString(R.string.uob));
            title.setText(getString(R.string.title));
            description.setText(getString(R.string.description));

            Toast.makeText(MainActivity.this, "English Selected", Toast.LENGTH_SHORT).show();

            return true;
        } else if ((id == R.id.ChineseSelection)) {
            btnDbs.setText(getString(R.string.dbschi));
            btnOcbc.setText(getString(R.string.ocbcchi));
            btnUob.setText(getString(R.string.uobchi));
            title.setText(getString(R.string.titlechi));
            description.setText(getString(R.string.descriptionchi));

            Toast.makeText(MainActivity.this, "中文选中", Toast.LENGTH_SHORT).show();

            return true;
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
