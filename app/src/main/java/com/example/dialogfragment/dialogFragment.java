package com.example.dialogfragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class dialogFragment extends androidx.fragment.app.DialogFragment {//نغير وراثة الدالة من Fragment الى DialogFragment

    private  static final String ARG_TITLE = "title";
    private  static final String ARG_MESSAGE = "message";
    private  static final String ARG_ICON = "icon";

    private String title;
    private String message;
    private int icon;//نستخدم متغير ال int لأن ال Icon نجلبها من ملف ال drawable



    //نعمل X Instance
    public static DialogFragment newInstance(String title , String message, int icon){

        //نضيف المعلومات على ال Bundel و Frgment

        Bundle bundle = new Bundle();

        bundle.putString(ARG_TITLE,title);
        bundle.putString(ARG_MESSAGE ,message);
        bundle.putInt(ARG_ICON ,icon);

        DialogFragment fragment = new DialogFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
    //Y


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null){
            title = args.getString(ARG_TITLE);
            message = args.getString(ARG_MESSAGE);
            icon = args.getInt(ARG_ICON);
        }
    }

    public dialogFragment() {
        // Required empty public constructor
    }




    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(icon);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "yes clicked", Toast.LENGTH_SHORT).show();
            }
        });


        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "no clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("xxx", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });

        return builder.create();
    }

    /*
     هذه الدالة نحذفه لأننا لانستخدمها مع ال Dialog ونستبدلها بدالة onCreateDialog الموجودة اعلاه

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }
   */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

}
