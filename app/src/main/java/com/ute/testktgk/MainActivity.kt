package com.ute.testktgk

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Khai bao bien giao dien voi hau to 226
    private lateinit var edtTenKhoanChi_226: EditText
    private lateinit var edtSoTien_226: EditText
    private lateinit var edtGhiChu_226: EditText
    private lateinit var btnThemKhoanChi_226: Button
    private lateinit var btnXemChiTiet_226: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cai dat tieu de ActionBar theo yeu cau de bai
        supportActionBar?.title = "Nguyen Quang Nhat - 2415053122226 - Quan ly chi tieu ca nhan"

        // Anh xa view
        anhXaView_226()

        // Xu ly su kien
        xuLySuKien_226()
    }

    private fun anhXaView_226() {
        edtTenKhoanChi_226 = findViewById(R.id.edtTenKhoanChi_226)
        edtSoTien_226 = findViewById(R.id.edtSoTien_226)
        edtGhiChu_226 = findViewById(R.id.edtGhiChu_226)
        btnThemKhoanChi_226 = findViewById(R.id.btnThemKhoanChi_226)
        btnXemChiTiet_226 = findViewById(R.id.btnXemChiTiet_226)

        // Du lieu mau ban dau (tranh trung lap voi sinh vien khac)
        edtTenKhoanChi_226.setText("Tien mua sach chuyen nganh Kotlin")
        edtSoTien_226.setText("226000")
        edtGhiChu_226.setText("Giao trinh hoc lap trinh di dong 24T2")
    }

    private fun xuLySuKien_226() {
        btnThemKhoanChi_226.setOnClickListener {
            val tenKhoanChi_226 = edtTenKhoanChi_226.text.toString().trim()
            val soTienChuoi_226 = edtSoTien_226.text.toString().trim()
            val ghiChu_226 = edtGhiChu_226.text.toString().trim()

            if (tenKhoanChi_226.isEmpty()) {
                Toast.makeText(this, "Ten khoan chi khong duoc de trong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val soTien_226 = soTienChuoi_226.toDoubleOrNull() ?: -1.0

            // Khoi tao doi tuong tu lop KhoanChi - 226
            val doiTuongKhoanChi_226 = KhoanChi(
                maKhoanChi_226 = "KC_226_" + System.currentTimeMillis().toString().takeLast(4),
                tenKhoanChi_226 = tenKhoanChi_226,
                soTien_226 = soTien_226,
                ghiChu_226 = ghiChu_226,
                daThanhToan_226 = false
            )

            // Su dung ham kiem tra so tien hop le tu lop KhoanChi
            if (!doiTuongKhoanChi_226.laSoTienHopLe_226()) {
                Toast.makeText(this, "So tien phai lon hon 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Su dung ham layThongTin tu lop KhoanChi de hien thi thong bao
            Toast.makeText(this, "Them thanh cong: ${doiTuongKhoanChi_226.layThongTin_226()}", Toast.LENGTH_LONG).show()
        }

        btnXemChiTiet_226.setOnClickListener {
            val tenKhoanChi_226 = edtTenKhoanChi_226.text.toString().trim()
            val soTienChuoi_226 = edtSoTien_226.text.toString().trim()
            val ghiChu_226 = edtGhiChu_226.text.toString().trim()

            val yDinh_226 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra("EXTRA_TEN_226", tenKhoanChi_226)
                putExtra("EXTRA_SO_TIEN_226", soTienChuoi_226)
                putExtra("EXTRA_GHI_CHU_226", ghiChu_226)
            }
            startActivity(yDinh_226)
        }
    }
}