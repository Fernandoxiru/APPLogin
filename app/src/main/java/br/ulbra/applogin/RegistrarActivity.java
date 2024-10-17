package br.ulbra.applogin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {
    private EditText ednome, edlogin, edsenha, edsenha2;
    private Button btsalvar;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_usuario);

        db = new DBHelper(this);

        ednome = findViewById(R.id.ednome);
        edlogin = findViewById(R.id.edlogin);
        edsenha = findViewById(R.id.edsenha);
        edsenha2 = findViewById(R.id.edsenha2);
        btsalvar = findViewById(R.id.btsalvar);

        btsalvar.setOnClickListener(view -> {
            String userName = edlogin.getText().toString().trim();
            String password1 = edsenha.getText().toString().trim();
            String password2 = edsenha2.getText().toString().trim();

            if (userName.equals("")) {
                Toast.makeText(RegistrarActivity.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
            } else if (edsenha.equals("") || edsenha2.equals("")) {
                Toast.makeText(RegistrarActivity.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
            } else if (!edsenha.equals(edsenha2)) {
                Toast.makeText(RegistrarActivity.this, "As senhas não correspondem ao login do usuário", Toast.LENGTH_SHORT).show();
            } else {
                long res = db.criarUtilizador(userName, password1);
                if (res > 0) {
                    Toast.makeText(RegistrarActivity.this, "Resgistro OK", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrarActivity.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



