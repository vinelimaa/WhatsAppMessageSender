package com.example.whatsappmessagesender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutPrefix;
    private TextInputLayout inputLayoutTel;
    private TextInputLayout inputLayoutMsg;

    private TextInputEditText inputEditPrefix;
    private TextInputEditText inputEditTel;
    private TextInputEditText inputEditMsg;

    private Button buttonSendMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutPrefix = findViewById(R.id.input_layout_prefix);
        inputLayoutTel = findViewById(R.id.input_layout_tel);
        inputLayoutMsg = findViewById(R.id.input_layout_msg);

        inputEditPrefix = findViewById(R.id.input_edit_prefix);
        inputEditTel = findViewById(R.id.input_edit_tel);
        inputEditMsg = findViewById(R.id.input_edit_msg);

        buttonSendMsg = findViewById(R.id.button_submit);

        buttonSendMsg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendMsg();
                    }
                }
        );
    }
    private void sendMsg() {

        String prefix = inputEditPrefix.getText().toString().trim();
        String tel = inputEditTel.getText().toString().trim();
        String msg = inputEditMsg.getText().toString();

        if(tel.isEmpty()) {
            inputEditTel.setError("Favor preencher o campo");
            return;
        }
        if(msg.isEmpty()) {
            inputEditMsg.setError("Favor preencher o campo");
            return;
        }

        Uri webpage = Uri.parse("https://wa.me/" + prefix + tel +"?text=" + msg);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);

    }
}