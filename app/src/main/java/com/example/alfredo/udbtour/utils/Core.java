package com.example.alfredo.udbtour.utils;

/**
 * Created by Ariel on 12/05/2018.
 */

import android.app.Application;

import com.example.alfredo.udbtour.Purposes.DaoMaster;
import com.example.alfredo.udbtour.Purposes.DaoSession;
import com.example.alfredo.udbtour.Purposes.Purposes;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;


public class Core extends Application {
    private DaoSession daoSession; //Objeto privado de la sesion de green dao
    private static Core applicationInstance; // Este objeto regresara la instancia de la propia clase

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this; //se setea el objeto de la la clase con su instancia
        // setup the broadcast action namespace string which will
        // be used to notify upload status.
        // Gradle automatically generates proper variable as below.

        //Grendao Implementation

        //Aqui se espeicifica el nombre de la base de datos
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "workshop-db");
        Database db = helper.getWritableDb(); //aqui se escribe
        daoSession = new DaoMaster(db).newSession(); //aqui se obtiene la sesion
        //green dao funciona con capas, como los ogros

        ///Dao Master  -> configuraciones de la base
        ///Dao Sesion  -> sesion o instancia de la base
        ///EntidadDao  -> operaciones sobre la tabla




    }

    public DaoSession getDaoSession() {
        //Metodo para recuperar la sesion que se inicia con la aplicacion
        return daoSession;
    }
    public void DeleteAllBases(){
        ///Este metodo puede limpiar la base
        DaoMaster.dropAllTables(daoSession.getDatabase(), true);
        DaoMaster.createAllTables(daoSession.getDatabase(), true);
    }

    public static synchronized Core getInstance() {

        //Este metodo recupera la instancia de esta clase
        return applicationInstance;
    }




}
