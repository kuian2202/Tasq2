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
 * Use the {@link HeadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeadFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HeadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeadFragment newInstance(String param1, String param2) {
        HeadFragment fragment = new HeadFragment();
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

    private ImageView mainHead;
    private ImageView head1;
    private ImageView head2;
    private ImageView head3;
    private ImageView head4;
    private ImageView head5;
    private ImageView head6;
    private ImageView head7;
    private ImageView head8;
    private ImageView head9;
    private ImageView head10;
    private ImageView head11;
    private ImageView head12;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_head, container, false);
        View rootView1 = inflater.inflate(R.layout.activity_character, container, false);
        mainHead = rootView1.findViewById(R.id.head_image_view);
        head1 = rootView.findViewById(R.id.myHeadView1);
        head2 = rootView.findViewById(R.id.myHeadView2);
        head3 = rootView.findViewById(R.id.myHeadView3);
        head4 = rootView.findViewById(R.id.myHeadView4);
        head5 = rootView.findViewById(R.id.myHeadView5);
        head6 = rootView.findViewById(R.id.myHeadView6);
        head7 = rootView.findViewById(R.id.myHeadView7);
        head8 = rootView.findViewById(R.id.myHeadView8);
        head9 = rootView.findViewById(R.id.myHeadView9);
        head10 = rootView.findViewById(R.id.myHeadView10);
        head11 = rootView.findViewById(R.id.myHeadView11);
        head12 = rootView.findViewById(R.id.myHeadView12);
        rootView.findViewById(R.id.myHeadView1).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView2).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView3).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView4).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView5).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView6).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView7).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView8).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView9).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView10).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView11).setOnClickListener(this);
        rootView.findViewById(R.id.myHeadView12).setOnClickListener(this);
        rootView1.findViewById(R.id.head_image_view).setOnClickListener(this);
        head1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head);

            }
        });
        head2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead2();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head2);

            }
        });
        head3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead3();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head3);

            }
        });
        head4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead4();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head4);

            }
        });
        head5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head5);

            }
        });
        head6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead6();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head6);

            }
        });
        head7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead7();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head7);

            }
        });
        head8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead8();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head8);

            }
        });
        head9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead1();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head9);

            }
        });
        head10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead10();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head10);

            }
        });
        head11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead11();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head11);

            }
        });
        head12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharacterActivity) requireActivity()).changeHead12();
                CharacterActivity characterActivity = (CharacterActivity) getActivity();
                characterActivity.changeHeadImage(R.drawable.head12);

            }
        });
        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}