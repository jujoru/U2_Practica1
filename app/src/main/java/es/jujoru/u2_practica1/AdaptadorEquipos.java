package es.jujoru.u2_practica1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nino Ruano on 16/01/2018.
 */

public class AdaptadorEquipos extends ArrayAdapter<Equipo> {

    ArrayList<Equipo> equipos;
    Context c;

    public AdaptadorEquipos(Context c, ArrayList<Equipo> equipos){
        super(c, R.layout.item_equipo, equipos);
        this.equipos = equipos;
        this.c=c;
    }

    public View getView(int position, View view, ViewGroup viewGroup){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_equipo,null);

        TextView tv_nombre=(TextView)item.findViewById(R.id.item_nombre);
        tv_nombre.setText(equipos.get(position).getNombre());

        TextView tv_estadio=(TextView)item.findViewById(R.id.item_estadio);
        tv_estadio.setText(equipos.get(position).getEstadio());

        String logo = equipos.get(position).getLogo();

        int idImagen = c.getResources().getIdentifier(logo,"drawable",c.getPackageName());
        ImageView iv_logo = (ImageView)item.findViewById(R.id.item_logo);
        iv_logo.setImageResource(idImagen);

        return item;
    }
}
