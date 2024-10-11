package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Inisialisasi Spinner
        val city = resources.getStringArray(R.array.city)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, city
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun onRadioButtonClicked(view: View) {
        // Apakah tombol sudah diklik?
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked) // Layanan pengiriman hari yang sama
                displayToast(getString(R.string.same_day_messenger_service))

            R.id.nextday -> if (checked) // Pengiriman hari berikutnya
                displayToast(getString(R.string.next_day_ground_delivery))

            R.id.pickup -> if (checked) // Ambil sendiri
                displayToast(getString(R.string.pick_up))

            else -> {}
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
