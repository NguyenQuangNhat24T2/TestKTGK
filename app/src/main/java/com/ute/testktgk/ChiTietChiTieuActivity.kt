package com.ute.testktgk

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvHienThiTen_226: TextView
    private lateinit var tvHienThiSoTien_226: TextView
    private lateinit var tvHienThiGhiChu_226: TextView
    private lateinit var btnQuayLai_226: Button
    private lateinit var btnChinhSua_226: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Nguyen Quang Nhat - 2415053122226 - Quan ly chi tieu ca nhan"

        anhXaView_226()
        nhanVaHienThiDuLieu_226()
        xuLySuKien_226()
    }

    private fun anhXaView_226() {
        tvHienThiTen_226 = findViewById(R.id.tvHienThiTen_226)
        tvHienThiSoTien_226 = findViewById(R.id.tvHienThiSoTien_226)
        tvHienThiGhiChu_226 = findViewById(R.id.tvHienThiGhiChu_226)
        btnQuayLai_226 = findViewById(R.id.btnQuayLai_226)
        btnChinhSua_226 = findViewById(R.id.btnChinhSua_226)
    }

    private fun nhanVaHienThiDuLieu_226() {
        val ten_226 = intent.getStringExtra("EXTRA_TEN_226") ?: ""
        val soTienChuoi_226 = intent.getStringExtra("EXTRA_SO_TIEN_226") ?: ""
        val ghiChu_226 = intent.getStringExtra("EXTRA_GHI_CHU_226") ?: ""

        tvHienThiTen_226.text = "Ten khoan chi: $ten_226"
        tvHienThiSoTien_226.text = "So tien: $soTienChuoi_226 VND"
        tvHienThiGhiChu_226.text = "Ghi chu: $ghiChu_226"
    }

    private fun xuLySuKien_226() {
        // Nut quay lai man hinh chinh
        btnQuayLai_226.setOnClickListener {
            finish()
        }
    }
}