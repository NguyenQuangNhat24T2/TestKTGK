package com.ute.testktgk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var edtChinhSuaTen_226: EditText
    private lateinit var edtChinhSuaSoTien_226: EditText
    private lateinit var edtChinhSuaGhiChu_226: EditText
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
        btnLuuChinhSua_226 = findViewById(R.id.btnLuuChinhSua_226)
        btnHuyChinhSua_226 = findViewById(R.id.btnHuyChinhSua_226)
    }

    private fun hienThiDuLieuHienTai_226() {
        val tenHienTai_226 = intent.getStringExtra("EXTRA_TEN_226") ?: ""
        val soTienHienTai_226 = intent.getStringExtra("EXTRA_SO_TIEN_226") ?: ""
        val ghiChuHienTai_226 = intent.getStringExtra("EXTRA_GHI_CHU_226") ?: ""

        edtChinhSuaTen_226.setText(tenHienTai_226)
        edtChinhSuaSoTien_226.setText(soTienHienTai_226)
        edtChinhSuaGhiChu_226.setText(ghiChuHienTai_226)
    }

    private fun xuLySuK