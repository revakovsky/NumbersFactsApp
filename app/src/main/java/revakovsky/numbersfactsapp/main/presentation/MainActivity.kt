package revakovsky.numbersfactsapp.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import revakovsky.numbersfactsapp.R
import revakovsky.numbersfactsapp.numbers.presentation.NumbersFragment

class MainActivity : AppCompatActivity(), ShowFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) showFragment(NumbersFragment(), true)
    }

    override fun showFragment(fragment: Fragment, replaceFragment: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()

        if (replaceFragment) {
            transaction
                .replace(R.id.main_container, fragment)
        } else {
            transaction
                .add(R.id.main_container, fragment)
                .addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commit()
    }
}

interface ShowFragment {

    fun showFragment(fragment: Fragment, replaceFragment: Boolean)

    class Empty : ShowFragment {
        override fun showFragment(fragment: Fragment, replaceFragment: Boolean) = Unit
    }
}