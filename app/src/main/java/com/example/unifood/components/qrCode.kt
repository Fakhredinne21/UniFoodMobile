package com.example.unifood.components

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix

@Throws(WriterException::class)
fun textToQRCode(text: String, width: Int, height: Int): Bitmap {
    val bitMatrix: BitMatrix
    try {
        bitMatrix = MultiFormatWriter().encode(
            text,
            BarcodeFormat.QR_CODE,
            width, height, null
        )
    } catch (Illegalargumentexception: IllegalArgumentException) {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565)
    }

    val bitMatrixWidth = bitMatrix.width
    val bitMatrixHeight = bitMatrix.height
    val pixels = IntArray(bitMatrixWidth * bitMatrixHeight)

    for (y in 0 until bitMatrixHeight) {
        val offset = y * bitMatrixWidth
        for (x in 0 until bitMatrixWidth) {
            pixels[offset + x] = if (bitMatrix[x, y]) -0x1000000 else -0x1
        }
    }

    val bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.RGB_565)
    bitmap.setPixels(pixels, 0, width, 0, 0, bitMatrixWidth, bitMatrixHeight)
    return bitmap
}