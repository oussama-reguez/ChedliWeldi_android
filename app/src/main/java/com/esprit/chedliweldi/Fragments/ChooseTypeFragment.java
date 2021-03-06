package com.esprit.chedliweldi.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import butterknife.Bind;
import butterknife.ButterKnife;
import com.esprit.chedliweldi.Activities.SignUpActivity;
import com.esprit.chedliweldi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseTypeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ChooseTypeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseTypeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseTypeFragment newInstance(String param1, String param2) {
        ChooseTypeFragment fragment = new ChooseTypeFragment();
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



    @Bind(R.id.parent)
    LinearLayoutCompat parent;


    @Bind(R.id.babySitter)
    LinearLayoutCompat babySitter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.sign_up1, container, false);
        ButterKnife.bind(this,v);

  parent.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

         SignUpActivity activity = (SignUpActivity) getActivity() ;
        activity.type="Parent";
        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.enter_from_right,R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right).addToBackStack(null).replace(R.id.Fragcontainer,new CreateAccountFragment()).commit();
    }
   });



        babySitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity activity = (SignUpActivity) getActivity() ;
                activity.type="Babysitter";

                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.enter_from_right,R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right).addToBackStack(null).replace(R.id.Fragcontainer,new CreateAccountFragment()).commit();
            }
        });

        return v;


    }

}
