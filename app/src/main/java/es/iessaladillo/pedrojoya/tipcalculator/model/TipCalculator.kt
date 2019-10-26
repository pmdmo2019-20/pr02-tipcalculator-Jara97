package es.iessaladillo.pedrojoya.tipcalculator.model

import kotlin.math.roundToInt


// TipCalculator class. Its constructor receives bill, percentage and diners


class TipCalculator {

    private var bill:Float=0f
    private var percentage:Float=0f
    private var  diners:Int=0

    constructor(bill:Float,percentage:Float,diners:Int){
        if(bill<0||percentage<0||diners<0){
            throw IllegalArgumentException("Params cant be negatives")
        }
        this.bill=bill
        this.percentage=percentage
        this.diners=diners

    }

    fun calculateTip(): Float {
        return bill*percentage/100
    }

    fun calculateTotal(): Float {
        return calculateTip()+bill
    }

    fun calculatePerDiner(): Float {
        if (diners==0){
            return 0f
        }
        return calculateTotal()/diners
    }

    fun calculatePerDinerRounded(): Float {
        var value:Float
        value=calculatePerDiner()
        value.roundToInt()
        value=Math.ceil(value.toDouble()).toFloat()
        return value
    }


}
