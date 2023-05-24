package com.example.tasq;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShirtFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShirtFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShirtFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShirtFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShirtFragment newInstance(String param1, String param2) {
        ShirtFragment fragment = new ShirtFragment();
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

    private ImageView mainShirt;
    private ImageView shirt1;
    private ImageView shirt2;
    private ImageView shirt3;
    private ImageView shirt4;
    private ImageView shirt5;
    private ImageView shirt6;
    private ImageView shirt7;
    private ImageView shirt8;
    private ImageView shirt9;
    private ImageView shirt10;
    private ImageView shirt11;
    private ImageView shirt12;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_shirt, container, false);
        View rootView1 = inflater.inflate(R.layout.activity_main, container, false);
        mainShirt = rootView1.findViewById(R.id.shirt_image_view);
        shirt1 = rootView.findViewById(R.id.myShirtView1);
        shirt2 = rootView.findViewById(R.id.myShirtView3);
        shirt3 = rootView.findViewById(R.id.myShirtView2);
        shirt4 = rootView.findViewById(R.id.myShirtView4);
        shirt5 = rootView.findViewById(R.id.myShirtView5);
        shirt6 = rootView.findViewById(R.id.myShirtView6);
        shirt7 = rootView.findViewById(R.id.myShirtView7);
        shirt8 = rootView.findViewById(R.id.myShirtView8);
        shirt9 = rootView.findViewById(R.id.myShirtView9);
        shirt10 = rootView.findViewById(R.id.myShirtView10);
        shirt11 = rootView.findViewById(R.id.myShirtView11);
        shirt12 = rootView.findViewById(R.id.myShirtView12);
        rootView.findViewById(R.id.myShirtView1).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView2).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView3).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView4).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView5).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView6).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView7).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView8).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView9).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView10).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView11).setOnClickListener(this);
        rootView.findViewById(R.id.myShirtView12).setOnClickListener(this);
        rootView1.findViewById(R.id.shirt_image_view).setOnClickListener(this);
        shirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.upper_limb);

            }
        });
        shirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt2();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt2);

            }
        });
        shirt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt1);

            }
        });
        shirt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt4();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt3);

            }
        });
        shirt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt5();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt4);

            }
        });
        shirt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt5);

            }
        });
        shirt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt7();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt6);

            }
        });
        shirt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt8();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt7);

            }
        });
        shirt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt9();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt8);

            }
        });
        shirt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt10();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt9);

            }
        });
        shirt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt11();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt10);

            }
        });
        shirt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeShirt12();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeShirtImage(R.drawable.shirt11);

            }
        });
        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}