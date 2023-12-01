package com.example.myemergentapplication;


import android.content.Intent;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopBar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopBar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopBar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopBar.
     */
    // TODO: Rename and change types and number of parameters
    public static TopBar newInstance(String param1, String param2) {
        TopBar fragment = new TopBar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



//ImageButton prof;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View v=inflater.inflate(R.layout.fragment_top_bar, container, false);
//////////////////////////////////////////////////////////////////////////////////////
        Button button=v.findViewById(R.id.searchButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplication(),SearchActivity.class);
                startActivity(intent);
            }
        });
////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////
        ImageButton prof=v.findViewById(R.id.proftopimgbtn);
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplication(),ServicePersonp.class);
              // DataHelper dh=new DataHelper(getContext());
                /*Cursor c=dh.getserviceprovider();
                intent.putExtra("name",c.getString(0));
                intent.putExtra("stype",c.getString(1));
                intent.putExtra("sloc",c.getString(2));
                intent.putExtra("scontact",c.getString(3));
                intent.putExtra("desc",c.getString(4));*/
               // intent.putExtra("qwer","navee");

                startActivity(intent);

            }
        });

        return v;
    }



}