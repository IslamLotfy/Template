package com.islam.template.view.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.google.zxing.Result
import com.islam.template.R
import kotlinx.android.synthetic.main.activity_simple_scanner.*
import me.dm7.barcodescanner.zxing.ZXingScannerView


class SimpleScannerActivity : Activity(), ZXingScannerView.ResultHandler {
    public override fun onCreate(state: Bundle?) {
        super.onCreate(state)
//        mScannerView = ZXingScannerView(this) // Programmatically initialize the scanner view
        setContentView(R.layout.activity_simple_scanner)

    }

    public override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this) // Register ourselves as a handler for scan results.
        mScannerView!!.startCamera() // Start camera on resume
    }

    public override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera() // Stop camera on pause
    }

    override fun handleResult(rawResult: Result) { // Do something with the result here
        Log.e("scannneeer", rawResult.text) // Prints scan results
        Log.e(
            "scannneeer",
            rawResult.barcodeFormat.toString()
        ) // Prints the scan format (qrcode, pdf417 etc.)
        // If you would like to resume scanning, call this method below:
    }
}