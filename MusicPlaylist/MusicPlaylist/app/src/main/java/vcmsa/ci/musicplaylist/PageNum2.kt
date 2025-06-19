package vcmsa.ci.musicplaylist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PageNum2 : AppCompatActivity() {


    var button1: Button? = null
    var output: TextView? = null
    var button2: Button? = null
    var output2: TextView? = null
    var button3: Button? = null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_num2)

        button1 = findViewById<View>(R.id.button1) as Button
        output = findViewById<View>(R.id.output) as TextView
        button2 = findViewById<View>(R.id.button2) as Button
        output2 = findViewById<View>(R.id.output2) as TextView
        button3 = findViewById<View>(R.id.button3) as Button

        button3!!.setOnClickListener {
            startActivity(Intent(this@PageNum2, MainActivity::class.java))
        }

        button1!!.setOnClickListener {
            output
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}