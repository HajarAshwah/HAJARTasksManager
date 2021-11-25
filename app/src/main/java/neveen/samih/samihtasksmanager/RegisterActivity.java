package neveen.samih.samihtasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText etEmail,etPassword, etRePassword,etFullname;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etRePassword=findViewById(R.id.etRePassword);
        etFullname=findViewById(R.id.etName);
        btnSave=findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void   validate() {
        boolean isOk= true;
        String email = etEmail.getText().toString();
        String pass1 = etPassword.getText().toString();
        String pass2 = etRePassword.getText().toString();
        String name = etFullname.getText().toString();



    }
}