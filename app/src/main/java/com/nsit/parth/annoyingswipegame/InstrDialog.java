package com.nsit.parth.annoyingswipegame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;

/**
 * Created by parth on 15/10/15.
 */
public class InstrDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(
                R.layout.instructions_dialog, null);
        builder.setView(view);
        return builder.create();
    }
}
