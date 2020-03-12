package jp.noir.tomiyama.bottomsheetsample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "SeruSeruLand"
        setSupportActionBar(toolbar)

        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottom_sheet)

        behavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                Log.d("onSlide(bottomSheet)", bottomSheet.toString())
//                Log.d("onSlide(slideOffset)", slideOffset.toString())
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Log.d("現在の状態", "STATE_DRAGGING")
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        Log.d("現在の状態", "STATE_SETTLING")
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Log.d("現在の状態", "STATE_EXPANDED")
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        Log.d("現在の状態", "STATE_COLLAPSED")
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Log.d("現在の状態", "STATE_HIDDEN")
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        Log.d("現在の状態", "STATE_HALF_EXPANDED")
                    }
                }
            }
        })

        hide_button.setOnClickListener {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN)
        }

        expand_button.setOnClickListener {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }

        collapse_button.setOnClickListener {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        }

        three_button.setOnClickListener {
            behavior.peekHeight = 300
        }

        five_button.setOnClickListener {
            behavior.peekHeight = 500
        }

        eight_button.setOnClickListener {
            behavior.peekHeight = 800
        }
    }
}
