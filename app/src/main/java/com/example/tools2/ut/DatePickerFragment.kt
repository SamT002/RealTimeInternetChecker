package com.example.tools2.ut

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tools2.DialogCustomInterface
import java.util.*

open class DatePickerFragment(dialogCustomInterface: DialogCustomInterface) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val initialYear = calendar.get(Calendar.YEAR)
        val initialMonth = calendar.get(Calendar.MONTH)
        val initialDay = calendar.get(Calendar.DAY_OF_MONTH)

        val date = arguments?.getSerializable("date") as Date

        calendar.time = date

//        DatePickerDialog это каленьдарь где юзер выбирает дату


        return DatePickerDialog(requireContext(),
                null,
                initialYear,
                initialMonth,
                initialDay
        )

    }

    /*companion object{
        fun newInstance(date:Date):DatePickerFragment{
            val args = Bundle().apply {
                putSerializable("date", date)
            }
            return DatePickerFragment().apply {
                arguments = args
            }
        }*/

}