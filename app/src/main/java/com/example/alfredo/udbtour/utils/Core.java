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

    private List<Purposes> getAllPurposes(){
        return new ArrayList<Purposes>(){{
            add(new Purposes("Parque Nacional Montecristo","Parque Nacional Montecristo","14.386390", "-89.384345"));
            add(new Purposes("Reserva Biológica El Pital","Reserva Biológica El Pital","14.382935","-89.117361"));
            add(new Purposes("Parque Nacional Walter Thilo Deininger","Parque Nacional Walter Thilo Deininger","13.499370","-89.268123"));
            add(new Purposes("Bosque Conchagua","Bosque Conchagua","13.263668","-87.840255"));
            add(new Purposes("Bosque La Joya","Bosque La Joya","13.552005", "-88.720558"));
            add(new Purposes("Bosque El Tecomatal","Bosque El Tecomatal","13.669336","-88.491244"));


            add(new Purposes("Playa El Tunco","Playa El Tunco","13.493027", "-89.385048"));
            add(new Purposes("Playa El Majagual","Playa El Majagual","13.489923","-89.365954"));
            add(new Purposes("Playa El Cocal","Playa El Cocal","13.486493","-89.348049"));
            add(new Purposes("Puerto de La Libertad","Puerto de La Libertad","13.486221","-89.319273"));
            add(new Purposes("Playa San Diego","Playa San Diego","13.47791", "-89.280196"));
            add(new Purposes("Playa Los Cobanos","Playa Los Cobanos","13.525478","-89.804414"));
            add(new Purposes("Playa Costa del Sol","Playa Costa del Sol","13.330511", "-88.975641"));
            add(new Purposes("Playa La Zunganera","Playa La Zunganera","13.404572","-89.129187"));








        }};
    }




}
