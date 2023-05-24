package com.example.tasq;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrouserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrouserFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrouserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrouserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrouserFragment newInstance(String param1, String param2) {
        TrouserFragment fragment = new TrouserFragment();
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

    private ImageView mainPants;
    private ImageView pants1;
    private ImageView pants2;
    private ImageView pants3;
    private ImageView pants4;
    private ImageView pants5;
    private ImageView pants6;
    private ImageView pants7;
    private ImageView pants8;
    private ImageView pants9;
    private ImageView pants10;
    private ImageView pants11;
    private ImageView pants12;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_trouser, container, false);
        View rootView1 = inflater.inflate(R.layout.activity_character, container, false);
        mainPants = rootView1.findViewById(R.id.pants_image_view);
        pants1 = rootView.findViewById(R.id.myPantsView1);
        pants2 = rootView.findViewById(R.id.myPantsView2);
        pants3 = rootView.findViewById(R.id.myPantsView3);
        pants4 = rootView.findViewById(R.id.myPantsView4);
        pants5 = rootView.findViewById(R.id.myPantsView5);
        pants6 = rootView.findViewById(R.id.myPantsView6);
        pants7 = rootView.findViewById(R.id.myPantsView7);
        pants8 = rootView.findViewById(R.id.myPantsView8);
        pants9 = rootView.findViewById(R.id.myPantsView9);
        pants10 = rootView.findViewById(R.id.myPantsView10);
        pants11 = rootView.findViewById(R.id.myPantsView11);
        pants12 = rootView.findViewById(R.id.myPantsView12);
        rootView.findViewById(R.id.myPantsView1).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView2).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView3).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView4).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView5).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView6).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView7).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView8).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView9).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView10).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView11).setOnClickListener(this);
        rootView.findViewById(R.id.myPantsView12).setOnClickListener(this);
        rootView1.findViewById(R.id.pants_image_view).setOnClickListener(this);
        pants1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants1);

            }
        });
        pants2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants2();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants2);

            }
        });
        pants3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants3();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants3);

            }
        });
        pants4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants4();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants4);

            }
        });
        pants5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants5();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants5);

            }
        });
        pants6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants6);

            }
        });
        pants7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants7);

            }
        });
        pants8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants8();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants8);

            }
        });
        pants9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants9);

            }
        });
        pants10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants10);

            }
        });
        pants11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants11);

            }
        });
        pants12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changePants12();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changePantsImage(R.drawable.pants12);

            }
        });

        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}