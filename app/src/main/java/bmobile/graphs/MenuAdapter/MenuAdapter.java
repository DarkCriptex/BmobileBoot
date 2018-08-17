package bmobile.graphs.MenuAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import bmobile.graphs.LoginInterface.Proveedores;
import bmobile.graphs.MenuFragment.MenuFragment;
import bmobile.graphs.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder>{

    ArrayList<Proveedores> MenuArrayList;
    Context context;
    MenuFragment.MenuOnClickItem menuOnClickItem;
    public  MenuAdapter(ArrayList<Proveedores> MenuArrayList, Context context, MenuFragment.MenuOnClickItem menuOnClickItem){
        this.MenuArrayList = MenuArrayList;
        this.context = context;
        this.menuOnClickItem = menuOnClickItem;

    }
    public static class MenuHolder extends RecyclerView.ViewHolder{

        public TextView MenuTextView;
        public MenuHolder(View itemView) {
            super(itemView);

            MenuTextView = itemView.findViewById(R.id.MenuNameTextView);

        }

        public void bind (Context context, final ArrayList<Proveedores> MenuArrayList, final MenuFragment.MenuOnClickItem menuOnClickItem, final int position){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        menuOnClickItem.onMenuItemClick(MenuArrayList, position);
                    }
                });
        }
    }


    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_list_item, parent, false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
            holder.MenuTextView.setText(MenuArrayList.get(position).getNameProvider());
            holder.bind(context, MenuArrayList, menuOnClickItem, position);
    }

    @Override
    public int getItemCount() {
        return MenuArrayList.size();
    }


}
