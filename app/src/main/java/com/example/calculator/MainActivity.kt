package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var answerview: TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        answerview=findViewById(R.id.resultArea)
        setContentView(R.layout.activity_main)
        val btnequal: Button=findViewById(R.id.equals)
        val btn1: Button=findViewById(R.id.num1)
        val btn2: Button=findViewById(R.id.num2)
        val btn3: Button=findViewById(R.id.num3)
        val btn4: Button=findViewById(R.id.num4)
        val btn5: Button=findViewById(R.id.num5)
        val btn6: Button=findViewById(R.id.num6)
        val btn7: Button=findViewById(R.id.num7)
        val btn8: Button=findViewById(R.id.num8)
        val btn9: Button=findViewById(R.id.num9)
        val btn0: Button=findViewById(R.id.num0)
        val btndecimal: Button=findViewById(R.id.decimal)
        val btnmultiplu: Button=findViewById(R.id.multiply)
        val btndivide: Button=findViewById(R.id.divide)
        val btnadd: Button=findViewById(R.id.plus)
        val btnsub: Button=findViewById(R.id.minus)
        val btndel: Button=findViewById(R.id.del)
        val btncl: Button=findViewById(R.id.clear)
        btn0.setOnClickListener { onclick(btn0) }
        btn1.setOnClickListener { onclick(btn1) }
        btn2.setOnClickListener { onclick(btn2) }
        btn3.setOnClickListener { onclick(btn3) }
        btn4.setOnClickListener { onclick(btn4) }
        btn5.setOnClickListener { onclick(btn5) }
        btn6.setOnClickListener { onclick(btn6) }
        btn7.setOnClickListener { onclick(btn7) }
        btn8.setOnClickListener { onclick(btn8) }
        btn9.setOnClickListener { onclick(btn9) }
        btndecimal.setOnClickListener { onclick(btndecimal) }
        btnmultiplu.setOnClickListener { onclick(btnmultiplu) }
        btndivide.setOnClickListener { onclick(btndivide) }
        btnadd.setOnClickListener { onclick(btnadd) }
        btnsub.setOnClickListener { onclick(btnsub) }
        btndel.setOnClickListener { answerview?.text=del(answerview?.text.toString()) }
        btncl.setOnClickListener { answerview?.text= cl(answerview?.text.toString())}
        btnequal.setOnClickListener { onclick(btnequal)
        answerview?.text=finalanswer(answerview?.text.toString())
        }
    }
    fun onclick(view: View){ // this means it will take any view as parameter
        answerview=findViewById(R.id.resultArea)
    answerview?.append((view as Button).text) // this will make sure that view is button and it's text is appended in text view
    }

    fun multiply(str1: String): String {
        var str1 = str1
        var f =0f
        var j = 0
        var i = 1
        while (i <= str1.length) {
            var internal = str1.substring(j, i)
            if (internal.contains("+")) {
                j = i
            }
            if (internal.contains("X")) {
                val meds = j
                var mede = 1
                f = internal.substring(0, internal.length - 1).toFloat()
                j = i
                var inter = 1f
                for (k in i..str1.length) {
                    internal = str1.substring(j, k)
                    if (internal.contains("+") || internal.contains("-") || internal.contains("X") || internal.contains(
                            "="
                        )
                    ) {
                        inter = internal.substring(0, internal.length - 1).toFloat()
                        mede = k - 1
                        j = k
                        break
                    }
                }
                i = j
                f = f * inter
                str1 = str1.replace(str1.substring(meds, mede), f.toString())
                str1 = multiply(str1)
            }
            if (internal.contains("/")) {
                if (f == 0f) {
                    f = 1f
                }
                f /= internal.substring(0, internal.length - 1).toFloat()
                j = i
            }
            if (internal.contains("-")) {
                j = i
            }
            i++
        }
        return str1
    }

    fun divide(str1: String): String {
        var str1 = str1
        var f = 0f
        var j = 0
        var i = 1
        while (i <= str1.length) {
            var internal = str1.substring(j, i)
            if (internal.contains("+")) {
                j = i
            }
            if (internal.contains("/")) {
                val meds = j
                var mede = 1
                f = internal.substring(0, internal.length - 1).toFloat()
                j = i
                var inter = 1f
                for (k in i..str1.length) {
                    internal = str1.substring(j, k)
                    if (internal.contains("+") || internal.contains("-") || internal.contains("X") || internal.contains(
                            "="
                        ) || internal.contains("/")
                    ) {
                        inter = internal.substring(0, internal.length - 1).toFloat()
                        mede = k - 1
                        j = k
                        break
                    }
                }
                i = j
                f = f / inter
                str1 = str1.replace(str1.substring(meds, mede), f.toString())
                str1 = divide(str1)
            }
            if (internal.contains("X")) {
                j = i
            }
            if (internal.contains("-")) {
                j = i
            }
            i++
        }
        return str1
    }

    fun add(str1: String): String {
        var str1 = str1
        var f = 0f
        var j = 0
        var i = 1
        while (i <= str1.length) {
            var internal = str1.substring(j, i)
            if (internal.contains("+")) {
                val meds = j
                var mede = 1
                f = internal.substring(0, internal.length - 1).toFloat()
                j = i
                var inter = 1f
                for (k in i..str1.length) {
                    internal = str1.substring(j, k)
                    if (internal.contains("+") || internal.contains("-") || internal.contains("X") || internal.contains(
                            "="
                        )
                    ) {
                        inter = internal.substring(0, internal.length - 1).toFloat()
                        mede = k - 1
                        j = k
                        break
                    }
                }
                i = j
                f = f + inter
                str1 = str1.replace(str1.substring(meds, mede), f.toString())
                str1 = add(str1)
            }
            if (internal.contains("-")) {
                j = i
            }
            i++
        }
        return str1
    }

    fun sub(str1: String): String {
        var str1 = str1
        var f = 0f
        var j = 0
        var i = 1
        while (i <= str1.length) {
            var internal = str1.substring(j, i)
            if (internal.contains("-")) {
                val meds = j
                var mede = 1
                f = internal.substring(0, internal.length - 1).toFloat()
                j = i
                var inter = 1f
                for (k in i..str1.length) {
                    internal = str1.substring(j, k)
                    if (internal.contains("+") || internal.contains("-") || internal.contains("X") || internal.contains(
                            "="
                        )
                    ) {
                        inter = internal.substring(0, internal.length - 1).toFloat()
                        mede = k - 1
                        j = k
                        break
                    }
                }
                i = j
                f = f - inter
                str1 = str1.replace(str1.substring(meds, mede), f.toString())
                str1 = sub(str1)
            }
            i++
        }
        return str1
    }

    fun finalanswer(str1: String): String? {
        var str1 = str1
        str1 = divide(str1)
        str1 = multiply(str1)
        str1 = add(str1)
        str1 = sub(str1)
        str1 = str1.replace("=", "")
        return str1
    }
    fun del(str1: String): String? {
        var str1 = str1
        str1 = str1.replace(str1[str1.length - 1].toString(), "")
        return str1
    }
    fun cl(str: String): String?{
        var str=str
        str=str.replace(str.substring(0,str.length),"")
        return str
    }
}