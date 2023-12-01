package com.example.myemergentapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.myemergentapplication.databinding.FragmentHomeFragmentBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static home_fragment newInstance(String param1, String param2) {
        home_fragment fragment = new home_fragment();
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
//***************************************************************
    ViewFlipper viewFlipper;
    Button b1,b2;
    FragmentHomeFragmentBinding binding;
    FloatingActionButton floatingActionButton,sharefab, closeFab,contactfab;
//******************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHomeFragmentBinding.inflate(inflater, container, false);
        View v=binding.getRoot();

//viewFlipper*****************************************************************
        viewFlipper=binding.viewFlip;
        int img[]={R.drawable.fuelimg,R.drawable.carserimg,R.drawable.tutimg};
        for (int i:img) {
            ImageView imageView=new ImageView(getActivity().getApplication());
            imageView.setBackgroundResource(i);
            viewFlipper.addView(imageView);
            viewFlipper.setFlipInterval(3000);
            viewFlipper.setAutoStart(true);
            viewFlipper.setInAnimation(getActivity().getApplication(),R.anim.comein);
            viewFlipper.setOutAnimation(getActivity().getApplication(),R.anim.fadeleft);
        }
//viewFlipper********************************************************************



//fab********************************************************************
        floatingActionButton=v.findViewById(R.id.helpBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabclick(v);
            }
        });
//*****************************************************************


//button click*************************************************************
        Button mech1=binding.bikeButton1;
        mech1.setOnClickListener(view -> {
            serviceprovide(view);
        });


//********************************************************************
        EmergentProvider emergentProvider=new EmergentProvider();
        b2=v.findViewById(R.id.tutorButton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout2,emergentProvider)
                        .addToBackStack(null)
                        .commit();

            }
        });
//////////////////////////////////////////////////////////////////////

        return v;
    }


    public void fabclick(View v)
    {
        contactfab=v.findViewById(R.id.about);
         sharefab=v.findViewById(R.id.shareFab);
         closeFab=v.findViewById(R.id.closeFab);
        closeFab.setVisibility(View.VISIBLE);
        sharefab.setVisibility(View.VISIBLE);
        contactfab.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.INVISIBLE);
        closeFab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                closeFab.setVisibility(View.INVISIBLE);
                sharefab.setVisibility(View.INVISIBLE);
                contactfab.setVisibility(View.INVISIBLE);
                floatingActionButton.setVisibility(View.VISIBLE);
            }
        });
        sharefab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"developer.androidstudio.com");
                startActivity(intent);

            }
        });

        contactfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),AboutUs.class);
                startActivity(intent);
            }
        });
    }

    public void serviceprovide(View view)
    {
       getFragmentManager().beginTransaction().replace(R.id.frameLayout2,new EmergentProvider())
               .addToBackStack(null).commit();
    }
}