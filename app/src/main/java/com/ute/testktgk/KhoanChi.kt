package com.ute.testktgk

import java.io.Serializable

class KhoanChi(
    var maKhoanChi_226: String,
    var tenKhoanChi_226: String,
    var soTien_226: Double,
    var ghiChu_226: String,
    var daThanhToan_226: Boolean = false
) : Serializable {

    // Ham tra ve chuoi mo ta khoan chi - 226
    fun layThongTin_226(): String {
        val trangThai_226 = if (daThanhToan_226) "Da thanh toan" else "Chua thanh toan"
        return "Ma: $maKhoanChi_226 | Ten: $tenKhoanChi_226 | So tien: $soTien_226 VND | Ghi chu: $ghiChu_226 | Trang thai: $trangThai_226"
    }

    // Ham kiem tra so tien hop le (> 0) - 226
    fun laSoTienHopLe_226(): Boolean {
        return soTien_226 > 0
    }
}