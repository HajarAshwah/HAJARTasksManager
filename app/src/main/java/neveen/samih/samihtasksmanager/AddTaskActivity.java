package neveen.samih.samihtasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class AddTaskActivity extends AppCompatActivity {

    private TextInputEditText etTitle,etSubject;
    private TextView tvImportance;
    private Spinner spnrImprotance;
    private SeekBar skbNecessity;
    private ImageButton imgvTaskPic;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle=findViewById(R.id.etTitle);
        etSubject=findViewById(R.id.etSubject);
        tvImportance=findViewById(R.id.tvImportance);
        spnrImprotance=findViewById(R.id.spnrImprotance);
        skbNecessity=findViewById(R.id.skbNecessity);
        imgvTaskPic=findViewById(R.id.imgvTaskPic);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }
    public void validate()
    {
        String title =etTitle.getText().toString();
        String subject =etSubject.getText().toString();
        int progress = skbNecessity.getProgress();
        String importance = spnrImprotance.getSelectedItem().toString();
        boolean isOk=true;
        if (title.length()==0)
        {
            etTitle.setError("must inter subject");
            isOk=false;
        }
        if (isOk)
        {

        }

    }
}