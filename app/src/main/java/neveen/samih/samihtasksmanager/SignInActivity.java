package neveen.samih.samihtasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {
  ///1.
    private TextInputEditText etEmail,etPassword;
    private Button btnSignIn,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //2.
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }

        });
    }

            private void validate()
            {
                boolean isOk=true;
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                if(email.length()==)
                {
                    etEmail.setError("enter email");
                }
                if (password.length()<8)
                {
                    etPassword.setError("password at least 8 letters");
                }
                if (isOk)
                {
                    signiningIn(email,password);
                }

    }

    private void signiningIn(String email, String password)
    {

    }
}