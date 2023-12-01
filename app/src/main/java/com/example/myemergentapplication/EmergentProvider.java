package com.example.myemergentapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myemergentapplication.databinding.FragmentEmergentProviderBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmergentProvider#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmergentProvider extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmergentProvider() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmergentProvider.
     */
    // TODO: Rename and change types and number of parameters
    public static EmergentProvider newInstance(String param1, String param2) {
        EmergentProvider fragment = new EmergentProvider();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
FragmentEmergentProviderBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


ImageButton like,liked,call;
    EditText e1,e2,e3,e4,e5;
    String name,contact,location,date,time;
    BookingHelper bh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentEmergentProviderBinding.inflate(inflater, container, false);
        View v=binding.getRoot();
       // /*************************************************
        e1=binding.dt1;
        e2=binding.dt2;
        e3=binding.dt3;
        e4=binding.dt4;
        e5=binding.d15;
        bh=new BookingHelper(getContext());




        ///////////////////////////////////////////////////////////////
        ImageButton locbut=v.findViewById(R.id.locbutton);
       locbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri geoloc=Uri.parse("https://goo.gl/maps/hCPeMmbvH6cwff7r7");
                Intent intent=new Intent(Intent.ACTION_VIEW,geoloc);
                startActivity(intent);
            }
        });
 ////////////////////////////////////////////////////////////////////////////////////
 like=v.findViewById(R.id.like1);
 liked=v.findViewById(R.id.like2);
 like.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         likes(v,like,liked);
     }
 });
 liked.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         likes(v,liked,like);
     }
 });
 ///////////////////////////////////////////

////////////////////////////////////////////////////////
call=v.findViewById(R.id.call);
call.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+"9698323995"));

        startActivity(intent);
    }
});

//*********************************************************************
        Button req=v.findViewById(R.id.requestService);
        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=e1.getText().toString();
                contact=e2.getText().toString();
                location=e3.getText().toString();
                date=e4.getText().toString();
                time=e5.getText().toString();

                boolean res=bh.insertbooking(name,contact,location,date,time);
                if(res==true) Toast.makeText(getContext(), "booked!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getContext(), "not booked!", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"visalya.gv@pec.edu"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"student application");
                intent.putExtra(Intent.EXTRA_TEXT,"Name:"+name+" \n contact:"+contact+" \narea:"+location+"\n Date:"+date+" \ntime:"+time);
                startActivity(Intent.createChooser(intent, "Choose an Email id :"));
            }
        });


        return v;
    }
    private void likes(View v,ImageButton imgb1,ImageButton imgb2)
    {
        imgb1.setVisibility(View.INVISIBLE);
        imgb2.setVisibility(View.VISIBLE);
    }
}