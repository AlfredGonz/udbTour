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
            add(new Purposes(null,"Parque Nacional Montecristo","Parque Nacional Montecristo","14.386390", "-89.384345"));
            add(new Purposes(null,"Reserva Biológica El Pital","Reserva Biológica El Pital","14.382935","-89.117361"));
            add(new Purposes(null,"Parque Nacional Walter Thilo Deininger","Parque Nacional Walter Thilo Deininger","13.499370","-89.268123"));
            add(new Purposes(null,"Bosque Conchagua","Bosque Conchagua","13.263668","-87.840255"));
            add(new Purposes(null,"Bosque La Joya","Bosque La Joya","13.552005", "-88.720558"));
            add(new Purposes(null,"Bosque El Tecomatal","Bosque El Tecomatal","13.669336","-88.491244"));

            add(new Purposes(null,"Playa El Tunco","Playa El Tunco","13.493027", "-89.385048"));
            add(new Purposes(null,"Playa El Majagual","Playa El Majagual","13.489923","-89.365954"));
            add(new Purposes(null,"Playa El Cocal","Playa El Cocal","13.486493","-89.348049"));
            add(new Purposes(null,"Puerto de La Libertad","Puerto de La Libertad","13.486221","-89.319273"));
            add(new Purposes(null,"Playa San Diego","Playa San Diego","13.47791", "-89.280196"));
            add(new Purposes(null,"Playa Los Cobanos","Playa Los Cobanos","13.525478","-89.804414"));
            add(new Purposes(null,"Playa Costa del Sol","Playa Costa del Sol","13.330511", "-88.975641"));
            add(new Purposes(null,"Playa La Zunganera","Playa La Zunganera","13.404572","-89.129187"));

            add(new Purposes(null,"Museo de Arte de El Salvador","Museo de Arte de El Salvador","13.69262", "-89.241932"));
            add(new Purposes(null,"Museo Nacional Dr. David J. Guzmán","Museo Nacional Dr. David J. Guzmán","13.687182","-89.238772"));
            add(new Purposes(null,"Museo del Ferrocarril y Parque Temático","Museo del Ferrocarril y Parque Temático","13.700938","-89.177667"));
            add(new Purposes(null,"Museo de Aviación","Museo de Aviación","13.695890","-89.115100"));
            add(new Purposes(null,"Museo de la Palabra y la Imagen","Museo de la Palabra y la Imagen","13.709297", "-89.205009"));
            add(new Purposes(null,"Tin Marín, Museo de los Niños","Tin Marín, Museo de los Niños","13.525478","-89.804414"));

            add(new Purposes(null,"Monumento al Divino Salvador del Mundo","Monumento al Divino Salvador del Mundo","13.701336", "-89.224435"));
            add(new Purposes(null,"Monumento a la Revolución","Monumento a la Revolución","13.692527", "-89.242015"));
            add(new Purposes(null,"Monumento a la Constitución","Monumento a la Constitución","13.718004", "-89.222461"));
            add(new Purposes(null,"Monumento Hermano Lejano","Monumento Hermano Lejano","13.684691", "-89.218067"));
            add(new Purposes(null,"Momumento Francisco Morazán","Momumento Francisco Morazán","13.47791", "-89.190395"));
            add(new Purposes(null,"Monumento a Gerardo Barrios","Monumento a Gerardo Barrios","13.697641","-89.191199"));
            add(new Purposes(null,"Monumento a Los Proceres","Monumento a Los Proceres","13.682608", "-89.193441"));
            add(new Purposes(null,"Monumento a La Paz","Monumento a La Paz","13.668522", "-89.190610"));

            add(new Purposes(null,"Cihuatan","Cihuatan","13.980932", "-89.164938"));
            add(new Purposes(null,"Sitio Arqueológico San Andrés","Sitio Arqueológico San Andrés","13.800649", "-89.389344"));
            add(new Purposes(null,"Sitio Arqueologico Joya de Cerén","Sitio Arqueologico Joya de Cerén","13.827935", "-89.356243"));
            add(new Purposes(null,"Sitio Arqueológico Casa Blanca","Sitio Arqueológico Casa Blanca","13.987967", "-89.671245"));
            add(new Purposes(null,"Sitio Arqueológico El Tazumal","Sitio Arqueológico El Tazumal","13.979621", "-89.674170"));



        }};
    }



}
