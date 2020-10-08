package coding_academy.crinimalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class CrimeFragment: Fragment() {
   private lateinit var crime: Crime
   private lateinit var titleText: TextView
    private lateinit var dateButton: Button
  private  lateinit var solvedCheckBox: CheckBox

    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProviders.of(this).get(CrimeListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime=Crime()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return super.onCreateView(inflater, container, savedInstanceState)
        val view=inflater.inflate(R.layout.fragment_crime,container,false)
        titleText=view.findViewById(R.id.crime_title)as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }


        return view
    }
   override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {

            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
// This space intentionally left blank
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
// This one too
            }
        }
       titleText.addTextChangedListener(titleWatcher)

       solvedCheckBox.apply {
           setOnCheckedChangeListener { _, isChecked ->
           crime.isSolved = isChecked
       }
       }
   }


    }