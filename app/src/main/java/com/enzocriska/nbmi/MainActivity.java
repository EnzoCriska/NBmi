package com.enzocriska.nbmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edCao, edNang;
    Button btTinh, btDatlai;
    TextView tvChiso, tvTrangthai;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCao = (EditText)findViewById(R.id.editCao);
        edNang = (EditText)findViewById(R.id.editNang);
        btTinh = (Button) findViewById(R.id.buttonTinh);
        btDatlai = (Button)findViewById(R.id.buttonDatlai);
        tvChiso = (TextView)findViewById(R.id.textViewChiso);
        tvTrangthai = (TextView)findViewById(R.id.textViewTrangthai);

        btTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float cao, nang;
                float BMI;

                String ccao = edCao.getText().toString();
                String cnang = edNang.getText().toString();
                if (ccao.isEmpty() || cnang.isEmpty()){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập đủ số!", Toast.LENGTH_LONG).show();
                }
                else {

                    cao = Float.parseFloat(ccao);
                    nang = Float.parseFloat(cnang);
                    BMI = nang / (cao*cao);
                    tvChiso.setText(String.valueOf(BMI));
                    if (BMI<=18.5) tvTrangthai.setText("Quá gầy, ăn thêm nhiều vào.");
                    if ((BMI >18.5) && (BMI <=25)) tvTrangthai.setText("Thật lý tưởng.");
                    if ((25<BMI) && (BMI <= 30)) tvTrangthai.setText("Bạn đang thừa cân đấy.");
                    if ((30<BMI) && (BMI <= 40)) tvTrangthai.setText("Bạn đang béo, giảm cân thôi.");
                    if (BMI >40) tvTrangthai.setText("Bạn quá béo rồi.");
                }
                

            }
        });

        btDatlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edCao.setText("");
                edNang.setText("");
                tvChiso.setText("");
                tvTrangthai.setText("");

            }
        });
    }
}
