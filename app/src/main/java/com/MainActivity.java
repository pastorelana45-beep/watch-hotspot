
package com.watchhotspot;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(20, 20, 20, 20);
        layout.setBackgroundColor(Color.BLACK);

        TextView title = new TextView(this);
        title.setText("WATCH HOTSPOT");
        title.setTextColor(Color.WHITE);
        title.setTextSize(22);
        title.setGravity(Gravity.CENTER);

        TextView status = new TextView(this);
        status.setText("Galaxy Watch 8 LTE\n\nVerifica disponibilità hotspot");
        status.setTextColor(Color.WHITE);
        status.setTextSize(14);
        status.setGravity(Gravity.CENTER);

        Button button = new Button(this);
        button.setText("VERIFICA HOTSPOT");

        button.setOnClickListener(v -> {
            status.setText("Controlla le impostazioni Wi-Fi e connessione del tuo smartwatch.");
            try {
                startActivity(new android.content.Intent(
                    android.provider.Settings.ACTION_WIRELESS_SETTINGS
                ));
            } catch (Exception e) {
                status.setText("Impostazioni non disponibili.");
            }
        });

        layout.addView(title);
        layout.addView(status);
        layout.addView(button);

        setContentView(layout);
    }
}
