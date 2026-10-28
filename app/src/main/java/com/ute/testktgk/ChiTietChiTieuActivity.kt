package com.ute.testktgk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvHienThiTen_226: TextView
    private lateinit var tvHienThiSoTien_226: TextView
    private lateinit var tvHienThiGhiChu_226: TextView
    private lateinit var tvHienThiTrangThai_226: TextView
    private lateinit var btnQuayLai_226: Button
    private lateinit var btnChinhSua_226: Button

    private var tenHienTai_226: String = ""
    private var soTienHienTai_226: String = ""
    private var ghiChuHienTai_226: String = ""
    private var daThanhToanHienTai_226: Boolean = false

    private val trinhNhanKetQua_226 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua_226 ->
        if (ketQua_226.resultCode == Activity.RESULT_OK) {
            val duLieuTraVe_226 = ketQua_226.data
            tenHienTai_226 = duLieuTraVe_226?.getStringExtra("RESULT_TEN_226") ?: tenHienTai_226
            soTienHienTai_226 = duLieuTraVe_226?.getStringExtra("RESULT_SO_TIEN_226") ?: soTienHienTai_226
            ghiChuHienTai_226 = duLieuTraVe_226?.getStringExtra("RESULT_GHI_CHU_226") ?: ghiChuHienTai_226
            daThanhToanHienTai_226 = duLieuTraVe_226?.getBooleanExtra("RESULT_DA_THANH_TOAN_226", false) ?: false

            capNhatGiaoDien_226()
            Toast.makeText(this, "Cap nhat khoan chi thanh cong", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Da huy chinh sua", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Nguyen Quang Nhat - 2415053122226 - Quan ly chi tieu ca nhan"

        anhXaView_226()
        khoiTaoDuLieu_226()
        xuLySuKien_226()
    }

    private fun anhXaView_226() {
        tvHienThiTen_226 = findViewById(R.id.tvHienThiTen_226)
        tvHienThiSoTien_226 = findViewById(R.id.tvHienThiSoTien_226)
        tvHienThiGhiChu_226 = findViewById(R.id.tvHienThiGhiChu_226)
        tvHienThiTrangThai_226 = findViewById(R.id.tvHienThiTrangThai_226)
        btnQuayLai_226 = findViewById(R.id.btnQuayLai_226)
        btnChinhSua_226 = findViewById(R.id.btnChinhSua_226)
    }

    private fun khoiTaoDuLieu_226() {
        tenHienTai_226 = intent.getStringExtra("EXTRA_TEN_226")?.trim() ?: ""
        soTienHienTai_226 = intent.getStringExtra("EXTRA_SO_TIEN_226")?.trim() ?: ""
        ghiChuHienTai_226 = intent.getStringExtra("EXTRA_GHI_CHU_226")?.trim() ?: ""
        daThanhToanHienTai_226 = intent.getBooleanExtra("EXTRA_DA_THANH_TOAN_226", false)

        capNhatGiaoDien_226()
    }

    private fun capNhatGiaoDien_226() {
        if (tenHienTai_226.isEmpty()) {
            tvHienThiTen_226.text = "Ten khoan chi: [Khong hop le / De trong]"
        } else {
            tvHienThiTen_226.text = "Ten khoan chi: $tenHienTai_226"
        }

        val soTien_226 = soTienHienTai_226.toDoubleOrNull()
        if (soTien_226 == null || soTien_226 <= 0) {
            tvHienThiSoTien_226.text = "So tien: [So tien khong hop le]"
        } else {
            tvHienThiSoTien_226.text = "So tien: $soTienHienTai_226 VND"
        }

        if (ghiChuHienTai_226.isEmpty()) {
            tvHienThiGhiChu_226.text = "Ghi chu: [Khong co ghi chu]"
        } else {
            tvHienThiGhiChu_226.text = "Ghi chu: $ghiChuHienTai_226"
        }

        val trangThai_226 = if (daThanhToanHienTai_226) "Da thanh toan" else "Chua thanh toan"
        tvHienThiTrangThai_226.text = "Trang thai: $trangThai_226"
    }

    private fun xuLySuKien_226() {
        btnQuayLai_226.setOnClickListener {
            finish()
        }

        btnChinhSua_226.setOnClickListener {
            val yDinhChinhSua_226 = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
                putExtra("EXTRA_TEN_226", tenHienTai_226)
                putExtra("EXTRA_SO_TIEN_226", soTienHienTai_226)
                putExtra("EXTRA_GHI_CHU_226", ghiChuHienTai_226)
                putExtra("EXTRA_DA_THANH_TOAN_226", daThanhToanHienTai_226)
            }
            trinhNhanKetQua_226.launch(yDinhChinhSua_226)
        }
    }
}