package com.example.alfredo.udbtour.Purposes;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alfredo.udbtour.R;

import java.util.Date;

/**
 * Created by Ariel on 03/03/2018.
 */

public class PurposesDialog {

    private static Purposes purposes;
    private onDataReadyListener listener;
    static int saveOrUpdate;

    public static void  showDialog(final Context context, final Purposes purposesTemp, String title, String descripcion, int iconId
    , String positive, String eliminar, String cancel, boolean cancelable, final onDataReadyListener listener)
    {

        // inflate alert dialog xml
        LayoutInflater li = LayoutInflater.from(context);
        final View dialogView = li.inflate( R.layout.purposes_form, null);

        final TextView lblDescription=dialogView.findViewById(R.id.PurposeDialogDescription);
        lblDescription.setText(descripcion);

        //gets controlls
        final EditText txtname = (EditText) dialogView
            .findViewById(R.id.purposeFormName);
        final EditText txtdescription = (EditText) dialogView
                .findViewById(R.id.purposeFormNDescription);

        final EditText txtLatitud = (EditText) dialogView
                .findViewById(R.id.purposeFormNLatitud);
        final EditText txtLongitud = (EditText) dialogView
                .findViewById(R.id.purposeFormNLogitud);



        txtname.setText(purposesTemp.getName());
        txtdescription.setText(purposesTemp.getDescription());
        txtLatitud.setText(purposesTemp.getLat());
        txtLongitud.setText(purposesTemp.getLon());

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set title
        alertDialogBuilder.setTitle(title);
        // set custom dialog icon
        alertDialogBuilder.setIcon(iconId);
        // set custom_dialog.xml to alertdialog builder
        alertDialogBuilder.setView(dialogView);
        // set dialog message
        purposes=purposesTemp;
        saveOrUpdate = 1;
        if(purposesTemp.getName()!=null){
               saveOrUpdate = 2 ;
        }
        alertDialogBuilder
                .setCancelable(cancelable)
                .setPositiveButton(positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        purposes.setName(txtname.getText().toString());
                        purposes.setDescription(txtdescription.getText().toString());
                        purposes.setLat(txtLatitud.getText().toString());
                        purposes.setLon(txtLongitud.getText().toString());


                        listener.onDataReady(purposes,saveOrUpdate);
                    }
                })
                .setNegativeButton(eliminar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onDataReady(purposes,3);
                    }

                })
                .setNeutralButton(cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                ;

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

    }

    public interface onDataReadyListener{
        void onDataReady(Purposes Purposes, int opt);
    }

}
