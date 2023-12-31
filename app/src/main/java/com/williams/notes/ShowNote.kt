package com.williams.notes

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.williams.notes.databinding.ShowNoteBinding

class ShowNote(private val note:Note, private val index:Int) : DialogFragment() {
    private var _binding:ShowNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?):Dialog {
        val callingActivity = activity as MainActivity
        val inflater = callingActivity.layoutInflater
        _binding = ShowNoteBinding.inflate(inflater)

        val builder  = AlertDialog.Builder(callingActivity)
            .setView(binding.root)
        binding.txtTitle.text = note.title
        binding.txtContents.text = note.contents

        binding.btnOK.setOnClickListener {
            dismiss()
        }
        binding.btnDelete.setOnClickListener {
            callingActivity.deleteNote(index)
            Toast.makeText(callingActivity, resources.getString(R.string.note_deleted), Toast.LENGTH_SHORT).show()
            dismiss()
        }
        return builder.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}