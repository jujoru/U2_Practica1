package es.jujoru.u2_practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Equipo> lista_equipos = new ArrayList<>();
    ListView lv_equipos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();

        lv_equipos = (ListView)findViewById(R.id.lv_equipos);
        AdaptadorEquipos adaptadorEquipos = new AdaptadorEquipos(this, lista_equipos);

        lv_equipos.setAdapter(adaptadorEquipos);

        lv_equipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Equipo equipo_seleccionado = ((Equipo)parent.getItemAtPosition(position));

                String nombre_equipo =  equipo_seleccionado.getNombre();
                Toast.makeText(getApplicationContext(),"EQUIPO: "+nombre_equipo, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void cargarDatos(){

        lista_equipos.add(new Equipo("Boston Celtics", "Boston Garden","bc"));
        lista_equipos.add(new Equipo("Chicago Bulls", "United Center","cb"));
        lista_equipos.add(new Equipo("Cleveland Cavaliers", "Quicken Loans Arena","cc"));
        lista_equipos.add(new Equipo("Golden State Warriors", "SAP Center","gew"));
        lista_equipos.add(new Equipo("Houston Rockets", "Toyota Center","hr"));
        lista_equipos.add(new Equipo("Los Angeles Lakers", "Staples Center","lal"));
        lista_equipos.add(new Equipo("New York Knicks", "Madison Square Garden","nyk"));
        lista_equipos.add(new Equipo("Oklahoma City Thunders", "Ford center","okc"));
        lista_equipos.add(new Equipo("San Antonio Spurs", "AT&T Center","sas"));
        lista_equipos.add(new Equipo("Utah Jazz", "Louisiana Superdome","uj"));
        lista_equipos.add(new Equipo("Sacramento Kings", "Sleep Train Arena","sk"));
    }
}
