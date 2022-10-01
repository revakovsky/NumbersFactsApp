package revakovsky.numbersfactsapp.numbers.presentation

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import revakovsky.numbersfactsapp.R
import revakovsky.numbersfactsapp.main.presentation.ShowFragment
import revakovsky.numbersfactsapp.numberdetails.presentation.NumberDetailsFragment

class NumbersFragment : Fragment() {

    private var fragmentCreator: ShowFragment = ShowFragment.Empty()

    lateinit var inputTextField: TextInputEditText
    lateinit var getNumberFactButton: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentCreator = context as ShowFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_numbers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE

        getNumberFactButton = view.findViewById(R.id.getNumberFactButton)
        inputTextField = view.findViewById(R.id.inputEditText)

        inputTextField.addTextChangedListener(watcher)

        getNumberFactButton.setOnClickListener {
            val numberDetailsFragment =
                NumberDetailsFragment.newInstance("some information about the number")
            fragmentCreator.showFragment(numberDetailsFragment, false)

        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentCreator = ShowFragment.Empty()
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            getNumberFactButton.isEnabled = inputTextField.text.toString().isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {}
    }

}