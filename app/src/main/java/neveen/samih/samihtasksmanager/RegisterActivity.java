package neveen.samih.samihtasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText etEmail,etPassword, etRePassword,etFullname,etPhone;
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
        etPhone=findViewById(R.id.etPhone);


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
        String phone =etPhone.getText().toString();

       if(email.length()<5 || email.indexOf('@')<=0)
       {
           etEmail.setError("wrong email syntax");
           isOk=false;
       }
       if(phone.length()<10 || phone.length()>10)
       {
           etPhone.setError("wrong phone number");
           isOk=false;
       }

       if(pass1.length()<8)
       {
           etPassword.setError("at least 8 chars");
           isOk=false;
       }

       if(pass1.equals(pass2)==false)
       {
           etRePassword.setError("not equal password");
           isOk=false;
       }
       if(name.length()==0)
       {
           etFullname.setError("must to enter full name");
           isOk=false;
       }

       if(isOk)// isok=true
       {

           createAccount(email,pass1);
       }

    }

    private void createAccount(String email, String pass1)
    {

    }


}