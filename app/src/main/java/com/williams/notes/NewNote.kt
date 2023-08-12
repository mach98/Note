package com.williams.notes

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.williams.notes.databinding.NewNoteBinding

class NewNote: DialogFragment() {
    private var _binding: NewNoteBinding? = null;
    private val binding get() = _binding!!;

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val callingActivity = activity as MainActivity;
        val inflater = callingActivity.layoutInflater;
        _binding = NewNoteBinding.inflate(inflater);

        val builder = AlertDialog.Builder(callingActivity)
            .setView(binding.root)
            .setMessage(resources.getString(R.string.add_new_note));

        return builder.create();
    }

    override fun onDestroyView() {
        super.onDestroyView();
        _binding = null;
    }
}