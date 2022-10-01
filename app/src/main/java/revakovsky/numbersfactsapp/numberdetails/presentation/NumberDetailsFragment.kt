package revakovsky.numbersfactsapp.numberdetails.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import revakovsky.numbersfactsapp.R

class NumberDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = requireArguments().getString(KEY)
        view.findViewById<TextView>(R.id.numberDetailsText).text = value
    }

    companion object {
        private const val KEY = "DETAILS"

        fun newInstance(value: String) = NumberDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, value)
            }
        }
    }
}