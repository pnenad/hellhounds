package com.example.uia.battlefree;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.view.View.OnClickListener;


public class PlayerUnitViewFragment extends Fragment {

    Button currOpen = null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types and number of parameters
    public static PlayerUnitViewFragment newInstance(String param1, String param2) {
        PlayerUnitViewFragment fragment = new PlayerUnitViewFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public PlayerUnitViewFragment() {
        // Required empty public constructor
    }

    public void setCurrOpen(Button b){
        this.currOpen = b;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_unit_view, container, false);

        Button useAbility = (Button) view.findViewById(R.id.useAbility);
        useAbility.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //((Game)getActivity()).targeting();
            }
        });
        return view;
    }







/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
