package baitap.cnttk13.qlthuvien;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangnhap extends AppCompatActivity {

    EditText tendn,mkdn;
    Button dangnhap,dangky,thoatdn;
    String tentk,matkhautk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        khaibao();
        ControlButton();

    }
    private void ControlButton(){
        thoatdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(dangnhap.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông báo !");
                builder.setMessage("Bạn có muốn thoát app ?");
                builder.setIcon(R.drawable.canhbao);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        /*dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(dangnhap.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_dangky);
                EditText edtTK =(EditText)dialog.findViewById(R.id.tendn);
                EditText edtMK =(EditText)dialog.findViewById(R.id.mkdn);
                Button btnHuy=(Button)dialog.findViewById(R.id.thoatdn);
                Button btnDongY=(Button)dialog.findViewById(R.id.dangky);
                btnDongY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tentk=edtTK.getText().toString().trim();
                        matkhautk=edtMK.getText().toString().trim();
                        tendn.setText(tentk);
                        mkdn.setText(matkhautk);
                        Toast.makeText(dangnhap.this,"Đăng ký thành công!",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });*/
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tentk=tendn.getText().toString().trim();
                if(tendn.getText().length()!=0 && mkdn.getText().length()!=0){
                    if(tendn.getText().toString().equals(tentk) && mkdn.getText().toString().equals(matkhautk)){
                        Toast.makeText(dangnhap.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(dangnhap.this,giaodien.class);
                        startActivity(intent);

                    }
                    else if(tendn.getText().toString().equals("admin")&& mkdn.getText().toString().equals("123456")){
                        Toast.makeText(dangnhap.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(dangnhap.this,giaodien.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(dangnhap.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    Toast.makeText(dangnhap.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private void khaibao(){
        tendn =(EditText)findViewById(R.id.tendn);
        mkdn =(EditText)findViewById(R.id.mkdn);
        dangnhap=(Button)findViewById(R.id.dangnhap);
        dangky=(Button)findViewById(R.id.dangky);
        thoatdn=(Button)findViewById(R.id.thoatdn);
    }

}
