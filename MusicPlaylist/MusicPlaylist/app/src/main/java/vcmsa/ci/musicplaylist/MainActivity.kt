package vcmsa.ci.musicplaylist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    var songtitle: EditText? = null
    var artistname: EditText? = null
    var rating: EditText? = null
    var comment: EditText? = null
    var btaddplay: Button? = null
    var btnext: Button? = null
    var btexit: Button? = null

    var songtitle_ = arrayOf("Leave me", "Delima", "Paradise", "Country man" )
    var artistname_ = arrayOf("Donald.T", "Nemez", "ColdPlay", "Finto")
    var rating_ = arrayOf("1, 2, 3, 4, 5")
    var comment_ = arrayOf("Nice", "Good", "Bad", "Horrible")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        songtitle = findViewById<View>(R.id.songtitle) as EditText
        artistname = findViewById<View>(R.id.artistname) as EditText
        rating = findViewById<View>(R.id.rating) as EditText
        comment = findViewById<View>(R.id.comment) as EditText
        btaddplay = findViewById<View>(R.id.btaddplay) as Button
        btnext = findViewById<View>(R.id.btnext) as Button
        btexit = findViewById<View>(R.id.btexit) as Button

        // Set onClickListener for ExitButton

        btexit!!.setOnClickListener {
            finishAffinity()
        }
        btnext!!.setOnClickListener {
            startActivity(Intent(this@MainActivity, PageNum2::class.java))
        }
        btaddplay!!.setOnClickListener {
            val songtitle = songtitle_.size.toString()
            val artistname = artistname_.size.toString()
            val rating = rating_.size.toString()
            val comment = comment_.size.toString()

            if (songtitle.isEmpty()||artistname_.isEmpty()||rating_.isEmpty()||comment_.isEmpty()){
                Toast.makeText(this,"Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rating_ = rating.toInt()
            if (rating_ <=0){
                Toast.makeText(this, "Enter valid rating", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()

        }








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}