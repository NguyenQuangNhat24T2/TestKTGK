package com.ute.testktgk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var edtChinhSuaTen_226: EditText
    private lateinit var edtChinhSuaSoTien_226: EditText
    private lateinit var edtChinhSuaGhiChu_226: EditText
    private lateinit var cbDaThanhToan_226: CheckBox
    private lateinit var btnLuuChinhSua_226: Button
    private lateinit var btnHuyChinhSua_226: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_chi_tieu)

        supportActionBar?.title = "Nguyen Quang Nhat - 2415053122226 - Quan ly chi tieu ca nhan"

        anhXaView_226()
        hienThiDuLieuHienTai_226()
        xuLySuKien_226()
    }

    private fun anhXaView_226() {
        edtChinhSuaTen_226 = findViewById(R.id.edtChinhSuaTen_226)
        edtChinhSuaSoTien_226 = findViewById(R.id.edtChinhSuaSoTien_226)
        edtChinhSuaGhiChu_226 = findViewById(R.id.edtChinhSuaGhiChu_226)
        cbDaThanhToan_226 = findViewById(R.id.cbDaThanhToan_226)
        btnLuuChinhSua_226 = findViewById(R.id.btnLuuChinhSua_226)
        btnHuyChinhSua_226 = findViewById(R.id.btnHuyChinhSua_226)
    }

    private fun hienThiDuLieuHienTai_226() {
        val tenHienTai_226 = intent.getStringExtra("EXTRA_TEN_226") ?: ""
        val soTienHienTai_226 = intent.getStringExtra("EXTRA_SO_TIEN_226") ?: ""
        val ghiChuHienTai_226 = intent.getStringExtra("EXTRA_GHI_CHU_226") ?: ""
        val daThanhToanHienTai_226 = intent.getBooleanExtra("EXTRA_DA_THANH_TOAN_226", false)

        edtChinhSuaTen_226.setText(tenHienTai_226)
        edtChinhSuaSoTien_226.setText(soTienHienTai_226)
        edtChinhSuaGhiChu_226.setText(ghiChuHienTai_226)
        cbDaThanhToan_226.isChecked = daThanhToanHienTai_226
    }

    private fun xuLySuKien_226() {
        btnLuuChinhSua_226.setOnClickListener {
            val tenMoi_226 = edtChinhSuaTen_226.text.toString().trim()
            val soTienMoi_226 = edtChinhSuaSoTien_226.text.toString().trim()
            val ghiChuMoi_226 = edtChinhSuaGhiChu_226.text.toString().trim()
            val daThanhToanMoi_226 = cbDaThanhToan_226.isChecked

            if (tenMoi_226.isEmpty()) {
                Toast.makeText(this, "Ten khoan chi khong duoc de trong hoac chua khoang trang", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val soTienKiemTra_226 = soTienMoi_226.toDoubleOrNull()
            if (soTienKiemTra_226 == null || soTienKiemTra_226 <= 0) {
                Toast.makeText(this, "So tien khong duoc bang 0, so am hoac khong hop le", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val yDinhKetQua_226 = Intent().apply {
                putExtra("RESULT_TEN_226", tenMoi_226)
                putExtra("RESULT_SO_TIEN_226", soTienMoi_226)
                putExtra("RESULT_GHI_CHU_226", ghiChuMoi_226)
                putExtra("RESULT_DA_THANH_TOAN_226", daThanhToanMoi_226)
            }
            setResult(Activity.RESULT_OK, yDinhKetQua_226)
            finish()
        }

        btnHuyChinhSua_226.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}