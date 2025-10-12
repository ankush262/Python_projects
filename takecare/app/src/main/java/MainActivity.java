

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create layout programmatically
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(24, 24, 24, 24);

        // Add a TextView
        TextView textView = new TextView(this);
        textView.setText("Toggle Switch");
        textView.setTextSize(18f);
        layout.addView(textView);

        // Add a Switch
        Switch switchButton = new Switch(this);
        switchButton.setTextOn("ON");
        switchButton.setTextOff("OFF");
        layout.addView(switchButton);

        // Handle switch toggle
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        isChecked ? "Switch is ON" : "Switch is OFF",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Set layout as content view
        setContentView(layout);
    }
}
