import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

 public class MainActivity : AppCompatActivity() {
    private var listView: ListView? = null
    private var buttonCheckout: Button? = null
    private var cartItems: ArrayList<String>? = null
    private var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<ListView>(R.id.listView)
        buttonCheckout = findViewById<Button>(R.id.buttonCheckout)
        cartItems = ArrayList()
        adapter = ArrayAdapter<String>(
            this, R.layout.list_item, R.id.textViewListItem,
            cartItems!!
        )
        listView.setAdapter(adapter)

        // Simulating burger items being added to the cart
        listView.setOnItemClickListener(OnItemClickListener { adapterView: AdapterView<*>, view: View?, i: Int, l: Long ->
            val item = adapterView.getItemAtPosition(i).toString()
            cartItems!!.add(item)
            adapter!!.notifyDataSetChanged()
        })

        // Checkout button click listener
        buttonCheckout.setOnClickListener(View.OnClickListener { // Implement checkout logic here
            // For this example, let's just display a message
            displayCheckoutMessage()
        })
    }

    // Method to display checkout message (customize as needed)
    private fun displayCheckoutMessage() {
        val message = StringBuilder("Items in Cart:\n")
        for (item in cartItems!!) {
            message.append("- ").append(item).append("\n")
        }
        // Display your message (e.g., show in a dialog, toast, or logcat)
        // For example:
        // Toast.makeText(this, message.toString(), Toast.LENGTH_LONG).show();
    }
}