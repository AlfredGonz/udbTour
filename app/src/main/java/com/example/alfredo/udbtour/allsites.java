package com.example.alfredo.udbtour;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.alfredo.udbtour.Purposes.Purposes;
import com.example.alfredo.udbtour.Purposes.PurposesAdapter;
import com.example.alfredo.udbtour.Purposes.PurposesController;
import com.example.alfredo.udbtour.Purposes.PurposesDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariel on 12/05/2018.
 */

public class allsites  extends AppCompatActivity
    {

        private RecyclerView myReclyclerView;
        private RecyclerView.Adapter myAdapter;
        private RecyclerView.LayoutManager myLayoutManager;
        PurposesController purposesController;
        List<Purposes> lista;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);
        try{
            purposesController = new PurposesController();
            lista = getAllPurposes();

            for(Purposes purposes :  purposesController.getAll()) {
                lista.add(new Purposes(null,purposes.getName(),purposes.getDescription(),purposes.getLat(), purposes.getLon()));
            }
            myReclyclerView = (RecyclerView) findViewById(R.id.mRecycler);
            myAdapter = new PurposesAdapter( lista, R.layout.purposes_item,new PurposesAdapter.onItemClickListener(){
                @Override
                public void onItemClick(final Purposes purpose, int position) {

                }
            });
            //todos los tipos de layout manager con los que se puede jugar con el recycler view
            myLayoutManager = new LinearLayoutManager(this);
            //myLayoutManager = new GridLayoutManager(this,2);
            // myLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //solo en caso que sepamos que el tamaño del layout no va a cambiar ahrehgamos esto e incrementa el rendimiento, aunque de nada sirve con el StraggeredGridLayout porque cambia los tamaños
            myReclyclerView.setHasFixedSize(true);
            //animacion por defecto
            myReclyclerView.setItemAnimator(new DefaultItemAnimator());
            myReclyclerView.setLayoutManager(myLayoutManager);
            myReclyclerView.setAdapter(myAdapter);
        }catch(Exception e)
        {
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
            System.out.println("Error :" + e.getMessage());
        }

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


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
         /*   getMenuInflater().inflate(R.menu.menu_main, menu);

            // Associate searchable configuration with the SearchView
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            searchView = (SearchView) menu.findItem(R.id.action_search)
                    .getActionView();
            searchView.setSearchableInfo(searchManager
                    .getSearchableInfo(getComponentName()));
            searchView.setMaxWidth(Integer.MAX_VALUE);

            // listening to search query text change
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    // filter recycler view when query submitted
                    mAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String query) {
                    // filter recycler view when text is changed
                    mAdapter.getFilter().filter(query);
                    return false;
                }
            });
            return true;*/
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_search) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }




    }
