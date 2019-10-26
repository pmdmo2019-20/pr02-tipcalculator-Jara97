package es.iessaladillo.pedrojoya.tipcalculator.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.tipcalculator.R
import es.iessaladillo.pedrojoya.tipcalculator.model.TipCalculator
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class MainActivity : AppCompatActivity() {
    lateinit var tipcalculator:TipCalculator
    lateinit var formato:DecimalFormat
    lateinit var separador:DecimalFormatSymbols


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFormaters()
        setListeners()
    }

    private fun setFormaters() {
        separador=DecimalFormatSymbols()
        separador.decimalSeparator = '.'
        formato=DecimalFormat("#0.00",separador)
    }

    private fun setListeners() {
        txtBill.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                defaultValues()
                var tipcalculator= TipCalculator(txtBill.text.toString().toFloat(),txtPercentage.text.toString().toFloat(),txtDiners.text.toString().toInt())

                txtTip2.setText(formato.format(tipcalculator.calculateTip()))
                txtTotal.setText(formato.format(tipcalculator.calculateTotal()))
                txtDiner.setText(formato.format(tipcalculator.calculatePerDiner()))
                txtPerDinerRounded.setText(formato.format(tipcalculator.calculatePerDinerRounded()))
            }
        })

        txtPercentage.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                defaultValues()
                var tipcalculator= TipCalculator(txtBill.text.toString().toFloat(),txtPercentage.text.toString().toFloat(),txtDiners.text.toString().toInt())
                txtTip2.setText(formato.format(tipcalculator.calculateTip()))
                txtTotal.setText(formato.format(tipcalculator.calculateTotal()))
                txtDiner.setText(formato.format(tipcalculator.calculatePerDiner()))
                txtPerDinerRounded.setText(formato.format(tipcalculator.calculatePerDinerRounded()))
            }
        })

        txtDiners.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                defaultValues()
                var tipcalculator= TipCalculator(txtBill.text.toString().toFloat(),txtPercentage.text.toString().toFloat(),txtDiners.text.toString().toInt())
                txtDiner.setText(formato.format(tipcalculator.calculatePerDiner()))
                txtPerDinerRounded.setText(formato.format(tipcalculator.calculatePerDinerRounded()))
            }
        })

        btnResetTip.setOnClickListener { reset() }
        btnResetDiners.setOnClickListener { reset2() }
    }

    private fun defaultValues() {
        if (txtDiners.text.toString() == "") {
            txtDiners.setText("1")
        }
        if (txtBill.text.toString() == "") {
            txtBill.setText("0.00")
        }
        if (txtPercentage.text.toString() == "") {
            txtPercentage.setText("10.00")
        }
    }

    private fun reset() {
        txtBill.setText("0.00")
        txtPercentage.setText("10.00")
        txtBill.requestFocus()
    }

    private fun reset2(){
        txtDiners.setText("1")
        txtDiners.requestFocus()
    }
    // TODO

}
